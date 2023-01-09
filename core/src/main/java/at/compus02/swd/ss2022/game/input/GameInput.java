package at.compus02.swd.ss2022.game.input;

import at.compus02.swd.ss2022.game.gameobjects.Player;
import com.badlogic.gdx.Input.Keys;
import com.badlogic.gdx.InputAdapter;

public class GameInput extends InputAdapter {

    private MoveUpCommand muc;
    private MoveDownCommand mdc;
    private MoveLeftCommand mlc;
    private MoveRightCommand mrc;

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

    public void initialize(Player player) {
        muc = new MoveUpCommand(player);
        mdc = new MoveDownCommand(player);
        mlc = new MoveLeftCommand(player);
        mrc = new MoveRightCommand(player);
    }
}
