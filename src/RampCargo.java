package src;

public class RampCargo implements Cargo {
    private boolean isLowered = false;

    @Override
    public void raise(double amount) {
        isLowered = false;
    }

    @Override
    public void lower(double amount) {
        isLowered = true;
    }

    @Override
    public double getCargoAngle() {
        if (isLowered) {
            return 45;
        } else {
            return 0;
        }
    }

    @Override
    public boolean isCargoInResetPosition() {
        return !isLowered;
    }
}
