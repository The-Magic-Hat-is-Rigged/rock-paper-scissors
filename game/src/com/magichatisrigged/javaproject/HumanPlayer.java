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

        // This will read the user input and convert whatever they entered to uppercase to match the enum definition.
        String moveSelectionString = userMove.nextLine().toUpperCase();

        // Creates boolean validator for following while loop. this is to validate user input to only enter valid enums
        boolean isValid = false;

        // Iterate through the user's moveSelection input
        // If it's rock, paper or scissors, run it and exit loop, if not, ask for a proper move again
        while (!(isValid))  {
            try {
                MoveSelection moveSelection = MoveSelection.valueOf(moveSelectionString);

                if (moveSelection.equals(MoveSelection.ROCK)) {
                    this.playerMove = MoveSelection.ROCK;
                    isValid = true;
                }

                else if (moveSelection.equals(MoveSelection.PAPER)) {
                    this.playerMove = MoveSelection.PAPER;
                    isValid = true;
                }

                else if (moveSelection.equals(MoveSelection.SCISSORS)) {
                    this.playerMove = MoveSelection.SCISSORS;
                    isValid = true;
                }

                System.out.println("The move you selected is: " + getPlayerMove());
            }

            catch (IllegalArgumentException e) {
                System.out.println("Invalid move. Choose Rock, Paper, or Scissors");
                break;
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
