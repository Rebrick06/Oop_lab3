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

        if (Math.abs(vehicle.x - this.x) > 1 || Math.abs(vehicle.y - this.y) > 1) return;

        container.loadVehicle(vehicle);

        vehicle.x = this.x;
        vehicle.y = this.y;

    }

    public void unLoadVehicle() {

        if (ramp.isRampUp()) return;

        Vehicle vehicle = container.unloadVehicle();

        vehicle.x = this.x + 1;
        vehicle.y = this.y + 1;

    }

    @Override
    public void move() {
        if (ramp.isRampUp()) {
            super.move();
            for (Vehicle vehicle : container.getLoaded()) {
                vehicle.x = this.x;
                vehicle.y = this.y;
            }
        }
    }
}


