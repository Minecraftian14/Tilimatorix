package in.mcxiv.tilimatorix.tiles;

import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import in.mcxiv.tilimatorix.Tilimatorix;

public class TilesGroup {

    private Tilimatorix tilimatorix;

    public Tile topLefFlat;
    public Tile topRigFlat;
    public Tile botLefFlat;
    public Tile botRigFlat;

    public Tile topFlat;
    public Tile lefFlat;
    public Tile rigFlat;
    public Tile botFlat;

    public Tile rigLefFlat;
    public Tile topBotFlat;

    public Tile noFlat;
    public Tile allFlat;
    public Tile fullFlat;
    public Tile allCor;

    public Tile notBotFlat;
    public Tile notTopFlat;
    public Tile notRigFlat;
    public Tile notLefFlat;

    public Tile topLefBiCor;
    public Tile topRigBiCor;
    public Tile botLefBiCor;
    public Tile botRigBiCor;

    public Tile topFlatBotRigCor;
    public Tile topFlatBotLefCor;
    public Tile lefFlatBotRigCor;
    public Tile lefFlatTopRigCor;
    public Tile rigFlatBotLefCor;
    public Tile rigFlatTopLefCor;
    public Tile botFlatTopRigCor;
    public Tile botFlatTopLefCor;

    public Tile botRigCor;
    public Tile botLefCor;
    public Tile topRigCor;
    public Tile topLefCor;

    public Tile topFlatOppoCor;
    public Tile botFlatOppoCor;
    public Tile lefFlatOppoCor;
    public Tile rigFlatOppoCor;

    public Tile topOppoCor;
    public Tile botOppoCor;
    public Tile lefOppoCor;
    public Tile rigOppoCor;

    public Tile topRigBotLefCor;
    public Tile topLefBotRigCor;

    public Tile notBotRigCor;
    public Tile notBotLefCor;
    public Tile notTopRigCor;
    public Tile notTopLefCor;

    public Tile[] aio;
    public Tile[][] map;

