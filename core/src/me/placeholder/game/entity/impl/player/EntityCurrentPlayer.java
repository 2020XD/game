package me.placeholder.game.entity.impl.player;

import box2dLight.ConeLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import me.placeholder.game.Platform;
import me.placeholder.game.entity.Entity;
import me.placeholder.utils.MathUtils;
import me.placeholder.utils.TexturesManager;

/**
 * @author Adrian on 4/27/2018
 */
public class EntityCurrentPlayer extends Entity {

    private final Sprite sprite = new Sprite(TexturesManager.playerTexture);
    private Vector2 delta;
    private RayHandler rayHandler;

    public EntityCurrentPlayer(World world) {
        createBody(this, world, 20, 9);
        delta = new Vector2();

        rayHandler = new RayHandler(world);
        rayHandler.setAmbientLight(0.5f);
        ConeLight pointLight = new ConeLight(rayHandler, 1000, Color.WHITE, 300, 0, 0, 0, 30);
        pointLight.attachToBody(body);
    }

    @Override
    public void attack() {
        for (Body body : Platform.get().getEntites()) {
            Entity entity = (Entity) body.getUserData();
            if (entity == this) {
                continue;
            }
            /** check is in range */
            if (MathUtils.getDistanceBetweenPositions(entity.getBody().getPosition(), body.getPosition()) <= stats.getAttackRadius()) {
                /** check if the angle is similar */
                if ((int) getBody().getAngle() == MathUtils.getAngleBetweenPositions(getBody().getPosition(), entity.getBody().getPosition())) {
                    /** attacking state */
                    /** send attack packet for multiplayer */
                    entity.damage(this, stats.getItem());
                }
            }
        }
    }

    @Override
    public void render() {
        rayHandler.setCombinedMatrix(Platform.get().getCamera());
        rayHandler.updateAndRender();

        SpriteBatch spriteBatch = Platform.get().getSpriteBatch();
        sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        sprite.setRotation((float) Math.toDegrees(body.getAngle()));
        spriteBatch.begin();
        sprite.draw(spriteBatch);
        spriteBatch.end();
    }

    @Override
    public void update() {
        moveBody();
    }

    public void moveBody() {
        body.setLinearVelocity(delta.setZero());
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            delta.y += stats.getMovementSpeed();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            delta.y += -stats.getMovementSpeed();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            delta.x += -stats.getMovementSpeed();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            delta.x += stats.getMovementSpeed();
        }
        body.setLinearVelocity(delta);
    }

    public void lookMouse(float mouseX, float mouseY) {
        setAngle((float) Math.atan2((mouseY - body.getPosition().y), (mouseX - body.getPosition().x)));
    }
}
