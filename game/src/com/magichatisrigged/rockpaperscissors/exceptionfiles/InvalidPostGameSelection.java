/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.rockpaperscissors.exceptionfiles;

/**
 * Custom exception InvalidPostGameSelection class extends Exception.
 * This exception validates user input for the BasicGameEngine and AdvancedGameEngine class's
 * post-game play menu method, wherein you may choose to replay game, or return to menu.
 */
public class InvalidPostGameSelection extends Exception {

    public InvalidPostGameSelection () {
        super("Invalid Menu Choice. Please type Yes, or Exit");
    }

    public InvalidPostGameSelection(String message) {
        super(message);
    }
}
