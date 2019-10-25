package gameField.gameEntity;

public class Tower implements gameEntity{
    private double posX, posY;
    private double shootingRadius;

    public double getHeight() {
        return 0;
    }
    public double getWidth() {
        return 0;
    }


    public void setPosX(double posX) {
        this.posX = posX;
    }
    public void setPosY(double posY) {
        this.posY = posY;
    }
    public void setShootingRadius(double shootingRadius) {
        this.shootingRadius = shootingRadius;
    }

    public double getShootingRadius() {
        return shootingRadius;
    }
    public double getPosX() {
        return posX;
    }
    public double getPosY() {
        return posY;
    }


}
