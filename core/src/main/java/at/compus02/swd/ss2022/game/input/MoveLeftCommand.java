package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.observer.PlayerPositionObserver;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Player;

public class MoveLeftCommand implements Command {

    private Sprite sprite;
    private Player player;
    @Override
    public void execute() {
        PlayerPositionObserver positionObserver = new PlayerPositionObserver();
        player.addObserver(positionObserver);
        // negative x-position = left
        player.setPosition(sprite.getX() - 10, sprite.getY());
    }

    public MoveLeftCommand(Player player) {
        this.sprite = player.getSprite();
        this.player = player;
    }
}
