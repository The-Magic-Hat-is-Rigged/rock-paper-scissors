/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.rockpaperscissors.client;

import com.magichatisrigged.rockpaperscissors.coregamefiles.GameMenu;

/**
 * Welcome to the Rock-Paper-Scissors Game by team 'The Magic Hat is Rigged'.
 * This game was developed in Java by Bruce West and RJ Smith, and is available on GitHub.
 * https://github.com/The-Magic-Hat-is-Rigged/java-project
 */
public class GameEngineClient {
    public static void main(String[] args) {
        GameMenu gameMenu = new GameMenu();
        gameMenu.startGame();
    }
}
