package at.compus02.swd.ss2022.game.observer;

import at.compus02.swd.ss2022.game.gameobjects.Enemy;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import at.compus02.swd.ss2022.game.strategy.AttackStrategy;
import at.compus02.swd.ss2022.game.strategy.CowardStrategy;

public class EnemyStrategyChangerObserver implements PositionObserver{

    private final Player player;
    private final Enemy enemy;
    private final AttackStrategy attackStrategy;
    private final CowardStrategy cowardStrategy;

    public EnemyStrategyChangerObserver (Player player, Enemy enemy){
        this.player = player;
        this.enemy = enemy;
        this.attackStrategy = new AttackStrategy(enemy, player);
        this.cowardStrategy = new CowardStrategy(enemy, player);
    }
    @Override
    public void update(float x, float y) {
        float distanceX = Math.abs(player.getPosX()) - Math.abs(enemy.getPosX());
        float distanceY = Math.abs(player.getPosY()) - Math.abs(enemy.getPosY());
        if (Math.abs(distanceX) < 20 && Math.abs(distanceY) < 20) {
            enemy.setStrategy(cowardStrategy);
        } else {
            enemy.setStrategy(attackStrategy);
        }
    }
}
