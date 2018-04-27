package me.placeholder.game.entity.impl;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.placeholder.game.entity.Entity;

/**
 * @author Adrian on 4/27/2018
 */
public class EntityPlayer implements Entity {
    private Texture texture;

    public EntityPlayer(Texture texture) {
        this.texture = texture;
    }

    @Override
    public void update() {

    }

    @Override
    public void render(SpriteBatch spriteBatch) {
//        spriteBatch.draw(texture );
    }
}
