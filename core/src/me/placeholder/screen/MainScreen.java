package me.placeholder.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import me.placeholder.PlaceholderGame;

/**
 * Created by AwfaZ on 27/04/2018.
 */
public class MainScreen implements Screen {

    private PlaceholderGame game;
    private Stage stage;
    private ImageButton playButton;

    private Table buttonTable;

    public MainScreen(final PlaceholderGame game) {
        this.game = game;
        stage = new Stage(new ScreenViewport());
        buttonTable = new Table();
        Texture playTexture = new Texture("src/assets/playbutton.png");
        playButton = new ImageButton(new TextureRegionDrawable(new TextureRegion(playTexture)));
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setScreen(new GameScreen(game));
                System.out.println("f");
            }
        });
        buttonTable.add(playButton);
        buttonTable.setPosition(Gdx.graphics.getWidth() / 2 - buttonTable.getWidth() / 2, Gdx.graphics.getHeight() / 2 - buttonTable.getHeight() / 2);
        stage.addActor(buttonTable);
    }

    @Override
    public void show() {
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(1,1,1,1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT | (Gdx.graphics.getBufferFormat().coverageSampling?GL20.GL_COVERAGE_BUFFER_BIT_NV:0));
        stage.act();
        stage.draw();
    }

    @Override
    public void resize(int width, int height) {
        buttonTable.setPosition(Gdx.graphics.getWidth() / 2 - buttonTable.getWidth() / 2, Gdx.graphics.getHeight() / 2 - buttonTable.getHeight() / 2);
        stage.getViewport().update(width, height, true);
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
        stage.dispose();
    }
}
