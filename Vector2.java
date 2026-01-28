import java.util.ArrayList;

public class Vector2 {
    private double x;
    private double y;
    Vector2(double x, double y) {
        this.x = x;
        this.y = y;
    }
    Vector2(){
        this.x = 0;
        this.y = 0;
    }
    public double x(){
        return this.x;
    }
    public double y(){
        return this.y;
    }

    public Vector2 scaled(double scalar) {
        return new Vector2(this.x * scalar, this.y * scalar);
    }
    public double length(){
        return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
    }
    public Vector2 add(Vector2 other) {
        return new Vector2(this.x + other.x(), this.y + other.y());
    }
    public Vector2 normalized(){
        return new Vector2(this.x/this.length(), this.y/this.length());
    }
    public Vector2 turned(double angle){
        angle = angle % 360;
        angle = Math.toRadians(angle);
        double temp_x = this.x * Math.cos(angle) - this.y * Math.sin(angle);
        double temp_y = this.x * Math.sin(angle) + this.y * Math.cos(angle);
        if (Math.abs(temp_x) < Math.pow(10, -15)){temp_x = 0;}
        if (Math.abs(temp_y) < Math.pow(10, -15)){temp_y = 0;}
        return new Vector2(temp_x, temp_y);
    }
}
