package com.magichatisrigged.javaproject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ComputerPlayer extends Player {

    private MoveSelection computerMove;

    public ComputerPlayer() {
        // no arg
    }

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

        else {
            throw new IllegalArgumentException("Invalid Selection.  Please select Rock, Paper, Scissors.");
        }

        System.out.println("Computer Player picked: " + getComputerMove());
    }

    @Override
    public void enterName() {
        System.out.println("The computer name is " + getName());
    }

    public String getName() {
        // Because why wouldn't Jay be the opponent? :)
        return "Jay";
    }

    public MoveSelection getComputerMove() {
        return computerMove;
    }
}
