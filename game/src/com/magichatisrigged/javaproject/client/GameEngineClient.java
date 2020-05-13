package com.magichatisrigged.javaproject.client;

import com.magichatisrigged.javaproject.enginefiles.BasicGameEngine;

/**
 * Welcome to the Rock-Paper-Scissors Game by team 'The Magic Hat is Rigged'.
 * This game was developed in Java by Bruce West and RJ Smith, and is available on GitHub.
 * https://github.com/The-Magic-Hat-is-Rigged/java-project
 */
public class GameEngineClient {
    public static void main(String[] args) {

        BasicGameEngine basicGameEngine = new BasicGameEngine();
        basicGameEngine.playGame();
    }
}
