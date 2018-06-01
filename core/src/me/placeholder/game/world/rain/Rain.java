package me.placeholder.game.world.rain;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by AwfaZ on 1/06/2018.
 */
public class Rain {

    private Vector2 pos;
    private RainCycle rainCycle;

    public Rain(Vector2 pos) {
        this.pos = pos;
        this.rainCycle = RainCycle.DROPPING;
    }

    public RainCycle getRainCycle() {
        return rainCycle;
    }
}
