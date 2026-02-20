import java.awt.*;

public class Scania extends Truck {

    private double platformAngle;

    public Scania(){
        super(2, Color.blue, 150, "ScaniaTruck");
        this.platformAngle = 0;

    }

    public double getPlatformAngle() {
        return platformAngle;
    }

    @Override
    public void move() {
        if (platformAngle == 0) {
            super.move();
        }
    }


    public void raisePlatform() {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.min(platformAngle + 1, 70);
        }
    }

    public void lowerPlatform() {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.max(platformAngle - 1, 0);
        }
    }

    /*public void raisePlatform(double angle) {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.min(platformAngle + angle, 70);
        }
    }

    public void lowerPlatform(double angle) {
        if (getCurrentSpeed() == 0) {
            platformAngle = Math.max(platformAngle - angle, 0);
        }
    }*/


}
