package me.placeholder.game.entity.impl.player;

import box2dLight.ConeLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
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

    public RayHandler rayHandler;
    private Cycle cycle = Cycle.STATIC;
    private Sprite sprite;
    private Vector2 delta;

    public EntityCurrentPlayer(World world) {
        createBody(this, world, 20, 9);
        delta = new Vector2();

        rayHandler = new RayHandler(world);
        rayHandler.setAmbientLight(0.5f);
        ConeLight pointLight = new ConeLight(rayHandler, 50, Color.valueOf("646464"), stats.getAttackRadius() * 10, 0, 0, 0, 30);
        pointLight.attachToBody(body);

        sprite = cycle.sprite;
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
        OrthographicCamera camera = Platform.get().getCamera();
        rayHandler.setCombinedMatrix(camera);
        rayHandler.updateAndRender();

        SpriteBatch spriteBatch = Platform.get().getSpriteBatch();
        spriteBatch.begin();

        sprite.setPosition(body.getPosition().x - sprite.getWidth() / 2, body.getPosition().y - sprite.getHeight() / 2);
        sprite.setRotation((float) Math.toDegrees(body.getAngle()));
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

    enum Cycle {
        STATIC(new Sprite(TexturesManager.playerTexture)), RUNNING(new Sprite(TexturesManager.playerTexture));

        Sprite sprite;

        Cycle(Sprite sprite) {
            this.sprite = sprite;
        }
    }
}
