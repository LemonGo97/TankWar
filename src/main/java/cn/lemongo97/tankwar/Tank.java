package cn.lemongo97.tankwar;

import java.awt.*;
import java.util.Random;

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
    private Group group;
    private Random random = new Random();


    public Tank(int x, int y, MoveStatus moveStatus, Group group, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.moveStatus = moveStatus;
        this.group = group;
        this.tankFrame = tankFrame;
    }

    public Tank(int x, int y, MoveStatus moveStatus, Group group, boolean moving, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.moveStatus = moveStatus;
        this.moving = moving;
        this.group = group;
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
        if (this.group == Group.BAD && random.nextInt(10) > 8) this.fire();
        if (this.group == Group.BAD) randomMove();
    }

    private void randomMove() {
        if (random.nextInt(100) > 95) this.moveStatus = MoveStatus.values()[random.nextInt(4)];
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void fire() {
        int bulletX = this.x + Tank.TANK_WIDTH / 2 - Bullet.BULLET_WIDTH / 2;
        int bulletY = this.y + Tank.TANK_HEIGHT / 2 - Bullet.BULLET_HEIGHT / 2;
        tankFrame.bullets.add(new Bullet(bulletX, bulletY, this.moveStatus, group, this.tankFrame));
    }

    public void die() {
        this.live = false;
        int bulletX = this.x + Tank.TANK_WIDTH / 2 - Explode.WIDTH / 2;
        int bulletY = this.y + Tank.TANK_HEIGHT / 2 - Explode.HEIGHT / 2;
        tankFrame.explodes.add(new Explode(bulletX, bulletY, this.tankFrame));

    }
}
