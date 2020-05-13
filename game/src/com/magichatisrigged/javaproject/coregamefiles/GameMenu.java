/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.coregamefiles;

import com.magichatisrigged.javaproject.enginefiles.AdvancedGameEngine;
import com.magichatisrigged.javaproject.enginefiles.BasicGameEngine;
import com.magichatisrigged.javaproject.exceptionfiles.InvalidGameMenuSelectionException;

import java.util.Scanner;

public class GameMenu {
    // This will display the visuals for the game menu.
    public void startGame() {
        boolean isValid = false;
        BasicGameEngine basicGameEngine = new BasicGameEngine();
        AdvancedGameEngine advancedGameEngine = new AdvancedGameEngine();
        Scanner userInput = new Scanner(System.in);

        WelcomeMessage.welcome();

        System.out.println("_______________________________________________________\n" +
                           "|  Welcome to Rock Paper Scissors, the Java Game!!    |\n" +
                           "|  Please select an option from the choices below:    |\n" +
                           "|                                                     |\n" +
                           "|  Play the Basic Game      [Command: Basic]          |\n" +
                           "|  Play the Advanced Game   [Command: Advanced]       |\n" +
                           "|  Exit this Program        [Command: Exit]           |\n" +
                           "|_____________________________________________________|\n");
        while (!(isValid)) {
            try {
                switch (userInput.nextLine().toUpperCase()) {
                    case "BASIC":
                        basicGameEngine.playGame();
                        isValid = true;
                        break;
                    case "ADVANCED":
                        advancedGameEngine.playGame();
                        isValid = true;
                        break;
                    case "EXIT":
                        System.out.println("Goodbye!  Thanks for playing.");
                        isValid = true;
                        GoodbyeMessage.goodbye();
                    default:
                        throw new InvalidGameMenuSelectionException();
                }
            }
            catch(InvalidGameMenuSelectionException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
