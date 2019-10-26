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

    // tower width and height default is 30,30 in BasicTowerGraphics.png
    public Tower(){
        this.width = 30;
        this.height = 30;
    }
    public Tower(double posX_, double posY_){
        this.width = 30;
        this.height = 30;
        this.posX = posX_;
        this.posY = posY_;
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
