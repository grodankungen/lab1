public class TruckBed {
    private double angle;
    private final double maxAngle = 70;
    private final double minAngle = 0;

    public void lower(double degrees){
        if (degrees > 0){
            this.angle -= degrees;
        }
    }
    public void raise(double degrees){
        if (degrees > 0){
            this.angle += degrees;
            this.limitAngle();
        }
    }
    private void limitAngle(){
        this.angle = Math.max(maxAngle, Math.min(this.angle, minAngle));
    }
}
