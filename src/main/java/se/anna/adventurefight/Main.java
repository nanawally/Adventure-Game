package se.anna.adventurefight;


public class Main {
    private static Player player;
    private static Enemy lakeCreature;
    private static Enemy windSpirit;
    private static boolean running = true;

    public static void main(String[] args) {
        Dice dice = new Dice();
        player = new Player("The player (you)", 40, dice.D8());
        lakeCreature = new Enemy("The Lake Creature", 30, (2*dice.D6()));
        windSpirit = new Enemy("The Wind Spirit", 100, dice.D4());

        //FightMechanics.fightRound(player, lakeCreature);
        if (player.getHealth() > lakeCreature.getHealth() && lakeCreature.isAlive()){
            System.out.println("You have chosen to leave the fight.");
        } else if (player.getHealth() < lakeCreature.getHealth() && lakeCreature.isAlive()) {
            System.out.println("You have fled the fight.");
        }
    }
}
