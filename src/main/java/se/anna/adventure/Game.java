package se.anna.adventure;

import java.util.Scanner;

public class Game {
    private Scanner scanner = new Scanner(System.in);

    public void start() throws InterruptedException {
        CentreMenu menu = new CentreMenu();
        menu.welcome();
        menu.introduction();
        MapDirections map = new MapDirections(scanner);
        map.chooseDirection();
    }
}
