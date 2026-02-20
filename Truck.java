import java.awt.*;

public abstract class Truck extends Vehicle {

    public Truck(int nrDoors, Color color, double enginePower, String modelName) {
        super(nrDoors, color, enginePower, modelName);
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }

}
