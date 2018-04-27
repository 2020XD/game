package me.placeholder;

<<<<<<< HEAD
import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import me.placeholder.screen.MainScreen;

public class PlaceholderGame extends Game {
    public SpriteBatch batch;

    @Override
    public void create() {
        setScreen(new MainScreen(this));
    }
=======
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class PlaceholderGame extends ApplicationAdapter {
	SpriteBatch batch;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
	}
>>>>>>> 577e6cc70e46dd5f8ba0cfa606614f42b7413cbd
}
