import java.awt.*;
import java.util.Stack;

public class CarTransport extends Truck{

    private final Ramp ramp;
    private VehicleContainer container;

    public CarTransport(int max){
        super(2, Color.yellow, 200, "CarTransport");
        ramp = new Ramp();
        container = new VehicleContainer(max);
    }

    private boolean canNotLoad(Vehicle vehicle){
        if (ramp.isRampUp()) return true;
        else if (vehicle instanceof Truck) return true;
        else if (getCurrentSpeed() != 0) return true;
        else return false;
    }

    public void raiseRamp() {
        if (getCurrentSpeed() == 0)
            ramp.setRampUp();
    }

    public void lowerRamp() {
        if (getCurrentSpeed() == 0)
            ramp.setRampDown();
    }

    public void loadVehicle(Vehicle vehicle) {
        if (ramp.isRampUp()) return;
        if (getCurrentSpeed() != 0) return;
        if (container.canNotLoad(vehicle)) return;

        if (Math.abs(vehicle.getX() - this.getX()) > 1 || Math.abs(vehicle.getY() - this.getY()) > 1) return;

        container.loadVehicle(vehicle);

        vehicle.setPosition(this.getX(), this.getY());


    }

    public void unLoadVehicle() {

        if (ramp.isRampUp()) return;

        Vehicle vehicle = container.unloadVehicle();

        vehicle.setPosition(this.getX(), this.getY());

    }

    @Override
    public void move() {
        if (ramp.isRampUp()) {
            super.move();
            for (Vehicle vehicle : container.getLoaded()) {
                vehicle.setPosition(this.getX(), this.getY());
            }
        }
    }
}


