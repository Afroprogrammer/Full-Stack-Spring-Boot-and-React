package com.example.fullstackspringbootandreact.domain;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
    //fetch cars by brand

    List<Car> findByBrand(@Param("brand") String brand);

    List<Car> findByColor(@Param("color") String colour);

//    List<Car> findByYear(String year);
//
//    List<Car> findByBrandAndModel(String brand, String model);
//
//    List<Car> findByBrandAndColor(String brand, String color);
//
//    //using order by query
//    List<Car>findByBrandOrderByYearAsc(String brand);
//
//    //using the query
//    @Query("select c from Car c where c.brand = ?1")
//    List<Car> findByBrandUsingSql(String brand);
//
//    //using advanced sql
//    @Query("select c from Car c where c.brand like %?1")
//    List<Car> findByBrandEndingWith(String brand);
}
