package at.compus02.swd.ss2022.game.strategy;

import at.compus02.swd.ss2022.game.gameobjects.Enemy;
import at.compus02.swd.ss2022.game.gameobjects.Player;

import java.util.Random;

public class AttackStrategy implements Strategy{
    private Enemy _enemy;
    private Player _player;

    public AttackStrategy(Enemy enemy, Player player){
        _enemy = enemy;
        _player = player;
    }
    @Override
    public void execute() {
        if (_enemy.getPosX() < -240)
            _enemy.setPosition(0, _enemy.getPosY());

        float distanceX = Math.abs(_player.getPosX()) - Math.abs(_enemy.getPosX());
        float distanceY = Math.abs(_player.getPosY()) - Math.abs(_enemy.getPosY());

        int playerThresholdMin = -10;
        int playerThresholdMax = 10;

        int thresholdMin = -2;
        int thresholdMax = 2;

        if ((distanceX < playerThresholdMax && distanceX > playerThresholdMin) && (distanceY < playerThresholdMax && distanceY > playerThresholdMin)) {
            _enemy.setPosition(_player.getPosX(), _player.getPosY());
        }
        else{
            int randomPos = new Random().nextBoolean() ? thresholdMax : thresholdMin;
            _enemy.setPosition(_enemy.getPosX() + randomPos, _enemy.getPosY() + randomPos);
        }
    }
}
