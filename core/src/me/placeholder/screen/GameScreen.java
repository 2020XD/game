package me.placeholder.screen;

import com.badlogic.gdx.Screen;
import me.placeholder.PlaceholderGame;
import me.placeholder.game.Platform;

/**
 * Created by Adrian on 27/04/2018.
 */
public class GameScreen implements Screen {

    /**
     * main game thing w/ all the entities
     */
    private Platform platform;

    public GameScreen(PlaceholderGame game) {
        platform = Platform.get();
    }

    @Override
    public void render(float delta) {
        platform.update();
        platform.render();
    }

    @Override
    public void resize(int width, int height) {
        platform.resize(width, height);
    }

    @Override
    public void show() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    @Override
    public void hide() {
    }

    @Override
    public void dispose() {
    }
}
