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
        for (int i = 0; i < 100; i++) {
            volvo.gas(1);
        }

        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed());
    }

    @Test
    void gasReachesPowerLimit() {

        //gas that shii up
        for (int i = 0; i < 1000000; i++) {
            volvo.gas(1);
        }

        double exp = volvo.getEnginePower();
        double real =  volvo.getCurrentSpeed();

        assertEquals(exp, real);

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