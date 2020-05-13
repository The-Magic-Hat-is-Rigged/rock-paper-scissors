package com.magichatisrigged.javaproject.enginefiles;

import org.junit.Test;

import static org.junit.Assert.*;

public class AdvancedGameEngineTest {

    //create instance of game
    private AdvancedGameEngine advancedGameEngine = new AdvancedGameEngine();

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
        assertEquals(1, advancedGameEngine.getGameRoundCounter());
    }

    @Test
    public void testNotValidGetGameRoundCounter() {
        assertNotEquals(3, advancedGameEngine.getGameRoundCounter());
    }
}