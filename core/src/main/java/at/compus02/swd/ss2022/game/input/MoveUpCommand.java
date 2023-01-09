package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.observer.PlayerPositionLogObserver;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Player;

public class MoveUpCommand implements Command {

    private Sprite sprite;
    private Player player;

    @Override
    public void execute() {
        // positive y-position = up
        player.setPosition(sprite.getX(), sprite.getY() + 10);
    }

    public MoveUpCommand(Player player) {
        this.sprite = player.getSprite();
        this.player = player;
    }
}
