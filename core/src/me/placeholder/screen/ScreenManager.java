package me.placeholder.screen;

import me.placeholder.PlaceholderGame;

/**
 * Created by AwfaZ on 27/04/2018.
 */
public class ScreenManager {

    private PlaceholderGame game;

    public ScreenManager(PlaceholderGame game) {
        this.game = game;
    }

    public void init() {
        game.setScreen(new MainScreen(game));
    }

}
