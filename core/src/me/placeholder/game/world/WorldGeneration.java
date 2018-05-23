package me.placeholder.game.world;

import com.badlogic.gdx.math.Vector2;
import me.placeholder.game.world.types.tile.TileData;
import me.placeholder.game.world.types.wall.WallData;
import me.placeholder.game.world.types.wall.WallType;

import java.util.ArrayList;

/**
 * @author Adrian on 4/27/2018
 *         TODO: generate worlds
 */
public class WorldGeneration {

    private WallType[][] coords = new WallType[10][10];
    private TileData[][] tiles = new TileData[10][10];

    public void createWorld() {
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                coords[i][j] = WallType.WALL;

                tiles[i][j] = new TileData(new Vector2(i, j));
            }
        }
    }

    public ArrayList<TileData> getTiles() {
        ArrayList<TileData> temp = new ArrayList();
        for (int i = 0; i < tiles.length; i++) {
            for (int j = 0; j < tiles[i].length; j++) {
                temp.add(tiles[i][j]);
            }
        }
        return temp;
    }

    public ArrayList<WallData> getCoords() {
        ArrayList<WallData> tiles = new ArrayList();
        for (int i = 0; i < coords.length; i++) {
            for (int j = 0; j < coords[i].length; j++) {
                if (coords[i][j] != WallType.NONE) {
                    tiles.add(new WallData(new Vector2(i, j), coords[i][j]));
                }
            }
        }
        return tiles;
    }
}
