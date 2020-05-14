package com.magichatisrigged.javaproject.exceptionfiles;

import static com.magichatisrigged.javaproject.enginefiles.GameEngine.MIN_GAME_ROUNDS;
import static com.magichatisrigged.javaproject.enginefiles.GameEngine.MAX_GAME_ROUNDS;

public class InvalidNumberOfGamesException extends Exception {

    //ctor
    public InvalidNumberOfGamesException(){
        super("Invalid number of games. Please choose a number between " + MIN_GAME_ROUNDS + " & " + MAX_GAME_ROUNDS + ".");
    }

    public InvalidNumberOfGamesException(String message){
        super(message);
    }
}
