package game;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import java.io.FileInputStream;


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
