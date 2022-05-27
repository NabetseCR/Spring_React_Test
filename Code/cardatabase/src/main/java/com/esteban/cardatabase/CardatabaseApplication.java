package com.esteban.cardatabase;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.esteban.cardatabase.domain.Car;
import com.esteban.cardatabase.domain.CarRepository;
import com.esteban.cardatabase.domain.Owner;
import com.esteban.cardatabase.domain.OwnerRepository;

@SpringBootApplication
public class CardatabaseApplication implements CommandLineRunner {
	// CommandLineRuner enable execute additional code before the application fully started.
	
	public static final Logger logger =
			LoggerFactory.getLogger
				(CardatabaseApplication.class);
	// We call our repository and with autowired we DI the repository
	@Autowired
	private CarRepository repository;
	@Autowired
	private OwnerRepository orepository;

	public static void main(String[] args) {
		SpringApplication.run(CardatabaseApplication.class, args);
		logger.info("Application Started");
	}
	
	// Method from the CommandLineRunner that allow us to run code before fully execution
	
	@Override
	public void run(String... args) throws Exception{
		Owner owner1 = new Owner("Esteban", "Chinchilla");
		Owner owner2 = new Owner("Ana", "Solano");
		
		orepository.saveAll(Arrays.asList(owner1, owner2));
		
		Car car1 = new Car("Ford", "Mustang", "Red", "ADF-1121", 2021, 59000, owner1);
		Car car2 = new Car("Toyota", "Prius", "Blue", "KKO-0212", 2020, 39000, owner2);
		Car car3 = new Car("Nissan", "Leaf", "White", "SSJ-3002", 2019, 29000, owner2);
		
		repository.saveAll(Arrays.asList(car1, car2, car3));
		
		repository.findAll().forEach(car -> logger.info(car.getBrand() + " " + car.getModel()));
	}

}
