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

public class TowerMachineGun extends Tower {

    private static final int BUILD_TIME = 100;
    private int attackDamageMachine;
    private double attackSpeedMachine;
    private int attackRangeMachine;
    private ArrayList<Bullet> bulletListMachine;
    private Coordinate coordinate;
    private TowerAtk towerAttackerMachine;

    public TowerMachineGun(int x , int y){
        super(x,y);
        bulletListMachine = new ArrayList<Bullet>();
        coordinate = new Coordinate(x , y);
        attackDamageMachine = 4;
        attackSpeedMachine = 800;
        attackRangeMachine = 250;
        towerAttackerMachine = new TowerAtk(this);
        towerAttackerMachine.pollTowerMachine(BUILD_TIME);
    }


    public void createBullet(Monster target){
        bulletShotSound = new MediaPlayer(new Media(new File("src/game/characters/res/sound/Shot.wav").toURI().toString()));
        bulletShotSound.play();
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
        return attackSpeedMachine;
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
