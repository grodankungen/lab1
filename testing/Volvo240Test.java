import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {

    Volvo240 volvo;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        this.volvo = new Volvo240();
    }

    @org.junit.jupiter.api.Test
    void getNrDoors() {
        assertEquals(4, volvo.getNrDoors());
    }

    @org.junit.jupiter.api.Test
    void getEnginePower() {
        assertEquals(100, volvo.getEnginePower());
    }

    @org.junit.jupiter.api.Test
    void startEngine() {
        volvo.startEngine();
        assertEquals(true, volvo.get_engine_running());
    }

    @org.junit.jupiter.api.Test
    void stopEngine() {
        volvo.stopEngine();
        assertEquals(false, volvo.get_engine_running());
    }

    @org.junit.jupiter.api.Test
    void getCurrentSpeed() {
        volvo.startEngine();
        volvo.gas(1);
        assertEquals(1.25, volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void getColor() {
        volvo.setColor(new Color(87, 88, 0));
        assertEquals(new Color(87, 88, 0), volvo.getColor());
    }

    @org.junit.jupiter.api.Test
    void setColor() {
        volvo.setColor(new Color(87, 88, 0));
        assertEquals(new Color(87, 88, 0), volvo.getColor());
    }

    @org.junit.jupiter.api.Test
    void turnLeft() {
        volvo.turnLeft(90);
        assertEquals(0.0, volvo.get_direction().x());
        volvo.turnLeft(45);
        assertEquals(0.71, Math.round(volvo.get_direction().y()*100)/100.0);
        assertEquals(-0.71, Math.round(volvo.get_direction().x()*100)/100.0);
    }

    @org.junit.jupiter.api.Test
    void turnRight() {
        volvo.turnRight(90);
        assertEquals(0.0, volvo.get_direction().x());
        volvo.turnRight(45);
        assertEquals(-0.71, Math.round(volvo.get_direction().y()*100)/100.0);
        assertEquals(-0.71, Math.round(volvo.get_direction().x()*100)/100.0);
    }

    @org.junit.jupiter.api.Test
    void set_velocity() {

    }

    @org.junit.jupiter.api.Test
    void tick() {
        volvo.gas(1);
        volvo.gas(1);
        volvo.tick();
        assertEquals(2.5, volvo.position().x());

    }

    @org.junit.jupiter.api.Test
    void velocity() {
    }

    @org.junit.jupiter.api.Test
    void position() {
    }

    @org.junit.jupiter.api.Test
    void setTurboOn() {

    }

    @org.junit.jupiter.api.Test
    void setTurboOff() {
    }

    @org.junit.jupiter.api.Test
    void gas() {
        for (int i = 0; i < 102; i++){
            volvo.gas(1);
        }
        assertEquals(volvo.getEnginePower(), volvo.getCurrentSpeed());
    }

    @org.junit.jupiter.api.Test
    void brake() {
        for (int i = 0; i < 102; i++){
            volvo.gas(1);
        }
        volvo.brake(1);
        assertEquals(volvo.getEnginePower() - 1* volvo.speedFactor(), volvo.getCurrentSpeed());
    }
}