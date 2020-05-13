package com.magichatisrigged.javaproject.enginefiles;

import java.util.Scanner;


public class GameMenu {

    public enum GameMenuOptions { BASIC, ADVANCED, EXIT }
    private GameEngine gameEngine = new GameEngine();


    // This will display the visuals for the game menu.
    public void startGame() {
        boolean isValid = false;
        Scanner userInput = new Scanner(System.in);
        System.out.println("_______________________________________________________\n" +
                           "|  Welcome to Rock Paper Scissors, the Java Game!!    |\n" +
                           "|  Please select an option from the choices below:    |\n" +
                           "|                                                     |\n" +
                           "|  Play the Basic Game      [Command: Basic]          |\n" +
                           "|  Play the Advanced Game   [Command: Advanced]       |\n" +
                           "|  Exit this Program        [Command: Exit]           |\n" +
                           "_______________________________________________________\n");

        while (!(isValid)) {
            try {
                switch (userInput.nextLine().toUpperCase()) {
                    case "BASIC":
                        gameEngine.playGame();
                        isValid = true;
                        break;
                    case "ADVANCED":
                        // gameEngine.playAdvancedGame();
                        System.out.println("This would normally play the advanced game.");
                        isValid = true;
                        break;
                    case "EXIT":
                        System.out.println("Goodbye!  Thanks for playing.");
                        isValid = true;
                        System.exit(0);
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
