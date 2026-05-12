package web.dao;

import org.springframework.stereotype.Component;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Component
public class CarDaoImpl implements CarDao {
    private final List<Car> cars = new ArrayList<>();

    {
        cars.add(new Car("Lada", "Red", "1999"));
        cars.add(new Car("Volga", "Green", "1985"));
        cars.add(new Car("Toyota", "Blue", "2001"));
        cars.add(new Car("Fiat", "Yellow", "2007"));
        cars.add(new Car("Ford", "Black", "2012"));
    }

    @Override
    public List<Car> getCars(int carCount) {
        return cars.stream().limit(carCount).toList();
    }
}
