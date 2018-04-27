package me.placeholder.game.entity.impl.player;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.physics.box2d.World;
import me.placeholder.game.entity.impl.EntityPlayer;

/**
 * @author Adrian on 4/27/2018
 */
public class EntityCurrentPlayer extends EntityPlayer {

    /**
     * TODO: stats
     */
    private int movementSpeed = 5;

    public EntityCurrentPlayer(World world) {
        super(world);
    }

    @Override
    public void update() {
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            body.setTransform(body.getPosition().x, body.getPosition().y + movementSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            body.setTransform(body.getPosition().x - movementSpeed, body.getPosition().y, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            body.setTransform(body.getPosition().x, body.getPosition().y - movementSpeed, 0);
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            body.setTransform(body.getPosition().x + movementSpeed, body.getPosition().y, 0);
        }
    }
}
