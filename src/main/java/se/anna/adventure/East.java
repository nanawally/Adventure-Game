package se.anna.adventure;

import se.anna.adventurefight.*;

import java.util.Scanner;

public class East implements Directions {
    private final Scanner scanner;
    private Tasks task;
    private Player player;
    private final FightMechanics fightMechanics;
    private boolean haveFought;
    private boolean haveSpoken;

    public East(Scanner scanner, Tasks task, Player player, FightMechanics fightMechanics) {
        this.scanner = scanner;
        this.task = task;
        this.player = player;
        this.fightMechanics = fightMechanics;
        this.haveFought = false;
        this.haveSpoken = false;
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
        boolean shouldInteract = false;
        while (running) {
            System.out.println("""
                    
                    What do you want to do?
                    1. Look around
                    2. Examine the tree stump
                    3. Go back west""");
            String userInput = scanner.nextLine().toLowerCase().trim();

            switch (userInput) {
                case "look around" -> System.out.println("""
                        
                        The forest is immensely beautiful, but as you \
                        look closer at the trees, you notice the leaves are not rustling in the wind.
                        In fact, \
                        there is neither wind nor sound in this clearing.""");
                case "examine the tree stump" -> {
                    if (task.isSouthCompleted() && !task.isEastCompleted()) {
                        System.out.println("""
                                
                                You approach the tree stump, and gently \
                                knock on it.
                                At first, nothing happens.
                                Suddenly, strong winds rush past you from all directions.""");
                        shouldInteract = true;
                        running = false;
                    } else {
                        System.out.println("""
                                
                                You approach the tree stump, and gently \
                                knock on it.
                                Nothing happens.""");
                    }
                }
                case "go back west" -> {
                    System.out.print("\nGoing back west");
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
        if (shouldInteract) {
            interactWithWindSpirit();
        }
    }

    public void interactWithWindSpirit() {
        boolean running = true;
        System.out.println("""
                
                \u001B[31mBLOOD!\u001B[0m a voice cries, its sound being carried \
                in the wind, surrounding you.
                \u001B[31mBLOOD! BLOOD! BLOOD!\u001B[0m
                Before you, the wind picks up leaves and twigs and seems to make itself into a
                massive humanoid shape before you.""");
        while (running) {
            System.out.println("\nWhat will you do?\n1. Attempt to attack the wind spirit\n2. Attempt to speak " +
                    "to the wind spirit\n3. Attempt to flee back west");
            String userInput = scanner.nextLine().toLowerCase().trim();
            switch (userInput) {
                case "attempt to attack the wind spirit" -> {
                    playerAttacksWindSpirit();
                    running = false;
                }
                case "attempt to speak to the wind spirit" -> {
                    speakToWindSpirit();
                    haveSpoken = true;
                    //running = false;
                }
                case "attempt to flee back west" -> {
                    System.out.println("\nYou try to turn around to flee. " +
                            "This seems to anger the spirit.");
                    windSpiritAttacksPlayer();
                    running = false;
                }
            }
        }
    }

    public void speakToWindSpirit() {
        System.out.println("""
                
                You open your mouth to try to speak, but the winds steal your breath away.
                The small rocks that make up the wind spirit's eyes appear fixed on your hands.
                \u001B[31mBLOOD! BLOOD!\u001B[0m it repeats.""");
    }

    public void playerAttacksWindSpirit() {
        Dice dice = new Dice();
        player = new Player("The player (you)", 40, 0);
        Enemy windSpirit = new Enemy("The Wind Spirit", 60, 0);
        if (!haveSpoken) {
            System.out.println("""
                    
                    You try to run at the wind spirit.""");
            fightMechanics.fightRound(player, dice::D4, windSpirit, dice::D12);
            if (player.isAlive() && windSpirit.isAlive()) {
                System.out.println("\nYou use all your might to get back west.");
                return;
            }
        } else {
            System.out.println("""
                    
                    You understand what you must do.
                    You hold out your bloodied hands \
                    towards the wind spirit.
                    It shrieks and your blood runs cold.""");
            fightMechanics.fightRound(player, dice::D8, windSpirit, dice::D4);
        }
        if (!windSpirit.isAlive()) {
            System.out.println("\nYou try to breathe deep breaths.\nYou return west.");
            completeTask();
        }
    }

    public void windSpiritAttacksPlayer() {
        Dice dice = new Dice();
        player = new Player("The player (you)", 40, 0);
        Enemy windSpirit = new Enemy("The Wind Spirit", 60, 0);
        fightMechanics.fightRound(windSpirit, dice::D12, player, dice::D4);
    }

    @Override
    public void completeTask() {
        task.setEastCompleted(true);
        haveFought = true;
    }
}
