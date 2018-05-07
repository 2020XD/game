package me.placeholder.game.world;

import com.badlogic.gdx.math.Vector2;
import me.placeholder.game.world.tile.TileData;
import me.placeholder.game.world.tile.TileType;

import java.util.ArrayList;

/**
 * @author Adrian on 4/27/2018
 *         TODO: generate worlds
 */
public class WorldGeneration {

    private TileType[][] coords = new TileType[10][10];

    public void createWorld() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                coords[i][j] = TileType.FLOOR;
            }
        }
    }

    public ArrayList<TileData> getCoords() {
        ArrayList<TileData> tiles = new ArrayList();
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < coords[i].length; j++) {
//                if (coords[i][j] != TileType.NONE) {
                tiles.add(new TileData(new Vector2(i, j), coords[i][j]));
//                }
            }
        }
        return tiles;
    }
}
