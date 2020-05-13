/*
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.playerfiles;
import com.magichatisrigged.javaproject.enginefiles.MoveSelection;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {

    private MoveSelection computerMoveSelection = null;
    private MoveSelection computerMove;

    // This method will randomly select a move for the computer player.
    @Override
    public void selectMove() {
        List<MoveSelection> validComputerMoveList = new ArrayList<>();
        validComputerMoveList.add(MoveSelection.ROCK);
        validComputerMoveList.add(MoveSelection.PAPER);
        validComputerMoveList.add(MoveSelection.SCISSORS);

        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            int n = random.nextInt(validComputerMoveList.size());
            computerMoveSelection = validComputerMoveList.get(n);
        }

        if (computerMoveSelection.equals(MoveSelection.ROCK)) {
            this.computerMove = MoveSelection.ROCK;
        }

        else if (computerMoveSelection.equals(MoveSelection.PAPER)) {
            this.computerMove = MoveSelection.PAPER;
        }

        else if (computerMoveSelection.equals(MoveSelection.SCISSORS)) {
            this.computerMove = MoveSelection.SCISSORS;
        }

        displayComputerMoveSelection();
    }

    // This method will randomly select a move for the computer player.
    @Override
    public void selectMoveAdvancedGame() {
        List<MoveSelection> validComputerMoveList = new ArrayList<>();
        validComputerMoveList.add(MoveSelection.ROCK);
        validComputerMoveList.add(MoveSelection.PAPER);
        validComputerMoveList.add(MoveSelection.SCISSORS);
        validComputerMoveList.add(MoveSelection.LIZARD);
        validComputerMoveList.add(MoveSelection.SPOCK);

        Random random = new Random();
        for (int i = 0; i < 1; i++) {
            int n = random.nextInt(validComputerMoveList.size());
            computerMoveSelection = validComputerMoveList.get(n);
        }

        if (computerMoveSelection.equals(MoveSelection.LIZARD)) {
            this.computerMove = MoveSelection.LIZARD;
        }

        else if (computerMoveSelection.equals(MoveSelection.SPOCK)) {
            this.computerMove = MoveSelection.SPOCK;
        }

        else if (computerMoveSelection.equals(MoveSelection.ROCK)) {
            this.computerMove = MoveSelection.ROCK;
        }

        else if (computerMoveSelection.equals(MoveSelection.PAPER)) {
            this.computerMove = MoveSelection.PAPER;
        }

        else if (computerMoveSelection.equals(MoveSelection.SCISSORS)) {
            this.computerMove = MoveSelection.SCISSORS;
        }

        displayComputerMoveSelection();
    }

    private void displayComputerMoveSelection() {
        System.out.println("Computer Player picked: " + getComputerMove() + "\n");
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
