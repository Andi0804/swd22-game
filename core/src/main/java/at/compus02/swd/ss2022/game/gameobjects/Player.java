package at.compus02.swd.ss2022.game.gameobjects;

import at.compus02.swd.ss2022.game.observer.PositionObserver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import at.compus02.swd.ss2022.game.input.GameInput;
import at.compus02.swd.ss2022.game.input.MoveDownCommand;
import at.compus02.swd.ss2022.game.input.MoveLeftCommand;
import at.compus02.swd.ss2022.game.input.MoveRightCommand;
import at.compus02.swd.ss2022.game.input.MoveUpCommand;

import java.util.ArrayList;
import java.util.List;

public class Player implements GameObject {
    private Texture image;
    private Sprite sprite;

    private List<PositionObserver> observers = new ArrayList<>();

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

        for (PositionObserver obs : this.observers) {
            obs.update(x,y);
        }
    }

    @Override
    public void draw(SpriteBatch batch) {
        sprite.draw(batch);
    }

    public void addObserver(PositionObserver obs) {
        this.observers.add(obs);
    }
    public void removeObserver(PositionObserver obs) {
        this.observers.remove(obs);
    }

}
