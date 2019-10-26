package gameField.gameEntity;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bullet implements gameEntity{
    private double bulletSpeed, DMG;
    private double posX, posY;
    private double width, height;
    // default image width, height
    Bullet(){
        this.width = 22;
        this.height = 10;
    }
    Bullet(double posX_, double posY_){
        this.width = 22;
        this.height = 10;
        this.bulletSpeed = 1;
        this.posX = posX_;
        this.posY = posY_;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }

    public double getWidth() {
        return width;
    }
    public double getHeight() {
        return height;
    }

    public void setBulletSpeed(double bulletSpeed) {
        this.bulletSpeed = bulletSpeed;
    }
    public double getBulletSpeed() {
        return bulletSpeed;
    }

    public void setDMG(double DMG) {
        this.DMG = DMG;
    }
    public double getDMG() {
        return DMG;
    }

    public ImageView getImage() throws FileNotFoundException {
        //Passing FileInputStream object as a parameter
        FileInputStream inputstream = new FileInputStream("C:\\IdeaProjects\\TowerDefense\\src\\" +
                "graphics\\BasicTowerProjectileGraphic.png");
        Image image = new Image(inputstream);

        //Setting the image view
        return new ImageView(image);
    }

    public ImageView setImagePos() throws FileNotFoundException {
        ImageView imageView = this.getImage();

        // position of image
        imageView.setX(posX);
        imageView.setY(posY);

        //setting the fit height and width of the image view
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        return imageView;
    }
}
