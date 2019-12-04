package game.characters.entity.Monster;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class NormalMonster extends Monster{
    public NormalMonster(){
        super();
        healthPoints = 10;
        movementSpeed = 1;
        reward = 10;
        view = new Circle(path.get(0).getExactX() , path.get(0).getExactY() , radius);
        view.setFill(Color.ORANGERED);
    }
}
