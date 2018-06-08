package me.placeholder.game.world.rain;

import com.badlogic.gdx.math.Vector3;

/**
 * Created by AwfaZ on 1/06/2018.
 */
public class Rain {

    private Vector3 pos;
    private RainCycle rainCycle;

    public Rain(Vector3 pos) {
        this.pos = pos;
        this.rainCycle = RainCycle.DROPPING;
    }

    public void update() {

    }

    public RainCycle getRainCycle() {
        return rainCycle;
    }

    public Vector3 getPos() {
        return pos;
    }

    public void setPos(Vector3 v) {
        pos = (v);
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Vector3 ? pos.equals(obj) : super.equals(obj);
    }
}
