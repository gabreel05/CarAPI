package br.com.gabriel.api.controller.form;

import br.com.gabriel.api.model.Car;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class CarForm {

    @NotBlank
    private String chassi;
    @NotBlank
    private String name;
    @NotBlank
    private String brand;
    @NotBlank
    private String color;
    @NotNull
    private Double value;
    @NotNull
    private Integer yearManufacture;

    public Car toCar() {
        return new Car(chassi, name, brand, color, value, yearManufacture);
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

    public Double getValue() {
        return value;
    }

    public Integer getYearManufacture() {
        return yearManufacture;
    }

}
