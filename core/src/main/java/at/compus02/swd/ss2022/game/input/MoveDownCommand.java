package at.compus02.swd.ss2022.game.input;

import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Player;

public class MoveDownCommand implements Command {

    private Sprite sprite;

    @Override
    public void execute() {

        // negative y-position = down
        sprite.setPosition(sprite.getX(), sprite.getY() - 10);
    }

    public MoveDownCommand(Player player) {
        this.sprite = player.getSprite();
    }
}
