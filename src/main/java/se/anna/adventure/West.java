package se.anna.adventure;

import se.anna.adventurefight.*;

import java.util.Scanner;


public class West implements Directions {
    private final Scanner scanner;
    private Tasks task;
    private Player player;
    private FightMechanics fightMechanics;
    private boolean haveFought;

    public West(Scanner scanner, Tasks task, Player player, FightMechanics fightMechanics) {
        this.scanner = scanner;
        this.task = task;
        this.player = player;
        this.fightMechanics = fightMechanics;
        this.haveFought = false;
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

        if (!task.isNorthCompleted()) {
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
                    firstFight();
                    break;
                } else {
                    System.out.println("Invalid input");
                }
            }
            while (true);
        } else {
            secondFight();
        }
    }

    void diplomacy() {
        System.out.println("""
                
                The creature croaks. Is it... laughing?
                'Poor fool', the creature says. 'What \
                you seek is not here. You are going to leave now.'""");
        System.out.println("Your vision goes dark. You wake up on the ground.");
    }

    void firstFight() {
        System.out.println("""
                
                You leap at the creature. In the blink of an eye it has moved out of your way, \
                and you trip.
                As you hit your head hard on the ground, you swear you can hear a croaking \
                laugh becoming fainter...""");
        System.out.println("Your vision goes dark. You wake up on the ground.");
    }

    private void secondFight() {
        System.out.println("\nSuddenly, the creature's eyes widen as it spots the rusty medallion in your hand." +
                "\nBefore you can think, it has launched itself at you.");
        Enemy lakeCreature = new Enemy("The Lake Creature", 40, 10);
        fightMechanics.fightRound(lakeCreature, player);
        if (player.getHealth() > lakeCreature.getHealth() && lakeCreature.isAlive()) {
            System.out.println("You have chosen to leave the fight and go back east.");
        } else if (player.getHealth() < lakeCreature.getHealth() && lakeCreature.isAlive()) {
            System.out.println("You have fled the fight and gone back east.");
        }
        if (!lakeCreature.isAlive()) {
            completeTask();
        }
    }

    @Override
    public void completeTask() {
        task.setWestCompleted(true);
        haveFought = true;
    }
}
