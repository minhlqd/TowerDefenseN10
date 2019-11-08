package game.entity.tower;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


abstract class Tower{
    // tower attributes;
    private int posX, posY;
    private double shootingRadius;
    private int width,height;
    public Pane towerPane;

//    public Tower(){
//        width = 64;
//        height = 64;
//    }
    public Tower(int posX_, int posY_){
        this.posX = posX_;
        this.posY = posY_;
        width = 64;
        height = 64;
    }

    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
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

    abstract void renderImageTower(int x, int y);
    abstract boolean buildTower

//    // image draw
//    public ImageView getImage() throws FileNotFoundException {
//        //Passing FileInputStream object as a parameter
//        FileInputStream inputstream = new FileInputStream("C:\\IdeaProjects\\TowerDefense\\src\\graphics\\BasicTower.png");
//        Image image = new Image(inputstream);
//
//        //Setting the image view
//        return new ImageView(image);
//    }
//
//    public ImageView setImagePos() throws FileNotFoundException {
//        ImageView imageView = this.getImage();
//        // position of image
//        imageView.setX(posX);
//        imageView.setY(posY);
////
////        //setting the fit height and width of the image view
////        imageView.setFitHeight(height);
////        imageView.setFitWidth(width);
////
////        //Setting the preserve ratio of the image view
////        imageView.setPreserveRatio(true);
//
//        return imageView;
//    }
//    public void renderTower() throws FileNotFoundException {
//        towerPane = new Pane();
//        towerPane.getChildren().add(setImagePos());
//    }
}
