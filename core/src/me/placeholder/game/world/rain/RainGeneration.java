package me.placeholder.game.world.rain;

import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * Created by AwfaZ on 1/06/2018.
 */
public class RainGeneration {

    int sizeX;
    int sizeY;
    private Array<Rain> rains = new Array();
    private Random random = new Random();

    public RainGeneration(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;

        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                rains.add(new Rain(new Vector2(i, j)));
            }
        }
    }


    public void update() {
    }

    public void render() {

    }
}