    public TilesGroup(Tilimatorix tilimatorix, int size) {
        this.tilimatorix = tilimatorix;

        {
            topLefFlat = new Tile(size, 0, 4);
            topRigFlat = new Tile(size, 2, 4);
            botLefFlat = new Tile(size, 0, 2);
            botRigFlat = new Tile(size, 2, 2);

            topFlat = new Tile(size, 1, 4);
            lefFlat = new Tile(size, 0, 3);
            rigFlat = new Tile(size, 2, 3);
            botFlat = new Tile(size, 1, 2);

            rigLefFlat = new Tile(size, 3, 3);
            topBotFlat = new Tile(size, 1, 1);

            noFlat = new Tile(size, 1, 3);
            allFlat = new Tile(size, 3, 1);
            fullFlat = new Tile(size, 0, 0);
            allCor = new Tile(size, 8, 0);

            notBotFlat = new Tile(size, 3, 4);
            notTopFlat = new Tile(size, 3, 2);
            notRigFlat = new Tile(size, 0, 1);
            notLefFlat = new Tile(size, 2, 1);

            topLefBiCor = new Tile(size, 4, 4);
            topRigBiCor = new Tile(size, 7, 4);
            botLefBiCor = new Tile(size, 4, 1);
            botRigBiCor = new Tile(size, 7, 1);

            topFlatBotRigCor = new Tile(size, 5, 4);
            topFlatBotLefCor = new Tile(size, 6, 4);
            lefFlatBotRigCor = new Tile(size, 4, 3);
            lefFlatTopRigCor = new Tile(size, 4, 2);
            rigFlatBotLefCor = new Tile(size, 7, 3);
            rigFlatTopLefCor = new Tile(size, 7, 2);
            botFlatTopRigCor = new Tile(size, 5, 1);
            botFlatTopLefCor = new Tile(size, 6, 1);

            botRigCor = new Tile(size, 5, 3);
            botLefCor = new Tile(size, 6, 3);
            topRigCor = new Tile(size, 5, 2);
            topLefCor = new Tile(size, 6, 2);

            topFlatOppoCor = new Tile(size, 8, 4);
            botFlatOppoCor = new Tile(size, 8, 1);
            lefFlatOppoCor = new Tile(size, 4, 0);
            rigFlatOppoCor = new Tile(size, 7, 0);

            topOppoCor = new Tile(size, 8, 3);
            botOppoCor = new Tile(size, 8, 2);
            lefOppoCor = new Tile(size, 5, 0);
            rigOppoCor = new Tile(size, 6, 0);

            topRigBotLefCor = new Tile(size, 9, 4);
            topLefBotRigCor = new Tile(size, 9, 3);

            notBotRigCor = new Tile(size, 9, 2);
            notBotLefCor = new Tile(size, 10, 2);
            notTopRigCor = new Tile(size, 9, 1);
            notTopLefCor = new Tile(size, 10, 1);
        }

        {
            topLefFlat.setNeighbours(
                    new Tile[]{fullFlat},
                    new Tile[]{fullFlat},
                    new Tile[]{topFlat, topRigFlat, topFlatBotRigCor, topLefCor, rigFlatTopLefCor, botOppoCor, topLefBotRigCor, notBotLefCor},
                    new Tile[]{lefFlat, botLefFlat, lefFlatBotRigCor, topLefCor, botFlatTopLefCor, rigOppoCor, topLefBotRigCor, notTopRigCor}
            );
            topRigFlat.setNeighbours(
                    new Tile[]{fullFlat},
                    new Tile[]{topFlat, topLefFlat, topFlatBotLefCor, topRigCor, lefFlatTopRigCor, botOppoCor, topRigBotLefCor, notBotRigCor},
                    new Tile[]{fullFlat},
                    new Tile[]{rigFlat, botRigFlat, rigFlatBotLefCor, topRigCor, botFlatTopRigCor, lefOppoCor, topRigBotLefCor, notTopLefCor}
            );
            botLefFlat.setNeighbours(
                    new Tile[]{lefFlat, topLefFlat, lefFlatTopRigCor, botLefCor, topFlatBotLefCor, rigOppoCor, topRigBotLefCor, notBotRigCor},
                    new Tile[]{fullFlat},
                    new Tile[]{botFlat, botRigFlat, botFlatTopRigCor, botLefCor, rigFlatBotLefCor, topOppoCor, topRigBotLefCor, notTopRigCor},
                    new Tile[]{fullFlat}
            );
            botRigFlat.setNeighbours(
                    new Tile[]{rigFlat, topRigFlat, rigFlatTopLefCor, botRigCor, topFlatBotRigCor, lefOppoCor, topLefBotRigCor, notBotLefCor},
                    new Tile[]{botFlat, botLefFlat, botFlatTopLefCor, botRigCor, lefFlatBotRigCor, topOppoCor, topLefBotRigCor, notBotRigCor},
                    new Tile[]{fullFlat},
                    new Tile[]{fullFlat}
            );

            topFlat.setNeighbours(
                    new Tile[]{fullFlat},
                    new Tile[]{topLefFlat, topFlatBotLefCor, topRigCor, lefFlatTopRigCor, botOppoCor, topRigBotLefCor, notBotRigCor},
                    new Tile[]{topRigFlat, topFlatBotRigCor, topLefCor, rigFlatTopLefCor, botOppoCor, topLefBotRigCor, notBotLefCor},
                    new Tile[]{noFlat, botFlat, botLefCor, botRigCor, topOppoCor}
            );
            lefFlat.setNeighbours(
                    new Tile[]{topLefFlat, lefFlatTopRigCor, botLefCor, topFlatBotLefCor, rigOppoCor, topRigBotLefCor, notBotRigCor},
                    new Tile[]{fullFlat},
                    new Tile[]{noFlat, rigFlat, topRigCor, botRigCor, lefOppoCor},
                    new Tile[]{botLefFlat, lefFlatBotRigCor, topLefCor, botFlatTopLefCor, rigOppoCor, topLefBotRigCor, notTopRigCor}
            );
            rigFlat.setNeighbours(
                    new Tile[]{topRigFlat, rigFlatTopLefCor, botRigCor, topFlatBotRigCor, lefOppoCor, topLefBotRigCor, notBotLefCor},
                    new Tile[]{noFlat, lefFlat, topLefFlat, botLefFlat, rigOppoCor},
                    new Tile[]{fullFlat},
                    new Tile[]{botRigFlat, rigFlatBotLefCor, topRigCor, botFlatTopRigCor, lefOppoCor, topRigBotLefCor, notTopLefCor}
            );
            botFlat.setNeighbours(
                    new Tile[]{noFlat, topFlat, topLefCor, topRigCor, botOppoCor},
                    new Tile[]{botLefFlat, botFlatTopLefCor, botRigCor, lefFlatBotRigCor, topOppoCor, topLefBotRigCor, notTopRigCor},
                    new Tile[]{botRigFlat, botFlatTopRigCor, botLefCor, rigFlatBotLefCor, topOppoCor, topRigBotLefCor, notTopLefCor},
                    new Tile[]{fullFlat}
            );

            rigLefFlat.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            topBotFlat.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );

            noFlat.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            allFlat.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            fullFlat.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            allCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );

