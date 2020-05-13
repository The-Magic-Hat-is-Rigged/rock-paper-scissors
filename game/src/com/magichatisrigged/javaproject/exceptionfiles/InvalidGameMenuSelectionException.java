/*
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.exceptionfiles;

/**
 * This exception, combined with the while loop, try catch and switch statement in that method,
 * ensures users input only strings that – after being parse to all capital letters – are equal to one
 * of the allowed GameMenu enum items
 */
public class InvalidGameMenuSelectionException extends Exception {

    //ctor
    public InvalidGameMenuSelectionException (){
        super("Invalid Menu Choice. Please type Basic, Advanced or Exit");
    }

    public InvalidGameMenuSelectionException(String message){
        super(message);
    }
}
