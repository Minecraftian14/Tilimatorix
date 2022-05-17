package in.mcxiv.tilimatorix.scenes;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputAdapter;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.*;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Interpolation;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.scenes.scene2d.Stage;
import in.mcxiv.tilimatorix.Tilimatorix;
import in.mcxiv.tilimatorix.tiles.TilesGroup;
import in.mcxiv.tilimatorix.tools.BrushTool;
import in.mcxiv.tilimatorix.tools.Tool;

public class MainScreen extends ScreenAdapter {

    private final Tilimatorix tilimatorix;

    private Camera camera;
    private Stage stage;
    private Batch batch;
    private Texture pixel;

    private int width, height;
    private float scale = 1.0f;
    public TilesGroup group;

    public MainScreen(Tilimatorix tilimatorix) {
        this.tilimatorix = tilimatorix;
    }

    @Override
    public void show() {
        width = Gdx.graphics.getWidth();
        height = Gdx.graphics.getHeight();
        group = new TilesGroup(tilimatorix, tilimatorix.sizeOfOneTile);

        camera = new OrthographicCamera();
        updateCamera();

        stage = new Stage();
        batch = stage.getBatch();

        pixel = new Texture(new Pixmap(1, 1, Pixmap.Format.RGB565) {{
            setColor(Color.WHITE);
            drawPixel(0, 0);
        }});

        Tool tool = new BrushTool(tilimatorix);

        Gdx.input.setInputProcessor(new InputAdapter() {

            @Override
            public boolean keyDown(int keycode) {
                if (keycode == Input.Keys.SPACE) {
                    tilimatorix.color = new Color(MathUtils.random(), MathUtils.random(), MathUtils.random(), 1);
                    return true;
                } else if (keycode == Input.Keys.ENTER) {
                    PixmapIO.writePNG(
                            new FileHandle("output.png"),
                            group.createComposite()
                    );
                    return true;
                }
                return false;
            }

            @Override
            public boolean mouseMoved(int screenX, int screenY) {
                screenY = height - screenY;
                float screenXf = screenX * 1f / width;
                float screenYf = screenY * 1f / height;
                screenXf = Interpolation.linear.apply(
                        camera.viewportWidth / 2 - tilimatorix.sizeOfOneTile,
                        Tilimatorix.TILES_IN_X * tilimatorix.sizeOfOneTile - camera.viewportWidth / 2 + tilimatorix.sizeOfOneTile,
                        screenXf
                );
                screenYf = Interpolation.linear.apply(
                        camera.viewportHeight / 2 - tilimatorix.sizeOfOneTile,
                        Tilimatorix.TILES_IN_Y * tilimatorix.sizeOfOneTile - camera.viewportHeight / 2 + tilimatorix.sizeOfOneTile,
                        screenYf
                );
                camera.position.set(screenXf, screenYf, 0);
                return true;
            }

            @Override
            public boolean scrolled(float amountX, float amountY) {
                scale += amountY * 0.005f;
                if (scale < 0.01f) scale = 0.01f;
                else if (scale > 100f) scale = 100f;
                return true;
            }

            private volatile Vector3 temporary = new Vector3();

            @Override
            public boolean touchDown(int screenX, int screenY, int pointer, int button) {
                camera.unproject(temporary.set(screenX, screenY, 0));
                tool.touchDown((int) temporary.x, (int) temporary.y, pointer, button);
                return true;
            }

            @Override
            public boolean touchDragged(int screenX, int screenY, int pointer) {
                camera.unproject(temporary.set(screenX, screenY, 0));
                tool.touchDragged(
                        temporary.x,
                        temporary.y,
                        pointer);
                return true;
            }

            @Override
            public boolean touchUp(int screenX, int screenY, int pointer, int button) {
                camera.unproject(temporary.set(screenX, screenY, 0));
                tool.touchUp((int) temporary.x, (int) temporary.y, pointer, button);
                return true;
            }
        });
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0.15f, 0.15f, 0.2f, 1f);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        updateCamera();
        batch.setProjectionMatrix(camera.combined);

        int size = tilimatorix.sizeOfOneTile;

        batch.begin();

        group.draw(batch);

        for (int x = 0; x <= Tilimatorix.TILES_IN_X; x++)
            batch.draw(pixel, x * size, 0, 1, Tilimatorix.TILES_IN_Y * size);
        for (int y = 0; y <= Tilimatorix.TILES_IN_Y; y++)
            batch.draw(pixel, 0, y * size, Tilimatorix.TILES_IN_X * size, 1);

        batch.end();
    }

    @Override
    public void resize(int width, int height) {
        this.width = width;
        this.height = height;
        updateCamera();
    }

    private void updateCamera() {
        camera.viewportWidth = width * scale;
        camera.viewportHeight = height * scale;
//        camera.viewportHeight = Tilimatorix.TILES_IN_Y * tilimatorix.sizeOfOneTile * scale;
        camera.update();
    }

    @Override
    public void hide() {
        stage.dispose();
        pixel.dispose();
    }


}
