package se.anna.adventure;

import java.util.Scanner;

public class South implements Directions {
    private Scanner scanner;

    public South(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void surroundings() {
        System.out.println("\nYou go to the south. The sight of a brilliant cerulean ocean fills your eyes, " +
                "and the sun glimmers on the surface of the waves.\nYou see a flag in a tidal pool.");
    }

    @Override
    public void menu() throws InterruptedException {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat do you want to do?\n1. Look around\n2. Examine the flag\n3. Go back north");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "look around" -> System.out.println("\nThere is nothing man-made on the beach except for the " +
                        "flag. Shells of sea creatures are the only proof you see of life.");
                case "examine the flag" -> System.out.println("\nYou pick up the flag. It was presumably once " +
                        "white; it is now yellowed and stained brown with old blood.");
                case "go back north" -> {
                    System.out.print("\nGoing back north");
                    for (int i = 0; i<3;i++){
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    System.out.println("");
                    running = false;
                }
                default -> System.out.println("\nInvalid input");
            }
        }
    }
}
