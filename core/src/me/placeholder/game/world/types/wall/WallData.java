package me.placeholder.game.world.types.wall;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by AwfaZ on 4/05/2018.
 */
public class WallData {

    private Vector2 pos;
    private WallType type;

    private int length, width;

    public WallData(Vector2 pos, WallType type) {
        this.pos = pos;
        this.type = type;

        this.length = type.length;
        this.width = type.length;
    }

    public int getWidth() {
        return width;
    }

    public int getLength() {
        return length;
    }

    public Vector2 getPos() {
        return pos;
    }

    public WallType getType() {
        return type;
    }
}
