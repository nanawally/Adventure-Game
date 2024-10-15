package se.anna.adventure;

import java.util.Scanner;

public class West implements Directions {
    private Scanner scanner;

    public West(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void surroundings() {
        System.out.println("\nYou go to the west. Before you a green lake appears, with a stillness reminiscent " +
                "of a mirror.\nSuddenly, a creature steps out of the water.");
    }

    @Override
    public void menu() {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat do you want to do?\n1. Look around\n2. Speak to the creature\n3. Go back east");
            String userInput = scanner.nextLine().toLowerCase();

            switch (userInput) {
                case "look around" -> System.out.println("\nYou cannot take your eyes off the creature. Its " +
                        "scaly skin shows that this lake is its home.\nThe creature bares its teeth at you. " +
                        "Is it smiling? Or snarling?");
                case "speak to the creature" -> {
                    System.out.println("\nYou approach the approach the creature " +
                            "and open your mouth to speak.");
                    running = false;
                }
                case "go back east" -> {
                    System.out.println("\nGoing back east...");
                    running = false;
                }
                default -> System.out.println("\nInvalid input");
            }
        }
        speak();
    }

    public void speak() {
        System.out.println("'What do you want?' the creature snarls.");
        String userInput;

        do {
            System.out.println("\nHow do you respond?" +
                    "\n1. I am searching for something\n2. How dare you! Die!");
            userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("i am searching for something")) {
                diplomacy();
                break;
            } else if (userInput.equals("how dare you! die!")) {
                fight();
                break;
            } else {
                System.out.println("Invalid input");
            }
        }
        while (true);
    }

    public void diplomacy() {
        System.out.println("\nThe creature croaks. Is it... laughing?\n'Poor fool', the creature says. 'What " +
                "you seek is not here. You are going to leave now.'");
        System.out.println("Your vision goes dark. You wake up on the ground.");
    }

    public void fight() {
        System.out.println("\nYou leap at the creature. In the blink of an eye it has moved out of your way, " +
                "and you trip.\nAs you hit your head hard on the ground, you swear you can hear a croaking " +
                "laugh becoming fainter...");
        System.out.println("Your vision goes dark. You wake up on the ground.");
    }
}
