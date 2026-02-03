package test;

import src.Car;
import src.Saab95;
import test.GenericCarTest;

class Saab95Test extends GenericCarTest {

    @Override
    protected Car createCar() {
        return new Saab95();
    }
}
