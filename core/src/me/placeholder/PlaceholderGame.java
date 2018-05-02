package me.placeholder;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Cursor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.placeholder.screen.MainScreen;

public class PlaceholderGame extends Game {

    public SpriteBatch batch;

    Cursor open;
    Cursor close;
    boolean clicked = false;

    @Override
    public void create() {
//        open = Gdx.graphics.newCursor(TexturesManager.crosshair1Texture, TexturesManager.crosshair1Texture.getWidth() / 2, TexturesManager.crosshair1Texture.getHeight() / 2);
//        close = Gdx.graphics.newCursor(TexturesManager.crosshair2Texture, TexturesManager.crosshair2Texture.getWidth() / 2, TexturesManager.crosshair2Texture.getHeight() / 2);
        batch = new SpriteBatch();
        /**
         * Empty crosshair to replace with our own
         */
//        Gdx.graphics.setCursor(close);

        setScreen(new MainScreen(this));
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling ? GL20.GL_COVERAGE_BUFFER_BIT_NV : 0));
        super.render();


        /**
         * Fullscreen check
         */
        if (Gdx.input.isKeyPressed(Input.Keys.F11)) {
            if (!Gdx.graphics.isFullscreen())
                Gdx.graphics.setFullscreenMode(Gdx.graphics.getDisplayMode());
            else
                Gdx.graphics.setWindowedMode(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
        }
//        if (Gdx.input.isButtonPressed(Input.Buttons.LEFT)) {
//            Gdx.graphics.setCursor(open);
//            clicked = true;
//        } else if (clicked) {
//            Gdx.graphics.setCursor(close);
//        }
    }

}
