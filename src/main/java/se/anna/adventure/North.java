package se.anna.adventure;

import java.util.Scanner;

public class North implements Directions {
    private Scanner scanner;

    public North(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void surroundings() {
        System.out.println("\nYou go to the north. Before you a vast desert expands towards the horizon. " +
                "There is a large jar a few metres ahead of you.");
    }

    @Override
    public void menu() {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat do you want to do?\n1. Look around\n2. Look into the jar\n3. Go back south");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "look around" -> System.out.println("\nThe desert completely surrounds you. The sun beats " +
                        "down mercilessly. There is nothing growing here.");
                case "look into the jar" -> System.out.println("\nYou look into the jar. It contains only sand.");
                case "go back south" -> {
                    System.out.println("\nGoing back south...");
                    running = false;
                }
                default -> System.out.println("\nInvalid input");
            }
        }
    }
}
