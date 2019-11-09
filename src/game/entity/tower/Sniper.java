package game.entity.tower;

import game.gameField.TileMap;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Sniper extends Tower {

    public Sniper(int x, int y, double radius){
        super(x,y);
        super.radius = Tile_width * radius;
    }
    public void showRange(){
        Circle circle = new Circle();
        circle.setCenterX(Tile_width * 2 + Tile_width / 2f );
        circle.setCenterY(Tile_height * 4 + Tile_height / 2f);
        circle.setRadius(radius);
        circle.setOpacity(0.2);
        towerPane.getChildren().add(circle);
    }

    // image draw
    private ImageView ImageTower() throws FileNotFoundException {
        //Passing FileInputStream object as a parameter
        FileInputStream inputstream = new FileInputStream("C:\\IdeaProjects\\TowerDefense\\src\\graphics\\SniperTower.png");
        Image image = new Image(inputstream);

        //Setting the image view
        ImageView imageView = new ImageView(image);

        // position of image
        imageView.setX(posX);
        imageView.setY(posY);

        //setting the fit height and width of the image view
        imageView.setFitHeight(Tile_height);
        imageView.setFitWidth(Tile_width);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        return imageView;
    }
    public void renderImageTower(int x, int y) throws FileNotFoundException {
        showRange();
        towerPane.getChildren().add(ImageTower());
    }


}
