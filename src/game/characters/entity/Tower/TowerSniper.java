package game.characters.entity.Tower;


import game.characters.Coordinate;
import game.characters.entity.Bullet.Bullet;
import game.characters.entity.Bullet.TowerAtk;
import game.characters.entity.Monster.Monster;
import javafx.scene.paint.Color;

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
        attackDamageSniper = 3;
        attackSpeedSniper = 10;
        attackRangeSniper = 300;
        towerAttackerSniper = new TowerAtk(this);
        towerAttackerSniper.pollTowerSniper(BUILD_TIME);
        sellCostSniper = 35;
        upgradeCost = 20;
        upgradeTime = 5000;
    }


    public void upgradeTower(){
        attackDamageSniper += 1;
        attackSpeedSniper = attackSpeedSniper + 0.1;
        attackRangeSniper = attackRangeSniper + 50;
        upgradeTime += 3000;
        upgradeCost += 20;
    }


    public void createBulletSniper(Monster target){
        bulletListSniper.add(new Bullet(target , coordinate.getExactX() , coordinate.getExactY() , Color.BLACK));
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
