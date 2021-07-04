package br.com.gabriel.api.controller;

import br.com.gabriel.api.config.swagger.ApiPageable;
import br.com.gabriel.api.controller.dto.CarDTO;
import br.com.gabriel.api.controller.form.CarForm;
import br.com.gabriel.api.exception.UniqueChassiException;
import br.com.gabriel.api.model.Car;
import br.com.gabriel.api.service.CarService;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    @ApiPageable
    public ResponseEntity<Page<CarDTO>> findAll(
            @RequestParam(required = false, defaultValue = "") String brand,
            @RequestParam(required = false, defaultValue = "") String name,
            @RequestParam(required = false, defaultValue = "") String color,
            @RequestParam(required = false, defaultValue = "") String cheaperCar,
            @RequestParam(required = false, defaultValue = "") String mostExpensiveCar,
            @PageableDefault Pageable pagination) {
        Page<CarDTO> carTDOS = carService.findAll(brand, name, color, cheaperCar, mostExpensiveCar, pagination);

        return ResponseEntity.ok().body(carTDOS);
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody @Valid CarForm carForm, UriComponentsBuilder uriComponentsBuilder) {
        try {
            Car car = carService.saveCar(carForm);

            URI uri = uriComponentsBuilder.path("/api/cars/{id}").buildAndExpand(car.getId()).toUri();

            return ResponseEntity.created(uri).body(new CarDTO(car));
        } catch (DataIntegrityViolationException e) {
            throw new UniqueChassiException(HttpStatus.FORBIDDEN, "O chassi já está cadastrado: " + carForm.getChassi());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarDTO> findOne(@PathVariable Long id) {
        Optional<Car> car = carService.findCarById(id);

        return car.map(value -> ResponseEntity.ok().body(new CarDTO(value)))
                .orElseGet(() -> ResponseEntity.notFound().build());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteById(@PathVariable Long id) {
        Optional<Car> car = carService.findCarById(id);

        if (car.isPresent()) {
            carService.deleteCarById(id);

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

}
