package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Player;

public class PlayerFactory implements Factory{
    private static PlayerFactory playerFactory;

    public static PlayerFactory getInstance(){
        if (playerFactory == null)
            playerFactory = new PlayerFactory();

        return playerFactory;
    }

    private PlayerFactory(){

    }

    @Override
    public GameObject create(float x, float y) {
        Player player = new Player();
        player.setPosition(x, y);
        return player;
    }

    @Override
    public void initialize() {

    }

    @Override
    public GameObject[] GetObjects() {
        return new GameObject[0];
    }
}
