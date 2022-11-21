package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Grass;
import at.compus02.swd.ss2022.game.gameobjects.Tile;
import at.compus02.swd.ss2022.game.gameobjects.Water;

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

        Tile[] tiles = {new Tile(), new Grass(), new Water()};

        Tile tile = tiles[new Random().nextInt(3)];
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
