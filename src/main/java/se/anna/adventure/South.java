package se.anna.adventure;

import java.util.Scanner;

public class South implements Directions {
    private final Scanner scanner;
    private Tasks task;
    private boolean flagTaken;
    private boolean firstPickUp;

    public South(Scanner scanner, Tasks task) {
        this.scanner = scanner;
        this.task = task;
        this.flagTaken = false;
        this.firstPickUp = false;
    }

    @Override
    public void surroundings() {
        if (task.isSouthCompleted()) {
            System.out.println("""
                    
                    You go to the south. The sight of a brilliant cerulean ocean fills your eyes, \
                    and the sun glimmers on the surface of the waves.
                    The bloody flag is nowhere to be seen.""");
        } else {
            System.out.println("""
                    
                    You go to the south. The sight of a brilliant cerulean ocean fills your eyes, \
                    and the sun glimmers on the surface of the waves.
                    You see a flag in a tidal pool.""");
        }
    }

    @Override
    public void menu() throws InterruptedException {
        if (task.isSouthCompleted()) {
            boolean running = true;
            while (running) {
                System.out.println("\nWhat do you want to do?\n1. Look around\n2. Go back north");
                String userInput = scanner.nextLine().toLowerCase().trim();

                switch (userInput) {
                    case "look around" ->
                            System.out.println("\nThere is nothing man-made on the beach. Shells of sea " +
                                    "creatures are the only proof you see of life.");
                    case "go back north" -> {
                        System.out.print("\nGoing back north");
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
        } else {
            boolean running = true;
            while (running) {
                System.out.println("\nWhat do you want to do?\n1. Look around\n2. Examine the flag\n3. Go back north");
                String userInput = scanner.nextLine().toLowerCase().trim();

                switch (userInput) {
                    case "look around" ->
                            System.out.println("\nThere is nothing man-made on the beach except for the " +
                                    "flag. Shells of sea creatures are the only proof you see of life.");
                    case "examine the flag" -> {
                        if (!firstPickUp) {
                            System.out.println("\nYou pick up the flag. It was presumably once " +
                                    "white; it is now yellowed and stained brown with old blood.");
                            firstPickUp = true;
                        } else {
                            System.out.println("\nYou pick up the flag. It was presumably once " +
                                    "white; it is now yellowed and stained brown with old blood.");
                            examineFlag();
                        }
                    }
                    case "go back north" -> {
                        System.out.print("\nGoing back north");
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
    }

    public void examineFlag() {
        boolean running = true;
        while (running) {
            System.out.println("\nWhat are you thinking?\n1. What a useless find\n2. I should look closer");
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "what a useless find" -> {
                    System.out.println("\nFrustrated with the lack of new knowledge, you put the flag back.");
                    running = false;
                }
                case "i should look closer" -> {
                    if (!flagTaken) {
                        System.out.println("""
                                
                                You move the flag around in the hands, examining every thread. It appears to be a \
                                completely normal flag.
                                As you put it back on the ground, you notice your hands have fresh \
                                blood on them.""");
                        completeTask();
                    } else {
                        System.out.println("\nThe blood on your hands is still there from the last time you " +
                                "picked up the flag.");
                    }
                    running = false;
                }
                default -> System.out.println("\nInvalid input");
            }
        }
    }

    @Override
    public void completeTask() {
        task.setSouthCompleted(true);
        flagTaken = true;
    }
}
