package game;

import game.characters.GameField;

import java.io.IOException;

public class MainMenu {

    public void startNewGame(){
        try{
            GameField gameField = new GameField();
            gameField.GameField();}catch (IOException ex){ex.printStackTrace();}
    }
    public void exitGame(){
        System.exit(1);
    }
}
