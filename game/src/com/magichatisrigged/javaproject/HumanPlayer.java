package com.magichatisrigged.javaproject;

import java.util.Scanner;

public class HumanPlayer extends Player {

    private String name;
    private static MoveSelection playerMove;

    public HumanPlayer() {
        // No Arg
    }

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


    // TODO: Test this method.  I did a brief test in client code (wrong I know) and it worked, but needs proper testing.
    @Override
    public void selectMove() {

        String validation;

        // This will prompt the user to select Rock, Paper, or Scissors as their move choice.
        Scanner userMove = new Scanner(System.in);

        //reusable String message prompting valid user moves
        String printValidMoves = "Choose Rock, Paper, or Scissors";

        //Call printValidMoves
        System.out.println(printValidMoves);

        //reusable String to notify player move choice
        String printSelectedMove = "The move you selected is: " ;

        // This will read the user input and convert whatever they entered to uppercase to match the enum definition.
        validation = userMove.nextLine();
        MoveSelection moveSelection = MoveSelection.valueOf(validation.toUpperCase());

        // This is a validation if/else chain which will assign the user's input to a move or throw an exception.
//        if (moveSelection.equals(MoveSelection.ROCK)) {
//            this.playerMove = MoveSelection.ROCK;
//            System.out.println("The move you selected is: " + getPlayerMove());
//        }
//
//        else if (moveSelection.equals(MoveSelection.PAPER)) {
//            this.playerMove = MoveSelection.PAPER;
//            System.out.println("The move you selected is: " + getPlayerMove());
//        }
//
//        else if (moveSelection.equals(MoveSelection.SCISSORS)) {
//            this.playerMove = MoveSelection.SCISSORS;
//            System.out.println("The move you selected is: " + getPlayerMove());
//        }
//
//        else {
//            throw new IllegalArgumentException("Invalid Selection.  Please select Rock, Paper, Scissors.");
//        }

        //creates boolean validator for following while loop. this is to validate user input to only enter valid enums
        boolean isValid = false;

        //iterate through the user's moveSelection input
        //if it's rock, paper or scissors, run it and exit loop, if not, ask for a proper move again
        while (!(isValid)) {
            try {
                // This is a validation if/else chain which will assign the user's input to a move or throw an exception.
                if (moveSelection.equals(MoveSelection.ROCK)) {
                    isValid = true;
                    HumanPlayer.playerMove = MoveSelection.ROCK;
                    System.out.println(printSelectedMove + getPlayerMove());
                } else if (moveSelection.equals(MoveSelection.PAPER)) {
                    isValid = true;
                    HumanPlayer.playerMove = MoveSelection.PAPER;
                    System.out.println(printSelectedMove + getPlayerMove());
                } else if (moveSelection.equals(MoveSelection.SCISSORS)) {
                    isValid = true;
                    HumanPlayer.playerMove = MoveSelection.SCISSORS;
                    System.out.println(printSelectedMove + getPlayerMove());
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid move. " + printValidMoves);
            }
        }
    }

    public MoveSelection getPlayerMove() {
        return playerMove;
    }

    public String getName() {
        return name;
    }
}