            notBotFlat.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            notTopFlat.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            notRigFlat.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            notLefFlat.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );

            topLefBiCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            topRigBiCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            botLefBiCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            botRigBiCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );

            topFlatBotRigCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            topFlatBotLefCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            lefFlatBotRigCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            lefFlatTopRigCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            rigFlatBotLefCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            rigFlatTopLefCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            botFlatTopRigCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            botFlatTopLefCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );

            botRigCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            botLefCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            topRigCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            topLefCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );

            topFlatOppoCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            botFlatOppoCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            lefFlatOppoCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            rigFlatOppoCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );

            topOppoCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            botOppoCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            lefOppoCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            rigOppoCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );

            topRigBotLefCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            topLefBotRigCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );

            notBotRigCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            notBotLefCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            notTopRigCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
            notTopLefCor.setNeighbours(
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{},
                    new Tile[]{}
            );
        }

        {
            aio = new Tile[]{
                    topLefFlat,
                    topRigFlat,
                    botLefFlat,
                    botRigFlat,

                    topFlat,
                    lefFlat,
                    rigFlat,
                    botFlat,

                    rigLefFlat,
                    topBotFlat,

                    noFlat,
                    allFlat,
                    fullFlat,
                    allCor,

                    notBotFlat,
                    notTopFlat,
                    notRigFlat,
                    notLefFlat,

                    topLefBiCor,
                    topRigBiCor,
                    botLefBiCor,
                    botRigBiCor,

                    topFlatBotRigCor,
                    topFlatBotLefCor,
                    lefFlatBotRigCor,
                    lefFlatTopRigCor,
                    rigFlatBotLefCor,
                    rigFlatTopLefCor,
                    botFlatTopRigCor,
                    botFlatTopLefCor,

                    botRigCor,
                    botLefCor,
                    topRigCor,
                    topLefCor,

                    topFlatOppoCor,
                    botFlatOppoCor,
                    lefFlatOppoCor,
                    rigFlatOppoCor,

                    topOppoCor,
                    botOppoCor,
                    lefOppoCor,
                    rigOppoCor,

                    topRigBotLefCor,
                    topLefBotRigCor,

                    notBotRigCor,
                    notBotLefCor,
                    notTopRigCor,
                    notTopLefCor
            };
        }

        {
            map = new Tile[Tilimatorix.TILES_IN_X][Tilimatorix.TILES_IN_Y];
            for (Tile tile : aio)
                map[tile.x][tile.y] = tile;
            // xD
        }
    }

    public Tile getTileAt(int x, int y) {
        if (x < 0 || y < 0) return null;
        x /= tilimatorix.sizeOfOneTile;
        y /= tilimatorix.sizeOfOneTile;
        if (x >= Tilimatorix.TILES_IN_X || y >= Tilimatorix.TILES_IN_Y) return null;
        return map[x][y];
    }

    public void draw(Batch batch) {
        for (Tile tile : aio)
            batch.draw(tile.texture, tile.x * tilimatorix.sizeOfOneTile, tile.y * tilimatorix.sizeOfOneTile);
    }

    public Pixmap createComposite() {
        Pixmap map = new Pixmap(Tilimatorix.TILES_IN_X * tilimatorix.sizeOfOneTile, Tilimatorix.TILES_IN_Y * tilimatorix.sizeOfOneTile, Pixmap.Format.RGBA4444);
        for (Tile tile : aio)
            map.drawPixmap(tile.pixmap, tile.x * tilimatorix.sizeOfOneTile, (Tilimatorix.TILES_IN_Y - tile.y-1) * tilimatorix.sizeOfOneTile);
        return map;
    }
}
