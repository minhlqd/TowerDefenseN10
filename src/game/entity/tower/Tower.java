package game.entity.tower;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;


public abstract class Tower{
    // tower attributes;
    protected int posX, posY;
    protected double radius;
    protected int Tile_width,Tile_height;
    protected boolean isBuilded;
    public Pane towerPane = new Pane();

    public Tower(){
        Tile_height = 64;
        Tile_width = 64;
    }

    public Tower(int posX_, int posY_){
        this.posX = posX_;
        this.posY = posY_;
        Tile_width = 64;
        Tile_height = 64;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setBuilded(boolean builded) {
        isBuilded = builded;
    }


    public boolean isBuilded() {
        return isBuilded;
    }
    public double getRadius() {
        return radius;
    }
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }


    public double getHeight() {
        return Tile_height;
    }
    public double getWidth() {
        return Tile_width;
    }

    public abstract void renderImageTower(int x, int y) throws FileNotFoundException;



}
