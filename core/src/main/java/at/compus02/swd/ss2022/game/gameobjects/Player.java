package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import at.compus02.swd.ss2022.game.input.GameInput;

public class Player implements GameObject {
    private Texture image;
    private Sprite sprite;

    public Player() {
        image = new Texture("character.png");
        sprite = new Sprite(image);
    }

    @Override
    public void act(float delta) {

        if (GameInput.pressedKeys.contains(GameInput.keys.up)) {
            moveUp();
        }
        if (GameInput.pressedKeys.contains(GameInput.keys.down)) {
            moveDown();
        }
        if (GameInput.pressedKeys.contains(GameInput.keys.left)) {
            moveLeft();
        }
        if (GameInput.pressedKeys.contains(GameInput.keys.right)) {
            moveRight();
        }
    }

    @Override
    public void setPosition(float x, float y) {
        sprite.setPosition(x, y);
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void moveUp() {
        setPosition(sprite.getX(), sprite.getY() + 1);
    }

    public void moveDown() {
        setPosition(sprite.getX(), sprite.getY() - 1);
    }

    public void moveRight() {
        setPosition(sprite.getX() + 1, sprite.getY());
    }

    public void moveLeft() {
        setPosition(sprite.getX() - 1, sprite.getY());
    }

}
