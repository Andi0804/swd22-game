package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Tile;
import java.util.Random;

public class TileFactory implements Factory {
    private static TileFactory tileFactory;

    public static TileFactory getInstance() {
        if (tileFactory == null)
            tileFactory = new TileFactory();

        return tileFactory;
    }

    private TileFactory() {

    }

    @Override
    public GameObject create(float x, float y) {

        String[] imgPaths = { "tile_wall.png", "tile_gras.png", "tile_gravel.png", "tile_water.png" };

        Tile tile = new Tile(imgPaths[new Random().nextInt(4)]);
        tile.setPosition(x, y);
        return tile;
    }

    @Override
    public void initialize() {

    }

    @Override
    public GameObject[] GetObjects() {
        return new GameObject[0];
    }
}
