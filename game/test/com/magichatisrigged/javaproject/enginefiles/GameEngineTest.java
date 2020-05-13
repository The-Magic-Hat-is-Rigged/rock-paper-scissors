package com.magichatisrigged.javaproject.enginefiles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class GameEngineTest {

    //create instance of game
    private GameEngine gameEngine = new GameEngine(3, 1);

    @Test
    public void testPlayGame() {
    }

    @Test
    public void testValidGetNumberOfGameRounds() {
        assertEquals(3, gameEngine.getNumberOfGameRounds());
    }

    @Test
    public void testNotValidGetNumberOfGameRounds() {
        assertNotEquals(1, gameEngine.getNumberOfGameRounds());
    }

    @Test
    public void testValidGetGameRoundCounter() {
        assertEquals(1, gameEngine.getGameRoundCounter());
    }

    @Test
    public void testNotValidGetGameRoundCounter() {
        assertNotEquals(3, gameEngine.getGameRoundCounter());
    }
}