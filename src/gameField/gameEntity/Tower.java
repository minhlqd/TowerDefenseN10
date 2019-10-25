package gameField.gameEntity;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class Tower implements gameEntity{
    // tower attributes;
    private double posX, posY;
    private double shootingRadius;
    public double width,height;

    public Tower(){
        this.width = 30;
        this.height = 30;
    }
    public void setHeight(double height) {
        this.height = height;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public void setPosX(double posX) {
        this.posX = posX;
    }
    public void setPosY(double posY) {
        this.posY = posY;
    }
    public void setShootingRadius(double shootingRadius) {
        this.shootingRadius = shootingRadius;
    }

    public double getShootingRadius() {
        return shootingRadius;
    }
    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }

    public double getHeight() {
        return height;
    }
    public double getWidth() {
        return width;
    }

    // image draw
    public ImageView getImage() throws FileNotFoundException {
        //Passing FileInputStream object as a parameter
        FileInputStream inputstream = new FileInputStream("C:\\IdeaProjects\\TowerDefense\\src\\graphics\\BasicTowerGraphic.png");
        Image image = new Image(inputstream);

        //Setting the image view
        ImageView imageView = new ImageView(image);

        return imageView;
    }

}
