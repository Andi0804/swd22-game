package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.gameobjects.Enemy;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.observer.PlayerPositionLogObserver;
import at.compus02.swd.ss2022.game.observer.PositionObserver;

public class EnemyFactory implements Factory<Enemy>{

    private Player _player;

    public EnemyFactory(){

    }

    @Override
    public Enemy create(float x, float y) {
        Enemy enemy = new Enemy();
        enemy.setPosition(x, y);
        enemy.addObserver(new PlayerPositionLogObserver());
        enemy.setStrategy(_player);
        return enemy;
    }

    @Override
    public void initialize() {

    }

    @Override
    public Enemy[] GetObjects() {
        return null;
    }

    public void setPlayer(Player player){
        _player = player;
    }
}
