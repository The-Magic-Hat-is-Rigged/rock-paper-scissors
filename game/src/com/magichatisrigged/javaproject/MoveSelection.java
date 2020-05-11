/*
 *      The Magic Hat is Rigged (Team 7)
 *      RJ Smith & Bruce West
 *      TLG Learning: Java Mini-Project 1
 *
 */

package com.magichatisrigged.javaproject;

import java.util.Arrays;
import java.util.List;


/*
 * MoveSelection creates Enum of "characters,"
 * Rock, Paper, Scissors, Lizard & Spock.
 * Within the Enum class, each character is defined as well – that is,
 * the rules by which those characters win or lose are set here in the Enum
 * where they are created. Rules defined by who they lose to, returned as a Booleean
 * losesTo
 */
public enum MoveSelection {

    // These contain the available selections for the player and computer in each game.
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK;

    //declare loses to list
    public List<MoveSelection> losesTo;

    public boolean losesTo(MoveSelection other) {
        return losesTo.contains(other);
    }

    //static loses to list, returns rules for who loses to whom
    static {
        SCISSORS.losesTo = Arrays.asList(ROCK, SPOCK);
        ROCK.losesTo = Arrays.asList(PAPER, SPOCK);
        PAPER.losesTo = Arrays.asList(SCISSORS, LIZARD);
        SPOCK.losesTo = Arrays.asList(PAPER, LIZARD);
        LIZARD.losesTo = Arrays.asList(SCISSORS, ROCK);
    }

}
