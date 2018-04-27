package me.placeholder.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.placeholder.PlaceholderGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		// set fullscreen
		config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());
		config.fullscreen = false;
		config.vSyncEnabled = true;
		config.backgroundFPS = 75;
		config.foregroundFPS = 75;
		new LwjglApplication(new PlaceholderGame(), config);
	}
}
