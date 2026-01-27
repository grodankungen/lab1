import java.awt.*;

public abstract class Vehicle extends Movable_Object{
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vector2 direction;

    public Vehicle(double currentSpeed, Color color, String modelName, Vector2 direction){
        super();
        this.currentSpeed = currentSpeed;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction;
        this.update_speed();
    }

    private void update_speed(){
        direction.normalize();
        this.set_velocity(direction.x(), direction.y());
        this.velocity().scale(currentSpeed);
    }

    @Override
    public void tick() {
        this.update_speed();
        super.tick();
    }

    private void set_direction(Vector2 direction){
        this.direction = direction;
    }

    protected void incrementSpeed(double amount, double max_speed){
        set_speed(Math.min(getCurrentSpeed() + amount, max_speed));
    }

    protected void decrementSpeed(double amount){
        set_speed(Math.max(this.currentSpeed - amount, 0));
    }

    private void set_speed(double speed) {
        currentSpeed = speed;
        update_speed();
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

    public void turnLeft(double angle){
        if (angle > 0){
            this.direction.turn(angle);
            this.update_speed();
        }
    }
    public void turnRight(double angle){
        if (angle > 0){
            this.direction.turn(-angle);
            this.update_speed();
        }
    }

}
