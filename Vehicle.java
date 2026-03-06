import java.awt.*;

public abstract class Vehicle implements Moveable {
    protected int nrDoors; // Number of doors on the car
    protected final Engine engine; // Engine power of the car
    private final Movement movement; // The current speed of the car
    protected Color color; // Color of the car
    public String modelName; // The car model


    public Vehicle(int nrDoors, Color color, double enginePower, String modelName){
        this.nrDoors = nrDoors;
        this.color = color;

        engine = new Engine(enginePower);
        movement = new Movement();

        stopEngine();
    }

    public int getNrDoors(){
        return nrDoors;
    }

    /*public double getEnginePower(){
        return engine.getEnginePower();
    }*/

    public double getCurrentSpeed(){
        return movement.getCurrentSpeed();
    }

    public Color getColor(){
        return color;
    }

    public double getX() { return movement.getX(); }

    public double getY() { return movement.getY(); }

    public void setColor(Color clr){
	    color = clr;
    }

    public void setPosition(double newX, double newY) {
        movement.setPosition(newX, newY);
    }

    public void setSpeed(double speed) {movement.setCurrentSpeed((speed));}

    public void startEngine(){
	    engine.startEngine();
    }

    public void stopEngine(){
	    engine.stopEngine();
    }

    protected abstract double speedFactor();

    private void incrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() + speedFactor() * amount;
        if(newSpeed > engine.getEnginePower()) newSpeed = engine.getEnginePower();
        movement.setCurrentSpeed(newSpeed);
    }

    private void decrementSpeed(double amount){
        double newSpeed = getCurrentSpeed() - speedFactor() * amount;
        if(newSpeed < 0) newSpeed = 0;
        movement.setCurrentSpeed(newSpeed);
    }
    
    public void gas(double amount){
        if(amount > 0 && amount < 1){
            if (getCurrentSpeed() < engine.getEnginePower() && engine.engineOn ) {
                incrementSpeed(amount);
                move();
            }
        }
    }

    public void brake(double amount){
        if(amount > 0 && amount < 1) {
            if (getCurrentSpeed() < engine.getEnginePower() && !engine.engineOn) {
                decrementSpeed(amount);
                if (getCurrentSpeed() <= 0) {
                    movement.setCurrentSpeed(0);
                }
                move();
            }
        }
    }

    @Override
    public void move() {
        movement.move();
    }

    @Override
    public void turnLeft() {
        movement.turnLeft();
    }

    @Override
    public void turnRight() {
         movement.turnRight();
    }
}

