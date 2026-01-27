import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

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
        double real = volvo.getCurrentSpeed();

        assertEquals(exp, real);

    }

    @Test
    void brake() {
    }

    @Test
    void setColor() {
        volvo.setColor(Color.red);

        Color expected = Color.red;
        Color actual = volvo.getColor();
        assertEquals(expected, actual);
    }

    @Test
    void move() {

    }

    /*
    Tests if the methods handles:
        - Positive angles
        - Negative angles
        - Multiple rotations (> 360), should be normalized to 0-360 after turn
     */
    @Test
    void turnLeft() {
        double[] expected = {90, 90, 90};
        double[] actual = {
                turnLeftAndGetAngle(90),
                turnLeftAndGetAngle(-90),
                turnLeftAndGetAngle(1080)  // 3 cycles
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void turnRight() {
        double[] expected = {270, 270, 270};
        double[] actual = {
                turnRightAndGetAngle(90),
                turnRightAndGetAngle(-90),
                turnRightAndGetAngle(1080)  // 3 cycles
        };

        assertArrayEquals(expected, actual);
    }

    // Helper methods for turnLeft / turnRight
    private double turnRightAndGetAngle(double degrees) {
        volvo.turnRight(degrees);
        return volvo.getAngle();
    }

    private double turnLeftAndGetAngle(double degrees) {
        volvo.turnLeft(degrees);
        return volvo.getAngle();
    }
}