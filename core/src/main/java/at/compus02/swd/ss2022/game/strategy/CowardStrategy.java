package at.compus02.swd.ss2022.game.strategy;

import at.compus02.swd.ss2022.game.common.ConfigurationData;
import at.compus02.swd.ss2022.game.gameobjects.Enemy;
import at.compus02.swd.ss2022.game.gameobjects.Player;

import java.awt.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CowardStrategy implements Strategy{

    private Enemy _enemy;
    private Player _player;
    public CowardStrategy(Enemy enemy, Player player){
        _enemy = enemy;
        _player = player;
    }

    @Override
    public void execute() {
        if (_enemy.getPosX() < -240)
            _enemy.setPosition(0, _enemy.getPosY());

        float distanceX = Math.abs(_player.getPosX()) - Math.abs(_enemy.getPosX());
        float distanceY = Math.abs(_player.getPosY()) - Math.abs(_enemy.getPosY());

        int playerThresholdMin = -20;
        int playerThresholdMax = 20;

        int thresholdMin = -2;
        int thresholdMax = 2;

        if ((distanceX < playerThresholdMax && distanceX > playerThresholdMin) && (distanceY < playerThresholdMax && distanceY > playerThresholdMin)) {
            int randomPos = new Random().nextBoolean() ? playerThresholdMax : playerThresholdMin;
            _enemy.setPosition(_enemy.getPosX() + randomPos, _enemy.getPosY() + randomPos);
        }
        else{
            int randomPos = new Random().nextBoolean() ? thresholdMax : thresholdMin;
            _enemy.setPosition(_enemy.getPosX() + randomPos, _enemy.getPosY() + randomPos);
        }
    }
}
