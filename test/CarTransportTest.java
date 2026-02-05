package test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import src.CarTransport;

import src.Car;
import src.Volvo240;
import src.Saab95;

import java.util.Collection;
import java.util.List;

class CarTransportTest extends GenericCarTest {

    @Override
    protected CarTransport createCar() {
        return new CarTransport(5);
    }

    void helper_load_some_cars(Collection<Car> theCars) {
        ((CarTransport) car).lower(45);
        for (Car c : theCars) {
            ((CarTransport) car).loadCar(c);
        }
        ((CarTransport) car).raise(45);
    }

    @Test
    void loadCar() {

        int prevSize = ((CarTransport) car).getLoadedCars().size();
        helper_load_some_cars(List.of(new Volvo240(), new Saab95()));
        int currSize = ((CarTransport) car).getLoadedCars().size();

        assertNotEquals(prevSize, currSize);

    }

    @Test
    void offloadCar() {
        helper_load_some_cars(List.of(new Volvo240(), new Saab95()));
        ((CarTransport) car).offloadCar();
        int currSize = ((CarTransport) car).getLoadedCars().size();
        int exp1 = 1;

        assertEquals(exp1, currSize);

        ((CarTransport) car).offloadCar();
        currSize = ((CarTransport) car).getLoadedCars().size();
        int exp2 = 1;

        assertNotEquals(exp2, currSize);

    }

    @Test
    void testMove() {
        //TODO: move the truck and make sure that car-positions are updated. somnehow...
    }
}
