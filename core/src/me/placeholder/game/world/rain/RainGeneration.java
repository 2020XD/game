package me.placeholder.game.world.rain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Random;

/**
 * Created by AwfaZ on 1/06/2018.
 */
public class RainGeneration {

    private Array<Rain> rains = new Array();
    private Random random = new Random();
    private SpriteBatch spriteBatch = new SpriteBatch();
    private TimeUtils alive = new TimeUtils();

    public RainGeneration() {
        for (int i = 0; i < Gdx.graphics.getWidth() / 16; i++) {
            for (int j = 0; j < Gdx.graphics.getHeight() / 16; j++) {
                rains.add(new Rain(new Vector3(i * 16, j * 16, 0), random.nextBoolean()));
            }
        }
    }

    public void update() {
        for (Rain rain : rains) {
            rain.update();
        }
    }

    public void render() {
        spriteBatch.begin();
        for (Rain rain : rains) {
            if (rain.isInRange())
                spriteBatch.draw(rain.getRainCycle().texture, rain.getPos().x, rain.getPos().y);
        }
        spriteBatch.end();
    }
}
