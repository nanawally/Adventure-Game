package se.anna.adventure;

import java.util.Scanner;

public class North implements Directions {
    private final Scanner scanner;
    private Tasks task;
    private boolean medallionTaken;
    private boolean firstLook;

    public North(Scanner scanner, Tasks task) {
        this.scanner = scanner;
        this.task = task;
        this.medallionTaken = false;
        this.firstLook = false;
    }

    @Override
    public void surroundings() {
        System.out.println("\nYou go to the north. Before you a vast desert expands towards the horizon. " +
                "There is a large jar a few metres ahead of you.");
    }

    @Override
    public void menu() throws InterruptedException {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat do you want to do?\n1. Look around\n2. Look into the jar\n3. Go back south");
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "look around" -> System.out.println("\nThe desert completely surrounds you. The sun beats " +
                        "down mercilessly. There is nothing growing here.");
                case "look into the jar" -> {
                    if (!firstLook) {
                        System.out.println("\nYou look into the jar. You see only sand.");
                        firstLook = true;
                    } else {
                        System.out.println("\nYou look into the jar. You see only sand.");
                        lookIntoJar();
                    }
                }
                case "go back south" -> {
                    System.out.print("\nGoing back south");
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    System.out.println();
                    running = false;
                }
                default -> System.out.println("\nInvalid input");
            }
        }
    }

    public void lookIntoJar() {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat are you thinking?\n1. What a shame\n2. Look again");
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "what a shame" -> {
                    System.out.println("\nDisappointed by your lack of findings, you pull your " +
                            "hand out of the jar.");
                    running = false;
                }
                case "look again" -> {
                    if (!medallionTaken) {
                        System.out.println("""
                                
                                You thought you saw something glimmer. \
                                Is it a trick of the eye?
                                Regardless, you ignore the odd feeling in your stomache and \
                                reach down into the jar.""");
                        takeMedallion();
                        completeTask();
                    } else {
                        System.out.println("\nYou have already pulled out the medallion. There is now only " +
                                "sand in the jar.");
                    }
                    running = false;
                }
                default -> System.out.println("\nInvalid input");
            }
        }
    }

    public void takeMedallion() {
        System.out.println("""
                
                You hand closes round something small and flat. As you pull it out, you \
                see it is a medallion.
                It is practically grey with rust and dirt.""");
    }

    @Override
    public void completeTask() {
        task.setNorthCompleted(true);
        medallionTaken = true;
    }
}
