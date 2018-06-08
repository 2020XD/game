package me.placeholder.game.world.rain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;

import java.util.Random;

/**
 * Created by AwfaZ on 1/06/2018.
 */
public class RainGeneration {

    private Array<Rain> rains = new Array();
    private Random random = new Random();
    private SpriteBatch spriteBatch = new SpriteBatch();

    public RainGeneration() {
        for (int i = 0; i < Gdx.graphics.getWidth() / 16; i++) {
            for (int j = 0; j < Gdx.graphics.getHeight() / 16; j++) {
                rains.add(new Rain(new Vector3(i * 16, j * 16, 0)));
            }
        }
    }

    public void update() {
    }

    public void render() {
        spriteBatch.begin();
        for (Rain rain : rains) {
            spriteBatch.draw(rain.getRainCycle().texture, rain.getPos().x, rain.getPos().y);
        }
        spriteBatch.end();
    }
}
