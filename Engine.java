public class Engine {
    protected double enginePower;
    protected boolean engineOn;

    public Engine(double enginePower) {
        this.enginePower = enginePower;
        this.engineOn = false;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public void startEngine(){
        engineOn = true;
    }

    public void stopEngine(){
        engineOn = false;
    }

}
