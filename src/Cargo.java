package src;

public interface Cargo {
    void raise(double amount);

    void lower(double amount);

    double getCargoAngle();

    boolean isCargoInResetPosition();
}
