/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.enginefiles;

import com.magichatisrigged.javaproject.coregamefiles.GameMenu;
import com.magichatisrigged.javaproject.exceptionfiles.InvalidPostGameSelection;
import com.magichatisrigged.javaproject.playerfiles.ComputerPlayer;
import com.magichatisrigged.javaproject.playerfiles.HumanPlayer;

import java.util.Scanner;

public class AdvancedGameEngine extends GameEngine {

    private int numberOfGameRounds;
    private int gameRoundCounter = 1;

    /*
     * Constructor methods for GameEngine
     */
    //no-op ctor
    public AdvancedGameEngine() {
        //no-op ctor
    }

    //one arg ctor for num of game rounds to play
    public AdvancedGameEngine(int numberOfGameRounds) {
        this.numberOfGameRounds = numberOfGameRounds;
    }

    //two arg ctor for test purposes, tests numOfGames and gameRoundCounter
    public AdvancedGameEngine(int numberOfGameRounds, int gameRoundCounter) {
        this.numberOfGameRounds = numberOfGameRounds;
        this.gameRoundCounter = gameRoundCounter;
    }

    @Override
    public void playGame() {
        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        String gameType = "Advanced";

        introductionToTheGame(gameType);
        enterNumberOfGameRounds();
        enterNamePrompt(humanPlayer, computerPlayer);

        // The number of lives for both the human and the computer will be based on the user provided input above.
        int humanWinCounter = 0;
        int computerWinCounter = 0;

        // This will loop "n" times based on the number of games the player selected at the start.
        for (int i = 0; i < getNumberOfGameRounds(); i++) {

            // This will display which game round is currently in play.
            System.out.println("\n----- Round Number: " + getGameRoundCounter() + " -----");

            // These methods will prompt the user and computer to make their moves.
            humanPlayer.selectMoveAdvancedGame();
            computerPlayer.selectMoveAdvancedGame();

            // This if block will execute if the human player loses the round and take one away from the humans life pool.
            if (humanPlayer.getPlayerMove().losesTo(computerPlayer.getComputerMove())) {
                System.out.println(computerPlayer.getName() + " wins round " + getGameRoundCounter() + "!");
                computerWinCounter++;
                scoreBoardDisplay(humanPlayer, computerPlayer, humanWinCounter, computerWinCounter);
            }

            // This if block will execute if the computer player loses the round and take one away from the computer life pool.
            else if (computerPlayer.getComputerMove().losesTo(humanPlayer.getPlayerMove())) {
                System.out.println(humanPlayer.getName() + " wins round " + getGameRoundCounter() + "!");
                humanWinCounter++;
                scoreBoardDisplay(humanPlayer, computerPlayer, humanWinCounter, computerWinCounter);
            }

            // The only other option besides win or lose would be tie, in which case no lives will be taken from either the human or computer.
            else {
                tieMatchTextDisplay();
                numberOfGameRounds++;
            }

            // This will increase the game round counter by one.
            gameRoundCounter++;
        }

        // This if else statement will display the final winner of the game based on who has won more rounds.
        if (humanWinCounter > computerWinCounter) {
            humanWinTextDisplay(humanPlayer);
        }

        else {
            humanLoseTextDisplay(computerPlayer);
        }
        //selection prompt to play game again, or return to menu, defined below
        playAgainPrompt();
    }

    /*
     * playAgainPrompt gives you choide of replaying game, or returning to menu
     */
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

    private void enterNumberOfGameRounds() {
        Scanner userInput = new Scanner(System.in);
        boolean isValid = false;

        // This will ask the user how many rounds per game they would like to play.
        System.out.println("How many rounds would you like to play this game? \n");
        printValidRange();

        while (!(isValid)) {
            try {
                int userInputConvertedFromString = Integer.parseInt(userInput.nextLine());
                if (userInputConvertedFromString >= MIN_GAME_ROUNDS && userInputConvertedFromString <= MAX_GAME_ROUNDS) {
                    isValid = true;
                    numberOfGameRounds = userInputConvertedFromString;
                    System.out.println("You will play " + getNumberOfGameRounds() + " rounds this game.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. " + printValidRange());
            }
        }
    }

    // Public getter for the number of games.
    public int getNumberOfGameRounds() {
        return numberOfGameRounds;
    }
    public int getGameRoundCounter() {
        return gameRoundCounter;
    }
}
