package me.placeholder.game.entity.impl;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.physics.box2d.*;
import me.placeholder.game.entity.Entity;

/**
 * @author Adrian on 4/27/2018
 */
public abstract class EntityPlayer implements Entity {

    /**
     * TODO: stats
     */
    protected Body body;

    public EntityPlayer(World world) {
        BodyDef bodyDef = new BodyDef();
        bodyDef.position.set(0, 0);
        bodyDef.type = BodyDef.BodyType.DynamicBody;
        body = world.createBody(bodyDef);

        PolygonShape polygonShape = new PolygonShape();
        polygonShape.setAsBox(32, 32);

        FixtureDef fixtureDef = new FixtureDef();
        fixtureDef.shape = polygonShape;
        body.createFixture(fixtureDef);
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
