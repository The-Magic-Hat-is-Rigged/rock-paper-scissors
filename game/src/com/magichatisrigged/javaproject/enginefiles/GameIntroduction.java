package com.magichatisrigged.javaproject.enginefiles;

import java.util.Scanner;

public class GameIntroduction {

    public void welcomeMessage() {
        // Basic Information about the program
        System.out.println("Welcome to the Rock-Paper-Scissors Game by team 'The Magic Hat is Rigged'." +
                           "This game was developed in Java by Bruce West and RJ Smith, and is available on GitHub." +
                           "https://github.com/The-Magic-Hat-is-Rigged/java-project");
    }

    public void basicGameInformation() {
        System.out.println("\nWould you like to hear the rules of the game?" +
                           "Type Y or Yes to hear the rules." +
                           "Type anything else to continue to the game.");
        Scanner userInput = new Scanner(System.in);
        String userInputStringConversion = userInput.nextLine().toUpperCase();

        if (userInputStringConversion.equals("Y") || userInputStringConversion.equals("YES")) {
            System.out.println("\nWelcome to the basic version of the game.  Please read the rules below:\n" +
                               "Although the basic game has a lot of complexity to it, the rules to play it are pretty simple." +
                               "The game is played where players select one of the elements of the game; rock, paper and scissors." +
                               "The outcome of the game is determined by 3 simple rules:" +
                               "    Rock wins against scissors." +
                               "    Scissors win against paper." +
                               "    Paper wins against rock." +
                               "For further information on the official rules please visit: https://www.wrpsa.com/the-official-rules-of-rock-paper-scissors/\n");
        }
    }

    public void advancedGameInformation() {
        System.out.println("Welcome to the advanced version of the game, congratulations on getting here!" +
                           "The following moves have been added into the advanced game: Lizard and Spock" +
                           "    Rock wins against: Lizard, Scissors." +
                           "    Paper wins against: Rock, Spock." +
                           "    Scissors wins against: Lizard, Rock." +
                           "    Lizard wins against: Spock, Paper." +
                           "    Spock wins against: Rock, Scissors." +
                           "This version of the game was created by Karen Bryla and popularized by the US TV Show 'Big Bang Theory'." +
                           "Read more here: http://www.samkass.com/theories/RPSSL.html");
    }
}
