package me.placeholder.game.stats.powerup;

/**
 * @author Adrian on 4/27/2018
 */
public abstract class Item {

    private String itemName;

    public Item() {}

    public Item(String itemName) {
        this.itemName = itemName;
    }

    /**
     * ability
     */
    public abstract void use();

    public String getItemName() {
        return itemName;
    }
}
