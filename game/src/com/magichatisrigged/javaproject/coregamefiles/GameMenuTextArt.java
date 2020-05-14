package com.magichatisrigged.javaproject.coregamefiles;

public class GameMenuTextArt extends GameMenu {

    static void gameMenuDisplayText() {
        System.out.println("_______________________________________________________\n" +
                "|  Welcome to Rock Paper Scissors, the Java Game!!    |\n" +
                "|  Please select an option from the choices below:    |\n" +
                "|                                                     |\n" +
                "|  Play the Basic Game      [Command: Basic]          |\n" +
                "|  Play the Advanced Game   [Command: Advanced]       |\n" +
                "|  Exit this Program        [Command: Exit]           |\n" +
                "|_____________________________________________________|\n");
    }

    static void welcome() {
        System.out.println("__________               __                          \n" +
                "\\______   \\ ____   ____ |  | __                      \n" +
                " |       _//  _ \\_/ ___\\|  |/ /                      \n" +
                " |    |   (  <_> \\  \\___|    <                       \n" +
                " |____|_  /\\____/ \\___  |__|_ \\ /\\                   \n" +
                "__________            \\/     \\/ )/                   \n" +
                "\\______   _____  ______   ___________                \n" +
                " |     ___\\__  \\ \\____ \\_/ __ \\_  __ \\               \n" +
                " |    |    / __ \\|  |_> \\  ___/|  | \\/               \n" +
                " |____|   (____  |   __/ \\___  |__| /\\               \n" +
                "  _________    \\/.__|        \\/     )/               \n" +
                " /   _____/ ____ |__| ______ _________________ ______\n" +
                " \\_____  \\_/ ___\\|  |/  ___//  ___/  _ \\_  __ /  ___/\n" +
                " /        \\  \\___|  |\\___ \\ \\___ (  <_> |  | \\\\___ \\ \n" +
                "/_______  /\\___  |__/____  /____  \\____/|__| /____  >\n" +
                "        \\/     \\/        \\/     \\/                \\/ ");

        System.out.println(" Built by 'The Magic Hat is Rigged' (Team 7)\n" +
                " Bruce West (https://github.com/BruceBAWest)\n" +
                " RJ Smith (https://github.com/tupleHunden)\n" +
                " TLG Learning: Java Mini-Project 1\n" +
                " https://github.com/The-Magic-Hat-is-Rigged/java-project");
    }

    static void goodbye() {
        System.out.println("Goodbye!  Thanks for playing.");
        System.out.println("  ________                  .______.                 \n" +
                " /  _____/  ____   ____   __| _/\\_ |__ ___.__. ____  \n" +
                "/   \\  ___ /  _ \\ /  _ \\ / __ |  | __ <   |  |/ __ \\ \n" +
                "\\    \\_\\  (  <_> |  <_> ) /_/ |  | \\_\\ \\___  \\  ___/ \n" +
                " \\______  /\\____/ \\____/\\____ |  |___  / ____|\\___  >\n" +
                "        \\/                   \\/      \\/\\/         \\/ ");
        System.exit(0);
    }
}
