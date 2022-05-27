package com.esteban.cardatabase.domain;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CarRepository extends CrudRepository<Car, Long> {
	//Fetch cars by brand
	//List<Car> findByBrand(String brand);
	
	//Fetch cars by color
	List<Car> findByColor(@Param("color") String color);
	
	//Fetch by year
	List<Car> findByYear(int year);
	
	//Also we can use AND, OR
	List<Car> findByBrandAndModel(String brand, String model);
	List<Car> findByBrandOrColor(String brand, String color);
	
	//We can also use the OrderBy
	List<Car> findByBrandOrderByYearAsc(String brand);
	
	//We can also use @Query to use in line SQL
	@Query("select c from Car c where c.brand = ?1")
	List<Car> findByBrand(String brand);
	
	@Query("select c from Car c where c.brand like %?1")
	List<Car> findByBrandEndsWith(String brand);
}
