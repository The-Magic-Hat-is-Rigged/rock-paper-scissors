package com.magichatisrigged.javaproject;
import java.util.Scanner;

public class GameEngine {

    private int numberOfGames;

    public void enterNumberOfGames() {

        // This will ask how many games the user would like to play..
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many games would you like to play? (1, 3, 5)");

        // This will read the input the user provided and set it as username.
        this.numberOfGames = Integer.parseInt(userInput.nextLine());
        System.out.println("You will play " + getNumberOfGames() + " number of games.");
    }

    public void playGame() {

        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        humanPlayer.enterName();
        computerPlayer.enterName();

        for (int i = 0; i < getNumberOfGames(); i++) {
            System.out.println("Game Start!");
            humanPlayer.selectMove();
            computerPlayer.selectMove();
        }
    }


    public int getNumberOfGames() {
        return numberOfGames;
    }
}
