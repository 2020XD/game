package me.placeholder.utils;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by AwfaZ on 2/05/2018.
 */
public class MathUtils {

    /**
     * Pythagorean theorem
     *
     * @param posA first position
     * @param posB second position
     * @return direct distance between two positions
     */
    public static double getDistanceBetweenPositions(Vector2 posA, Vector2 posB) {
        return Math.sqrt(Math.pow(posA.x - posB.y, 2) + Math.pow(posA.y - posB.y, 2));
    }

    public static double getAngleBetweenPositions(Vector2 origin, Vector2 pos) {
        return Math.atan((origin.y - pos.y) / (origin.x - pos.x));
    }
}
