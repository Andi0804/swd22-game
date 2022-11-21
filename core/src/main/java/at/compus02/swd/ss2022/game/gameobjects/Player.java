package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.input.MoveDownCommand;
import at.compus02.swd.ss2022.game.input.MoveLeftCommand;
import at.compus02.swd.ss2022.game.input.MoveRightCommand;
import at.compus02.swd.ss2022.game.input.MoveUpCommand;

public class Player implements GameObject {
    private Texture image;
    private Sprite sprite;

    public Player() {
        image = AssetRepository.getInstance().getTexture(TextureType.PLAYER);
        sprite = new Sprite(image);
    }

    public Sprite getSprite() {
        return this.sprite;
    }

    @Override
    public void act(float delta) {

        GameInput.muc = new MoveUpCommand(this);
        GameInput.mdc = new MoveDownCommand(this);
        GameInput.mlc = new MoveLeftCommand(this);
        GameInput.mrc = new MoveRightCommand(this);
    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

}
