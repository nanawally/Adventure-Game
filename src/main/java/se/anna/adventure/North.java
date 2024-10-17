package se.anna.adventure;

import java.util.Scanner;

public class North implements Directions {
    private Scanner scanner;
    private boolean medallionTaken;

    public North(Scanner scanner) {
        this.scanner = scanner;
        this.medallionTaken = false;
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
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "look around" -> System.out.println("\nThe desert completely surrounds you. The sun beats " +
                        "down mercilessly. There is nothing growing here.");
                case "look into the jar" -> {
                    System.out.println("\nYou look into the jar. You see only sand.");
                    lookIntoJar();
                }
                case "go back south" -> {
                    System.out.print("\nGoing back south");
                    for (int i = 0; i < 3; i++) {
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

    public void lookIntoJar() {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat are you thinking?\n1. What a shame\n2. There must be something in here");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "what a shame" -> {
                    System.out.println("\nDisappointed by your lack of findings, you pull your " +
                            "hand out of the jar.");
                    running = false;
                }
                case "there must be something in here" -> {
                    if(!medallionTaken){
                        System.out.println("\nYou thought you saw something glimmer. " +
                                "Is it a trick of the eye?\nRegardless, you ignore the odd feeling in your stomache and " +
                                "reach down into the jar.");
                        takeMedallion();
                        medallionTaken = true;
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
        System.out.println("\nYou hand closes round something small and flat. As you pull it out, you " +
                "see it is a medallion.\nIt is practically grey with rust and dirt.");
    }
}
