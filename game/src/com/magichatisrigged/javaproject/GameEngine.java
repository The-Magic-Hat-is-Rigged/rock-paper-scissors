package com.magichatisrigged.javaproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameEngine {

    private int numberOfGames;
    private int gameDisplayCounter = 1;

    private void introductionToTheGame() {
        GameIntroduction gameIntroduction = new GameIntroduction();
        gameIntroduction.welcomeMessage();
        gameIntroduction.basicGameInformation();
    }

    private void enterNumberOfGames() {

        // This will ask how many games the user would like to play.
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many games would you like to play?");

        int userInputConvertedFromString = Integer.parseInt(userInput.nextLine());

        // This will test that the input was valid.
        if (userInputConvertedFromString > 0) {
            this.numberOfGames = userInputConvertedFromString;
            System.out.println("You will play " + getNumberOfGames() + " number of games.");
        }
        else {
            throw new IllegalArgumentException("You selected an invalid number of games. \n" +
                                               "Entry must be a positive number.");
        }
    }

    public void playGame() {

        introductionToTheGame();
        enterNumberOfGames();

        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        humanPlayer.enterName();
        computerPlayer.enterName();

        int humanLives = getNumberOfGames();
        int computerLives = getNumberOfGames();

        for (int i = 0; i < getNumberOfGames(); i++) {
            System.out.println("----- Game Number: " + gameDisplayCounter + " -----");
            humanPlayer.selectMove();
            computerPlayer.selectMove();
            gameDisplayCounter++;

            // TODO: See if this can be converted to a Switch Statement later.
            if (humanPlayer.getPlayerMove().losesTo(computerPlayer.getComputerMove())) {
                System.out.println("Computer Wins!");
                humanLives--;
                System.out.println(humanPlayer.getName() + " Lives: " + humanLives);
                System.out.println(computerPlayer.getName() + " Lives: " + computerLives);
            }

            else if (computerPlayer.getComputerMove().losesTo(humanPlayer.getPlayerMove())) {
                System.out.println("Human Wins!");
                computerLives--;
                System.out.println(humanPlayer.getName() + " Lives: " + humanLives);
                System.out.println(computerPlayer.getName() + " Lives: " + computerLives);
            }

            else {
                System.out.println("Tie! Go again.");
            }
        }
    }


    public int getNumberOfGames() {
        return numberOfGames;
    }
}
