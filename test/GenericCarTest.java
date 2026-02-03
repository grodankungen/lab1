package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

import src.Car;
import src.Saab95;

abstract class GenericCarTest {
    protected Car car;

    protected abstract Car createCar();

    @BeforeEach
    void setUp() {
        car = createCar();
    }

    /**
     * Tests that the startEngine method increases speed as expected
     */
    @Test
    void startEngine() {
        double startingSpeed = car.getCurrentSpeed();

        car.startEngine();
        Assertions.assertNotEquals(startingSpeed, car.getCurrentSpeed());
    }

    /**
     * Tests that stopping the engine sets its current speed to 0
     * (highly unrealistic but according to spec)
     */
    @Test
    void stopEngine() {
        for (int i = 0; i < 100; i++) {
            car.gas(1);
        }

        car.stopEngine();
        Assertions.assertEquals(0, car.getCurrentSpeed());
    }

    /**
     * Tests that the '.gas()' method with a positive number DOES affect the current
     * speed
     */
    @Test
    void gasWithPositiveNumber() {

        double initialSpeed = car.getCurrentSpeed();

        for (int i = 0; i < 100; i++) {
            car.gas(1);
        }

        Assertions.assertNotEquals(initialSpeed, car.getCurrentSpeed());
    }

    /**
     * Tests that '.gas()' using a negative number doesn't affect the current speed
     */
    @Test
    void gasWithNegativeNumber() {

        for (int i = 0; i < 100; i++) {
            car.gas(1);
        }
        double previousSpeed = car.getCurrentSpeed();

        for (int i = 0; i < 100; i++) {
            car.gas(-1);
        }

        Assertions.assertEquals(previousSpeed, car.getCurrentSpeed());
    }

    /**
     * Tests that trying to accelerate past the
     * engines power-limits won't increase its speed
     */
    @Test
    void gasReachesPowerLimit() {

        // gas that shii up
        for (int i = 0; i < 100_000; i++) {
            car.gas(1);
        }

        double exp = car.getEnginePower();
        double real = car.getCurrentSpeed();

        assertEquals(exp, real);

    }

    /**
     * Tests that brake() won't result in negative speed
     */
    @Test
    void brake() {
        for (int i = 0; i < 1000; i++) {
            car.gas(1);
        }

        for (int i = 0; i < 10_000; i++) {
            car.brake(1);
        }

        double expected = 0;
        double actual = car.getCurrentSpeed();

        assertEquals(expected, actual);
    }

    /**
     * Tests that the color is set correctly
     */
    @Test
    void setColor() {
        car.setColor(Color.red);

        Color expected = Color.red;
        Color actual = car.getColor();
        assertEquals(expected, actual);
    }

    double doubleRounderMcPicklePounder(double dub) {
        return Math.round(dub * 1e10) / 1e10;
    }

    double[] move_helper(double angle) {

        car.turnLeft(angle);
        car.move();

        return new double[]{
                doubleRounderMcPicklePounder(car.getX()),
                doubleRounderMcPicklePounder(car.getY())
        };
    }

    @Test
    void move() {

        for (int i = 0; i < 100_000; i++) {
            car.gas(1);
        }
        double maxSpeed = car.getCurrentSpeed();

        double[] expected_xs = {
                doubleRounderMcPicklePounder(maxSpeed),
                doubleRounderMcPicklePounder(maxSpeed + maxSpeed * Math.cos(Math.toRadians(45))), // 45 DEG LEFT
                doubleRounderMcPicklePounder(maxSpeed + 2 * maxSpeed * Math.cos(Math.toRadians(45))), // 90 DEG Right

        };

        double[] expected_ys = {
                0,
                doubleRounderMcPicklePounder(maxSpeed * Math.sin(Math.toRadians(45))),
                0
        };

        double[] actual_xs = new double[3];
        double[] actual_ys = new double[3];

        double[] x_and_y = move_helper(0);
        actual_xs[0] = x_and_y[0];
        actual_ys[0] = x_and_y[1];

        x_and_y = move_helper(45);
        actual_xs[1] = x_and_y[0];
        actual_ys[1] = x_and_y[1];

        x_and_y = move_helper(270);
        actual_xs[2] = x_and_y[0];
        actual_ys[2] = x_and_y[1];

        // x-coordinates
        assertArrayEquals(expected_xs, actual_xs);

        // y-coordinates
        assertArrayEquals(expected_ys, actual_ys);
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
                turnLeftAndGetAngle(1080) // 3 cycles
        };

        assertArrayEquals(expected, actual);
    }

    @Test
    void turnRight() {
        double[] expected = {270, 270, 270};
        double[] actual = {
                turnRightAndGetAngle(90),
                turnRightAndGetAngle(-90),
                turnRightAndGetAngle(1080) // 3 cycles
        };

        assertArrayEquals(expected, actual);
    }

    /**
     * Helper methods for turnLeft / turnRight
     */
    private double turnRightAndGetAngle(double degrees) {
        car.turnRight(degrees);
        return car.getAngle();
    }

    private double turnLeftAndGetAngle(double degrees) {
        car.turnLeft(degrees);
        return car.getAngle();
    }
}