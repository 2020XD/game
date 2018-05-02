package me.placeholder.game.stats;

import me.placeholder.game.stats.powerup.Item;

/**
 * @author Adrian on 4/27/2018
 *         TODO: finish this
 */
public class Stats {

    private int playerHealth = 20;
    private int attackRadius = 40;
    private int movementSpeed = 100;

    private Item item;

    public Stats() {
    }

    public int getPlayerHealth() {
        return playerHealth;
    }

    public int getAttackRadius() {
        return attackRadius;
    }

    public int getMovementSpeed() {
        return movementSpeed;
    }

    public Item getItem() {
        return item;
    }
}
