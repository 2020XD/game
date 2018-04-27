package me.placeholder.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
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
        platform = new Platform(game.batch);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        platform.update();
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
        platform.render();
    }

    @Override
    public void resize(int width, int height) {

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
