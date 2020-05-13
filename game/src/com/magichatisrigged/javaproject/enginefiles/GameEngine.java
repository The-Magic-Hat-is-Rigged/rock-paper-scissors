/*
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.enginefiles;

import com.magichatisrigged.javaproject.coregamefiles.GameIntroduction;
import com.magichatisrigged.javaproject.playerfiles.ComputerPlayer;
import com.magichatisrigged.javaproject.playerfiles.HumanPlayer;

/*
 * Abstract Game Engine Class defines the rules for both
 * the BasicGameEngine class and AdvancedGameEngine class
 */
public abstract class GameEngine {
    public static final int MIN_GAME_ROUNDS = 1;
    public static final int MAX_GAME_ROUNDS = 50;

    abstract void playGame();

    void introductionToTheGame(String gameType) {
        GameIntroduction gameIntroduction = new GameIntroduction();
        if (gameType.equals("Basic")) {
            gameIntroduction.basicGameInformation();
        }
        if (gameType.equals("Advanced")) {
            gameIntroduction.advancedGameInformation();
        }
    }

    void enterNamePrompt(HumanPlayer humanPlayer, ComputerPlayer computerPlayer) {
        humanPlayer.enterName();
        computerPlayer.enterName();
    }

    String printValidRange() {
        return "Please enter a number between: " + MIN_GAME_ROUNDS + " and " + MAX_GAME_ROUNDS + ".";
    }

    void scoreBoardDisplay(HumanPlayer humanPlayer, ComputerPlayer computerPlayer, int humanWinCounter, int computerWinCounter) {
        System.out.println(humanPlayer.getName() + " has " + humanWinCounter + " wins so far.");
        System.out.println(computerPlayer.getName() + " has " + computerWinCounter + " wins so far.");
    }

    void tieMatchTextDisplay() {
        System.out.println("Tie! Go again.");
    }

    void humanWinTextDisplay(HumanPlayer humanPlayer) {
        System.out.println("\n" + humanPlayer.getName() + " wins the Game!!!!!");
        System.out.println("_____.___.               __      __.__      ._._._.\n" +
                "\\__  |   | ____  __ __  /  \\    /  \\__| ____| | | |\n" +
                " /   |   |/  _ \\|  |  \\ \\   \\/\\/   /  |/    \\ | | |\n" +
                " \\____   (  <_> )  |  /  \\        /|  |   |  \\|\\|\\|\n" +
                " / ______|\\____/|____/    \\__/\\  / |__|___|  /_____\n" +
                " \\/                            \\/          \\/\\/\\/\\/");
    }

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
