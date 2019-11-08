package game.entity.tower;

import java.io.FileNotFoundException;

import javafx.scene.image.ImageView;


// interface for tower,mountain,path,..
public interface gameEntity{
    double getPosX();
    double getPosY();
    double getWidth();
    double getHeight();
    ImageView getImage() throws FileNotFoundException;
    ImageView setImagePos() throws FileNotFoundException;
}
