package se.anna.adventurefight;

public class Creature {
    private String name;
    private int health;
    protected int damage;

    public Creature(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int takeDamage(int damage) {
        health -= damage;
        return health;
    }

    public void attack(Creature toAttack) {
        toAttack.takeDamage(damage);
    }

    public boolean isAlive() {
        if (health > 0) {
            return true;
        } else {
            return false;
        }
    }
}
