package game.gameField;

import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import game.Coordinate;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class TileMap {

    public int[][] grid;
    public Pane mapPane;


    public TileMap( ) {

        grid  = new int[][]{
                // ( 10 x 14 ) * 64 pixel
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
                {0, 0, 0, 2, 0, 1, 1, 1, 1, 2, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 3, 0, 0, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 2, 0, 3, 0, 0, 0, 2, 0, 0, 0 ,0},
                {0, 0, 0, 2, 0, 3, 0, 0, 0, 2, 0, 0, 0 ,0},
                {0, 0, 0, 1, 1, 3, 0, 0, 0, 2, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 7},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 ,0},
        };
    }

    public ArrayList<Coordinate> findPath(){
        // FIND STARTING POINT - END POINT
        int goX = 0 , goY = 1;
        int finishX = 13, finishY = 9;

        // AUTO FIND PATH
        ArrayList<Coordinate> path = new ArrayList<>();
        while (goX != finishX || goY != finishY){
            System.out.println(goX + " " + goY);
            if (grid[goY][goX] == 1 ){ //RIGHT
                goX++;
                path.add(new Coordinate(goX, goY));
            }
            if (grid[goY][goX] == 2) { // DOWN
                goY++;
                path.add(new Coordinate(goX, goY));
            }
            if (grid[goY][goX] == 3) // UP
            {
                goY--;
                path.add(new Coordinate(goX, goY));
            }
            if (grid[goY][goX] == 4) // LEFT
            {
                goX--;
                path.add(new Coordinate(goX, goY));
            }
            if (grid[goY][goX] == 7){ // FINISH LINE
                break;
            }
        }
        System.out.println(goX + " " + goY);
        return path;
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

                int tileWidth = 64;
                imageView.setX(j * tileWidth);
                imageView.setY(i * tileWidth);

                imageView.setPreserveRatio(true);

                mapPane.getChildren().add(imageView);
            }
        }
    }
}
