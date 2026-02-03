
package test;

import src.Car;
import src.Volvo240;

class Volvo240Test extends GenericCarTest {
    @Override
    protected Car createCar() {
        return new Volvo240();
    }
}