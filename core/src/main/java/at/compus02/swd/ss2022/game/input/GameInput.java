package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.Input.Keys;

public class GameInput extends InputAdapter {

    private static MoveUpCommand muc;
    private  static MoveDownCommand mdc;
    private static MoveLeftCommand mlc;
    private static MoveRightCommand mrc;

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

    public static void initialize(Player player) {
        muc = new MoveUpCommand(player);
        mdc = new MoveDownCommand(player);
        mlc = new MoveLeftCommand(player);
        mrc = new MoveRightCommand(player);
    }
}
