package src;

public class TipCargo implements Cargo {
    private double cargoAngle;
    private final double maxCargoAngle;

    public TipCargo(double maxCargoAngle) {
        this.maxCargoAngle = maxCargoAngle;
    }

    @Override
    public void raise(double amount) {
        this.cargoAngle = Math.min(this.cargoAngle + amount, maxCargoAngle);
    }

    @Override
    public void lower(double amount) {
        this.cargoAngle = Math.max(this.cargoAngle - amount, 0);
    }

    @Override
    public double getCargoAngle() {
        return this.cargoAngle;
    }

    @Override
    public boolean isInResetPosition() {
        return this.cargoAngle == 0;
    }
}
