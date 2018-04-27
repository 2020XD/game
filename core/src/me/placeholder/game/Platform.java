package me.placeholder.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.*;
import me.placeholder.game.entity.Entity;

import java.util.ArrayList;

/**
 * Created by Adrian on 27/04/2018.
 */
public class Platform {

    private SpriteBatch spriteBatch;

    private ArrayList<Entity> entities;

    private World world;
    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;
    private FPSLogger logger;

    public Platform(SpriteBatch spriteBatch) {
        this.spriteBatch = spriteBatch;
        entities = new ArrayList();
        renderer = new Box2DDebugRenderer();
        logger = new FPSLogger();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        camera.update();
        camera.zoom -= 0.7f;

        /**
         * Testing BOX2D
         */
        world = new World(new Vector2(0, -9.8f), false);

        BodyDef ground = new BodyDef();
        ground.position.set(0, -10);
        Body groundBody = world.createBody(ground);
        PolygonShape groundShape = new PolygonShape();
        groundShape.setAsBox(1000, 3.0f);
        groundBody.createFixture(groundShape, 0f);

    }

    Vector3 getMousePosInGameWorld() {
        return camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
    }

    public void update() {
        if (Gdx.input.justTouched()) {
            BodyDef circleTest = new BodyDef();
            circleTest.type = BodyDef.BodyType.DynamicBody;
            circleTest.position.set(getMousePosInGameWorld().x, getMousePosInGameWorld().y);

            Body circleBody = world.createBody(circleTest);
            CircleShape circleShape = new CircleShape();
            circleShape.setRadius(8f);
            FixtureDef circleFixture = new FixtureDef();
            circleFixture.shape = circleShape;
            circleFixture.density = 0.4f;
            circleFixture.friction = 0.2f;
            circleFixture.restitution = 0.8f;
            circleBody.createFixture(circleFixture);
        }
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
        camera.update();
        renderer.render(world, camera.combined);
        logger.log();
        world.step(1f/60f, 10, 2);
    }

}
