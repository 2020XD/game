package me.placeholder.game.world.tile;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by AwfaZ on 4/05/2018.
 */
public class TileData {

    private Vector2 pos;
    private TileType type;

    public TileData(Vector2 pos, TileType type) {
        this.pos = pos;
        this.type = type;
    }

    public Vector2 getPos() {
        return pos;
    }

    public TileType getType() {
        return type;
    }
}
