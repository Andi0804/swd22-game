package at.compus02.swd.ss2022.game.observer;

public class PlayerPositionObserver implements PositionObserver{
    @Override
    public void update(float x, float y) {
        System.out.println("X: " + x + " Y: " + y);
    }
}
