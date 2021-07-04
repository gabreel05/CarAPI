package br.com.gabriel.api.model;

import javax.persistence.*;
import java.util.Objects;

@Table(name = "car")
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "chassi", nullable = false, unique = true)
    private String chassi;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "color", nullable = false)
    private String color;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "yearManufacture", nullable = false)
    private Integer yearManufacture;

    public Car(
            String chassi,
            String name,
            String brand,
            String color,
            Double value,
            Integer yearManufacture
    ) {
        this.chassi = chassi;
        this.name = name;
        this.brand = brand;
        this.color = color;
        this.value = value;
        this.yearManufacture = yearManufacture;
    }

    public Car() {

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

    public Double getValue() {
        return value;
    }

    public Integer getYearManufacture() {
        return yearManufacture;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getId().equals(car.getId())
                && getChassi().equals(car.getChassi())
                && getName().equals(car.getName())
                && getBrand().equals(car.getBrand())
                && getColor().equals(car.getColor())
                && getValue().equals(car.getValue())
                && getYearManufacture().equals(car.getYearManufacture());
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                getId(),
                getChassi(),
                getName(),
                getBrand(),
                getColor(),
                getValue(),
                getYearManufacture()
        );
    }

}
