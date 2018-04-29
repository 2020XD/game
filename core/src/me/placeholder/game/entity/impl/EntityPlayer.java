package me.placeholder.game.entity.impl;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import me.placeholder.game.entity.Entity;
import me.placeholder.game.world.WorldBodies;

/**
 * @author Adrian on 4/27/2018
 */
public abstract class EntityPlayer implements Entity {

    /**
     * TODO: stats
     */
    protected Body body;

    public EntityPlayer(World world) {
        body = WorldBodies.createEntityBody(world, 0, 0, 8, 8);
    }

    @Override
    public void update() {
    }

    @Override
    public void render(SpriteBatch spriteBatch) {
    }

    public Body getBody() {
        return body;
    }
}
