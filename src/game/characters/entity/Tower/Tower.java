package game.characters.entity.Tower;


import game.characters.entity.Bullet.Bullet;
import game.characters.entity.Bullet.TowerAtk;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.ArrayList;


public abstract class Tower {

    protected int x;
    protected int y;
    protected MediaPlayer bulletShotSound;
    ;

    public Tower(int x,int y){

        this.x=x;
        this.y=y;
    }

    public abstract TowerAtk getTowerAttacker();

    public abstract ArrayList<Bullet> getBulletList();

    public abstract void setAttackDamage(int attackDamage);

    public abstract void setAttackRange(int attackRange);

    public abstract void setAttackSpeed(double attackSpeed);

}
