/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.rockpaperscissors.coregamefiles;

import com.magichatisrigged.rockpaperscissors.enginefiles.AdvancedGameEngine;
import com.magichatisrigged.rockpaperscissors.enginefiles.BasicGameEngine;
import com.magichatisrigged.rockpaperscissors.exceptionfiles.InvalidGameMenuSelectionException;

import java.util.Scanner;

public class GameMenu {

    // This will be the method to start the game.
    public void startGame() {
        displayMenuText();
        startGameMenu();
    }

    // This method will display the welcome messaging and game menu text.
    private void displayMenuText() {
        GameMenuTextArt.welcome();
        GameMenuTextArt.gameMenuDisplayText();
    }

    // This method will handle all of the user input logic and start the user specified game version.
    private void startGameMenu() {
        boolean isValid = false;
        BasicGameEngine basicGameEngine = new BasicGameEngine();
        AdvancedGameEngine advancedGameEngine = new AdvancedGameEngine();
        Scanner userInput = new Scanner(System.in);
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
                        isValid = true;
                        GameMenuTextArt.goodbye();
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
