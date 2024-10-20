package se.anna.adventure;

import java.util.Scanner;

public class CentreMenu {
    Scanner scanner = new Scanner(System.in);

    public void welcome(){
        System.out.println("-----------------------------");
        System.out.println("Welcome to Mystery Adventure!");
        System.out.println("-----------------------------");
    }

    public void introduction(){
        System.out.println("\nYou open your eyes. You do not know where you are, or how you got there.\nYou " +
                "only have a faint feeling that you are here to search for something." +
                "\nStaring down at you is a signpost; it only has arrows pointing north, south, east, and west.");
    }

    public String showMenuTakeUserInput(){
        System.out.println("\nYou are at a crossroads. Which direction will you go?\n1. Go north" +
                "\n2. Go south\n3. Go east\n4. Go west\n5. Quit game");
        String userInput = scanner.nextLine().toLowerCase();
        return userInput;
    }
}
