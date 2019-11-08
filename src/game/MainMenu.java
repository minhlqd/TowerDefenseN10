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
public class MainMenu {

    public static class GameMenu extends Parent {
        public GameMenu() {
            VBox menu0 = new VBox(10);
            VBox menu1 = new VBox(10);

            menu0.setTranslateX(100);
            menu0.setTranslateY(200);

            menu1.setTranslateX(100);
            menu1.setTranslateY(200);

            final int offset = 100;

            menu1.setTranslateX(offset);
           
            // create buttonLoadGame 
            
            MenuButton buttonLoadGame = new MenuButton("LOAD GAME");
            buttonLoadGame.setOnMouseClicked(event -> {
                 GameField gameField = new GameField();
                try {
                    gameField.renderGameField();
                    getChildren().addAll(gameField.tileMap.mapPane,gameField.towers.towerPane);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            });
            
            // create buttonOption

            MenuButton buttonOption = new MenuButton("OPTIONS");
            buttonOption.setOnMouseClicked(event -> {
                getChildren().add(menu1);

                TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25), menu0);
                translateTransition.setToX(menu0.getTranslateX() - offset);

                TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menu0);
                translateTransition1.setToX(menu0.getTranslateX());

                translateTransition.play();
                translateTransition1.play();

                translateTransition.setOnFinished(evt -> {
                    getChildren().remove(menu0);
                });
            });
            
            // create buttonExit

            MenuButton buttonExit = new MenuButton("EXIT");
            buttonExit.setOnMouseClicked(event -> {
                System.exit(0);
            });

            MenuButton buttonBack = new MenuButton("BACK");
            buttonBack.setOnMouseClicked(event -> {
                getChildren().add(menu0);

                TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(0.25), menu1);
                translateTransition.setToX(menu1.getTranslateX() + offset);

                TranslateTransition translateTransition1 = new TranslateTransition(Duration.seconds(0.5), menu1);
                translateTransition1.setToX(menu1.getTranslateX());

                translateTransition.play();
                translateTransition1.play();

                translateTransition.setOnFinished(evt -> {
                    getChildren().remove(menu1);
                });

            });
            
            // create buttonSound , buttonVideo

            MenuButton buttonSound = new MenuButton("SOUND");
            MenuButton buttonVideo = new MenuButton("VIDEO");

            menu0.getChildren().addAll(buttonLoadGame, buttonOption, buttonExit);
            menu1.getChildren().addAll(buttonBack, buttonSound, buttonVideo);

            Rectangle rectangle = new Rectangle(800, 600);
            rectangle.setFill(Color.GREY);
            rectangle.setOpacity(0.4);

            getChildren().addAll(rectangle, menu0);
        }
    }


    public static class MenuButton extends StackPane {
        private Text text;

        public MenuButton(String name) {
            text = new Text(name);
            text.setFont(text.getFont().font(20));
            text.setFill(Color.WHITE);

            Rectangle rectangle = new Rectangle(250, 30);
            rectangle.setOpacity(0.6);
            rectangle.setFill(Color.BLACK);
            rectangle.setEffect(new GaussianBlur(3.5));

            setAlignment(Pos.CENTER_LEFT);
            setRotate(-0.5);
            getChildren().addAll(rectangle, text);

            setOnMouseEntered(event -> {
                rectangle.setTranslateX(10);
                text.setTranslateX(10);
                rectangle.setFill(Color.GREEN);
                text.setFill(Color.BLACK);
            });

            setOnMouseExited(event -> {
                rectangle.setTranslateX(0);
                text.setTranslateX(0);
                rectangle.setFill(Color.BLACK);
                text.setFill(Color.WHITE);
            });

            DropShadow drop = new DropShadow(50, Color.WHITE);
            drop.setInput(new Glow());

            setOnMousePressed(event -> setEffect(drop));
            setOnMouseReleased(event -> setEffect(null));
        }
    }
}


