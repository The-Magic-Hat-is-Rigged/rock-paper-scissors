package com.magichatisrigged.javaproject;

public class ComputerPlayer extends Player {

    // TODO: Build out this class more later.
    @Override
    void selectMove() {

    }

    @Override
    void enterName() {
        System.out.println("The computer name is " + getName());
    }

    public String getName() {
        // Because why wouldn't Jay be the opponent? :)
        return "Jay";
    }
}
