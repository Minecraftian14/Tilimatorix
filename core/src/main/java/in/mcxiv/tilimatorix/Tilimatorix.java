package in.mcxiv.tilimatorix;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.Color;
import in.mcxiv.tilimatorix.scenes.MainScreen;

public class Tilimatorix extends Game {

    public static final int TILES_IN_X = 11;
    public static final int TILES_IN_Y = 5;

    public int sizeOfOneTile = 64;

    public MainScreen mainScreen;
    public Color color = Color.WHITE;

    @Override
    public void create() {
        mainScreen = new MainScreen(this);
        setScreen(mainScreen);
    }

    @Override
    public void dispose() {
        mainScreen.dispose();
    }
}