package at.compus02.swd.ss2022.game.factories;

import at.compus02.swd.ss2022.game.gameobjects.GameObject;

public interface Factory<T> {
    public T create(float x, float y);

    public void initialize();

    public T[] GetObjects();
}
