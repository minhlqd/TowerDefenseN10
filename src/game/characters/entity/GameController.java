package game.characters;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;


public class GameController {

    @FXML
    private Label Score;
    @FXML
    private Label Resources;
    @FXML
    private Label Level;
    @FXML
    private Label Lives;
    @FXML
    private Label timeLabel;

    private GameField gameField;

    public void setGameField(GameField gameField){
        this.gameField = gameField;
    }

    public void buyTowerNormal(){
        gameField.getGameScene().setOnMouseClicked(new buyTowerNormal());
    }
    public void buyTowerSniper(){
        gameField.getGameScene().setOnMouseClicked(new buyTowerSniper());
    }
    public void buyTowerMachine() {gameField.getGameScene().setOnMouseClicked(new buyTowerMachine());}
    public void exit(){
        System.exit(1);
    }

    public void updateLabels(String  Level , String  Lives , String  Resources , String  Score , String timeLabel){
        this.Level.setText(Level);
        this.Lives.setText(Lives);
        this.Resources.setText(Resources);
        this.Score.setText(Score);
        this.timeLabel.setText(timeLabel);
    }


    class buyTowerNormal implements EventHandler<MouseEvent> {
        public void handle(MouseEvent mouseEvent) {
            gameField.buyTowerNormal(mouseEvent.getX(),mouseEvent.getY());
        }
    }
    class buyTowerSniper implements EventHandler<MouseEvent> {
        public void handle(MouseEvent mouseEvent) { gameField.buyTowerSniper(mouseEvent.getX(),mouseEvent.getY());}
    }
    class buyTowerMachine implements EventHandler<MouseEvent> {
        public void handle(MouseEvent mouseEvent) { gameField.buyTowerMachine(mouseEvent.getX(),mouseEvent.getY());}
    }

}
