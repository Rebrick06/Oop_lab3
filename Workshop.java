import java.util.ArrayList;
import java.util.List;

public class Workshop<T extends IVehicleWorkshop> {

    private int max;
    private List<T> vehicles;
    private double x;
    private double y;


    public Workshop(int max, double x, double y) {
        this.max = max;
        this.x = x;
        this.y = y;
        vehicles = new ArrayList<>();
    }

    double getX() {return x;}
    double getY() {return y;}

    public void load(T vehicle){
        if (vehicles.size() < max) {
            vehicles.add(vehicle);
            vehicle.stopEngine();
        }
    }

    public T unload(T vehicle) {
        if (vehicles.isEmpty()) return null;
        vehicle.gas(0);
        if (vehicles.contains(vehicle)) {
            return vehicles.remove(vehicles.indexOf(vehicle));
        } else {
           return null;
        }
    }
}

