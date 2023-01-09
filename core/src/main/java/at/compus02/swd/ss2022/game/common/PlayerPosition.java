package at.compus02.swd.ss2022.game.common;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;
import at.compus02.swd.ss2022.game.gameobjects.Player;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class PlayerPosition {
    private GameObject gameObject;
    public PlayerPosition(GameObject gameObject) {
        this.gameObject = gameObject;
    }

    public void LogPlayerPositionToUi(BitmapFont font, SpriteBatch batch){
        if(gameObject.getClass().getName().contains("Player"))
        {
            Player tempPlayer = (Player)gameObject;
            font.draw(batch, "Player position - X: " + tempPlayer.getPosX() + " Y: " + tempPlayer.getPosY(), -220, -200);
        }
    }
}
