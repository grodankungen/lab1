public class Movable_Object{
    private Vector3 position;
    private Vector3 velocity;
    private double weight;
    public Movable_Object(Vector3 position, Vector3 velocity) {
        this.position = position;
        this.velocity = velocity;
    }
    public Movable_Object() {
        this.position = new Vector3(0, 0, 0);
        this.velocity = new Vector3(0, 0, 0);
    }
    public void set_velocity(Vector3 velocity) {
        this.velocity.set(velocity);
    }

    public void accelerate(Vector3 acceleration) {
        this.velocity.add(velocity);
    }
    public void move(Vector3 delta){
        this.position.add(delta);
    }
    public void set_position(Vector3 position){
        this.position.set(position);
    }
    public void tick() {
        this.position.add(this.velocity);
    }
    public Vector3 velocity(){
        return this.velocity;
    }
    public Vector3 position(){
        return this.position;
    }
}
