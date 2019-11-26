package game.characters.entity.Tower;

import game.characters.Coordinate;
import game.characters.entity.Bullet.Bullet;
import game.characters.entity.Bullet.TowerAtk;
import game.characters.entity.Monster.Monster;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class TowerMachineGun extends Tower {

    private static final int BUILD_TIME = 100;
    private int attackDamageMachine;
    private double attackSpeedMachine;
    private int attackRangeMachine;
    private int upgradeTime;
    private int upgradeCost;
    private int sellCostMachine;
    private ArrayList<Bullet> bulletListMachine;
    private Coordinate coordinate;
    private TowerAtk towerAttackerMachine;

    public TowerMachineGun(int x , int y){
        super(x,y);
        bulletListMachine = new ArrayList<Bullet>();
        coordinate = new Coordinate(x , y);
        attackDamageMachine = 1;
        attackSpeedMachine = 20;
        attackRangeMachine = 200;
        towerAttackerMachine = new TowerAtk(this);
        towerAttackerMachine.pollTowerMachine(BUILD_TIME);
        sellCostMachine = 35;
        upgradeCost = 20;
        upgradeTime = 5000;
    }


    public void upgradeTower(){
        attackDamageMachine += 1;
        attackSpeedMachine = attackSpeedMachine + 0.1;
        attackRangeMachine = attackRangeMachine + 50;
        upgradeTime += 3000;
        upgradeCost += 20;
    }


    public void createBullet(Monster target){
        bulletListMachine.add(new Bullet(target , coordinate.getExactX() , coordinate.getExactY() , Color.GREEN));
    }


    public int getX(){
        return coordinate.getExactX();
    }

    public int getY(){
        return coordinate.getExactY();
    }

    public int getAttackRange(){
        return attackRangeMachine;
    }

    public int getAttackDamage(){
        return  attackDamageMachine;
    }

    public double getAttackSpeed(){
        return attackSpeedMachine
                ;
    }

    public int getUpgradeCost(){
        return upgradeCost;
    }

    public int getSellCost(){
        return sellCostMachine;
    }

    public int getUpgradeTime(){
        return upgradeTime;
    }

    public TowerAtk getTowerAttacker() {
        return towerAttackerMachine;
    }

    public ArrayList<Bullet> getBulletList() {
        return bulletListMachine;
    }

    public Coordinate getCoordinate(){
        return coordinate;
    }

    public void setAttackDamage(int attackDamage){
        this.attackDamageMachine = attackDamage;
    }

    public void setAttackRange(int attackRange) {
        this.attackRangeMachine = attackRange;
    }

    public void setAttackSpeed(double attackSpeed) {
        this.attackSpeedMachine = attackSpeed;
    }

}
