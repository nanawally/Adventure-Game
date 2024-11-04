package se.anna.adventure;

import java.util.Scanner;

public class CentreMenu {
    private final Scanner scanner;

    public CentreMenu(Scanner scanner) {
        this.scanner = scanner;
    }

    public void welcome() {
        System.out.println("-----------------------------");
        System.out.println("Welcome to Mystery Adventure!");
        System.out.println("-----------------------------");
    }

    public void introduction() {
        System.out.println("""
                
                You open your eyes. You do not know where you are, or how you got there.
                You only have a faint feeling that you are here to search for something.
                
                Staring down at you is a signpost; it only has arrows pointing north, south, east, and west.""");
    }

    public String showMenuTakeUserInput() {
        System.out.println("""
                
                You are at a crossroads. Which direction will you go?
                1. Go north
                2. Go south
                3. Go east
                4. Go west
                5. Quit game""");
        return scanner.nextLine().toLowerCase().trim();
    }

    public void allTasksCompleteMenu() throws InterruptedException {
        boolean running = true;
        System.out.println("""
                
                You are at a crossroads.
                You hold up the medallion to look at it. Before your \
                eyes, the blood on your hands runs off of them,
                and you hear what can only be someone's \
                final exhale in your ear.
                The medallion has lost its thick coating of rust and grime, and \
                now glimmers in the sunlight.
                You let out your own sigh of relief.""");
        while (running) {
            System.out.println("\nWhat will you do with the medallion?\nThrow it away? Put it on? Or something else?");
            String userInput = scanner.nextLine().toLowerCase().trim();
            switch (userInput) {
                case "put it on" -> {
                    System.out.println("""
                            
                            You put on the medallion.
                            Your vision grows dark, but you feel... \
                            relief.
                            You are free.""");
                    running = false;
                }
                case "throw it away" -> {
                    System.out.println("""
                            
                            You throw the medallion as far away from yourself as you can.
                            Your vision grows dark and it becomes difficult to breathe. You feel the wetness \
                            of blood on your hands again,
                            and hear the cackling and screaming of the Lake Creature and \
                            Wind Spirit in your ears.""");
                    retrieveMedallion();
                }
                case "quit game" -> {
                    System.out.print("\nThank you for playing!\nQuitting game");
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    closeScanner();
                    running = false;
                }
                default -> System.out.println();
            }
        }
    }

    public void retrieveMedallion() {
        boolean running = true;
        while (running) {
            System.out.println("\nWill you try to retrieve it?");
            String userInput = scanner.nextLine().toLowerCase().trim();
            switch (userInput) {
                case "yes" -> running = false;
                case "no" -> {
                    System.out.println("""
                            
                            The sounds only grow louder as your vision grows fainter.
                            You realise, far too late, that you've made a terrible mistake.""");
                    running = false;
                }
                default -> System.out.println();
            }
        }
    }

    public void closeScanner() {
        scanner.close();
    }
}
