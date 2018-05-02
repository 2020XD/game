package me.placeholder.game.entity.impl.player;

import box2dLight.PointLight;
import box2dLight.RayHandler;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.World;
import me.placeholder.game.entity.Entity;
import me.placeholder.utils.MathUtils;

/**
 * @author Adrian on 4/27/2018
 */
public class EntityCurrentPlayer extends Entity {

    private Vector2 delta;
    private RayHandler rayHandler;
    private OrthographicCamera camera;

    public EntityCurrentPlayer(World world, OrthographicCamera camera) {
        super(world, 8, 8);
        this.camera = camera;
        delta = new Vector2();

        rayHandler = new RayHandler(world);
        rayHandler.setAmbientLight(0.5f);
        PointLight pointLight = new PointLight(rayHandler, 50, Color.WHITE, stats.getAttackRadius(), 0, 0);
        pointLight.attachToBody(body);
        body.setLinearDamping(0);
    }

    @Override
    public void attack(Entity entity) {
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

    @Override
    public void render(SpriteBatch spriteBatch) {
        rayHandler.setCombinedMatrix(camera);
        rayHandler.updateAndRender();
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
        setAngle((float) Math.atan((mouseY - body.getPosition().y) / (mouseX - body.getPosition().x)));
    }
}
