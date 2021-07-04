package br.com.gabriel.api.service;

import br.com.gabriel.api.controller.dto.CarDTO;
import br.com.gabriel.api.controller.form.CarForm;
import br.com.gabriel.api.model.Car;
import br.com.gabriel.api.repository.CarRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Optional;

@Service
public class CarService {

    private static final String KEY_BRAND = "KEY_BRAND";
    private static final String KEY_NAME = "KEY_NAME";
    private static final String KEY_COLOR = "KEY_COLOR";
    private static final String KEY_CHEAPER_CAR = "KEY_CHEAPER_CAR";
    private static final String KEY_MOST_EXPENSIVE_CAR = "KEY_MOST_EXPENSIVE_CAR";

    private final CarRepository carRepository;

    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public Page<CarDTO> findAll(String brand, String name, String color, String cheaperCar, String mostExpensiveCar, Pageable pagination) {
        Page<Car> cars;

        HashMap<String, String> filter = new HashMap<>();

        if (!brand.isEmpty()) {
            filter.put(KEY_BRAND, brand);
        }

        if (!name.isEmpty()) {
            filter.put(KEY_NAME, name);
        }

        if (!color.isEmpty()) {
            filter.put(KEY_COLOR, color);
        }

        if (!cheaperCar.isEmpty()) {
            filter.put(KEY_CHEAPER_CAR, cheaperCar);
        }

        if (!mostExpensiveCar.isEmpty()) {
            filter.put(KEY_MOST_EXPENSIVE_CAR, mostExpensiveCar);
        }


        if (filter.containsKey(KEY_BRAND)) {
            if (filter.containsKey(KEY_NAME)) {
                if (filter.containsKey(KEY_COLOR)) {
                    cars = carRepository.findByBrandAndNameAndColor(brand, name, color, pagination);
                } else {
                    cars = carRepository.findByBrandAndName(brand, name, pagination);
                }
            } else if (filter.containsKey(KEY_COLOR)) {
                cars = carRepository.findByBrandAndColor(brand, color, pagination);
            } else {
                cars = carRepository.findByBrand(brand, pagination);
            }
        } else if (filter.containsKey(KEY_NAME)) {
            if (filter.containsKey(KEY_COLOR)) {
                cars = carRepository.findByNameAndColor(name, color, pagination);
            } else {
                cars = carRepository.findByName(name, pagination);
            }
        } else if (filter.containsKey(KEY_COLOR)) {
            cars = carRepository.findByColor(color, pagination);
        } else if (filter.containsKey(KEY_CHEAPER_CAR)) {
            cars = carRepository.findCheaperCar(cheaperCar, PageRequest.of(0, 1));
        } else if (filter.containsKey(KEY_MOST_EXPENSIVE_CAR)) {
            cars = carRepository.findMostExpensiveCar(mostExpensiveCar, PageRequest.of(0, 1));
        } else {
            cars = carRepository.findAll(pagination);
        }

        return CarDTO.toCar(cars);
    }

    public Car saveCar(CarForm carForm) {
        Car car = carForm.toCar();

        carRepository.save(car);

        return car;
    }

    public Optional<Car> findCarById(Long id) {
        return carRepository.findById(id);
    }

    public void deleteCarById(Long id) {
        carRepository.deleteById(id);
    }

}
