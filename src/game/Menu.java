package game;

import game.characters.GameField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;


public class Menu {


    public static final String MAIN    = "characters/res/menu/holder.fxml";
    public static final String MAIN_MENU = "characters/res/menu/MAIN_MENU.fxml";
    public static final URL GAME_UI = GameField.class.getResource("res/menu/GAME_UI.fxml");


    public static Stage stage;

    public static void setStage(Stage stage1){
        stage = stage1;
    }

    private static MainController mainController;


    public static void setMainController(MainController mainController) {
        Menu.mainController = mainController;
    }

    public static void loadVista(String fxml) {
        try {
            mainController.setVista((Node)(FXMLLoader.load((Menu.class.getResource(fxml)))));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}