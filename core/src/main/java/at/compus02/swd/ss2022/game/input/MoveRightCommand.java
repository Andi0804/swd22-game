package at.compus02.swd.ss2022.game.input;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.g2d.Sprite;

import at.compus02.swd.ss2022.game.gameobjects.Player;

public class MoveRightCommand implements Command {

    private Sprite sprite;

    @Override
    public void execute() {

        // positive x-position = right
        sprite.setPosition(sprite.getX() + 10, sprite.getY());
    }

    public MoveRightCommand(Player player) {
        this.sprite = player.getSprite();
    }
}
