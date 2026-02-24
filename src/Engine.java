package src;

import java.util.function.DoubleSupplier;
import java.util.function.Function;

public class Engine {
    private final double enginePower;

    private double engineSpeed = 0;

    private final Runnable updateFunc;
    private final DoubleSupplier speedFactorCallback;

    public Engine(double enginePower, Runnable updateFunc, DoubleSupplier speedFactorCallback) {
        this.enginePower = enginePower;
        this.updateFunc = updateFunc;
        this.speedFactorCallback = speedFactorCallback;
    }

    private double getSpeedFactor() {
        return speedFactorCallback.getAsDouble();
    }

    public double getEngineSpeed() {
        return engineSpeed;
    }

    private void setEngineSpeed(double amount) {
        this.engineSpeed = amount;
    }

    public void startEngine() {

        if (engineSpeed == 0) {
            setEngineSpeed(0.1);
        }

        updateFunc.run();
    }

    public void stopEngine() {
        setEngineSpeed(0);

        updateFunc.run();
    }

    void gas(double amount) {
        //TODO: TODO: TODO: DONT OVER_SPEED THIS CAR
        setEngineSpeed(getEngineSpeed() + getSpeedFactor() * amount);

        updateFunc.run();
    }

    void brake(double amount) {
        setEngineSpeed(Math.max(getEngineSpeed() - getSpeedFactor() * amount, 0));
        updateFunc.run();
    }


    public double getEnginePower() {
        return enginePower;
    }
}
