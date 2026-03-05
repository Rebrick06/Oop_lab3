public class Movement {
    private double currentSpeed;
    private double x;
    private double y;
    private Direction direction;

    public Movement() {
        currentSpeed = 0;
        x = 0;
        y = 0;
        direction = Direction.NORTH;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public void setCurrentSpeed(double speed) {
        currentSpeed = speed;
    }

    public double getX() {return x;}

    public double getY() {return y;}

    public void setPosition(double newX, double newY) {
        x = newX;
        y = newY;
    }

    public void move() {
        switch(direction) {
            case NORTH -> y += currentSpeed;
            case SOUTH -> y -= currentSpeed;
            case EAST -> x += currentSpeed;
            case WEST -> x -= currentSpeed;
        }
    }

    public void turnLeft() {
        switch(direction) {
            case NORTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.NORTH;
        }
    }

    public void turnRight() {
        switch(direction) {
            case NORTH -> direction = Direction.EAST;
            case EAST -> direction = Direction.SOUTH;
            case SOUTH -> direction = Direction.WEST;
            case WEST -> direction = Direction.NORTH;
        }
    }

}
