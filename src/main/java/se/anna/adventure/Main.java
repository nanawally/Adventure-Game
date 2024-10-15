package se.anna.adventure;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("Welcome to this adventure game!");
        Scanner scanner = new Scanner(System.in);
        MapDirections map = new MapDirections(scanner);
        map.chooseDirection();
    }
}
