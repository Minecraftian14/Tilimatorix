package in.mcxiv.tilimatorix.tiles;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Disposable;

public class Tile implements Disposable {

    public int x, y; // grid cords where it's to be drawn

    public Texture texture;
    public Pixmap pixmap;

    public Tile[] top;
    public Tile[] lef;
    public Tile[] rig;
    public Tile[] bot;

    public Tile(int size, int x, int y) {
        pixmap = new Pixmap(size, size, Pixmap.Format.RGBA4444);
        pixmap.setColor(Color.RED);
        pixmap.drawRectangle(0, 0, size, size);
        pixmap.setColor(Color.WHITE);
        pixmap.drawCircle(size / 2, size / 2, size / 4);
        texture = new Texture(pixmap);
        this.x = x;
        this.y = y;
    }

    public void setNeighbours(Tile[] top, Tile[] lef, Tile[] rig, Tile[] bot) {
        this.top = top;
        this.lef = lef;
        this.rig = rig;
        this.bot = bot;
    }

    @Override
    public void dispose() {
        pixmap.dispose();
        texture.dispose();
    }

    public void update() {
        texture.dispose();
        texture = new Texture(pixmap);
    }
}
