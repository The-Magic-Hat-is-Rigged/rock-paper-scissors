package com.magichatisrigged.javaproject;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameIntroduction {

    public void welcomeMessage() {

        // Basic Information about the program
        System.out.println("Welcome to the Rock-Paper-Scissors Game by team 'The Magic Hat is Rigged'.");
        System.out.println("This game was developed in Java by Bruce West and RJ Smith, and is available on GitHub.");
        System.out.println("https://github.com/The-Magic-Hat-is-Rigged/java-project");
    }

    public void basicGameInformation() {

        System.out.println("\nWould you like to hear the rules of the game?");
        System.out.println("Type Y or Yes to hear the rules.");
        System.out.println("Type anything else to continue to the game.");
        Scanner userInput = new Scanner(System.in);
        String userInputStringConversion = userInput.nextLine();
        String upperCaseForcedSelection = userInputStringConversion.toUpperCase();

        if (upperCaseForcedSelection.equals("Y") || upperCaseForcedSelection.equals("YES")) {
            System.out.println("\nWelcome to the basic version of the game.  Please read the rules below:\n");
            System.out.println("Although the basic game has a lot of complexity to it, the rules to play it are pretty simple.");
            System.out.println("The game is played where players select one of the elements of the game; rock, paper and scissors.");
            System.out.println("The outcome of the game is determined by 3 simple rules:");
            System.out.println("    Rock wins against scissors.");
            System.out.println("    Scissors win against paper.");
            System.out.println("    Paper wins against rock.");
            System.out.println("For further information on the official rules please visit: https://www.wrpsa.com/the-official-rules-of-rock-paper-scissors/\n");
        }
    }

    // This is a placeholder for when the game is ready to expand beyond the simple game of RPS.
    // TODO: Make Method Public and add background information.
    private void advancedGameInformation() {

    }


}
