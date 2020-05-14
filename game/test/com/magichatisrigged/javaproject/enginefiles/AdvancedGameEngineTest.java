/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.enginefiles;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdvancedGameEngineTest {

    //create instance of game
    private AdvancedGameEngine advancedGameEngine = new AdvancedGameEngine(3, 2);

    @Test
    public void testPlayGame() {
    }

    @Test
    public void testValidGetNumberOfGameRounds() {
        assertEquals(3, advancedGameEngine.getNumberOfGameRounds());
    }

    @Test
    public void testNotValidGetNumberOfGameRounds() {
        assertNotEquals(1, advancedGameEngine.getNumberOfGameRounds());
    }

    @Test
    public void testValidGetGameRoundCounter() {
        assertEquals(2, advancedGameEngine.getGameRoundCounter());
    }

    @Test
    public void testNotValidGetGameRoundCounter() {
        assertNotEquals(3, advancedGameEngine.getGameRoundCounter());
    }
}