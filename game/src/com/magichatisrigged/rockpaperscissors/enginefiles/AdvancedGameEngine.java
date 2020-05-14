/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.rockpaperscissors.enginefiles;

import com.magichatisrigged.rockpaperscissors.coregamefiles.GameMenu;
import com.magichatisrigged.rockpaperscissors.exceptionfiles.InvalidPostGameSelection;
import com.magichatisrigged.rockpaperscissors.playerfiles.ComputerPlayer;
import com.magichatisrigged.rockpaperscissors.playerfiles.HumanPlayer;

import java.util.Scanner;

public class AdvancedGameEngine extends GameEngine {
    public static final int MIN_GAME_ROUNDS = 1;
    public static final int MAX_GAME_ROUNDS = 50;

    private int numberOfGameRounds;
    private int gameRoundCounter = 1;

    // This is the main logic method for the game and will run the advanced version of Rock-Paper-Scissors.
    @Override
    public void playGame() {
        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        String gameType = "Advanced";

        introductionToTheGame(gameType);
        enterNumberOfGameRounds();
        enterNamePrompt(humanPlayer, computerPlayer);

        int humanWinCounter = 0;
        int computerWinCounter = 0;

        for (int i = 0; i < getNumberOfGameRounds(); i++) {
            System.out.println("\n----- Round Number: " + getGameRoundCounter() + " -----");

            humanPlayer.selectMoveAdvancedGame();
            computerPlayer.selectMoveAdvancedGame();

            if (humanPlayer.getPlayerMove().losesTo(computerPlayer.getComputerMove())) {
                System.out.println(computerPlayer.getName() + " wins round " + getGameRoundCounter() + "!");
                computerWinCounter++;
                scoreBoardDisplay(humanPlayer, computerPlayer, humanWinCounter, computerWinCounter);
            }
            else if (computerPlayer.getComputerMove().losesTo(humanPlayer.getPlayerMove())) {
                System.out.println(humanPlayer.getName() + " wins round " + getGameRoundCounter() + "!");
                humanWinCounter++;
                scoreBoardDisplay(humanPlayer, computerPlayer, humanWinCounter, computerWinCounter);
            }
            else {
                tieMatchTextDisplay();
                numberOfGameRounds++;
            }
            gameRoundCounter++;
        }

        // This will display word art for the player depending on if they won or lost the game.
        if (humanWinCounter > computerWinCounter) {
            humanWinTextDisplay(humanPlayer);
        }
        else {
            humanLoseTextDisplay(computerPlayer);
        }
        playAgainPrompt();
    }

    // This will prompt the user asking if they would like to play again, or exit to the game menu.
    private void playAgainPrompt() {
        System.out.println("Would you like to replay the game?\n" +
                           "Type Yes to replay, or type Exit to return to menu.");

        Scanner gameSelection = new Scanner(System.in);
        boolean isValid = false;
        while (!(isValid)) {
            try {
                switch (gameSelection.nextLine().toUpperCase()) {
                    case "YES":
                        this.playGame();
                        isValid = true;
                        break;
                    case "EXIT":
                        GameMenu gameMenu = new GameMenu();
                        gameMenu.startGame();
                        isValid = true;
                        break;
                    default:
                        throw new InvalidPostGameSelection();
                }
            }
            catch(InvalidPostGameSelection e){
                System.out.println(e.getMessage());
            }
        }
   }

   // This will prompt the user asking how many game rounds they would like to play for the current game.
   private void enterNumberOfGameRounds() {
        System.out.println("How many rounds would you like to play this game? \n");

        Scanner userInput = new Scanner(System.in);
        String printValidNumRange = "Please enter a number between: " + MIN_GAME_ROUNDS + " and " + MAX_GAME_ROUNDS + ".";
        boolean isValid = false;

        while (!(isValid)) {
            System.out.println(printValidNumRange);
            try {
                int userInputConvertedFromString = Integer.parseInt(userInput.nextLine());
                if (userInputConvertedFromString >= MIN_GAME_ROUNDS && userInputConvertedFromString <= MAX_GAME_ROUNDS) {
                    isValid = true;
                    numberOfGameRounds = userInputConvertedFromString;
                    System.out.println("You will play " + getNumberOfGameRounds() + " rounds this game.");
                }
            }
            catch (NumberFormatException e) {
                System.out.println("Invalid number. " + printValidNumRange);
            }
        }
    }

    public int getNumberOfGameRounds() {
        return numberOfGameRounds;
    }
    public int getGameRoundCounter() {
        return gameRoundCounter;
    }
}
