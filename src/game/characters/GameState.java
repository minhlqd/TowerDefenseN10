package game.characters;

import game.characters.entity.Monster.Monster;
import game.characters.entity.Tower.TowerMachineGun;
import game.characters.entity.Tower.TowerNormal;
import game.characters.entity.Tower.TowerSniper;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;


public class GameState implements Serializable{

    private static MediaPlayer mediaPlayer= new MediaPlayer(new Media(new File("src/game/characters/res/sound/background.wav").toURI().toString()));

    private static GameState playerGame;
    private int state;
    private int resources;
    private int level;
    private int score;
    private int lives;;
    private ArrayList<TowerSniper> towerSnipers;
    private ArrayList<TowerNormal> towerNormals;
    private ArrayList<TowerMachineGun> towerMachineGuns;
    private ArrayList<Monster> monstersAlive;

    private GameState(){
        resources = 100;
        level = 0;
        score = 0;
        lives = 20;
        towerSnipers = new ArrayList<TowerSniper>();
        towerNormals = new ArrayList<TowerNormal>();
        towerMachineGuns = new ArrayList<TowerMachineGun>();
        monstersAlive = new ArrayList<Monster>();
    }

    public static GameState getNewGame(){
        playerGame = new GameState();
        mediaPlayer.play();
        return playerGame;
    }


    public static GameState getGame() throws NullPointerException{
        return playerGame;
    }


    public void setResources(int resources){
        this.resources = resources;
    }
    public void setLevel(int level){
        this.level = level;
    }
    public void setScore(int score){
        this.score = score;
    }
    public void setLives(int lives){
        this.lives = lives;
    }


    public int getResources(){
        return resources;
    }
    public int getLevel(){
        return level;
    }
    public int getScore(){
        return score;
    }
    public int getLives() {
        return lives;
    }
    public ArrayList<TowerSniper> getTowerSniper(){
        return towerSnipers;
    }

    public ArrayList<TowerNormal> getTowerNormals() {
        return towerNormals;
    }

    public ArrayList<Monster> getMonstersAlive() {
        return monstersAlive;
    }

    public ArrayList<TowerMachineGun> getTowerMachineGuns() {
        return towerMachineGuns;
    }

    public void addTowerSniper(TowerSniper towerSniper){towerSnipers.add(towerSniper);}
    public void addTowerNormal(TowerNormal towerNormal){towerNormals.add(towerNormal);}
    public void addTowerMachine(TowerMachineGun towerMachineGun){towerMachineGuns.add(towerMachineGun);}

}
