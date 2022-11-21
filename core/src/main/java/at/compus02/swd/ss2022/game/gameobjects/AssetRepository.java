package at.compus02.swd.ss2022.game.gameobjects;

import com.badlogic.gdx.graphics.Texture;

import java.util.HashMap;
import java.util.Map;

public class AssetRepository {

    private static AssetRepository assetRepository;

    private final Map<TextureType, Texture> textures = new HashMap();

    private AssetRepository() {
    }

    public static AssetRepository getInstance() {
        if (assetRepository == null) {
            assetRepository = new AssetRepository();
        }

        return assetRepository;
    }

    public void loadAssets() {
        for (TextureType type : TextureType.values()) {
            textures.put(type, new Texture(type.getFileName()));
        }
    }

    public Texture getTexture(TextureType type) {
        return textures.get(type);
    }
}
