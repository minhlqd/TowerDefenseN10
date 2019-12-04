package game.characters;


import game.Menu;
import game.characters.entity.Monster.*;
import game.characters.entity.Bullet.Bullet;
import game.characters.entity.Tower.TowerMachineGun;
import game.characters.entity.Tower.TowerNormal;
import game.characters.entity.Tower.TowerSniper;
import javafx.animation.AnimationTimer;
import javafx.animation.PathTransition;
import javafx.beans.property.LongProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

import java.util.Iterator;
import java.util.Random;

public class GameField {
    private  TileMap tileMap;
    private  Group monsterGroup;
    private  GameState gameState;
    private  Scene gameScene;
    private  GameController gameController;
    private  AnimationTimer gameLoop;


    public void GameField() throws java.io.IOException{
      
        gameState = GameState.getNewGame();

        tileMap = new TileMap(1280 ,800);

        
        FXMLLoader loader = new FXMLLoader(Menu.GAME_UI);
        StackPane gamePane = new StackPane();
        Group tileMapGroup = new Group();
        monsterGroup = new Group();
        monsterGroup.getChildren().add(tileMap);
        tileMapGroup.getChildren().add(monsterGroup);
        gamePane.getChildren().add(tileMapGroup);

        
        Node gameUI = (Node)loader.load(Menu.GAME_UI.openStream());
        gamePane.getChildren().add(gameUI);
        gameScene = new Scene(gamePane);
        gameScene.getStylesheets().add(GameField.class.getResource("res/menu/GAME_STYLE.css").toExternalForm());
        gameController = loader.<GameController>getController();
        gameController.setGameField(this);

        Menu.stage.setScene(gameScene);
        Monster.setPath(tileMap.getPath());
        startGameLoop();
    }

    public  Scene getGameScene(){
        return gameScene;
    }



    public void buyTowerNormal(double coordinateX , double coordinateY){
       
        int tileX = (int)(coordinateX / 64);
        int tileY = (int)(coordinateY / 64);
        if(tileMap.nodeMap(tileX,tileY)){
            
            if(gameState.getResources() > 39) {
                gameState.addTowerNormal(new TowerNormal(tileX, tileY));
                gameState.setResources(gameState.getResources() - 40);
                tileMap.renderTower(((int) (coordinateX / 64)), ((int) (coordinateY / 64)), 7);
            }
        }
    }
    
    public void buyTowerSniper(double coordinateX , double coordinateY){
        int tileX = (int)(coordinateX / 64);
        int tileY = (int)(coordinateY / 64);
        if(tileMap.nodeMap(tileX,tileY)){
            if(gameState.getResources() > 99) {
                gameState.addTowerSniper(new TowerSniper(tileX, tileY));
                gameState.setResources(gameState.getResources() - 100);
                tileMap.renderTower(((int) (coordinateX / 64)), ((int) (coordinateY / 64)), 8);
            }
        }
    }

    public void buyTowerMachine(double coordinateX , double coordinateY){
        int tileX = (int)(coordinateX / 64);
        int tileY = (int)(coordinateY / 64);
        if(tileMap.nodeMap(tileX,tileY)){
            if(gameState.getResources() > 79) {
                gameState.addTowerMachine(new TowerMachineGun(tileX, tileY));
                gameState.setResources(gameState.getResources() - 80);
                tileMap.renderTower(((int) (coordinateX / 64)), ((int) (coordinateY / 64)), 9);
            }
        }
    }

    private void createMonster(int type){
        switch (type){
            case 0: {
                gameState.getMonstersAlive().add(new SmallMonster());
                break;
            }
            case 1: {
                gameState.getMonstersAlive().add(new NormalMonster());
                break;
            }
            case 2: {
                gameState.getMonstersAlive().add(new TankerMonster());
                break;
            }
            case 3:{
                gameState.getMonstersAlive().add(new BossMonster());
                break;
            }
        }
        monsterGroup.getChildren().add(gameState.getMonstersAlive().get(gameState.getMonstersAlive().size() - 1).getView());
    }


    private void updateLocations(){
        if(!gameState.getMonstersAlive().isEmpty()){
            Iterator<Monster> monsters = gameState.getMonstersAlive().iterator();
            Monster monster;
            while(monsters.hasNext()) {
                monster = monsters.next();
                monster.updateLocation(monster.getMovementSpeed());

                if(monster.isPathFinished()){
                    removeMonster(monster);
                }
            }
        }
    }

