package game.characters.entity.Monster;

import game.characters.Coordinate;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.util.ArrayList;

public abstract class Monster {
    protected static ArrayList<Coordinate> path;
    protected Circle view;
    protected Rectangle healthBar;
    protected final int radius = 10;
    protected int healthPoints;
    protected int movementSpeed;
    protected int reward;
    protected int nodeDirection;
    protected boolean moveX;
    protected boolean isDead;
    protected boolean pathFinished;

    public Monster(){
        healthBar = new Rectangle(healthPoints * 10, 14, Color.rgb(227, 57, 39));
        pathFinished = false;
        moveX = true;
        nodeDirection = 1;
    }

    public int getX(){
        return ((int)view.getCenterX());
    }
    public int getY(){
        return ((int)view.getCenterY());
    }
    public int getReward(){
        return reward;
    }
    public Shape getView(){
        return view;
    }
    public Rectangle getHealthBar() {
        return healthBar;
    }

    public boolean isDead(){
        return isDead;
    }
    public int getMovementSpeed() {
        return movementSpeed;
    }

    public boolean isPathFinished(){
        return pathFinished;
    }

    public static void setPath(ArrayList<Coordinate> pathSet){
        path = pathSet;
    }

//    public Rectangle showHealthBar(){
//
//    }
    public void takeDamage(int damage){
        healthPoints = healthPoints - damage;
        if (healthPoints <= 0){
            isDead = true;
            pathFinished = false;
        }
    }

    public void updateLocation(int distance){
        healthBar.setX(view.getCenterX());
        healthBar.setY(view.getCenterY() - 10);
        // Move along the x axis
        if(moveX){
            if (view.getCenterX() < path.get(nodeDirection).getExactX()) {
                view.setCenterX(view.getCenterX() + distance);
            }
            else{
                view.setCenterX(view.getCenterX() - distance);
            }

            if(view.getCenterX() == path.get(nodeDirection).getExactX()){
                moveX = false;
                nodeDirection++;

                if(nodeDirection == path.size()){
                    pathFinished = true;
                    isDead = true;
                }
            }
        }
        else{
            if(view.getCenterY() < path.get(nodeDirection).getExactY()) {
                view.setCenterY(view.getCenterY() + distance);
            }
            else{
                view.setCenterY(view.getCenterY() - distance);
            }
            if(view.getCenterY() == path.get(nodeDirection).getExactY() ){
                nodeDirection++;
                moveX = true;
                if(nodeDirection == path.size()){
                    pathFinished = true;
                    isDead = true;
                }
            }
        }

    }

}
