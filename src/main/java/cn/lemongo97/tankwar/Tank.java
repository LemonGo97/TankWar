package cn.lemongo97.tankwar;

import java.awt.*;

public class Tank {
    private Integer x;
    private Integer y;
    private static final int SPEED = 10;
    private MoveStatus moveStatus;
    private boolean moving = false;
    private TankFrame tankFrame;
    public static final int TANK_WIDTH = ResourceManager.tankU.getWidth();
    public static final int TANK_HEIGHT = ResourceManager.tankU.getHeight();
    private boolean live = true;


    public Tank(int x, int y, MoveStatus moveStatus, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
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
        if (!live) tankFrame.tanks.remove(this);
        switch (moveStatus) {
            case UP:
                g.drawImage(ResourceManager.tankU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.tankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.tankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.tankR, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        if (!moving) return;
        switch (moveStatus) {
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }

    public void fire() {
        int bulletX = this.x + Tank.TANK_WIDTH / 2 - Bullet.BULLET_WIDTH / 2;
        int bulletY = this.y + Tank.TANK_HEIGHT / 2 - Bullet.BULLET_HEIGHT / 2;
        tankFrame.bullets.add(new Bullet(bulletX, bulletY, this.moveStatus, this.tankFrame));
    }

    public void die() {
        this.live = false;
    }
}
