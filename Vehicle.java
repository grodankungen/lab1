import java.awt.*;

public abstract class Vehicle extends Movable_Object{
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private String modelName; // The car model name
    private Vector2 direction;

    public Vehicle(Color color, String modelName, Vector2 direction){
        super();
        this.currentSpeed = 0;
        this.color = color;
        this.modelName = modelName;
        this.direction = direction.normalized();
        this.update_speed();
    }

    private void update_speed(){
        Vector2 new_velocity = this.direction.scaled(currentSpeed);
        this.set_velocity(new_velocity.x(), new_velocity.y());
    }

    private void set_direction(Vector2 direction){
        this.direction = direction;
        this.update_speed();
    }

    protected Vector2 get_direction(){
        return this.direction;
    }

    protected void incrementSpeed(double amount, double max_speed){
        set_speed(Math.min(getCurrentSpeed() + amount, max_speed));
    }

    protected void decrementSpeed(double amount){
        set_speed(Math.max(this.currentSpeed - amount, 0));
    }

    protected void set_speed(double speed) {
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
            this.direction = this.direction.turned(angle).normalized();
            this.update_speed();
        }
    }
    public void turnRight(double angle){
        if (angle > 0){
            this.direction = this.direction.turned(-angle).normalized();
            this.update_speed();
        }
    }

}
