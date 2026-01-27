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

    @Test
    void turnLeft() {
        double angle = volvo.getAngle();
        volvo.turnLeft(90);

        double expected = angle + 90;
        double actual = volvo.getAngle();
        assertEquals(expected, actual);
    }

    @Test
    void turnRight() {
        double angle = volvo.getAngle();
        volvo.turnRight(90);

        double expected = angle - 90;
        if (expected < 0) {
            expected += 360;
        }
        double actual = volvo.getAngle();
        assertEquals(expected, actual);
    }
}