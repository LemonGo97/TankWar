package cn.lemongo97.tankwar;

public class Starter {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tankFrame = new TankFrame();
        for (int i = 0; i < PropertyManagement.getInt("tanksNum"); i++) {
            tankFrame.tanks.add(new Tank(50 + i * 50, 200, MoveStatus.DOWN, Group.BAD, true, tankFrame));
        }
        while (true) {
            Thread.sleep(50);
            tankFrame.repaint();
        }
    }
}
