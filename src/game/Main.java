package game;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.effect.Glow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.text.*;
import javafx.util.Duration;

//import javafx.swing.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main extends Application {

    private MainMenu.GameMenu gameMenu;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Pane root = new Pane();
        root.setPrefSize(638,443);

        FileInputStream is = new FileInputStream("C:\\Users\\DELL\\IdeaProjects\\TowerDefense\\src\\game\\res\\images\\MenuGame.jpg");
        Image image  = new Image(is);
        is.close();

        ImageView imageView = new ImageView(image);

        gameMenu = new MainMenu.GameMenu();

        root.getChildren().addAll(imageView,gameMenu);

        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
