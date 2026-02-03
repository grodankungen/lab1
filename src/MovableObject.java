package src;

abstract class MovableObject implements Movable {
    private double x;
    private double y;
    private double angle;

    public MovableObject(double x, double y, double angle) {
        this.x = x;
        this.y = y;
        this.angle = angle;
    }

    public void move() {
        double rad = Math.toRadians(angle);  // needed for Math functions
        double speed = getCurrentSpeed();

        x += speed * Math.cos(rad);
        y += speed * Math.sin(rad);
    }

    public void turnLeft(double amount) {
        if (amount < 0) {
            return;
        }

        angle = (angle + amount) % 360;
        angle = angle % 360;
    }

    public void turnRight(double amount) {
        if (amount < 0) {
            return;
        }

        angle = (angle - amount) % 360;
        if (angle < 0) {
            angle += 360;
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getAngle() {
        return angle;
    }

    protected abstract double getCurrentSpeed();
}
