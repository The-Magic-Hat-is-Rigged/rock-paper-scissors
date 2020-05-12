package com.magichatisrigged.javaproject.enginefiles;

/**
 * Custom exception InvalidMoveSelectionException class extends Exception.
 * This exception validates user input for the com.magichatisrigged.javaproject.playerfiles.HumanPlayer class's
 * selectMove method.
 * This exception, combined with the while loop, try catch and switch statement in that method,
 * ensures users input only strings that – after being parse to all capital letters – are equal to one
 * of the allowed MoveSelection enum items
 */
public class InvalidMoveSelectionException extends Exception {

    //ctor
    public InvalidMoveSelectionException (){
        super("Invalid move. Please type Rock, Paper or Scissors");
    }

    public InvalidMoveSelectionException(String message){
        super(message);
    }
}
