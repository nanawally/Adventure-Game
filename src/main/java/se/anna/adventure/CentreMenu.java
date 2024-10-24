package se.anna.adventure;

import java.util.Scanner;

public class CentreMenu {
    private final Scanner scanner;

    public CentreMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void welcome(){
        System.out.println("-----------------------------");
        System.out.println("Welcome to Mystery Adventure!");
        System.out.println("-----------------------------");
    }

    public void introduction(){
        System.out.println("""
                
                You open your eyes. You do not know where you are, or how you got there.
                You only have a faint feeling that you are here to search for something.
                
                Staring down at you is a signpost; it only has arrows pointing north, south, east, and west.""");
    }

    public String showMenuTakeUserInput(){
        // PUT AN IF STATEMENT TO CHECK IF ALL TASKS ARE COMPLETE
        System.out.println("""
                
                You are at a crossroads. Which direction will you go?
                1. Go north
                2. Go south
                3. Go east
                4. Go west
                5. Quit game""");
        return scanner.nextLine().toLowerCase().trim();
    }

    public void closeScanner(){
        scanner.close();
    }
}
