package se.anna.adventure;

import java.util.Scanner;

public class East implements Directions {
    private Scanner scanner;

    public East(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void surroundings() {
        System.out.println("\nYou go to the east. You come to a clearing in a forest. The tree leaves are " +
                "all various shades of auburn.\nYou see a tree stump that appears to be hollow.");
    }

    @Override
    public void menu() throws InterruptedException {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat do you want to do?\n1. Look around\n2. Examine the tree stump" +
                    "\n3. Go back west");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "look around" -> System.out.println("\nThe forest is immensely beautiful, but as you " +
                        "look closer at the trees, you notice the leaves are not rustling in the wind.\nIn fact, " +
                        "there is neither wind nor sound in this clearing.");
                case "examine the tree stump" -> System.out.println("\nYou approach the tree stump, and gently " +
                        "knock on it.\nNothing happens.");
                case "go back west" -> {
                    System.out.print("\nGoing back west");
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
