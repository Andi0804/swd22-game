package at.compus02.swd.ss2022.game.observer;

public class PlayerPositionLogObserver implements PositionObserver{
    @Override
    public void update(float x, float y) {
        System.out.println("Player position - X: " + x + " Y: " + y);
    }
}
