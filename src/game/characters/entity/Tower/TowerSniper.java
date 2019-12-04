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


public class TowerSniper extends Tower{
    private static final int BUILD_TIME = 100;
    private int attackDamageSniper;
    private double attackSpeedSniper;
    private int attackRangeSniper;
    private int upgradeTime;
    private int upgradeCost;
    private int sellCostSniper;
    private ArrayList<Bullet> bulletListSniper;
    private Coordinate coordinate;
    private TowerAtk towerAttackerSniper;

    public TowerSniper(int x , int y){
        super(x,y);
        bulletListSniper = new ArrayList<Bullet>();
        coordinate = new Coordinate(x , y);
        attackDamageSniper = 5;
        attackSpeedSniper = 350;
        attackRangeSniper = 350;
        towerAttackerSniper = new TowerAtk(this);
        towerAttackerSniper.pollTowerSniper(BUILD_TIME);

    }

    public void createBulletSniper(Monster target){
        bulletShotSound = new MediaPlayer(new Media(new File("src/game/characters/res/sound/cannon3.mp3").toURI().toString()));
        bulletShotSound.play();
        bulletListSniper.add(new Bullet(target , coordinate.getExactX() , coordinate.getExactY() , Color.rgb(214, 200, 39)));
    }


    public int getX(){
        return coordinate.getExactX();
    }

    public int getY(){
        return coordinate.getExactY();
    }

    public int getAttackRange(){
        return attackRangeSniper;
    }

    public int getAttackDamage(){
        return  attackDamageSniper;
    }

    public double getAttackSpeed(){
        return attackSpeedSniper
        ;
    }

    public int getUpgradeCost(){
        return upgradeCost;
    }

    public int getSellCost(){
        return sellCostSniper;
    }

    public int getUpgradeTime(){
        return upgradeTime;
    }

    public TowerAtk getTowerAttacker() {
        return towerAttackerSniper;
    }

    public ArrayList<Bullet> getBulletList() {
        return bulletListSniper;
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }

    public void setAttackDamage(int attackDamage){
        this.attackDamageSniper = attackDamage;
    }

    public void setAttackRange(int attackRange) {
        this.attackRangeSniper = attackRange;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeedSniper = attackSpeed;
    }

}
