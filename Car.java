import java.awt.*;

public abstract class Car extends Vehicle {
    private int nrDoors; // Number of doors on the car
    private double enginePower; // Engine power of the car


    public Car(int nrDoors, Color color, double enginePower, String modelName, double currentSpeed) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        super(currentSpeed, color, modelName, new Vector3(0,0,0));
        stopEngine();
    }



    protected void incrementSpeed(double amount){
        super.incrementSpeed(amount, this.enginePower);
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
