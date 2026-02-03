package test;

import org.junit.jupiter.api.Test;
import src.Car;
import src.Saab95;

import static org.junit.jupiter.api.Assertions.*;

class Saab95Test extends GenericCarTest {

    @Override
    protected Car createCar() {
        return new Saab95();
    }

    @Test
    public void setTurboOn() {
        Saab95 saab = ((Saab95) this.car);

        for (int i = 0; i < 10; i++) {
            car.gas(1);
        }
        double speedTurboOff = saab.getCurrentSpeed();

        for (int i = 0; i < 100; i++) {
            car.brake(1);
        }

        saab.setTurboOn();
        for (int i = 0; i < 10; i++) {
            car.gas(1);
        }
        double speedTurboOn = saab.getCurrentSpeed();

        assertNotEquals(speedTurboOff, speedTurboOn);
    }

    @Test
    public void setTurboOff() {
        Saab95 saab = ((Saab95) this.car);

        saab.setTurboOn();
        for (int i = 0; i < 10; i++) {
            car.gas(1);
        }
        double speedTurboOn = saab.getCurrentSpeed();

        for (int i = 0; i < 100; i++) {
            car.brake(1);
        }

        saab.setTurboOff();
        for (int i = 0; i < 10; i++) {
            car.gas(1);
        }
        double speedTurboOff = saab.getCurrentSpeed();

        assertNotEquals(speedTurboOff, speedTurboOn);
    }
}
