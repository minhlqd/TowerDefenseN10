package game.gameField;


import game.Coordinate;
import game.entity.enemy.Monster;

import game.entity.enemy.NormalEnemy;
import game.entity.tower.Sniper;
import game.entity.tower.Tower;
import javafx.event.EventHandler;

import javafx.scene.Group;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;


public class GameField{

    private TileMap tileMap;
    private ArrayList<Tower> t;
    private ArrayList<Monster> m;
    public Group gameNode ;
    public GameStage gameStage;
    public GameField(){
        tileMap = new TileMap();
        gameStage = new GameStage();
        gameNode = new Group();
        t = gameStage.getTowers();
        m = gameStage.getMonsters();
    }

    public void renderGameField() throws FileNotFoundException {
//        FileInputStream input = new FileInputStream("C:\\IdeaProjects\\TowerDefense\\src\\graphics\\SniperTower.png");
//        Image image = new Image(input);
//        ImageView imageView = new ImageView(image);
//
//        Button addTowers = new Button("ADD", imageView);
//        addTowers.setTranslateX(0);
//        addTowers.setTranslateY(64 * 10);
//
//        addTowers.prefHeight(64);
//        addTowers.prefHeight(64);
//
//        gameNode.getChildren().addAll(tileMap.mapPane, addTowers);
//        gameNode.setOnDragOver(new EventHandler<DragEvent>() {
//            @Override
//            public void handle(DragEvent dragEvent) {
//
//            }
//        });
        tileMap.renderTileMap();
        gameNode.getChildren().add(tileMap.mapPane);

        for (Tower tower : t) {
            tower.renderImageTower(tower.getPosX(),tower.getPosY());
            gameNode.getChildren().addAll(tower.towerPane);
        }
        for (Monster monster : m) {
            monster.renderMonster();
            monster.move();
            gameNode.getChildren().addAll(monster.monsterPane);
        }
    }

}
