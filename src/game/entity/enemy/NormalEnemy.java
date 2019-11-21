package game.entity.enemy;

import game.MainMenu;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NormalEnemy extends Monster {

    //private static ArrayList<Coordinate> path;
    private int width, height;
    private int rewardNormal;
    private int healthNormal;
    private int nodeDirection;
    private boolean DeadNormal;
    private boolean pathNormal;
    private boolean moveNormal;


    public NormalEnemy() {
        width = 64;
        height = 64;
        healthNormal = 3;
        rewardNormal = 2;
        pathNormal = true;
        DeadNormal = false;
    }

    public NormalEnemy(int monsterX, int monsterY) {
        super(monsterX,monsterY);
        width = 64;
        height = 64;
        healthNormal = 2;
        rewardNormal = 2;
        pathNormal = true;
        DeadNormal = false;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getRewardNormal() {
        return rewardNormal;
    }

    public int getHealthNormal() {
        return healthNormal;
    }

    public boolean isDeadNormal() {
        return DeadNormal;
    }

    public boolean isPathNormal() {
        return pathNormal;
    }

    void isDead(int damage) {
        healthNormal -= damage;
        if (healthNormal <= 0) {
            DeadNormal = false;
            pathNormal = false;
        }
    }

    ImageView getImageMonster() throws FileNotFoundException {
        //Passing FileInputStream object as a parameter
        FileInputStream inputstream = new FileInputStream("C:\\IdeaProjects\\TowerDefense\\src\\graphics\\enemy1.png");
        Image image = new Image(inputstream);

        //Setting the image view
        ImageView imageView =  new ImageView(image);

        // position of image
        imageView.setX(getMonsterX());
        imageView.setY(getMonsterY());

        //setting the fit height and width of the image view
        imageView.setFitHeight(height);
        imageView.setFitWidth(width);

        //Setting the preserve ratio of the image view
        imageView.setPreserveRatio(true);

        return imageView;
    }

    public void renderMonster() throws FileNotFoundException {
        monsterPane.getChildren().add(getImageMonster());
    }
}

