package me.placeholder.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.FPSLogger;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import me.placeholder.game.entity.Entity;
import me.placeholder.game.entity.impl.player.EntityCurrentPlayer;
import me.placeholder.game.world.WorldGeneration;
import me.placeholder.game.world.tile.TileData;

import java.util.ArrayList;

/**
 * Created by Adrian on 27/04/2018.
 */
public class Platform {

    private final static Platform INSTANCE = new Platform();
    WorldGeneration worldGeneration;
    ArrayList<TileData> walls;
    ShapeRenderer render
            = new ShapeRenderer();
    TiledMap map;
    TiledMapRenderer mapRenderer;
    float amb = 0.5f;
    private SpriteBatch spriteBatch = new SpriteBatch();
    private EntityCurrentPlayer player;
    private World world;
    private OrthographicCamera camera;
    private Box2DDebugRenderer renderer;
    private FPSLogger logger;
    private ScreenViewport viewport;
    private long startTime;
    private boolean zoomingIn = true;

    public Platform() {
        worldGeneration = new WorldGeneration();
        renderer = new Box2DDebugRenderer();
        logger = new FPSLogger();
        camera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        viewport = new ScreenViewport(camera);

        world = new World(new Vector2(0, 0), false);

        walls = new ArrayList();

        player = new EntityCurrentPlayer(world);

        worldGeneration.createWorld();
        walls.addAll(worldGeneration.getCoords());

//        walls.forEach(w -> WorldBodies.createWall(world, w.getPos().x * 400, w.getPos().y * 400, 400, 5));
//        walls.forEach(w -> WorldBodies.createWall(world, w.getPos().x * 400, w.getPos().y * 400, 5, 400));

        startTime = TimeUtils.millis();

        map = new TmxMapLoader().load("textures/testmap.tmx");
        mapRenderer = new OrthogonalTiledMapRenderer(map);
    }

    public static Platform get() {
        return INSTANCE;
    }

    private Vector3 getMousePosCamera() {
        return camera.unproject(new Vector3(Gdx.input.getX(), Gdx.input.getY(), 0));
    }

    /**
     * TODO: use {@link Interpolation} to do bounceIn
     */
    public void cameraUpdate() {
        camera.position.x = camera.position.x + (player.getBody().getPosition().x - camera.position.x) * 0.02f + (Gdx.input.getX() - Gdx.graphics.getWidth() / 2) / 200;
        camera.position.y = camera.position.y + (player.getBody().getPosition().y - camera.position.y) * 0.04f + (Gdx.graphics.getHeight() / 2 - Gdx.input.getY()) / 200;
        camera.update();
    }

    public void update() {
        world.step(1f / 60f, 6, 2);
        logger.log();

        cameraUpdate();
        Vector3 cameraPos = getMousePosCamera();
        player.lookMouse(cameraPos.x, cameraPos.y);
        player.update();

        /**
         * Zoom in
         */
        if (zoomingIn) {
            if (TimeUtils.timeSinceMillis(startTime) > 1000) {
                if ((int) (camera.zoom * 1000) > 400f)
                    camera.zoom = Interpolation.bounceIn.apply(camera.zoom, 0.4f, 0.03f);
                else zoomingIn = false;
                if ((int) (amb * 100) > 10) {
                    amb = Interpolation.bounceIn.apply(amb, 0.1f, 0.03f);
                    player.rayHandler.setAmbientLight(amb);
                }
            }
        }
        if (Gdx.input.isKeyPressed(Input.Keys.EQUALS)) camera.zoom -= 0.2f;
        if (Gdx.input.isKeyPressed(Input.Keys.MINUS)) camera.zoom += 0.2f;
    }

    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
        render.begin(ShapeRenderer.ShapeType.Filled);
        render.rect(0, 0, viewport.getScreenWidth(), viewport.getScreenHeight(), Color.valueOf("FFFFFF"), Color.valueOf("FFFFFF"), Color.valueOf("FF0000"), Color.valueOf("FF0000"));
        render.end();
        spriteBatch.setProjectionMatrix(camera.combined);
        mapRenderer.setView(camera);
        mapRenderer.render();
        spriteBatch.begin();
//        for (int j = 0; j < 20; j++) {
//            for (int i = 0; i < 20; i++) {
//                spriteBatch.draw(TexturesManager.floorTexture, i * 128, j * 128);
//            }
//        }
        spriteBatch.end();
        player.render();
//        renderer.render(world, camera.combined);
    }

    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    public Array<Body> getEntites() {
        Array<Body> worldBodies = new Array<Body>();
        Array<Body> entityBodies = new Array<Body>();
        world.getBodies(worldBodies);
        for (Body body : worldBodies)
            if (body.getUserData() instanceof Entity) {
                entityBodies.add(body);
            }
        return entityBodies;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }
}
