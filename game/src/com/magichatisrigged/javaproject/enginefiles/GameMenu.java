package com.magichatisrigged.javaproject.enginefiles;

import java.util.Scanner;


public class GameMenu {
    // This will display the visuals for the game menu.
    public void startGame() {
        boolean isValid = false;
        BasicGameEngine basicGameEngine = new BasicGameEngine();
        AdvancedGameEngine advancedGameEngine = new AdvancedGameEngine();
        Scanner userInput = new Scanner(System.in);

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
