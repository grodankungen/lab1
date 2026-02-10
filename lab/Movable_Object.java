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
        this.velocity = new Vector2(x, y);
    }
    private void move(double x, double y){
        Vector2 delta = new Vector2(x, y);
        this.position = this.position.add(delta);
    }
    public void tick() {
        this.move(this.velocity.x(), this.velocity.y());
    }
    public Vector2 velocity(){
        return this.velocity;
    }
    public Vector2 position(){
        return this.position;
    }
}
