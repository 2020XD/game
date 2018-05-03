package me.placeholder.game.stats.powerup.impl;

import me.placeholder.game.entity.impl.player.EntityCurrentPlayer;
import me.placeholder.game.stats.powerup.Item;
import me.placeholder.game.stats.powerup.ItemType;

/**
 * @author Adrian on 4/27/2018
 */
public class Sword extends Item {

    private int delay;

    public Sword() {
        super("sword", ItemType.ACTIVE);
    }

    @Override
    public void onClick(int id, EntityCurrentPlayer holder) {
        /**
         * todo delay
         */
        if (id == 0) {
            holder.attack();
        }
    }

    @Override
    public void render() {

    }
}
