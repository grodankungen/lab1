package test;

import org.junit.jupiter.api.Test;
import src.Scania;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest extends GenericCarTest {

    @Override
    protected Scania createCar() {
        return new Scania();
    }


    @Test
    void testRaiseBound() {
        Scania scan = (Scania) car;
        scan.raise(1000);
        assertEquals(70, scan.getCargoAngle());
    }

    @Test
    void testLowerBound() {
        Scania scan = (Scania) car;
        scan.lower(1000);
        assertEquals(0, scan.getCargoAngle());
    }

    @Test
    void testUnableToGasRaised() {
        Scania scan = (Scania) car;
        scan.raise(10);
        gasMultipleTimes(scan);

        assertEquals(0, scan.getCurrentSpeed());
    }

    @Test
    void testUnableToRaiseWhenMoving() {
        Scania scan = (Scania) car;
        gasMultipleTimes(scan);
        scan.raise(10);

        assertEquals(0, scan.getCargoAngle());
    }

    void gasMultipleTimes(Scania scan) {
        for (int i = 0; i < 1000; i++) {
            scan.gas(1);
        }
    }
}