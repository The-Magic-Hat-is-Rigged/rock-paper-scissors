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
