package se.anna.adventure;

import java.util.Scanner;

public class MapDirections {
    private final Directions north;
    private final Directions south;
    private final Directions east;
    private final Directions west;
    private final Scanner scanner;

    public MapDirections(Scanner scanner) {
        this.scanner = scanner;
        this.north = new North(scanner);
        this.south = new South(scanner);
        this.east = new East(scanner);
        this.west = new West(scanner);
    }

    public void chooseDirection() throws InterruptedException {
        CentreMenu centreMenu = new CentreMenu(scanner);
        boolean running = true;

        while (running) {
            switch (centreMenu.showMenuTakeUserInput()) {
                case "go north" -> directionGo("north", north);

                case "go south" -> directionGo("south", south);

                case "go east" -> directionGo("east", east);

                case "go west" -> directionGo("west", west);

                case "quit game" -> {
                    System.out.print("\nQuitting game");
                    for (int i = 0; i < 3; i++) {
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    running = false;
                }
                default -> System.out.println("\nInvalid input");
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
