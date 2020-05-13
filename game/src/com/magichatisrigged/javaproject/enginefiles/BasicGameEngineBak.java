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

public class BasicGameEngineBak extends GameEngine {

    public static final int MIN_GAME_ROUNDS = 1;
    public static final int MAX_GAME_ROUNDS = 50;

    private int numberOfGameRounds;
    private int gameRoundCounter = 1;

    //allows us to call advanced game when user decides to level up
    AdvancedGameEngine advancedGameEngine = new AdvancedGameEngine();
    //allows us to return to menu after playing game, if wanted
    GameMenu gameMenu = new GameMenu();

    /*
     * Constructor methods for GameEngine
     *
     */
    //no-op ctor
    public BasicGameEngineBak() {
        //no-op ctor
    }

    //one arg ctor for num of game rounds to play
    public BasicGameEngineBak(int numberOfGameRounds) {
        this.numberOfGameRounds = numberOfGameRounds;
    }

    //two arg ctor for test purposes, tests numOfGames and gameRoundCounter
    public BasicGameEngineBak(int numberOfGameRounds, int gameRoundCounter) {
        this.numberOfGameRounds = numberOfGameRounds;
        this.gameRoundCounter = gameRoundCounter;
    }

    private void introductionToTheGame() {
        GameIntroduction gameIntroduction = new GameIntroduction();
        gameIntroduction.basicGameInformation();
    }

    /*
     * private method for setting the number of games to be played
     * This integer can be between 1 and 50 game rounds (although, total play count can exceed this in the event of ties).
     * set between MIN_GAME_ROUNDS && MAX_GAME_ROUNDS
     * this method is called by the playGame method, set to private because only the play came method can see it.
     */
    private void enterNumberOfGameRounds() {

        // This will ask the user how many rounds per game they would like to play.
        System.out.println("How many rounds would you like to play this game? \n");

        // This will ask how many games the user would like to play.
        Scanner userInput = new Scanner(System.in);

        //create reusable string to return when user inputs invalid number of rounds
        String printValidNumRange = "Please enter a number between: " + MIN_GAME_ROUNDS + " and " + MAX_GAME_ROUNDS + ".";

        boolean isValid = false;

        //DONE: explore do/while, if/else to set playCount, so instead of breaking game, player is prompted to select a proper playcount
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

    public void playGame() {

        introductionToTheGame();

        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        humanPlayer.enterName();
        computerPlayer.enterName();

        // The number of lives for both the human and the computer will be based on the user provided input above.
        int humanWinCounter = 0;
        int computerWinCounter = 0;

        boolean isValid = false;
        Scanner userInput = new Scanner(System.in);
        System.out.println("Type 'PLAY' when ready");

        while (!(isValid)) {
            try {
                switch (userInput.nextLine().toUpperCase()) {
                    case "PLAY":
                        //enter number of rounds
                        enterNumberOfGameRounds();

                        // This will loop "n" times based on the number of games the player selected at the start.
                        for (int i = 0; i < getNumberOfGameRounds(); i++) {

                            // This will display which game round is currently in play.
                            System.out.println("\n----- Round Number: " + getGameRoundCounter() + " -----");

                            // These methods will prompt the user and computer to make their moves.
                            humanPlayer.selectMove();
                            computerPlayer.selectMove();

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
                            isValid = true;
                        }
                        break;

                    case "ADVANCED":
                        advancedGameEngine.playGame();
                        isValid = true;
                        break;

                    case "EXIT":
                        gameMenu.startGame();
                        isValid = true;

                    default:
                        throw new InvalidGameMenuSelectionException();
                }
            }
            catch(InvalidGameMenuSelectionException e){
                System.out.println(e.getMessage());
            }
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

            System.out.println("Would you like to play the Advanced game?\n" +
                               "Type Yes to continue, anything else to exit the program.");
            Scanner advancedGameSelection = new Scanner(System.in);
            switch (advancedGameSelection.nextLine().toUpperCase()) {
                case "YES":
                    AdvancedGameEngine advancedGameEngine = new AdvancedGameEngine();
                    advancedGameEngine.playGame();
                    break;
                case "NO":
                    System.exit(0);
                    break;
            }
        } else {
            System.out.println("\n" + computerPlayer.getName() + " wins the Game!!!!!");
            System.out.println("_____.___.              .____                        \n" +
                    "\\__  |   | ____  __ __  |    |    ____  ______ ____  \n" +
                    " /   |   |/  _ \\|  |  \\ |    |   /  _ \\/  ___// __ \\ \n" +
                    " \\____   (  <_> )  |  / |    |__(  <_> )___ \\\\  ___/ \n" +
                    " / ______|\\____/|____/  |_______ \\____/____  >\\___  >\n" +
                    " \\/                             \\/         \\/     \\/ ");
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