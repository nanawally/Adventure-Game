package se.anna.adventure;

import java.util.Scanner;

public class CentreMenu {
    Scanner scanner = new Scanner(System.in);

    //possible method for welcome message, if i wanna do something ~fancy~

    //make method for setting the stage after the player is welcomed (by a separate welcome message)

    public String centreMenu(){
        System.out.println("\nYou are at the crossroads. Which direction will you go?\n1. Go north" +
                "\n2. Go south\n3. Go east\n4. Go west\n5. Quit game");
        String userInput = scanner.nextLine().toLowerCase();
        return userInput;
    }
}
