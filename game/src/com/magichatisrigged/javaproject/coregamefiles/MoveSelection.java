/*
 *      Rock, Paper, Scissors
 *      The Magic Hat is Rigged (Team 7)
 *      Bruce West (https://github.com/BruceBAWest)
 *      RJ Smith (https://github.com/tupleHunden)
 *      TLG Learning: Java Mini-Project 1
 *      https://github.com/The-Magic-Hat-is-Rigged/java-project
 */

package com.magichatisrigged.javaproject.coregamefiles;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*
 * MoveSelection creates Enum of "characters,"
 * Rock, Paper, Scissors, Lizard & Spock.
 * Within the Enum class, each character is defined as well – that is,
 * the rules by which those characters win or lose are set here in the Enum
 * where they are created. Rules defined by who they lose to, returned as a Boolean
 * losesTo
 */
public enum MoveSelection {

    // These contain the available selections for the player and computer in each game.
    ROCK, PAPER, SCISSORS, LIZARD, SPOCK;

    // Declare loses to list
    public List<MoveSelection> losesTo;

    public boolean losesTo(MoveSelection other) {
        return losesTo.contains(other);
    }

    // Static loses to list, returns rules for who loses to whom
    static {
        ROCK.losesTo = Arrays.asList(PAPER, SPOCK);
        PAPER.losesTo = Arrays.asList(SCISSORS, LIZARD);
        SCISSORS.losesTo = Arrays.asList(ROCK, SPOCK);
        LIZARD.losesTo = Arrays.asList(SCISSORS, ROCK);
        SPOCK.losesTo = Arrays.asList(PAPER, LIZARD);
    }

    // Declare ties to list
    public List<MoveSelection> tiesWith;

    public boolean tiesWith(MoveSelection other) {
        return tiesWith.contains(other);
    }

    // Static ties to list, returns rules for who ties to whom
    static {
        ROCK.tiesWith = Collections.singletonList(ROCK);
        PAPER.tiesWith = Collections.singletonList(PAPER);
        SCISSORS.tiesWith = Collections.singletonList(SCISSORS);
        LIZARD.tiesWith = Collections.singletonList(LIZARD);
        SPOCK.tiesWith = Collections.singletonList(SPOCK);
    }
}
