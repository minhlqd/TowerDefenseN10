package game.gameField;

import game.entity.enemy.Monster;
import game.entity.enemy.NormalEnemy;
import game.entity.tower.Tower;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class GameStage {
    private ArrayList<Monster> monsters;
    private ArrayList<Tower> towers;
    private int n = 12;
    private int startX = 0;
    private int startY = 64;
    public GameStage(){
        monsters = new ArrayList<>();
        towers = new ArrayList<>();
        for (int i = 0; i < n; i++){
            Monster m = new NormalEnemy(startX, startY);
            monsters.add(m);
        }
    }
     public ArrayList<Tower> getPlayerTowers(){
        return playerTowers;
    }

    public ArrayList<Enemy> getEnemyAlive() {
        return EnemyAlive;
    }
    public void addTower(Tower tower){playerTowers.add(tower);}
    public void removeMonster(Enemy enemy){EnemyAlive.remove(enemy);}
    public void removeTower(Tower tower){playerTowers.remove(tower);}

}
