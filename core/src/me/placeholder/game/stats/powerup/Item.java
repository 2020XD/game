package me.placeholder.game.stats.powerup;

import me.placeholder.game.entity.Entity;

/**
 * @author Adrian on 4/27/2018
 */
public abstract class Item {

    private String itemName;
    private int delay = 0;
    private ItemType itemType;

    public Item() {
    }

    public Item(String itemName, ItemType itemType) {
        this.itemName = itemName;
        this.itemType = itemType;
    }

    /**
     * activation on press
     */
    public void onPress() {
    }

    /**
     * activation on mouse click
     */
    public void onClick(int id, Entity entity) {
    }

    public String getItemName() {
        return itemName;
    }
}
