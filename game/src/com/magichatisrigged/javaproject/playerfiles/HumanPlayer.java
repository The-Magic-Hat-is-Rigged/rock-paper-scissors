/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.playerfiles;

import com.magichatisrigged.javaproject.coregamefiles.MoveSelection;
import com.magichatisrigged.javaproject.exceptionfiles.InvalidAdvancedMoveSelectionException;
import com.magichatisrigged.javaproject.exceptionfiles.InvalidMoveSelectionException;

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
        System.out.println("\nPlease enter your name: ");

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

        // Creates boolean validator for following while loop. this is to validate user input to only enter valid enums
        boolean isValid = false;

        //iterate through the user's moveSelection input
        //if it's rock, paper or scissors, run it and exit loop, if not, ask for a proper move again
        while (!(isValid)) {
            try {
                // This will parse the user input and verify it was a valid selection.
                switch (userMove.nextLine().toUpperCase()) {
                    case "ROCK":
                        this.playerMove = MoveSelection.ROCK;
                        displayPlayerMoveChoice();
                        isValid = true;
                        break;
                    case "PAPER":
                        this.playerMove = MoveSelection.PAPER;
                        displayPlayerMoveChoice();
                        isValid = true;
                        break;
                    case "SCISSORS":
                        this.playerMove = MoveSelection.SCISSORS;
                        displayPlayerMoveChoice();
                        isValid = true;
                        break;
                    default:
                        throw new InvalidMoveSelectionException();
                }
            } catch(InvalidMoveSelectionException e){
                System.out.println(e.getMessage());
            }
        }
    }

    @Override
    public void selectMoveAdvancedGame() {
        // This will prompt the user to select Rock, Paper, or Scissors as their move choice.
        Scanner userMove = new Scanner(System.in);

        // Creates boolean validator for following while loop. this is to validate user input to only enter valid enums
        boolean isValid = false;

        // Call printValidMoves
        System.out.println("Choose Rock, Paper, Scissors, Lizard, or Spock");

        //iterate through the user's moveSelection input
        //if it's rock, paper or scissors, run it and exit loop, if not, ask for a proper move again
        while (!(isValid)) {
            try {
                // This will parse the user input and verify it was a valid selection.
                switch (userMove.nextLine().toUpperCase()) {
                    case "ROCK":
                        this.playerMove = MoveSelection.ROCK;
                        displayPlayerMoveChoice();
                        isValid = true;
                        break;
                    case "PAPER":
                        this.playerMove = MoveSelection.PAPER;
                        displayPlayerMoveChoice();
                        isValid = true;
                        break;
                    case "SCISSORS":
                        this.playerMove = MoveSelection.SCISSORS;
                        displayPlayerMoveChoice();
                        isValid = true;
                        break;
                    case "LIZARD":
                        this.playerMove = MoveSelection.LIZARD;
                        displayPlayerMoveChoice();
                        isValid = true;
                        break;
                    case "SPOCK":
                        this.playerMove = MoveSelection.SPOCK;
                        displayPlayerMoveChoice();
                        isValid = true;
                        break;
                    default:
                        throw new InvalidAdvancedMoveSelectionException();
                }
            } catch(InvalidAdvancedMoveSelectionException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void displayPlayerMoveChoice() {
        System.out.println(getName() + " picked " + getPlayerMove());
    }

    // Package Private Setter to enable unit testing.
    protected void setName(String name) {
        this.name = name;
    }

    // Package Private Setter to enable unit testing.
    protected void setPlayerMove(String playerMove) {
        this.playerMove = MoveSelection.valueOf(playerMove.toUpperCase());
    }

    public MoveSelection getPlayerMove () {
        return playerMove;
    }

    public String getName () {
        return name;
    }
}
