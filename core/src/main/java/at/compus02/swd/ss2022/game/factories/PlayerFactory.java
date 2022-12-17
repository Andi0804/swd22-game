package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.gameobjects.Player;

public class PlayerFactory implements Factory<Player>{
    private static PlayerFactory playerFactory;

    public static PlayerFactory getInstance(){
        if (playerFactory == null)
            playerFactory = new PlayerFactory();

        return playerFactory;
    }

    private PlayerFactory(){

    }

    @Override
    public Player create(float x, float y) {
        Player player = new Player();
        player.setPosition(x, y);
        return player;
    }

    @Override
    public void initialize() {

    }

    @Override
    public Player[] GetObjects() {
        return null;
    }
}
