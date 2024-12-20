package se.anna.adventurefight;

import java.util.Scanner;
import java.util.function.Supplier;

public class FightMechanics {
    static Scanner scanner = new Scanner(System.in);
    private static boolean running = true;

    public void fightRound(Creature attacker, Supplier<Integer>attackerDice, Creature defender, Supplier<Integer>defenderDice) {
        while (running && attacker.isAlive() && defender.isAlive()) {
            int attackerDamage = attackerDice.get();
            int defenderDamage = defenderDice.get();
            attacker.setDamage(attackerDamage);
            defender.setDamage(defenderDamage);
            executeAttack(attacker, defender);
            if (defender.isAlive()) {
                executeAttack(defender, attacker);
            }
            if (attacker.isAlive() && defender.isAlive()) {
                String userInput;
                do {
                    System.out.println("\nDo you wish to continue fighting?");
                    userInput = scanner.nextLine().toLowerCase().trim();
                    if (userInput.equals("no")) {
                        running = false;
                    } else if (!userInput.equals("yes")) {
                        System.out.println("Invalid input");
                    }
                } while (!userInput.equals("yes") && running);
            }
        }
        running = true;
    }

    static void executeAttack(Creature attacker, Creature defender) {
        attacker.attack(defender);
        System.out.println("\n" + attacker.getName() + " has attacked " + defender.getName()+".");
        if (defender.isAlive()) {
            System.out.println("\n" + defender.getName() + " has " + defender.getHealth() + " hit points remaining.");
        } else {
            System.out.println("\n" + defender.getName() + " has been killed.");
        }
    }
}
