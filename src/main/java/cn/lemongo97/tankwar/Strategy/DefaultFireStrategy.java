package cn.lemongo97.tankwar.Strategy;

import cn.lemongo97.tankwar.Bullet;
import cn.lemongo97.tankwar.Tank;

public class DefaultFireStrategy implements IFireStrategy {
    @Override
    public void fire(Tank tank) {
        int bulletX = tank.getX() + Tank.TANK_WIDTH / 2 - Bullet.BULLET_WIDTH / 2;
        int bulletY = tank.getY() + Tank.TANK_HEIGHT / 2 - Bullet.BULLET_HEIGHT / 2;
        new Bullet(bulletX, bulletY, tank.getMoveStatus(), tank.getGroup(), tank.getTankFrame());
    }
}
