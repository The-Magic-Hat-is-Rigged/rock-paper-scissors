package com.magichatisrigged.javaproject;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private String name;
    private MoveSelection playerMove;

    // This shouldn't need any tests as users can set whatever they want for their username.
    // If they want to be Elon Musk and do X Æ A-12, sweet.
    @Override
    public void enterName() {

        // This will ask the user to provide a username.
        Scanner userInput = new Scanner(System.in);
        System.out.println("Please enter your name: ");

        // This will read the input the user provided and set it as username.
        this.name = userInput.nextLine();
        System.out.println("Username has been set to: " + getName());
    }

    @Override
    public void selectMove() {

        // This will prompt the user to select Rock, Paper, or Scissors as their move choice.
        Scanner userMove = new Scanner(System.in);

        // Call printValidMoves
        System.out.println("Choose Rock, Paper, or Scissors");

        // This will parse the user input and verify it was a valid selection.
        switch (userMove.nextLine().toUpperCase()) {
            case "ROCK":
                this.playerMove = MoveSelection.ROCK;
                System.out.println(getName() + " picked " + getPlayerMove());
                break;
            case "PAPER":
                this.playerMove = MoveSelection.PAPER;
                System.out.println(getName() + " picked " + getPlayerMove());
                break;
            case "SCISSORS":
                this.playerMove = MoveSelection.SCISSORS;
                System.out.println(getName() + " picked " + getPlayerMove());
                break;
            default:
                System.out.println("Please try again.");
                selectMove();
                break;
        }
    }

    public MoveSelection getPlayerMove() {
        return playerMove;
    }

    public String getName() {
        return name;
    }
}
