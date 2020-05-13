package com.magichatisrigged.javaproject.exceptionfiles;

public class InvalidPostGameSelection extends Exception {

    //ctor
    public InvalidPostGameSelection () {
        super("Invalid Menu Choice. Please type Yes, or Exit");
    }

    public InvalidPostGameSelection(String message) {
        super(message);
    }
}
