package in.mcxiv.tilimatorix.tools;

import com.badlogic.gdx.graphics.Color;
import in.mcxiv.tilimatorix.Tilimatorix;
import in.mcxiv.tilimatorix.tiles.Tile;

import java.util.HashSet;

public class BrushTool extends Tool {

    Tilimatorix tilimatorix;

    public BrushTool(Tilimatorix tilimatorix) {
        this.tilimatorix = tilimatorix;
    }

    volatile Tile tile;

    @Override
    public boolean touchDown(int x, int y, int pointer, int button) {
        tile = tilimatorix.mainScreen.group.getTileAt(x, y);
//        System.out.println("Lol " + x + " " + y + " " + tile);
//        if (tile != null) {
//            tile.pixmap.setColor(Color.YELLOW);
//            tile.pixmap.drawRectangle(0, 0, tilimatorix.sizeOfOneTile, tilimatorix.sizeOfOneTile);
//            tile.update();
//        }
        return tile != null;
    }

    private volatile HashSet<Tile> rb = new HashSet<>();

    @Override
    public boolean touchDragged(float x, float y, int pointer) {
        if (tile == null) return false;
//        System.out.println("" + x + " " + y);
        x -= (tile.x) * tilimatorix.sizeOfOneTile;
        y -= (tile.y) * tilimatorix.sizeOfOneTile;

        rb.clear();
        drawOnTile(tile, (int) x, (int) (tilimatorix.sizeOfOneTile - y), radius, rb);
        return true;
    }

    private void drawOnTile(Tile tile, int x, int y, int radius, HashSet<Tile> recursionBreaker) {
        if (recursionBreaker.contains(tile))
            return;
        recursionBreaker.add(tile);
        tile.pixmap.setColor(tilimatorix.color);

        tile.pixmap.drawCircle(x, y, radius);
        tile.update();
        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // TOP
        if (y < radius) {
            y += tilimatorix.sizeOfOneTile;
            for (Tile t : tile.top)
                drawOnTile(t, x, y, radius, recursionBreaker);
            y -= tilimatorix.sizeOfOneTile;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // BOTTOM
        if (y > tilimatorix.sizeOfOneTile-radius) {
            y -= tilimatorix.sizeOfOneTile;
            for (Tile t : tile.bot)
                drawOnTile(t, x, y, radius, recursionBreaker);
            y += tilimatorix.sizeOfOneTile;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // LEFT
        if (x < radius) {
            x += tilimatorix.sizeOfOneTile;
            for (Tile t : tile.lef)
                drawOnTile(t, x, y, radius, recursionBreaker);
            x -= tilimatorix.sizeOfOneTile;
        }

        ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        // RIGHT
        if (x > tilimatorix.sizeOfOneTile - radius) {
            x -= tilimatorix.sizeOfOneTile;
            for (Tile t : tile.rig)
                drawOnTile(t, x, y, radius, recursionBreaker);
            x += tilimatorix.sizeOfOneTile;
        }

        recursionBreaker.remove(tile);
    }

    @Override
    public boolean touchUp(int x, int y, int pointer, int button) {
        return true;
    }
}
