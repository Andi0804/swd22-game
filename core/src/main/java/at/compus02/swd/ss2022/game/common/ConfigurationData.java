package at.compus02.swd.ss2022.game.common;

import java.awt.*;

public class ConfigurationData {
    private int surfaceObjectAmount = 25;
    private Point castlePosition = new Point(150,150);
    private Point bridgePosition = new Point(16, -10);
    private Point playerPosition = new Point(0,0);
    private float[] minMaxWater = {-16, 16};

    public float[] getMinMaxWater() {
        return minMaxWater;
    }

    public int getSurfaceObjectAmount() {
        return surfaceObjectAmount;
    }

    public Point getCastlePosition() {
        return castlePosition;
    }

    public Point getBridgePosition() {
        return bridgePosition;
    }

    public Point getPlayerPosition() {
        return playerPosition;
    }
    public Point getEnemyPosition(int x, int y) {
        return new Point(x,y);
    }
}
