package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.common.ConfigurationData;
import at.compus02.swd.ss2022.game.gameobjects.*;

import java.util.Random;

public class TileFactory implements Factory<Tile> {
    private static TileFactory tileFactory;

    public static TileFactory getInstance() {
        if (tileFactory == null)
            tileFactory = new TileFactory();

        return tileFactory;
    }

    private TileFactory() {

    }

    @Override
    public Tile create(float x, float y) {
        Tile[] templateTiles = {new Tile(), new Grass(), new Water(), new Bridge()};

        Tile tile = null;

        if ((x == new ConfigurationData().getBridgePosition().x && y == new ConfigurationData().getBridgePosition().y) ||
                (x == new ConfigurationData().getBridgePosition().x * -1 && y == new ConfigurationData().getBridgePosition().y))
        {
            tile = templateTiles[3];
        }
        else if(x < new ConfigurationData().getMinMaxWater()[0])
        {
            tile = templateTiles[0];
        }
        else if(x > new ConfigurationData().getMinMaxWater()[1])
        {
            tile = templateTiles[1];
        }
        else
        {
            tile = templateTiles[2];
        }

        tile.setPosition(x, y);
        return tile;
    }

    public Tile createSurfaceObjects(float x, float y){
        Tile[] templateTiles = {new Log(), new Stone(), new Bush(), new Castle()};

        Tile tile = null;

        if (x == new ConfigurationData().getCastlePosition().x && y == new ConfigurationData().getCastlePosition().y){
            tile = templateTiles[3];
        }
        else{
            tile = templateTiles[new Random().nextInt(3)];
        }

        tile.setPosition(x,y);
        return tile;
    }

    @Override
    public void initialize() {

    }

    @Override
    public Tile[] GetObjects() {
        return null;
    }
}
