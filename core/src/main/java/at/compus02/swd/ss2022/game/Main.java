package at.compus02.swd.ss2022.game;

import at.compus02.swd.ss2022.game.common.ConfigurationData;
import at.compus02.swd.ss2022.game.common.PlayerPosition;
import at.compus02.swd.ss2022.game.factories.EnemyFactory;
import at.compus02.swd.ss2022.game.factories.PlayerFactory;
import at.compus02.swd.ss2022.game.factories.TileFactory;
import at.compus02.swd.ss2022.game.gameobjects.*;
import at.compus02.swd.ss2022.game.input.GameInput;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.viewport.ExtendViewport;

import java.util.concurrent.ThreadLocalRandom;

/**
 * {@link com.badlogic.gdx.ApplicationListener} implementation shared by all
 * platforms.
 */
public class Main extends ApplicationAdapter {
	private static final int TILE_WIDTH = 32;
	private static final int TILE_HEIGHT = 32;
	private SpriteBatch batch;
	private ExtendViewport viewport = new ExtendViewport(480.0f, 480.0f, 480.0f, 480.0f);
	private GameInput gameInput = new GameInput();
	private Array<GameObject> gameObjects = new Array<>();
	private final float updatesPerSecond = 60;
	private final float logicFrameTime = 1 / updatesPerSecond;
	private float deltaAccumulator = 0;
	private BitmapFont font;
	private AssetRepository assetRepository;
	float x_from = (viewport.getMinWorldWidth() / 2) * -1;
	float x_to = viewport.getMaxWorldWidth() / 2;
	float y_from = viewport.getMaxWorldHeight() / 2;
	float y_to = y_from * -1;

	@Override
	public void create() {
		assetRepository = AssetRepository.getInstance();
		assetRepository.loadAssets();
		batch = new SpriteBatch();
		fillWithTiles();
		fillWithSurfaceObjects();
		Player player = PlayerFactory.getInstance().create(new ConfigurationData().getPlayerPosition().x,
				new ConfigurationData().getPlayerPosition().y);

		for (int i = 0 ; i < 10 ; i++)
		{
			int randX = ThreadLocalRandom.current().nextInt((int)x_from, (int)x_to + 1);
			int randY = ThreadLocalRandom.current().nextInt((int)y_to, (int)y_from + 1);
			Enemy enemy = new EnemyFactory().create(new ConfigurationData().getEnemyPosition(randX, randY).x,
					new ConfigurationData().getEnemyPosition(randX, randY).y);
			gameObjects.add(enemy);
		}

		gameObjects.add(player);
		gameInput.initialize(player);
		font = new BitmapFont();
		font.setColor(Color.WHITE);
		Gdx.input.setInputProcessor(this.gameInput);
	}

	public void fillWithTiles() {
		for (float x = x_from; x <= x_to; x += TILE_WIDTH) {
			for (float y = y_from; y >= y_to; y -= TILE_HEIGHT) {
				gameObjects.add(TileFactory.getInstance().create(x, y));
			}
		}

		gameObjects.add(TileFactory.getInstance().create(new ConfigurationData().getBridgePosition().x * -1, new ConfigurationData().getBridgePosition().y));
		gameObjects.add(TileFactory.getInstance().create(new ConfigurationData().getBridgePosition().x, new ConfigurationData().getBridgePosition().y));
	}

    public void fillWithSurfaceObjects() {
		for (int i = 0; i < new ConfigurationData().getSurfaceObjectAmount(); i++){
			float randX = ThreadLocalRandom.current().nextInt((int)x_from, (int)x_to + 1);
			float randY = ThreadLocalRandom.current().nextInt((int)y_to, (int)y_from + 1);
			if (randX < (TILE_WIDTH*-1) || randX > TILE_WIDTH)
			{
				gameObjects.add(TileFactory.getInstance().createSurfaceObjects(randX, randY));
				gameObjects.add(TileFactory.getInstance().createSurfaceObjects(new ConfigurationData().getCastlePosition().x, new ConfigurationData().getCastlePosition().y));
			}
		}
    }

	private void act(float delta) {
		for (GameObject gameObject : gameObjects) {
			gameObject.act(delta);
		}
	}

	private void draw() {
		batch.setProjectionMatrix(viewport.getCamera().combined);
		batch.begin();
		for (GameObject gameObject : gameObjects) {
			gameObject.draw(batch);

			PlayerPosition playerPosition = new PlayerPosition(gameObject);
			playerPosition.LogPlayerPositionToUi(font, batch);
		}
		batch.end();
	}

	@Override
	public void render() {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		float delta = Gdx.graphics.getDeltaTime();
		deltaAccumulator += delta;
		while (deltaAccumulator > logicFrameTime) {
			deltaAccumulator -= logicFrameTime;
			act(logicFrameTime);
		}
		draw();
	}

	@Override
	public void dispose() {
		batch.dispose();
		assetRepository.dispose();
	}

	@Override
	public void resize(int width, int height) {
		viewport.update(width, height);
	}
}