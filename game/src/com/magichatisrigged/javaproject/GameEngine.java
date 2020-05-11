package com.magichatisrigged.javaproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameEngine {

    private static final int STARTINGLIVES = 3;

    private int numberOfGames;
    public Map<String, Integer> scoreBoard = new HashMap<>();
    public int gameDisplayCounter = 1;


    public void enterNumberOfGames() {

        // This will ask how many games the user would like to play.
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many games would you like to play?");

        // Rename and refactor this later.
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
        //TODO: eplore new way to catch illegal playcount, so instead of breaking game, player is prompted to select a proper playcount
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
        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        humanPlayer.enterName();
        computerPlayer.enterName();

        scoreBoard.put(humanPlayer.getName(), STARTINGLIVES);
        scoreBoard.put(computerPlayer.getName(), STARTINGLIVES);

        for (int i = 0; i < getNumberOfGames(); i++) {
            System.out.println("----- Game Number: " + gameDisplayCounter + " -----");
            humanPlayer.selectMove();
            computerPlayer.selectMove();
            gameDisplayCounter++;
        }
    }


    public int getNumberOfGames() {
        return numberOfGames;
    }
}
