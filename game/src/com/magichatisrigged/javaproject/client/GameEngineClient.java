package com.magichatisrigged.javaproject.client;

import com.magichatisrigged.javaproject.GameEngine;

/**
 * Welcome to the Rock-Paper-Scissors Game by team 'The Magic Hat is Rigged'.
 * This game was developed in Java by Bruce West and RJ Smith, and is available on GitHub.
 * https://github.com/The-Magic-Hat-is-Rigged/java-project
 */
public class GameEngineClient {
    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine();
        gameEngine.playGame();
    }
}
