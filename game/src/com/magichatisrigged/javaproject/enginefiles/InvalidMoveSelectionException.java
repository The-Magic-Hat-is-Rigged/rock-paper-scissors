package com.magichatisrigged.javaproject.enginefiles;

public class InvalidMoveSelectionException extends Exception {

    //ctor
    public InvalidMoveSelectionException (){
        super("Invalid move. Please type Rock, Paper or Scissors");
    }

    public InvalidMoveSelectionException(String message){
        super(message);
    }
}
