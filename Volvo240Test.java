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

    /**
     * Tests that the startEngine method increases speed as expected
     */
    @Test
    void startEngine() {
        double startingSpeed = volvo.getCurrentSpeed();

        volvo.startEngine();
        assertNotEquals(startingSpeed, volvo.getCurrentSpeed());
    }

    /**
     * Tests that stopping the engine sets its current speed to 0
     * (highly unrealistic but according to spec)
     */
    @Test
    void stopEngine() {
        for (int i = 0; i < 100; i++) {
            volvo.gas(1);
        }

        volvo.stopEngine();
        assertEquals(0, volvo.getCurrentSpeed());
    }

    /**
     * Tests that the '.gas()' method with a positive number DOES affect the current speed
     */
    @Test
    void gasWithPositiveNumber() {

        double initialSpeed = volvo.getCurrentSpeed();

        for (int i = 0; i < 100; i++) {
            volvo.gas(1);
        }

        assertNotEquals(initialSpeed, volvo.getCurrentSpeed());
    }

    /**
     * Tests that '.gas()' using a negative number doesn't affect the current speed
     */
    @Test
    void gasWithNegativeNumber() {

        for (int i = 0; i < 100; i++) {
            volvo.gas(1);
        }
        double previousSpeed = volvo.getCurrentSpeed();

        for (int i = 0; i < 100; i++) {
            volvo.gas(-1);
        }

        assertEquals(previousSpeed, volvo.getCurrentSpeed());
    }

    /**
     * Tests that trying to accelerate past the
     * engines power-limits won't increase its speed
     */
    @Test
    void gasReachesPowerLimit() {

        //gas that shii up
        for (int i = 0; i < 100_000; i++) {
            volvo.gas(1);
        }

        double exp = volvo.getEnginePower();
        double real = volvo.getCurrentSpeed();

        assertEquals(exp, real);

    }

    /**
     * Test that brake() won't result in negative speed
     */
    @Test
    void brake() {
        for (int i = 0; i < 1000; i++) {
            volvo.gas(1);
        }

        for (int i = 0; i < 10_000; i++) {
            volvo.brake(1);
        }

        double expected = 0;
        double actual = volvo.getCurrentSpeed();

        assertEquals(expected, actual);
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

    /**
     * Tests if the methods handles:
     * - Positive angles
     * - Negative angles
     * - Multiple rotations (> 360), should be normalized to 0-360 after turn
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

    /**
     * Helper methods for turnLeft / turnRight
     */
    private double turnRightAndGetAngle(double degrees) {
        volvo.turnRight(degrees);
        return volvo.getAngle();
    }

    private double turnLeftAndGetAngle(double degrees) {
        volvo.turnLeft(degrees);
        return volvo.getAngle();
    }
}