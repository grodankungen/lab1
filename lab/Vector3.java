import java.util.ArrayList;

public class Vector3 {
    private double x;
    private double y;
    private double z;
    Vector3(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
    Vector3(){
        this.x = 0;
        this.y = 0;
        this.z = 0;
    }
    public void add(Vector3 other) {
        this.x += other.x();
        this.y += other.y();
        this.z += other.z();
    }
    public void set(Vector3 vector) {
        this.x = vector.x();
        this.y = vector.y();
        this.z = vector.z();
    }
    public void set(Double[] vector) {
        if (vector.length == 3) {
            this.x = vector[0];
            this.y = vector[1];
            this.z = vector[2];
        }
    }
    public double x(){
        return this.x;
    }
    public double y(){
        return this.y;
    }
    public double z(){
        return this.z;
    }
    public void scale(double scalar) {
        this.x *= scalar;
        this.y *= scalar;
        this.z *= scalar;
    }
}
