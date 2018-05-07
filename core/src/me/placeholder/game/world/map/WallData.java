package me.placeholder.game.world.map;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by Adrian on 7/05/2018.
 */
public class WallData {

    private int sizeX, sizeY;
    private Vector2 pos;

    public WallData(Vector2 pos) {
        this.pos = pos;
    }

    public int getSizeX() {
        return sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }
}
