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
    public void add(double x, double y) {
        this.x += x;
        this.y += y;
    }
    public void set(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void set(Double[] vector) {
        if (vector.length == 3) {
            this.x = vector[0];
            this.y = vector[1];
        }
    }
    public double x(){
        return this.x;
    }
    public double y(){
        return this.y;
    }

    public void scale(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
    }
    public void normalize(){
        double length = Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
        this.x /= length;
        this.y /= length;
    }
    public void turn(double angle){
        angle = angle % 360;
        angle = Math.toRadians(angle);
        this.x = this.x * Math.cos(angle) - this.y * Math.sin(angle);
        this.y = this.x * Math.sin(angle) + this.y * Math.cos(angle);
    }
}
