package se.anna.adventure;

import java.util.Scanner;

public class MapDirections {
    private Directions north;
    private Directions south;
    private Directions east;
    private Directions west;
    private Scanner scanner;

    public MapDirections(Scanner scanner) {
        this.scanner = scanner;
        this.north = new North(scanner);
        this.south = new South(scanner);
        this.east = new East(scanner);
        this.west = new West(scanner);
    }

    public void chooseDirection() throws InterruptedException {
        CentreMenu centreMenu = new CentreMenu();
        boolean running = true;

        while (running) {
            switch (centreMenu.centreMenu()) {
                case "go north" -> {
                    System.out.print("\nGoing north");
                    for (int i = 0; i<3; i++){
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    System.out.println("");
                    north.surroundings();
                    north.menu();
                }
                case "go south" -> {
                    System.out.print("\nGoing south");
                    for (int i = 0; i<3; i++){
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    System.out.println("");
                    south.surroundings();
                    south.menu();
                }
                case "go east" -> {
                    System.out.print("\nGoing east");
                    for (int i = 0; i<3; i++){
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    System.out.println("");
                    east.surroundings();
                    east.menu();
                }
                case "go west" -> {
                    System.out.print("\nGoing west");
                    for (int i = 0; i<3; i++){
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    System.out.println("");
                    west.surroundings();
                    west.menu();
                }
                case "quit game" -> {
                    System.out.print("\nQuitting game");
                    for (int i = 0; i<3; i++){
                        Thread.sleep(1000);
                        System.out.print(".");
                    }
                    running = false;
                }
                default -> System.out.println("\nInvalid input");
            }
        }
    }
}
