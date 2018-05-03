package me.placeholder.game.entity;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;
import me.placeholder.game.Platform;
import me.placeholder.game.stats.Stats;
import me.placeholder.game.stats.powerup.Item;
import me.placeholder.game.world.WorldBodies;

/**
 * Created by Adrian on 27/04/2018.
 */
public abstract class Entity {

    protected Stats stats;
    protected Body body;

    public Entity() {
        stats = new Stats();
    }

    public void createBody(Entity entity, World world, int sizeX, int sizeY) {
        body = WorldBodies.createEntityBody(entity, world, 0, 0, sizeX, sizeY);
    }

    public abstract void update();

    public abstract void render();

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public void setAngle(float angle) {
        body.setTransform(body.getPosition(), angle);
    }

    public Body getBody() {
        return body;
    }

    public void attack() {
    }

    public void damage(Entity attacker, Item withItem) {
    }

    public Vector3 getProjectedCoords() {
        return Platform.get().getCamera().project(new Vector3(body.getPosition().x, body.getPosition().y, 0));
    }
}
