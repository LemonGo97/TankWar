package cn.lemongo97.tankwar;

import java.awt.*;

public class Bullet {
    private static final int SPEED = 30;

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
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillRect(x, y, 5, 5);
        g.setColor(color);

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
