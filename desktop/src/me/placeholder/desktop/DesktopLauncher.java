package me.placeholder.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import me.placeholder.PlaceholderGame;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.setFromDisplayMode(LwjglApplicationConfiguration.getDesktopDisplayMode());
		config.fullscreen = false;
		config.vSyncEnabled = true;
		config.backgroundFPS = 30;
		config.foregroundFPS = 120;
		new LwjglApplication(new PlaceholderGame(), config);
	}
}
