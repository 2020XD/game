package me.placeholder;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.placeholder.screen.MainScreen;

public class PlaceholderGame extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        setScreen(new MainScreen(this));
    }
}
