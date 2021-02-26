package cn.lemongo97.tankwar;

import java.awt.*;

public class Explode {
    public static int WIDTH = ResourceManager.explods[0].getWidth();
    public static int HEIGHT = ResourceManager.explods[0].getHeight();
    private int x, y;
    TankFrame tankFrame;

    private int step = 0;

    public Explode(int x, int y, TankFrame tankFrame) {
        this.x = x;
        this.y = y;
        this.tankFrame = tankFrame;
        new Audio("/audio/explode.wav").play();
    }

    public void paint(Graphics g) {
        g.drawImage(ResourceManager.explods[step++], x, y, null);
        if (step >= ResourceManager.explods.length) {
            tankFrame.explodes.remove(this);
        }
    }


}
