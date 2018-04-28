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
import me.placeholder.game.entity.impl.EntityPlayer;

/**
 * @author Adrian on 4/27/2018
 */
public class EntityCurrentPlayer extends EntityPlayer {

    /**
     * TODO: stats
     */
    private int movementSpeed = 5;
    OrthographicCamera camera;
    private float angle = 0;
    private Vector2 delta;
    private RayHandler rayHandler;

    public EntityCurrentPlayer(World world, OrthographicCamera camera) {
        super(world);
        this.camera = camera;
        delta = new Vector2();
        rayHandler = new RayHandler(world);
        rayHandler.setAmbientLight(0.5f);
        PointLight pointLight = new PointLight(rayHandler, 100, Color.WHITE, 400, 0, 0);
        pointLight.attachToBody(body);
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
        delta = body.getPosition();
        if (Gdx.input.isKeyPressed(Input.Keys.W)) {
            delta.y += movementSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.A)) {
            delta.x += -movementSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.S)) {
            delta.y += -movementSpeed;
        }
        if (Gdx.input.isKeyPressed(Input.Keys.D)) {
            delta.x += movementSpeed;
        }
        body.setTransform(delta, angle);
    }

    public void lookMouse(float mouseX, float mouseY) {
        angle = (float) Math.atan((mouseY - body.getPosition().y) / (mouseX - body.getPosition().x));
    }
}
