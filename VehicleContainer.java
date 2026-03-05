import java.util.Stack;

public class VehicleContainer {

    private Stack<Vehicle> loaded = new Stack<>();
    protected int capacity;

    public VehicleContainer(int capacity) {
        this.capacity = capacity;
    }

    public boolean canNotLoad(Vehicle vehicle) {
        if (vehicle instanceof Truck) return true;
        return loaded.size() >= capacity;
    }

    public void loadVehicle(Vehicle vehicle) {
        loaded.push(vehicle);
    }

    public Vehicle unloadVehicle() {
        return loaded.pop();
    }

    public Stack<Vehicle> getLoaded() {
        return loaded;
    }

    public int getLoadedSize() {
        return loaded.size();
    }

}
