import java.awt.*;

public abstract class Car extends Vehicle {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car


    public Car(int nrDoors, Color color, double enginePower, String modelName, double currentSpeed, Vector2 direction) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        super(currentSpeed, color, modelName, direction);
        stopEngine();
    }

    protected abstract double speedFactor();

    protected void incrementSpeed(double amount){
        if (amount >= 0 && amount <=1) {
            super.incrementSpeed(amount * speedFactor(), this.enginePower);
        }
    }


    protected void decrementSpeed(double amount) {
        if (amount >= 0 && amount <=1) {
            super.decrementSpeed(amount * speedFactor());
        }
    }

    public int getNrDoors(){
        return this.nrDoors;
    }

    public double getEnginePower(){
        return this.enginePower;
    }

    public void startEngine() {
        set_speed(0.1);
    }

    public void stopEngine(){
        set_speed(0);
    }

}