    private void createBulletSniper(){
        Path bulletPath;
        PathTransition animation;
        for(TowerSniper towerSniper : gameState.getTowerSniper()){
            for(Bullet bullet : towerSniper.getBulletList()){

                bulletPath = new Path(new MoveTo(bullet.getStartX() , bullet.getStartY()));
                bulletPath.getElements().add(new LineTo(bullet.getEndX() , bullet.getEndY()));
                animation = new PathTransition(Duration.millis(1000 - towerSniper.getAttackSpeed()) , bulletPath , bullet);

                animation.setOnFinished(actionEvent -> {
                    PathTransition finishedAnimation = (PathTransition) actionEvent.getSource();
                    Bullet finishedBullet = (Bullet) finishedAnimation.getNode();

                    finishedBullet.setVisible(false);
                    monsterGroup.getChildren().remove(finishedBullet);

                    if (finishedBullet.getTarget().isDead()) {
                        removeMonster(finishedBullet.getTarget());
                    }
                });
                monsterGroup.getChildren().add(bullet);
                animation.play();
            }
            towerSniper.getBulletList().clear();
        }

    }

    private void createBulletNormal(){
        Path bulletPath;
        PathTransition animation;
        for(TowerNormal towerNormal : gameState.getTowerNormals()){
            for(Bullet bullet : towerNormal.getBulletList()){

                bulletPath = new Path(new MoveTo(bullet.getStartX() , bullet.getStartY()));
                bulletPath.getElements().add(new LineTo(bullet.getEndX() , bullet.getEndY()));
                animation = new PathTransition(Duration.millis(1000 - towerNormal.getAttackSpeed()) , bulletPath , bullet);

                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        PathTransition finishedAnimation = (PathTransition) actionEvent.getSource();
                        Bullet finishedBullet = (Bullet) finishedAnimation.getNode();

                        finishedBullet.setVisible(false);
                        monsterGroup.getChildren().remove(finishedBullet);

                        if(finishedBullet.getTarget().isDead()){
                            removeMonster(finishedBullet.getTarget());
                        }
                    }
                });
                monsterGroup.getChildren().add(bullet);
                animation.play();
            }
            towerNormal.getBulletList().clear();
        }

    }

    private void createBulletMachine(){
        Path bulletPath;
        PathTransition animation;
        for(TowerMachineGun towerMachineGun : gameState.getTowerMachineGuns()){
            for(Bullet bullet : towerMachineGun.getBulletList()){

                bulletPath = new Path(new MoveTo(bullet.getStartX() , bullet.getStartY()));
                bulletPath.getElements().add(new LineTo(bullet.getEndX() , bullet.getEndY()));
                animation = new PathTransition(Duration.millis(1000 - towerMachineGun.getAttackSpeed()) , bulletPath , bullet);

                animation.setOnFinished(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        PathTransition finishedAnimation = (PathTransition) actionEvent.getSource();
                        Bullet finishedBullet = (Bullet) finishedAnimation.getNode();

                        finishedBullet.setVisible(false);
                        monsterGroup.getChildren().remove(finishedBullet);

                        if(finishedBullet.getTarget().isDead()){
                            removeMonster(finishedBullet.getTarget());
                        }
                    }
                });
                monsterGroup.getChildren().add(bullet);
                animation.play();
            }
            towerMachineGun.getBulletList().clear();
        }

    }

    private void updateLabels(int timer){
        gameController.updateLabels(Integer.toString(gameState.getLevel()) , Integer.toString(gameState.getLives()) , Integer.toString(gameState.getResources()) , Integer.toString(gameState.getScore()) , Integer.toString(timer));
    }

    private synchronized void removeMonster(Monster monster){

        if (gameState.getLives() == 0){
            System.exit(1);
        }
        if (monster.isPathFinished()){
            gameState.setLives((gameState.getLives()) - 1);
        }

        else{
            gameState.setResources((gameState.getResources()) + monster.getReward());
            gameState.setScore(gameState.getScore() + (monster.getReward() * gameState.getLevel()));
        }

        monster.getView().setVisible(false);
        gameState.getMonstersAlive().remove(monster);

    }

    private void startGameLoop() {
        final LongProperty secondUpdate = new SimpleLongProperty(0);
        final LongProperty fpsTimer = new SimpleLongProperty(0);
        final AnimationTimer timer = new AnimationTimer() {
            int timer = 10;

            @Override
            public void handle(long timestamp) {
                Random rand = new Random();
                if (timestamp/ 1000000000 != secondUpdate.get()) {
                    timer--;
                    if(timer > 110 ) {
                        int type = rand.nextInt(2);
                        createMonster(type);
                    }
                    else if (timer > 75 && timer <= 95){
                        int type =  rand.nextInt(3);
                        createMonster(type);
                    }
                    else if (timer >= 30 && timer <= 45 ){
                        int type =  rand.nextInt(3);
                        createMonster(type);
                        if (timer == 30){
                            createMonster(3);
                        }
                    }

                    else if(timer <= 0){
                        gameState.setLevel(gameState.getLevel() + 1);
                        timer = 120;
                    }
                }
                createBulletMachine();
                createBulletNormal();
                createBulletSniper();
                if(timestamp / 10000000 != fpsTimer.get()){
                    updateLocations();
                }
                fpsTimer.set(timestamp / 10000000);
                secondUpdate.set(timestamp / 1000000000);
                updateLabels(timer);
            }
        };
        gameLoop = timer;
        timer.start();
    }

}
