package src;

public interface Movable {
    void move();

    double getCurrentSpeed();

    void turnLeft(double amount);

    void turnRight(double amount);
}
