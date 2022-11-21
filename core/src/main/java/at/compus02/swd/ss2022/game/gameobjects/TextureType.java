package at.compus02.swd.ss2022.game.gameobjects;

public enum TextureType {
    BUSH("bush.png"),
    GRASS("tile_gras.png"),
    PLAYER("character.png"),
    SIGN("sign.png"),
    TILE("tile_wall.png"),
    WATER("tile_water.png");

    private final String fileName;

    TextureType(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }
}
