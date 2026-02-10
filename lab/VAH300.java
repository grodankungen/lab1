package lab;


import java.awt.*;

public class CarTransportTruck extends Car{
    public CarTransport carTransport;

    public CarTransportTruck(String regNr){
        super(2, new Color(1,1,1), 50, "Man 422", 0, new Vector2(1, 0), regNr);
        carTransport = new CarTransport(0, 70, 4);
    }

    @Override
    public double speedFactor() {
        if (carTransport.getAngle() == carTransport.getMinAngle()){
            return getEnginePower()* 0.01;
        }
        return 0;
    }

    @Override
    public void tick(){
        super.tick();
        carTransport.sync(this);
    }
}
