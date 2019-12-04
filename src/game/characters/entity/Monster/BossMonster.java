package game.characters.entity.Monster;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BossMonster extends Monster{
    public BossMonster(){
        super();
        healthPoints = 200;
        movementSpeed = 1;
        reward = 100;
        view = new Circle(path.get(0).getExactX() , path.get(0).getExactY() , radius);
        view.setFill(Color.DARKGRAY);
        view.setRadius(18);
    }
}
