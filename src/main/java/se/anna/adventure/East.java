package se.anna.adventure;

import java.util.Scanner;

public class East implements Directions {
    private final Scanner scanner;
    private Tasks task;

    public East(Scanner scanner, Tasks task) {
        this.scanner = scanner;
        this.task = task;
    }

    @Override
    public void surroundings() {
        System.out.println("""
                
                You go to the east. You come to a clearing in a forest. The tree leaves are \
                all various shades of auburn.
                You see a tree stump that appears to be hollow.""");
    }

    @Override
    public void menu() throws InterruptedException {
        boolean running = true;
        while (running) {
            System.out.println("""
                    
                    What do you want to do?
                    1. Look around
                    2. Examine the tree stump\
                    
                    3. Go back west""");
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "look around" -> System.out.println("""
                        
                        The forest is immensely beautiful, but as you \
                        look closer at the trees, you notice the leaves are not rustling in the wind.
                        In fact, \
                        there is neither wind nor sound in this clearing.""");
                case "examine the tree stump" -> System.out.println("""
                        
                        You approach the tree stump, and gently \
                        knock on it.
                        Nothing happens.""");
                case "go back west" -> {
                    System.out.print("\nGoing back west");
                    for (int i = 0; i<3;i++){
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

    @Override
    public void completeTask() {
        task.setEastCompleted(true);
        // boolean personal to the class = true;
    }
}
