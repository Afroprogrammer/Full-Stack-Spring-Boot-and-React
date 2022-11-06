package com.example.fullstackspringbootandreact.domain;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarRepository extends CrudRepository<Car, Long> {
    //fetch cars by brand

    List<Car> findByBrand(String brand);

    List<Car> findByColor(String colour);

    List<Car> findByYear(String year);

    List<Car> findByBrandAndModel(String brand, String model);

    List<Car> findByBrandAndColor(String brand, String color);

    //using order by query
    List<Car>findByBrandOrderByYearAsc(String brand);

    //using the query
    @Query("select c from Car c where c.brand = ?1")
    List<Car> findByBrandUsingSql(String brand);

    //using advanced sql
    @Query("select c from Car c where c.brand like %?1")
    List<Car> findByBrandEndingWith(String brand);
}
