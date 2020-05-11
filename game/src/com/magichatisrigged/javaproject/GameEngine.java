package com.magichatisrigged.javaproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameEngine {

    private static final int STARTINGLIVES = 3;

    private int numberOfGames;
    public Map<String, Integer> scoreBoard = new HashMap<>();
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

        /*
         * experiment for implementing new approach to game play.
         * in current version, if you select a wrong play count for the game,
         * you essentially break the game.
         * instead, we should notify the player that the playcount they selected is improper,
         * then afford them the opportunity to select a proper playcount
         */
        //TODO: explore new way to catch illegal playcount, so instead of breaking game, player is prompted to select a proper playcount
//        try {
//            if (userInputConvertedFromString > 0) {
//            this.numberOfGames = userInputConvertedFromString;
//            System.out.println("You will play " + getNumberOfGames() + " number of games.");
//        }
//        }
//        catch (Exception e) {
//            System.out.println("You selected an invalid number of games. \n" +
//                                               "Entry must be a positive number.");
//            continue;
//        }

    }

    public void playGame() {

        introductionToTheGame();
        enterNumberOfGames();

        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        humanPlayer.enterName();
        computerPlayer.enterName();

        scoreBoard.put("Player Name: " + humanPlayer.getName(), getNumberOfGames());
        scoreBoard.put("Computer Name: " + computerPlayer.getName(), getNumberOfGames());

        for (int i = 0; i < getNumberOfGames(); i++) {
            System.out.println("----- Game Number: " + gameDisplayCounter + " -----");
            humanPlayer.selectMove();
            computerPlayer.selectMove();
            gameDisplayCounter++;

            // TODO: See if this can be converted to a Switch Statement later.
            if (humanPlayer.getPlayerMove().losesTo(computerPlayer.getComputerMove())) {
                System.out.println("Computer Wins!");
                scoreBoard.replace("Player Name: " + humanPlayer.getName(), STARTINGLIVES, STARTINGLIVES - 1);
                System.out.println(scoreBoard);
            }

            else if (computerPlayer.getComputerMove().losesTo(humanPlayer.getPlayerMove())) {
                System.out.println("Human Wins!");
                scoreBoard.replace("Player Name: " + computerPlayer.getName(), STARTINGLIVES, STARTINGLIVES - 1);
                System.out.println(scoreBoard);
            }

            else {
                System.out.println("Tie! Go again.");
                System.out.println(scoreBoard);
            }


        }
    }


    public int getNumberOfGames() {
        return numberOfGames;
    }
}
