package game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public final static int HEIGHT = 800;
    public final static int WIDTH = 1280;
    @Override
    public void start(Stage stage) throws Exception{
        stage.setTitle("Tower Defense");
        stage.setScene(createScene(loadMainPane()));
        stage.setWidth(WIDTH);
        stage.setHeight(HEIGHT);
        stage.setResizable(false);
        stage.show();
        Menu.setStage(stage);
    }

    private Pane loadMainPane() throws IOException {
        FXMLLoader loader = new FXMLLoader();

        Pane mainPane = (Pane) loader.load(getClass().getResourceAsStream(Menu.MAIN));

        MainController mainController = loader.getController();

        Menu.setMainController(mainController);
        Menu.loadMainController(Menu.MAIN_MENU);

        return mainPane;
    }

    private Scene createScene(Pane mainPane) {
        Scene scene = new Scene(mainPane);

        scene.getStylesheets().setAll(getClass().getResource("characters/res/menu/MENU_STYLE.css").toExternalForm());

        return scene;
    }

    public static void main(String[] args) {
        launch(args);

    }
}
