package game.entity.tower;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Bullet{
    private double DMG;
    private double posX, posY;
    private double width, height;
    private double bulletV_x, BulletV_y;
    // default image width, height
    Bullet(){
        this.width = 22;
        this.height = 10;
    }
    Bullet(double posX_, double posY_){
        this.width = 22;
        this.height = 10;
        this.posX = posX_;
        this.posY = posY_;
    }

    public void setBulletV_x(double bulletV_x) {
        this.bulletV_x = bulletV_x;
    }
    public void setBulletV_y(double bulletV_y) {
        BulletV_y = bulletV_y;
    }

    public void setPosY(double posY) {
        this.posY = posY;
    }
    public void setPosX(double posX) {
        this.posX = posX;
    }

    public double getBulletV_x() {
        return bulletV_x;
    }
    public double getBulletV_y() {
        return BulletV_y;
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
