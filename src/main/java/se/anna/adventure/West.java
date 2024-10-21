package se.anna.adventure;

import java.util.Scanner;

public class West implements Directions {
    private final Scanner scanner;

    public West(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void surroundings() {
        System.out.println("""
                
                You go to the west. Before you a green lake appears, with a stillness reminiscent \
                of a mirror.
                Suddenly, a creature steps out of the water.""");
    }

    @Override
    public void menu() throws InterruptedException {
        boolean running = true;
        boolean shouldSpeak = false;
        while (running) {
            System.out.println("\nWhat do you want to do?\n1. Look around\n2. Speak to the creature\n3. Go back east");
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "look around" -> System.out.println("""
                        
                        You cannot take your eyes off the creature. Its scaly skin shows that this lake is its home.
                        The creature bares its teeth at you. Is it smiling? Or snarling?""");
                case "speak to the creature" -> {
                    System.out.println("\nYou approach the approach the creature " +
                            "and open your mouth to speak.");
                    shouldSpeak = true;
                    running = false;
                }
                case "go back east" -> {
                    System.out.print("\nGoing back east");
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
        if (shouldSpeak) {
            speak();
        }
    }

    public void speak() {
        System.out.println("'What do you want?' the creature snarls.");
        String userInput;

        do {
            System.out.println("""
                    
                    How do you respond?
                    
                    1. I am searching for something
                    2. How dare you! Die!""");
            userInput = scanner.nextLine().toLowerCase().trim();

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
        System.out.println("""
                
                The creature croaks. Is it... laughing?
                'Poor fool', the creature says. 'What \
                you seek is not here. You are going to leave now.'""");
        System.out.println("Your vision goes dark. You wake up on the ground.");
    }

    public void fight() {
        System.out.println("""
                
                You leap at the creature. In the blink of an eye it has moved out of your way, \
                and you trip.
                As you hit your head hard on the ground, you swear you can hear a croaking \
                laugh becoming fainter...""");
        System.out.println("Your vision goes dark. You wake up on the ground.");
    }
}
