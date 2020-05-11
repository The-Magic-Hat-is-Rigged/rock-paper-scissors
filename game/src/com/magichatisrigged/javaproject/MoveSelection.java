/*
 *      The Magic Hat is Rigged (Team 7)
 *      RJ Smith & Bruce West
 *      TLG Learning: Java Mini-Project 1
 *
 */

package com.magichatisrigged.javaproject;

import java.util.Arrays;
import java.util.Collections;
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

    //DONE: declare losesTo rules; defines what each "character" (avatar?) loses to, naturally, at birth
    //like pre-determined natural selection
    //declare loses to list
    public List<MoveSelection> losesTo;

    public boolean losesTo(MoveSelection other) {
        return losesTo.contains(other);
    }

    //static loses to list, returns rules for who loses to whom
    static {
        ROCK.losesTo = Arrays.asList(PAPER, SPOCK);
        PAPER.losesTo = Arrays.asList(SCISSORS, LIZARD);
        SCISSORS.losesTo = Arrays.asList(ROCK, SPOCK);
        LIZARD.losesTo = Arrays.asList(SCISSORS, ROCK);
        SPOCK.losesTo = Arrays.asList(PAPER, LIZARD);
    }

    //ToDo: create tiesWith list
    //declare ties to list
    public List<MoveSelection> tiesWith;

    public boolean tiesWith(MoveSelection other) {
        return tiesWith.contains(other);
    }

    static {
        ROCK.tiesWith = Collections.singletonList(ROCK);
        PAPER.losesTo = Collections.singletonList(PAPER);
        SCISSORS.tiesWith = Collections.singletonList(SCISSORS);
        LIZARD.losesTo = Collections.singletonList(LIZARD);
        SPOCK.losesTo = Collections.singletonList(SPOCK);
    }

}
