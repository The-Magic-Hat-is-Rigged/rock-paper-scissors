package com.magichatisrigged.javaproject.client;

import com.magichatisrigged.javaproject.GameEngine;

public class RockPaperScissorsClient {
    public static void main(String[] args) {

        GameEngine gameEngine = new GameEngine();
        gameEngine.enterNumberOfGames();
        gameEngine.playGame();
    }
}
