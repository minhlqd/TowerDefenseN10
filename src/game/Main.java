package game;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Common common = new Common();
        MainMenu.GameMenu gameMenu = new MainMenu.GameMenu();
        MainMenu.LoadBackground background = new MainMenu.LoadBackground(common.screenWidth, common.screenHeight);

        Group root = new Group();
        root.getChildren().addAll(background.pane, gameMenu );

        Scene scene = new Scene(root);

        primaryStage.setTitle("Tower Defense");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}