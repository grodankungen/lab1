import java.awt.*;

public abstract class Vehicle extends Movable_Object{
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vector3 direction;

    public Vehicle(double currentSpeed, Color color, String modelName, Vector3 direction){
        super(new Vector3(0,0,0), new Vector3(0, 0,0));
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = new Vector3(0, 0, 0);
        this.update_speed();
    }

    private void update_speed(){
        this.set_velocity(direction);
        this.velocity().scale(currentSpeed);
    }

    @Override
    public void tick() {
        this.update_speed();
        super.tick();
    }

    public void set_direction(Vector3 direction){
        this.direction = direction;
    }

    protected void incrementSpeed(double amount, double max_speed){
        set_speed(Math.min(getCurrentSpeed() + amount, max_speed));
    }

    protected void decrementSpeed(double amount){
        set_speed(Math.max(this.currentSpeed + amount, 0));
    }

    public void set_speed(double speed) {
        currentSpeed = speed;
    }

    public double getCurrentSpeed(){
        return currentSpeed;
    }

    public Color getColor(){
        return color;
    }

    public void setColor(Color clr){
        color = clr;
    }

    @Override
    public void turnLeft(){

    }

    @Override
    public void turnRight(){

    }

}
