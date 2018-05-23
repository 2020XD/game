package me.placeholder.game.world.types.tile;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by AwfaZ on 4/05/2018.
 */
public class TileData {

    private Vector2 pos;

    private int length;
    private int width;

    public TileData(Vector2 pos) {
        this.pos = pos;
        length = 16;
        width = 16;
    }

    public Vector2 getPos() {
        return pos;
    }
}
