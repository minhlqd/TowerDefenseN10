package game;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;

public class MainController {

    @FXML
    private StackPane mainController;

    public void setVista(Node node) {
        mainController.getChildren().setAll(node);
    }

}