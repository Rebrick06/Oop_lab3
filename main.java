import javax.swing.Timer;


public static void main(String[] args) {


        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(CarFactory.createCar("Volvo"));
        cc.cars.add(CarFactory.createCar("Saab"));
        cc.cars.add(CarFactory.createCar("Scania"));

        cc.cars.get(0).setPosition(0, 0);
        cc.cars.get(1).setPosition(0, 100);
        cc.cars.get(2).setPosition(0, 200);

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
}
