/*
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.rockpaperscissors.enginefiles;

import com.magichatisrigged.rockpaperscissors.coregamefiles.GameIntroduction;
import com.magichatisrigged.rockpaperscissors.playerfiles.ComputerPlayer;
import com.magichatisrigged.rockpaperscissors.playerfiles.HumanPlayer;

public abstract class GameEngine {

    abstract void playGame();

    // This method is used to show the basic information for each game, specified by type.
    // This will be used in both Basic and Advanced Game Engine
    void introductionToTheGame(String gameType) {
        GameIntroduction gameIntroduction = new GameIntroduction();
        if (gameType.equals("Basic")) {
            gameIntroduction.basicGameInformation();
        }
        if (gameType.equals("Advanced")) {
            gameIntroduction.advancedGameInformation();
        }
    }

    // This method will prompt the players for their name selections
    // This will be used in both Basic and Advanced Game Engine
    void enterNamePrompt(HumanPlayer humanPlayer, ComputerPlayer computerPlayer) {
        humanPlayer.enterName();
        computerPlayer.enterName();
    }

    // This method will display the current scoreboard for both players.
    // This will be used in both Basic and Advanced Game Engine
    void scoreBoardDisplay(HumanPlayer humanPlayer, ComputerPlayer computerPlayer, int humanWinCounter, int computerWinCounter) {
        System.out.println(humanPlayer.getName() + " has " + humanWinCounter + " wins so far.");
        System.out.println(computerPlayer.getName() + " has " + computerWinCounter + " wins so far.");
    }

    // This method will display the text if there is a tie.
    // This will be used in both Basic and Advanced Game Engine
    void tieMatchTextDisplay() {
        System.out.println("Tie! Go again.");
    }

    // This method will display the word art when the human player wins the game.
    // This will be used in both Basic and Advanced Game Engine
    void humanWinTextDisplay(HumanPlayer humanPlayer) {
        System.out.println("\n" + humanPlayer.getName() + " wins the Game!!!!!");
        System.out.println("_____.___.               __      __.__      ._._._.\n" +
                "\\__  |   | ____  __ __  /  \\    /  \\__| ____| | | |\n" +
                " /   |   |/  _ \\|  |  \\ \\   \\/\\/   /  |/    \\ | | |\n" +
                " \\____   (  <_> )  |  /  \\        /|  |   |  \\|\\|\\|\n" +
                " / ______|\\____/|____/    \\__/\\  / |__|___|  /_____\n" +
                " \\/                            \\/          \\/\\/\\/\\/");
    }

    // This method will display the text when the computer player win the game.
    // This will be used in both Basic and Advanced Game Engine
    void humanLoseTextDisplay(ComputerPlayer computerPlayer) {
        System.out.println("\n" + computerPlayer.getName() + " wins the Game!!!!!");
        System.out.println("_____.___.              .____                        \n" +
                "\\__  |   | ____  __ __  |    |    ____  ______ ____  \n" +
                " /   |   |/  _ \\|  |  \\ |    |   /  _ \\/  ___// __ \\ \n" +
                " \\____   (  <_> )  |  / |    |__(  <_> )___ \\\\  ___/ \n" +
                " / ______|\\____/|____/  |_______ \\____/____  >\\___  >\n" +
                " \\/                             \\/         \\/     \\/ ");
    }
}
