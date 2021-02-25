package cn.lemongo97.tankwar;

import java.awt.*;

public class Tank {
    private Integer x;
    private Integer y;
    private Integer speed;
    private MoveStatus moveStatus;
    private boolean moving = false;
    private TankFrame tankFrame;

    public Tank(int x, int y, int speed, MoveStatus moveStatus, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.moveStatus = moveStatus;
        this.tankFrame = tankFrame;
    }

    public Integer getX() {
        return x;
    }

    public void setX(Integer x) {
        this.x = x;
    }

    public Integer getY() {
        return y;
    }

    public void setY(Integer y) {
        this.y = y;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public MoveStatus getMoveStatus() {
        return moveStatus;
    }

    public void setMoveStatus(MoveStatus moveStatus) {
        this.moveStatus = moveStatus;
    }

    public boolean getMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.YELLOW);
        g.fillRect(x, y, 50, 50);
        g.setColor(color);
        move();
    }

    private void move() {
        if (!moving) return;
        switch (moveStatus) {
            case UP:
                y -= speed;
                break;
            case DOWN:
                y += speed;
                break;
            case LEFT:
                x -= speed;
                break;
            case RIGHT:
                x += speed;
                break;
            default:
                break;
        }
    }

    public void fire() {
        tankFrame.bullets.add(new Bullet(this.x, this.y, this.moveStatus, this.tankFrame));
    }
}
