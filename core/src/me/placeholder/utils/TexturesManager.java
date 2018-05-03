package me.placeholder.utils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Adrian on 27/04/2018.
 */
public class TexturesManager {

    public static Texture playButtonTexture;
    public static Texture playerTexture;
    public static Pixmap crosshair1Texture;
    public static Pixmap crosshair2Texture;


    static {
        playButtonTexture = new Texture("textures/gui/playbutton.png");
        playerTexture = new Texture("textures/players/Untitled.png");
//        crosshair1Texture = new Pixmap(Gdx.files.internal("textures/gui/crosshair1.png"));
//        crosshair2Texture = new Pixmap(Gdx.files.internal("textures/gui/crosshair2.png"));

    }
}
