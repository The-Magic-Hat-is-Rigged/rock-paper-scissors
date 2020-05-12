/*
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {

    private MoveSelection computerMove;

    // This method will randomly select a move for the computer player.
    @Override
    public void selectMove() {

        MoveSelection computerMoveSelection = null;
        Random random = new Random();

        // The move choices the computer can select from are stored in this ArrayList which can be expanded later.
        List<MoveSelection> computerMoveChoices = new ArrayList<>();
        computerMoveChoices.add(MoveSelection.ROCK);
        computerMoveChoices.add(MoveSelection.PAPER);
        computerMoveChoices.add(MoveSelection.SCISSORS);

        // The choices for the computer during the advanced game go here.
        // computerMoveChoices.add(MoveSelection.LIZARD);
        // computerMoveChoices.add(MoveSelection.SPOCK);

        // This loop will assign each ArrayList option an integer and randomly pick one for the computer to play.
        // The computers selection is then assigned to computerMoveSelection and passed below for validation.
       for (int i = 0; i < 1; i++) {
            int n = random.nextInt(computerMoveChoices.size());
            computerMoveSelection = computerMoveChoices.get(n);
        }

        // This is a validation if/else chain which will assign the computer selection to a move or throw an exception.
        if (computerMoveSelection.equals(MoveSelection.ROCK)) {
            this.computerMove = MoveSelection.ROCK;
        }

        else if (computerMoveSelection.equals(MoveSelection.PAPER)) {
            this.computerMove = MoveSelection.PAPER;
        }

        else if (computerMoveSelection.equals(MoveSelection.SCISSORS)) {
            this.computerMove = MoveSelection.SCISSORS;
        }

        // These are for the advanced version of the game.
//        else if (computerMoveSelection.equals(MoveSelection.LIZARD)) {
//            this.computerMove = MoveSelection.LIZARD;
//        }
//
//        else if (computerMoveSelection.equals(MoveSelection.SPOCK)) {
//            this.computerMove = MoveSelection.SPOCK;
//        }

        System.out.println("Computer Player picked: " + getComputerMove());
    }

    @Override
    public void enterName() {
        System.out.println("The computer name is " + getName());
    }

    public String getName() {
        return "Jay";
    }

    public MoveSelection getComputerMove() {
        return computerMove;
    }
}
