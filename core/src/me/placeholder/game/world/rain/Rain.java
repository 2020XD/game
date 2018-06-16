package me.placeholder.game.world.rain;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector3;

/**
 * Created by AwfaZ on 1/06/2018.
 */
public class Rain {

    private Vector3 pos;
    private RainCycle rainCycle;

    private boolean inRange;

    private double z = 0;

    public Rain(Vector3 pos, boolean inRange) {
        this.pos = pos;
        this.rainCycle = RainCycle.DROPPING;
        this.inRange = inRange;
//        z = Math.sqrt(Math.pow((Gdx.graphics.getWidth() / 2 - pos.x), 2) + Math.pow((Gdx.graphics.getHeight() / 2 - pos.y), 2));
//        System.out.println(pos.toString());
    }

    public void update() {
        double a = (double) Gdx.graphics.getWidth() / (double) Gdx.graphics.getHeight();

        if (pos.x - Gdx.graphics.getWidth() / 2 > 0) {
            pos.x -= a;
        } else {
            pos.x += a;
        }

        double b = (double) Gdx.graphics.getHeight() / (double) Gdx.graphics.getWidth();

        if (pos.y - Gdx.graphics.getHeight() / 2 > 0) {
            pos.y -= b;
        } else {
            pos.y += b;
        }

    }

    public boolean isInRange() {
        return inRange;
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
