package game.characters.entity.Bullet;

import game.characters.GameState;
import game.characters.entity.Monster.Monster;
import game.characters.entity.Tower.TowerMachineGun;
import game.characters.entity.Tower.TowerNormal;
import game.characters.entity.Tower.TowerSniper;

import java.util.Iterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class TowerAtk {
    private final ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
    private ScheduledFuture<?> pollHandler;
    private TowerSniper towerSniper;
    private TowerNormal towerNormal;
    private TowerMachineGun towerMachineGun;
    private Monster target;

    public TowerAtk(TowerSniper towerSniper){
        this.towerSniper = towerSniper;
    }
    public TowerAtk(TowerNormal towerNormal) {this.towerNormal = towerNormal;}
    public TowerAtk(TowerMachineGun towerMachineGun){this.towerMachineGun = towerMachineGun;}

    public void pollTowerSniper(int delay){
        final Runnable task = new Runnable() {
            @Override
            public void run() {
                int towerMinXRange = towerSniper.getX() - towerSniper.getAttackRange();
                int towerMaxXRange = towerSniper.getX() + towerSniper.getAttackRange();
                int towerMinYRange = towerSniper.getY() - towerSniper.getAttackRange();
                int towerMaxYRange = towerSniper.getY() + towerSniper.getAttackRange();
                Iterator<Monster> iterator = GameState.getGame().getMonstersAlive().iterator();
                while (iterator.hasNext()) {
                    target = iterator.next();
                    if (target.getX() > towerMinXRange & target.getX() < towerMaxXRange & target.getY() > towerMinYRange & target.getY() < towerMaxYRange) {
                        towerSniper.createBulletSniper(target);
                        target.takeDamage(towerSniper.getAttackDamage());
                        break;
                    }
                }
            }
        };
        pollHandler = scheduledExecutorService.scheduleWithFixedDelay(task , delay , 1000 , TimeUnit.MILLISECONDS);
    }

    public void pollTowerMachine(int delay){
        final Runnable taskMachine = new Runnable() {
            @Override
            public void run() {
                int towerMinXRange = towerMachineGun.getX() - towerMachineGun.getAttackRange();
                int towerMaxXRange = towerMachineGun.getX() + towerMachineGun.getAttackRange();
                int towerMinYRange = towerMachineGun.getY() - towerMachineGun.getAttackRange();
                int towerMaxYRange = towerMachineGun.getY() + towerMachineGun.getAttackRange();
                Iterator<Monster> iterator = GameState.getGame().getMonstersAlive().iterator();
                while (iterator.hasNext()) {
                    target = iterator.next();
                    if (target.getX() > towerMinXRange & target.getX() < towerMaxXRange & target.getY() > towerMinYRange & target.getY() < towerMaxYRange) {
                        towerMachineGun.createBullet(target);
                        target.takeDamage(towerMachineGun.getAttackDamage());
                        break;
                    }
                }
            }
        };
        pollHandler = scheduledExecutorService.scheduleWithFixedDelay(taskMachine , delay , 1000 , TimeUnit.MILLISECONDS);
    }

    public void pollTowerNormal(int delay){
        final Runnable taskNormal = new Runnable() {
            @Override
            public void run() {
                int towerMinXRange = towerNormal.getX() - towerNormal.getAttackRange();
                int towerMaxXRange = towerNormal.getX() + towerNormal.getAttackRange();
                int towerMinYRange = towerNormal.getY() - towerNormal.getAttackRange();
                int towerMaxYRange = towerNormal.getY() + towerNormal.getAttackRange();
                Iterator<Monster> iterator = GameState.getGame().getMonstersAlive().iterator();
                while (iterator.hasNext()) {
                    target = iterator.next();
                    if (target.getX() > towerMinXRange & target.getX() < towerMaxXRange & target.getY() > towerMinYRange & target.getY() < towerMaxYRange) {
                        towerNormal.createBullet(target);
                        target.takeDamage(towerNormal.getAttackDamage());
                        break;
                    }
                }
            }
        };
        pollHandler = scheduledExecutorService.scheduleWithFixedDelay(taskNormal , delay , 1000 , TimeUnit.MILLISECONDS);
    }
  
}
