package game.characters.entity.Monster;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class TankerMonster extends Monster{
    public TankerMonster(){
        super();
        healthPoints = 25;
        movementSpeed = 1;
        reward = 35;
        view = new Circle(path.get(0).getExactX() , path.get(0).getExactY() , radius);
        view.setRadius(15);
        view.setFill(Color.CORNFLOWERBLUE);
    }
}
