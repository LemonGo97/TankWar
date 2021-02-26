package cn.lemongo97.tankwar;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceManager {
    public static BufferedImage tankL, tankU, tankR, tankD;
    public static BufferedImage bulletL, bulletU, bulletR, bulletD;
    public static BufferedImage[] explods = new BufferedImage[16];

    static {
        try {
            tankL = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankL.gif"));
            tankU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankU.gif"));
            tankR = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankR.gif"));
            tankD = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/tankD.gif"));
            bulletL = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletL.gif"));
            bulletU = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletU.gif"));
            bulletR = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletR.gif"));
            bulletD = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/bulletD.gif"));
            for (int i = 0; i < 16; i++) {
                explods[i] = ImageIO.read(ResourceManager.class.getResourceAsStream("/images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
