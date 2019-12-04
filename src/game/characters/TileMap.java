package game.characters;

import javafx.scene.image.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Scanner;


public class TileMap extends ImageView{
    private final static String TILE_SET_64 = "game/characters/res/TileSet/tile.jpg";
    private final static String TEXT = "src/game/characters/res/text/map";
    private final static int LENGTH_MAP = 20;


    public int[][] map;
    private final int RESOLUTION_WIDTH;
    private final int RESOLUTION_HEIGHT;
    private final int TILE_LENGTH_X;
    private final int TILE_LENGTH_Y;
    private final int OFFSET_Y;
    private final boolean OFFSET_Y_FLAG;

    public TileMap(int mapWidth , int mapHeight) throws FileNotFoundException {
        RESOLUTION_WIDTH  = mapWidth;
        RESOLUTION_HEIGHT  = mapHeight;

        TILE_LENGTH_X = (int) Math.ceil(mapWidth / 64d);
        TILE_LENGTH_Y = (int) Math.ceil(mapHeight / 64d);

        OFFSET_Y = TILE_LENGTH_Y * 64 - RESOLUTION_HEIGHT;

        if(OFFSET_Y == 0){
            OFFSET_Y_FLAG = false;
        }
        else{
            OFFSET_Y_FLAG = true;
        }
        map = getMap();
        System.out.println("map: ");
        for(int x = 0; x <TILE_LENGTH_Y; x++) {
            for (int y = 0; y < TILE_LENGTH_X; y++) {
                System.out.print(map[x][y] + " ");
            }
            System.out.println();
        }
        render();
    }

    public void render(){

        Image tileset = loadTileSet();
        PixelReader  tileReader = tileset.getPixelReader();
        byte[] buffer = new byte[64 * 64 * 4];
        WritablePixelFormat<ByteBuffer> picFormat = WritablePixelFormat.getByteBgraInstance();

        WritableImage loadMap = new WritableImage(RESOLUTION_WIDTH , RESOLUTION_HEIGHT);
        PixelWriter tileWriter = loadMap.getPixelWriter();

        for(int x = 0; x < TILE_LENGTH_X; x++){
            for(int y = 0; y < TILE_LENGTH_Y; y++ ){

                switch(map[y][x]){
                    // Path and landscape
                    case 0:
                        tileReader.getPixels(1216 , 384 , 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                    case 1:
                        tileReader.getPixels(384, 448, 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                    case 2:
                        tileReader.getPixels(384, 448 , 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                    case 3:
                        tileReader.getPixels(384 , 448 , 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                    case 4:
                        tileReader.getPixels(384, 448, 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                    case 5:
                        tileReader.getPixels(384, 448 , 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                    case 6:
                        tileReader.getPixels(384, 448, 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                        //__Towers____________
                    case 7:
                        tileReader.getPixels(1280 , 384 , 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                    case 8:
                        tileReader.getPixels(1344 , 384, 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                    case 9:
                        tileReader.getPixels(1408 ,  384 , 64,64 , picFormat , buffer , 0 , 256);
                        break;
                    //___Trees_______
                    case 10:
                        tileReader.getPixels(1344 , 320, 64 , 64 , picFormat , buffer , 0 , 256);
                        break;
                    case 11:
                        tileReader.getPixels(1408 ,  320 , 64,64 , picFormat , buffer , 0 , 256);
                        break;
                    case 12:
                        tileReader.getPixels(1024 ,  320 , 64,64 , picFormat , buffer , 0 , 256);
                        break;
                    case 13:
                        tileReader.getPixels(960 ,  320 , 64,64 , picFormat , buffer , 0 , 256);
                        break;

                }
                if(y == TILE_LENGTH_Y - 1 & OFFSET_Y_FLAG){
                    tileWriter.setPixels(x * 64 , y * 64, 64 , OFFSET_Y , picFormat , buffer , 0 , 256);
                }
                else{
                    tileWriter.setPixels(x * 64 , y * 64, 64 , 64 , picFormat , buffer , 0 , 256);
                }
            }
        };
        this.setImage(loadMap);
    }


    private int[][] getMap() throws FileNotFoundException {

        File file = new File(TEXT);
        Scanner sc = new Scanner(file);

        int[][] map = new int[10000][10000];
        for (int x = 0; sc.hasNextLine(); x++) {
            for (int y = 0; y < LENGTH_MAP; y++) {
                map[x][y] = sc.nextInt();
                System.out.print(map[x][y]+" ");
            }
            System.out.println();
        }

        return map;
    }


    private Image loadTileSet(){
        return new Image(TILE_SET_64);
    }

    public void renderTower(int coordinateX , int coordinateY , int value){
        map[coordinateY][coordinateX] = value;
        this.render();
    }


    public boolean nodeMap(int coordinateX , int coordinateY ){
        if(map[coordinateY][coordinateX] != 0){
            return false;
        }
        return true;
    }

    public ArrayList<Coordinate> getPath(){
        int goX = 0;
        int goY = 9;

        int finishX = 19;
        int finishY = 3;

        ArrayList<Coordinate> path = new ArrayList<Coordinate>();
        while (goX != finishX || goY != finishY) {

            if (map[goY][goX] == 1) { //RIGHT
                path.add(new Coordinate(goX, goY ));
                goX++;
            }
            if (map[goY][goX] == 2) { // DOWN
                path.add(new Coordinate(goX, goY));
                goY++;
            }
            if (map[goY][goX] == 3) // UP
            {
                path.add(new Coordinate(goX, goY));
                goY--;
            }
            if (map[goY][goX] == 4) // LEFT
            {
                path.add(new Coordinate(goX, goY));
                goX--;
            }

            if (map[goY][goX] == 5) { // FINISH LINE
                break;
            }
        }
        path.add(new Coordinate(goX, goY));

        return path;
    }
}
