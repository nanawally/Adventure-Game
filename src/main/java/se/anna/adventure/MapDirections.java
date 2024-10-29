package se.anna.adventure;

import se.anna.adventurefight.FightMechanics;
import se.anna.adventurefight.Player;

import java.util.Scanner;

public class MapDirections {
    private final Tasks tasks;
    private Player player;
    private FightMechanics fightMechanics;
    private final Directions north;
    private final Directions south;
    private final Directions east;
    private final Directions west;
    private final CentreMenu centreMenu;

    public MapDirections(Scanner scanner, CentreMenu centreMenu) {
        this.tasks = new Tasks();
        this.player = new Player("The player (you)", 40, 0);
        this.fightMechanics = new FightMechanics();
        this.north = new North(scanner, this.tasks);
        this.south = new South(scanner, this.tasks);
        this.east = new East(scanner, this.tasks, this.player, this.fightMechanics);
        this.west = new West(scanner, this.tasks, this.player, this.fightMechanics);
        this.centreMenu = centreMenu;
    }

    public void chooseDirection() throws InterruptedException {
        boolean running = true;
        while (running) {
            if (tasks.isNorthCompleted() && tasks.isSouthCompleted() && tasks.isEastCompleted() && tasks.isWestCompleted()) {
                centreMenu.allTasksCompleteMenu();
                centreMenu.closeScanner();
                running = false;
            } else {
                switch (centreMenu.showMenuTakeUserInput()) {
                    case "go north" -> directionGo("north", north);

                    case "go south" -> directionGo("south", south);

                    case "go east" -> directionGo("east", east);

                    case "go west" -> directionGo("west", west);

                    case "quit game" -> {
                        System.out.print("\nThank you for playing!\nQuitting game");
                        for (int i = 0; i < 3; i++) {
                            Thread.sleep(1000);
                            System.out.print(".");
                        }
                        centreMenu.closeScanner();
                        running = false;
                    }
                    default -> System.out.println("\nInvalid input");
                }
            }
        }
    }

    public void directionGo(String directionName, Directions name) throws InterruptedException {
        System.out.print("\nGoing " + directionName);
        for (int i = 0; i < 3; i++) {
            Thread.sleep(1000);
            System.out.print(".");
        }
        System.out.println();
        name.surroundings();
        name.menu();
    }
}
