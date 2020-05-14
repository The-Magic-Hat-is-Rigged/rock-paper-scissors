/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.coregamefiles;

import java.util.Scanner;

public class GameIntroduction {

    // This method will display the basic version of the game's rules and information.
    public void basicGameInformation() {
        welcomeMessage();
        String userInput = ruleDisplaySelection();
        if (userInput.equals("Y") || userInput.equals("YES")) {
            System.out.println("\nWelcome to the basic version of the game.  Please read the rules below:\n" +
                               "Although the basic game has a lot of complexity to it, the rules to play it are pretty simple.\n" +
                               "The game is played where players select one of the elements of the game; rock, paper and scissors.\n" +
                               "The outcome of the game is determined by 3 simple rules:\n" +
                               "    Rock wins against scissors.\n" +
                               "    Scissors win against paper.\n" +
                               "    Paper wins against rock.\n" +
                               "For further information on the official rules please visit: https://www.wrpsa.com/the-official-rules-of-rock-paper-scissors/\n");
        }
    }

    // This method will display the basic version of the game's rules and information.
    public void advancedGameInformation() {
        welcomeMessage();
        String userInput = ruleDisplaySelection();
        if (userInput.equals("Y") || userInput.equals("YES")){
            System.out.println("Welcome to the advanced version of the game! Please read the rules below:\n" +
                    "The following moves have been added into the advanced game: Lizard and Spock\n" +
                    "    Rock wins against: Lizard, Scissors.\n" +
                    "    Paper wins against: Rock, Spock.\n" +
                    "    Scissors wins against: Lizard, Rock.\n" +
                    "    Lizard wins against: Spock, Paper.\n" +
                    "    Spock wins against: Rock, Scissors.\n" +
                    "This version of the game was created by Karen Bryla and popularized by the US TV Show 'Big Bang Theory'.\n" +
                    "Read more here: http://www.samkass.com/theories/RPSSL.html\n");
        }
    }

    // This private method will prompt the user if they want to hear the rules for the game or not.
    private String ruleDisplaySelection() {
        System.out.println("\nWould you like to hear the rules of the game?\n" +
                           "Type Y or Yes to hear the rules.\n" +
                           "Type anything else to continue to the game.\n");

        Scanner userInput = new Scanner(System.in);
        return userInput.nextLine().toUpperCase();
    }

    // This method contains the welcome information text.
    private void welcomeMessage() {
        System.out.println("Welcome to the Rock-Paper-Scissors Game by team 'The Magic Hat is Rigged'.\n" +
                "This game was developed in Java by Bruce West and RJ Smith, and is available on GitHub.\n" +
                "https://github.com/The-Magic-Hat-is-Rigged/java-project\n");
    }
}
