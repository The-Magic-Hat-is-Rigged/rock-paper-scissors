/*
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.enginefiles;

import com.magichatisrigged.javaproject.coregamefiles.GameIntroduction;
import com.magichatisrigged.javaproject.coregamefiles.GameMenu;
import com.magichatisrigged.javaproject.exceptionfiles.InvalidGameMenuSelectionException;
import com.magichatisrigged.javaproject.playerfiles.ComputerPlayer;
import com.magichatisrigged.javaproject.playerfiles.HumanPlayer;

import java.util.Scanner;

public class AdvancedGameEngine extends GameEngine {

    public static final int MIN_GAME_ROUNDS = 1;
    public static final int MAX_GAME_ROUNDS = 50;

    private int numberOfGameRounds;
    private int gameRoundCounter = 1;

    @Override
    public void playGame() {
        introductionToTheGame();
        enterNumberOfGameRounds();

        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        humanPlayer.enterName();
        computerPlayer.enterName();

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

                // This will display the current lives for both human and computer.
                scoreBoardDisplay(humanPlayer, computerPlayer, humanWinCounter, computerWinCounter);
            }

            // This if block will execute if the computer player loses the round and take one away from the computer life pool.
            else if (computerPlayer.getComputerMove().losesTo(humanPlayer.getPlayerMove())) {
                System.out.println(humanPlayer.getName() + " wins round " + getGameRoundCounter() + "!");
                humanWinCounter++;

                // This will display the current lives for both human and computer.
                scoreBoardDisplay(humanPlayer, computerPlayer, humanWinCounter, computerWinCounter);
            }

            // The only other option besides win or lose would be tie, in which case no lives will be taken from either the human or computer.
            else {
                System.out.println("Tie! Go again.");
                numberOfGameRounds++;
            }

            // This will increase the game round counter by one.
            gameRoundCounter++;
        }


        // This if else statement will display the final winner of the game based on who has won more rounds.
        if (humanWinCounter > computerWinCounter) {
            System.out.println("\n" + humanPlayer.getName() + " wins the Game!!!!!");
            System.out.println("_____.___.               __      __.__      ._._._.\n" +
                    "\\__  |   | ____  __ __  /  \\    /  \\__| ____| | | |\n" +
                    " /   |   |/  _ \\|  |  \\ \\   \\/\\/   /  |/    \\ | | |\n" +
                    " \\____   (  <_> )  |  /  \\        /|  |   |  \\|\\|\\|\n" +
                    " / ______|\\____/|____/    \\__/\\  / |__|___|  /_____\n" +
                    " \\/                            \\/          \\/\\/\\/\\/");

            this.replayOrReturnToMenu();
        } else {
            System.out.println("\n" + computerPlayer.getName() + " wins the Game!!!!!");
            System.out.println("_____.___.              .____                        \n" +
                    "\\__  |   | ____  __ __  |    |    ____  ______ ____  \n" +
                    " /   |   |/  _ \\|  |  \\ |    |   /  _ \\/  ___// __ \\ \n" +
                    " \\____   (  <_> )  |  / |    |__(  <_> )___ \\\\  ___/ \n" +
                    " / ______|\\____/|____/  |_______ \\____/____  >\\___  >\n" +
                    " \\/                             \\/         \\/     \\/ ");
            this.replayOrReturnToMenu();
        }
    }

    /*
     * Advanced Game Replay or Return to Menu method
     * provides option to return to main menu or repeat game play
     * after winning or losing a game of advanced Rock, Paper, Scissors
     */
    public void replayOrReturnToMenu() {
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
                        throw new InvalidGameMenuSelectionException();
                }
            }
            catch(InvalidGameMenuSelectionException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void introductionToTheGame() {
        GameIntroduction gameIntroduction = new GameIntroduction();
        gameIntroduction.advancedGameInformation();
    }
    private void enterNumberOfGameRounds() {
        Scanner userInput = new Scanner(System.in);
        String printValidNumRange = "Please enter a number between: " + MIN_GAME_ROUNDS + " and " + MAX_GAME_ROUNDS + ".";

        // This will ask the user how many rounds per game they would like to play.
        System.out.println("How many rounds would you like to play this game? \n");

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
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. " + printValidNumRange);
            }
        }
    }
    private void scoreBoardDisplay(HumanPlayer humanPlayer, ComputerPlayer computerPlayer, int humanWinCounter, int computerWinCounter) {
        System.out.println(humanPlayer.getName() + " has " + humanWinCounter + " wins so far.");
        System.out.println(computerPlayer.getName() + " has " + computerWinCounter + " wins so far.");
    }

    // Public getter for the number of games.
    public int getNumberOfGameRounds() {
        return numberOfGameRounds;
    }
    public int getGameRoundCounter() {
        return gameRoundCounter;
    }
}
