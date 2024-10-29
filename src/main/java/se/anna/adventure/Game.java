package se.anna.adventure;

import java.util.Scanner;

public class Game {
    private final Scanner scanner = new Scanner(System.in);

    public void start() throws InterruptedException {
        CentreMenu menu = new CentreMenu(scanner);
        menu.welcome();
        menu.introduction();
        MapDirections map = new MapDirections(scanner, menu);
        map.chooseDirection();
    }
}
