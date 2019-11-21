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
    ArrayList<Monster> getMonsters() {
        return monsters;
    }
    ArrayList<Tower> getTowers() {
        return towers;
    }

    public void createTower(){

    }
    public void deleteTower(){

    }
    public void addMonster(){

    }
    public void destroyMonster(){

    }

}
