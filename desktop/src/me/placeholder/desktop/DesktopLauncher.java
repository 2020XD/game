package me.placeholder.desktop;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.placeholder.PlaceholderGame;
import org.lwjgl.opengl.Display;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// set fullscreen
		config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());
		config.fullscreen = false;
		config.vSyncEnabled = false;
		config.backgroundFPS = 240;
		config.foregroundFPS = 240;
		new LwjglApplication(new PlaceholderGame(), config);
	}
}
