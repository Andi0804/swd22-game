package at.compus02.swd.ss2022.game.input;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Player;

public class MoveUpCommand implements Command {

    private Sprite sprite;

    @Override
    public void execute() {

        // positive y-position = up
        sprite.setPosition(sprite.getX(), sprite.getY() + 10);
    }

    public MoveUpCommand(Player player) {
        this.sprite = player.getSprite();
    }
}
