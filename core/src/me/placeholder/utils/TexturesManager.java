package me.placeholder.utils;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Adrian on 27/04/2018.
 */
public class TexturesManager {

    public static Texture playButtonTexture;
    public static Texture playerTexture;
    public static Pixmap crosshair1Texture;
    public static Pixmap crosshair2Texture;

    public static Texture tempTexture;

    public static Texture tileRegionTexture;
    public static TextureRegion[][] tileRegions = new TextureRegion[12][8];

    static {
        tileRegionTexture = new Texture("actor110.png");
        tileRegions = TextureRegion.split(tileRegionTexture, 32,32);
    }

    static {
        tempTexture = new Texture("textures/temp.png");

        playButtonTexture = new Texture("textures/gui/playbutton.png");
        playerTexture = new Texture("textures/players/Untitled.png");
//        crosshair1Texture = new Pixmap(Gdx.files.internal("textures/gui/crosshair1.png"));
//        crosshair2Texture = new Pixmap(Gdx.files.internal("textures/gui/crosshair2.png"));

    }
}
