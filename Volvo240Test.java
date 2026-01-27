import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    Volvo240 volvo;
    @BeforeEach
    void setUp() {
        this.volvo = new Volvo240();
    }

    @Test
    void startEngine() {
        double startingSpeed = volvo.getCurrentSpeed();

        volvo.startEngine();

        assertNotEquals(startingSpeed, volvo.getCurrentSpeed());
    }

    @Test
    void stopEngine() {
    }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }

    @Test
    void setColor() {
    }

    @Test
    void move() {
    }

    @Test
    void turnLeft() {
    }

    @Test
    void turnRight() {
    }
}