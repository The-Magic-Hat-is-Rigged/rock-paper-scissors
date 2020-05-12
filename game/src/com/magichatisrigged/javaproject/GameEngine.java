package com.magichatisrigged.javaproject;

import java.util.Scanner;

public class GameEngine {

    private static final int STARTING_LIVES = 3;
    public static final int MIN_NUM_OF_GAMES = 1;
    public static final int MAX_NUM_OF_GAMES = 50;


    private int numberOfGames;
    private int gameDisplayCounter = 1;

    private void introductionToTheGame() {
        GameIntroduction gameIntroduction = new GameIntroduction();
        gameIntroduction.welcomeMessage();
        gameIntroduction.basicGameInformation();
    }


    /*
     * private method for setting the number of games to be played
     * This integer can be between 1 and 50 games (although, total play count can exceed this in the event of ties).
     * set between MIN_NUM_OF_GAMES && MAX_NUM_OF_GAMES
     * this method is called by the playGame method, set to private because only the play came method can see it.
     */
    private void enterNumberOfGames() {

        // This will ask how many games the user would like to play.
        Scanner userInput = new Scanner(System.in);

        String printNumGames = "How many games would you like to play? \n";
        String printValidNumRange = "Please enter a number between: " + MIN_NUM_OF_GAMES + " and " + MAX_NUM_OF_GAMES + ".";

        System.out.println(printNumGames);

        boolean isValid = false;

        //DONE: explore do/while, if/else to set playCount, so instead of breaking game, player is prompted to select a proper playcount
        while (!(isValid)) {
            System.out.println(printValidNumRange);
            try {
                int userInputConvertedFromString = Integer.parseInt(userInput.nextLine());
                if (userInputConvertedFromString >= MIN_NUM_OF_GAMES && userInputConvertedFromString <= MAX_NUM_OF_GAMES) {
                    isValid = true;
                    numberOfGames = userInputConvertedFromString;
                    System.out.println("You will play " + getNumberOfGames() + " games.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. " + printValidNumRange);
            }
        }

    }

    public void playGame() {

        introductionToTheGame();
        enterNumberOfGames();

        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        humanPlayer.enterName();
        computerPlayer.enterName();

        // The number of lives for both the human and the computer will be based on the user provided input above.
        int humanLives = getNumberOfGames();
        int computerLives = getNumberOfGames();

        // This will loop "n" times based on the number of games the player selected at the start.
        for (int i = 0; i < getNumberOfGames(); i++) {

            // This will display which game round is currently in play.
            System.out.println("----- Game Number: " + gameDisplayCounter + " -----");

            // These methods will prompt the user and computer to make their moves.
            humanPlayer.selectMove();
            computerPlayer.selectMove();

            // This will increase the game round counter by one.
            gameDisplayCounter++;

            // TODO: See if this can be converted to a Switch Statement later.

            // This if block will execute if the human player loses the round and take one away from the humans life pool.
            if (humanPlayer.getPlayerMove().losesTo(computerPlayer.getComputerMove())) {
                System.out.println(computerPlayer.getName() + " wins the " + gameDisplayCounter + " round!");
                humanLives--;

                // This will display the current lives for both human and computer.
                System.out.println(humanPlayer.getName() + " Lives: " + humanLives);
                System.out.println(computerPlayer.getName() + " Lives: " + computerLives);
            }

            // This if block will execute if the computer player loses the round and take one away from the computer life pool.
            else if (computerPlayer.getComputerMove().losesTo(humanPlayer.getPlayerMove())) {
                System.out.println(humanPlayer.getName() + " wins the " + gameDisplayCounter + " round!");
                computerLives--;

                // This will display the current lives for both human and computer.
                System.out.println(humanPlayer.getName() + " Lives: " + humanLives);
                System.out.println(computerPlayer.getName() + " Lives: " + computerLives);
            }

            // The only other option besides win or lose would be tie, in which case no lives will be taken from either the human or computer.
            else {
                System.out.println("Tie! Go again.");
                numberOfGames++;
            }
        }

        // This if else statement will display the final winner of the games based on who has more lives at the end.
        if (humanLives > computerLives) {
            System.out.println(humanPlayer.getName() + " wins the Game!!!!!");
        } else {
            System.out.println(computerPlayer.getName() + " wins the Game!!!!!");
        }
    }

    // Public getter for the number of games.
    public int getNumberOfGames() {
        return numberOfGames;
    }
}
