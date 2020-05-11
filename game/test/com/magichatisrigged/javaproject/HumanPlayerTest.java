package com.magichatisrigged.javaproject;

import junit.framework.TestCase;

public class HumanPlayerTest extends TestCase {

    public void setUp() throws Exception {
        super.setUp();
    }

    public void tearDown() {
    }

    // This should work... but gets hung up on user entry and does not allow any input.
    // This *does* work if you create a new humanplayer in client code and call the method... just not in JUnit.
//    @Test
//    public void testEnterName() {
//        HumanPlayer test = new HumanPlayer();
//        test.enterName();
//
//        assertEquals("RJ", getName());
//    }

    // This should work... but gets hung up on user entry and does not allow any input.
    // This *does* work if you create a new humanplayer in client code and call the method... just not in JUnit.
//    @Test
//    public void testValidMoveSelection() {
//        HumanPlayer test = new HumanPlayer();
//        test.selectMove();
//
//        assertEquals(MoveSelection.ROCK, test.getPlayerMove());
//    }
}