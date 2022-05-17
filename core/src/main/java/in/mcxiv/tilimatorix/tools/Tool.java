package in.mcxiv.tilimatorix.tools;

public abstract class Tool {

    int radius = 6;

    public abstract boolean touchDown(int x, int y, int pointer, int button);

    public abstract boolean touchDragged(float x, float y, int pointer);

    public abstract boolean touchUp(int x, int y, int pointer, int button);

    public int getRadius() {
        return radius;
    }

}
