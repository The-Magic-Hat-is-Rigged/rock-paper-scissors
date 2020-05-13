package com.magichatisrigged.javaproject.enginefiles;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class BasicGameEngineTest {

    //create instance of game
    private BasicGameEngine basicGameEngine = new BasicGameEngine(3, 1);

    @Test
    public void testPlayGame() {
    }

    @Test
    public void testValidGetNumberOfGameRounds() {
        assertEquals(3, basicGameEngine.getNumberOfGameRounds());
    }

    @Test
    public void testNotValidGetNumberOfGameRounds() {
        assertNotEquals(1, basicGameEngine.getNumberOfGameRounds());
    }

    @Test
    public void testValidGetGameRoundCounter() {
        assertEquals(1, basicGameEngine.getGameRoundCounter());
    }

    @Test
    public void testNotValidGetGameRoundCounter() {
        assertNotEquals(3, basicGameEngine.getGameRoundCounter());
    }
}