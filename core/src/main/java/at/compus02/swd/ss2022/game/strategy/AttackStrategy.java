package at.compus02.swd.ss2022.game.strategy;

import at.compus02.swd.ss2022.game.gameobjects.Enemy;

public class AttackStrategy implements Strategy{
    private Enemy _enemy;

    public AttackStrategy(Enemy enemy){
        _enemy = enemy;
    }
    @Override
    public void execute() {
        //TODO: implement some strategy
        _enemy.setPosition(0, 0);
    }
}
