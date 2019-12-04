package game.characters.entity.Tower;

import game.characters.Coordinate;
import game.characters.entity.Bullet.Bullet;
import game.characters.entity.Bullet.TowerAtk;
import game.characters.entity.Monster.Monster;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.io.File;
import java.util.ArrayList;

public class TowerNormal extends Tower {
    
    private static final int BUILD_TIME = 100;
    private int attackDamageNormal;
    private double attackSpeedNormal;
    private int attackRangeNormal;
    private int upgradeTime;
    private int upgradeCost;
    private int sellCostNormal;
    private ArrayList<Bullet> bulletListNormal;
    private Coordinate coordinate;
    private TowerAtk towerAttackerNormal;

    public TowerNormal(int x , int y){
        super(x,y);
        bulletListNormal = new ArrayList<Bullet>();
        coordinate = new Coordinate(x , y);
        attackDamageNormal = 3;
        attackSpeedNormal = 500;
        attackRangeNormal = 250;
        towerAttackerNormal = new TowerAtk(this);
        towerAttackerNormal.pollTowerNormal(BUILD_TIME);
    }


    public void createBullet(Monster target){
        bulletShotSound = new MediaPlayer(new Media(new File("src/game/characters/res/sound/normalcannon.wav").toURI().toString()));
        bulletShotSound.play();
        bulletListNormal.add(new Bullet(target , coordinate.getExactX() , coordinate.getExactY() , Color.rgb(209, 125, 42)));
    }


    public int getX(){
        return coordinate.getExactX();
    }

    public int getY(){
        return coordinate.getExactY();
    }

    public int getAttackRange(){
        return attackRangeNormal;
    }

    public int getAttackDamage(){
        return  attackDamageNormal;
    }

    public double getAttackSpeed(){
        return attackSpeedNormal;
    }



    public TowerAtk getTowerAttacker() {
        return towerAttackerNormal;
    }

    public ArrayList<Bullet> getBulletList() {
        return bulletListNormal;
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }

    public void setAttackDamage(int attackDamage){
        this.attackDamageNormal = attackDamage;
    }

    public void setAttackRange(int attackRange) {
        this.attackRangeNormal = attackRange;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeedNormal = attackSpeed;
    }

}
