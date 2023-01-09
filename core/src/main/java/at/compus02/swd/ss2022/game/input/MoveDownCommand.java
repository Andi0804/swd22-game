package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.observer.PlayerPositionLogObserver;
import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Player;

public class MoveDownCommand implements Command {

    private Sprite sprite;
    private Player player;

    @Override
    public void execute() {
        // negative y-position = down
        player.setPosition(sprite.getX(), sprite.getY() - 10);
    }

    public MoveDownCommand(Player player) {
        this.sprite = player.getSprite();
        this.player = player;
    }
}
