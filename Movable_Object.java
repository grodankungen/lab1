public abstract class Movable_Object{
    private Vector2 position;
    private Vector2 velocity;
    private double weight;
    public Movable_Object(Vector2 position, Vector2 velocity) {
        this.position = position;
        this.velocity = velocity;
    }
    public Movable_Object() {
        this.position = new Vector2(0, 0);
        this.velocity = new Vector2(0, 0);
    }
    public void set_velocity(double x, double y) {
        this.velocity.set(x, y);
    }

    public void accelerate(double x, double y) {
        this.velocity.add(x, y);
    }
    public void move(double x, double y){
        this.position.add(x, y);
    }
    public void set_position(double x, double y){
        this.position.set(x, y);
    }
    public void tick() {
        this.position.add(this.velocity.x(), this.velocity.y());
    }
    public Vector2 velocity(){
        return this.velocity;
    }
    public Vector2 position(){
        return this.position;
    }
}
