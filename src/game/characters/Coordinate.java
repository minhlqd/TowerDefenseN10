package game.characters;

public class Coordinate {
    private int x;
    private int y;

    public Coordinate(int x , int y){
        this.x = x;
        this.y = y;
    }

    public int getTileX(){
        return x;
    }
    public int getTileY(){
        return y;
    }

    public int getExactX(){
        return x * 64 + 32;
    }

    public int getExactY(){
        return y * 64 + 32;
    }

}
