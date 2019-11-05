package game.gameField;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class TileMap {
    private int TILE_WIDTH = 64;
    private int TILE_HEIGHT = 64;
    private int[][] grid;
    public Pane mapPane;
    // size of map tiles
    // tiles : 64 x 64
    public TileMap() {
//        12x10
        grid  = new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 4, 1, 1, 1, 1, 2, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 4, 1, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
        };
    }
    public void renderTileMap() throws FileNotFoundException {
        mapPane = new Pane();
        ImageView imageView;
        for (int i = 0; i < grid.length; i++ ) {
            for (int j = 0; j < grid[i].length; j++) {
                String url = ("C:\\IdeaProjects\\TowerDefense\\src\\graphics\\" + grid[i][j] +".png");
                FileInputStream fileInput = new FileInputStream(url);
                Image image = new Image(fileInput);
                imageView = new ImageView(image);
                imageView.setX(i * TILE_WIDTH);
                imageView.setY(j * TILE_HEIGHT);
                mapPane.getChildren().add(imageView);
            }
        }
    }
}
