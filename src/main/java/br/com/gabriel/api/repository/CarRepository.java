package br.com.gabriel.api.repository;

import br.com.gabriel.api.model.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CarRepository extends JpaRepository<Car, Long> {
    Page<Car> findByBrand(String brand, Pageable pagination);

    Page<Car> findByName(String name, Pageable pagination);

    Page<Car> findByColor(String color, Pageable pagination);

    Page<Car> findByBrandAndNameAndColor(String brand, String name, String color, Pageable pageable);

    Page<Car> findByBrandAndName(String brand, String name, Pageable pagination);

    Page<Car> findByBrandAndColor(String brand, String color, Pageable pagination);

    Page<Car> findByNameAndColor(String name, String color, Pageable pagination);

    @Query("select c from Car c order by c.value asc")
    Page<Car> findCheaperCar(String cheaperCar, Pageable pagination);

    @Query("select c from Car c order by c.value desc")
    Page<Car> findMostExpensiveCar(String mostExpensiveCar, Pageable pagination);
}
