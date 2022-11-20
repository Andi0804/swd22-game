package at.compus02.swd.ss2022.game.input;

import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

public class GameInput extends InputAdapter {

    public static MoveUpCommand muc;
    public static MoveDownCommand mdc;
    public static MoveLeftCommand mlc;
    public static MoveRightCommand mrc;

    @Override
    public boolean keyDown(int keycode) {

        switch (keycode) {
            case Keys.UP:
                muc.execute();
                break;
            case Keys.DOWN:
                mdc.execute();
                break;
            case Keys.LEFT:
                mlc.execute();
                break;
            case Keys.RIGHT:
                mrc.execute();
                break;
            default:
                break;
        }

        return true;
    }

    @Override
    public boolean keyUp(int keycode) {

        return true;
    }

}
