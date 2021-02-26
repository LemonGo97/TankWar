package cn.lemongo97.tankwar;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 30;
    public static final int BULLET_WIDTH = ResourceManager.bulletU.getWidth();
    public static final int BULLET_HEIGHT = ResourceManager.bulletU.getHeight();
    private int x;
    private int y;
    private boolean live = true;
    private MoveStatus moveStatus;
    private TankFrame tankFrame;

    public Bullet(int x, int y, MoveStatus moveStatus,TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.moveStatus = moveStatus;
        this.tankFrame = tankFrame;
    }

    public void paint(Graphics g) {
        if (!live){
            tankFrame.bullets.remove(this);
        }
        switch (moveStatus) {
            case UP:
                g.drawImage(ResourceManager.bulletU, x, y, null);
                break;
            case DOWN:
                g.drawImage(ResourceManager.bulletD, x, y, null);
                break;
            case LEFT:
                g.drawImage(ResourceManager.bulletL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(ResourceManager.bulletR, x, y, null);
                break;
        }
        move();
    }

    private void move() {
        switch (moveStatus) {
            case RIGHT:
                x += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            default:
                break;
        }
        if (x < 0 || y < 0 || x > TankFrame.GAME_HEIGHT || y > TankFrame.GAME_WIDTH) live = false;
    }

}
