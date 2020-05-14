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
    @Override
    public void enterName() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nPlease enter your name: ");
        this.name = userInput.nextLine();
        System.out.println("Username has been set to: " + getName());
    }

    // This method will prompt the user to select a move from the basic game move choices.
    @Override
    public void selectMove() {
        Scanner userMove = new Scanner(System.in);
        System.out.println("Choose Rock, Paper, or Scissors");

        boolean isValid = false;
        while (!(isValid)) {
            try {
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
            }
            catch(InvalidMoveSelectionException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // This method will prompt the user to select a move from the advanced game move choices.
    @Override
    public void selectMoveAdvancedGame() {
        Scanner userMove = new Scanner(System.in);
        System.out.println("Choose Rock, Paper, Scissors, Lizard, or Spock");

        boolean isValid = false;
        while (!(isValid)) {
            try {
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
            }
            catch(InvalidAdvancedMoveSelectionException e){
                System.out.println(e.getMessage());
            }
        }
    }

    // This method will display the move the human player selected.
    private void displayPlayerMoveChoice() {
        System.out.println(getName() + " picked " + getPlayerMove());
    }

    public MoveSelection getPlayerMove () {
        return playerMove;
    }
    public String getName () {
        return name;
    }
}
