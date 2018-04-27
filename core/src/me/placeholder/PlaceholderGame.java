package me.placeholder;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.placeholder.screen.MainScreen;

public class PlaceholderGame extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        setScreen(new MainScreen(this));
    }

    @Override
    public void render() {
        super.render();
        if (Gdx.input.isKeyPressed(Input.Keys.F11)) {
            Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
        }
    }
}
