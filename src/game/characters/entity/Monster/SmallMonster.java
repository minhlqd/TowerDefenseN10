package game.characters.entity.Monster;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class SmallMonster extends Monster {
    public SmallMonster(){
        super();
        healthPoints = 5;
        movementSpeed = 2;
        reward = 5;
        view = new Circle(path.get(0).getExactX() , path.get(0).getExactY() , radius);
        view.setRadius(9);
        view.setFill(Color.ALICEBLUE);
    }
}
