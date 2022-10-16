package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public interface Factory {
    public GameObject create(float x, float y);

    public void initialize();

    public GameObject[] GetObjects();
}
