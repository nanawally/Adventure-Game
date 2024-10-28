package se.anna.adventurefight;

import java.util.Random;

public class Dice {

    public int D4() {
        Random random = new Random();
        int roll = random.nextInt(4) + 1;
        return roll;
    }

    public int D6() {
        Random random = new Random();
        int roll = random.nextInt(6) + 1;
        return roll;
    }

    public int D8() {
        Random random = new Random();
        int roll = random.nextInt(8) + 1;
        return roll;
    }

    public int D12() {
        Random random = new Random();
        int roll = random.nextInt(12) + 1;
        return roll;
    }
}
