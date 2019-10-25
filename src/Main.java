import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import gameField.gameEntity.Tower;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.image.*;


public class Main extends Application {
    @Override
    public void start(Stage stage) throws FileNotFoundException {
        Tower tower = new Tower();

        //Setting the image view
        ImageView imageView = tower.getImage();

        Scanner scan = new Scanner(System.in);
        int x,y;
        x = scan.nextInt();
        y = scan.nextInt();

        tower.setPosX(x);
        tower.setPosY(y);

        //Setting the position of the image
        imageView.setX(tower.getPosX());
        imageView.setY(tower.getPosY());

        //setting the fit height and width of the image view
        imageView.setFitHeight(tower.height);
        imageView.setFitWidth(tower.width);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        //Creating a Group object
        Group root = new Group(imageView);

        //Creating a scene object
        Scene scene = new Scene(root, 900, 900);

        //Setting title to the Stage
        stage.setTitle("TowerDefense");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
