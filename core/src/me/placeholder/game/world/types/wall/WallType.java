package me.placeholder.game.world.types.wall;

/**
 * Created by AwfaZ on 4/05/2018.
 */
public enum WallType {
    WALL(16, 4), DOOR(2, 2), NONE(0, 0);

    public int length;
    public int width;

    WallType(int length, int width) {
        this.length = length;
        this.width = width;
    }
}
