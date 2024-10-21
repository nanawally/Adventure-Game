package se.anna.adventure;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);

    public void start() throws InterruptedException {
        CentreMenu menu = new CentreMenu(scanner);
        menu.welcome();
        menu.introduction();
        MapDirections map = new MapDirections(scanner);
        map.chooseDirection();
    }
}

//använda olika färger på det man skriver ut till konsollen:
//
//System.out.println("\u001B[31m" + "Detta är en röd text" + "\u001B[0m");
//System.out.println("\u001B[32m" + "Detta är en grön text" + "\u001B[0m");
//System.out.println("\u001B[33m" + "Detta är en gul text" + "\u001B[0m");
//System.out.println("\u001B[44m" + "Detta är en text med blå bakgrund" + "\u001B[0m");
// System.out.println("\u001B[31m" + "Röd text, " + "\u001B[32m" + "grön text, " + "\u001B[34m" + "blå text." + "\u001B[0m");
