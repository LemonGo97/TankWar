package cn.lemongo97.tankwar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManager {
    public static BufferedImage goodTankL, goodTankU, goodTankR, goodTankD;
    public static BufferedImage badTankL, badTankU, badTankR, badTankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explods = new BufferedImage[16];
    public static Audio audio;

    static {
        try {
            goodTankL = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankL.gif"));
            goodTankU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankU.gif"));
            goodTankR = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankR.gif"));
            goodTankD = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankD.gif"));
            badTankL = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankL.gif"));
            badTankU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankU.gif"));
            badTankR = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankR.gif"));
            badTankD = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankD.gif"));
            bulletL = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletL.gif"));
            bulletU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletU.gif"));
            bulletR = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletR.gif"));
            bulletD = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletD.gif"));
            audio = new Audio("audio/explode.wav");
            for (int i = 0; i < 16; i++) {
                explods[i] = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
