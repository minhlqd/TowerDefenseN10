package game.entity.enemy;


import game.Coordinate;
import game.gameField.GameField;
import game.gameField.TileMap;
import javafx.animation.PathTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.*;
import javafx.util.Duration;

import java.io.FileNotFoundException;
import java.util.*;


public abstract class Monster {

    private int monsterX;
    private int monsterY;
    private boolean isDead;
    private Path pathMonster;
    private TileMap tileMap = new TileMap();
    private ArrayList<Coordinate> path;
    public Pane monsterPane = new Pane();
    public Monster(){
        isDead = true;
    }

    public Monster(int monX,int monY){
        isDead = true;
        pathMonster = new Path();
        path = tileMap.findPath();
        this.monsterY = monY;
        this.monsterX = monX;
    }

    public void setMonsterX(int monsterX) {
        this.monsterX = monsterX;
    }

    public int getMonsterX() {
        return monsterX;
    }

    public void setMonsterY(int monsterY) {
        this.monsterY = monsterY;
    }

    public int getMonsterY() {
        return monsterY;
    }

    abstract void isDead(int damage);
    abstract ImageView getImageMonster() throws FileNotFoundException;
    public abstract void renderMonster() throws FileNotFoundException;


    public void move(){
        pathMonster = new Path();

        MoveTo moveTo = new MoveTo(monsterX, monsterY);
        pathMonster.getElements().add(moveTo);

        for (int i = 1; i < path.size(); i++){
//            LineTo lineto = new LineTo(path.get(i).getExactX(), path.get(i).getExactY());
//            pathMonster.getElements().add(lineto);
//            int x = path.get(i).getTileX();
//            int y = path.get(i).getTileY();
//            if (tileMap.grid[y][x] == 1|| tileMap.grid[y][x] == 4 ){
            LineTo way = new LineTo(path.get(i).getExactX(), path.get(i).getExactY());
            pathMonster.getElements().add(way);
        }

        PathTransition pathTransition = new PathTransition();

        pathTransition.setDuration(Duration.millis(10000));
        pathTransition.setNode(monsterPane);

        pathTransition.setPath(pathMonster);
        pathTransition.play();

    }
}