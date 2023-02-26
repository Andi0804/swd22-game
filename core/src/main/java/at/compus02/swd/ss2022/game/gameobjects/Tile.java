package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class Tile implements GameObject {
    protected Texture image;
    public Sprite sprite;

    public Tile() {
        image = AssetRepository.getInstance().getTexture(TextureType.TILE);
        sprite = new Sprite(image);
    }

    public Tile(TextureType type) {
        image = AssetRepository.getInstance().getTexture(type);
        sprite = new Sprite(image);
    }

    @Override
    public void act(float delta) {

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
