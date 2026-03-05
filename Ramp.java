public class Ramp {

    private boolean rampUp = true;

    public void setRampUp() {
        rampUp = true;
    }

    public void setRampDown() {
        rampUp = false;
    }

    public boolean isRampUp() {
        return rampUp;
    }
}
