package test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.Scania;
import test.GenericCarTest;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest extends GenericCarTest {

    @Override
    protected Scania createCar() {
        return new Scania();
    }


    @Test
    void test_raise_bounds() {
        Scania scan = (Scania) car;
        scan.raise(1000);
        assertEquals(70, scan.getCargoAngle());
    }

    @Test
    void test_lower_bounds() {
        Scania scan = (Scania) car;
        scan.lower(1000);
        assertEquals(0, scan.getCargoAngle());
    }

    @Test
    void unable_to_gas_raised() {
        Scania scan = (Scania) car;
        scan.raise(10);
        for (int i = 0; i < 100_000; i++) {
            scan.gas(1);
        }
        assertEquals(0, scan.getCurrentSpeed());
    }
}