package me.placeholder.game.world.rain;

import com.badlogic.gdx.graphics.Texture;
import me.placeholder.utils.TexturesManager;

/**
 * Created by AwfaZ on 1/06/2018.
 */
public enum RainCycle {
    DROPPING(TexturesManager.rain1), SPLASHING(TexturesManager.rain2), END(TexturesManager.rain3);

    public final Texture texture;

    RainCycle(Texture texture) {
        this.texture = texture;
    }
}
