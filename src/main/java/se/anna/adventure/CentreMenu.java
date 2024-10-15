package se.anna.adventure;

import java.util.Scanner;

public class CentreMenu {
    Scanner scanner = new Scanner(System.in);

    public String centreMenu(){
        System.out.println("\nYou are in the central area. Which direction will you go?\n1. Go north" +
                "\n2. Go south\n3. Go east\n4. Go west\n5. Quit game");
        String userInput = scanner.nextLine().toLowerCase();
        return userInput;
    }
}
