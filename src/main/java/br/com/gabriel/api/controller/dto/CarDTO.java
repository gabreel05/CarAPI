package br.com.gabriel.api.controller.dto;

import br.com.gabriel.api.model.Car;
import org.springframework.data.domain.Page;

import java.text.NumberFormat;
import java.util.Locale;

public class CarDTO {

    private final Long id;
    private final String chassi;
    private final String name;
    private final String brand;
    private final String color;
    private final String value;
    private final Integer yearManufacture;

    public CarDTO(Car car) {
        this.id = car.getId();
        this.chassi = car.getChassi();
        this.name = car.getName();
        this.brand = car.getBrand();
        this.color = car.getColor();
        this.value = convertValueToCurrency(car.getValue());
        this.yearManufacture = car.getYearManufacture();
    }

    public static Page<CarDTO> toCar(Page<Car> cars) {
        return cars.map(CarDTO::new);
    }

    private String convertValueToCurrency(double value) {
        Locale locale = new Locale("pt", "BR");

        NumberFormat formatter = NumberFormat.getCurrencyInstance(locale);

        return formatter.format(value);
    }

    public Long getId() {
        return id;
    }

    public String getChassi() {
        return chassi;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public String getValue() {
        return value;
    }

    public Integer getYearManufacture() {
        return yearManufacture;
    }

}
