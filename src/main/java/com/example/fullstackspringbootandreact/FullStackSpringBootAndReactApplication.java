package com.example.fullstackspringbootandreact;

import com.example.fullstackspringbootandreact.domain.Car;
import com.example.fullstackspringbootandreact.domain.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class FullStackSpringBootAndReactApplication  implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(FullStackSpringBootAndReactApplication.class);
    @Autowired
	private CarRepository carRepository;

	public static void main(String[] args) {
		SpringApplication.run(FullStackSpringBootAndReactApplication.class, args);
		logger.info("Application has started");
	}

	@Override
	public void run(String... args) throws Exception {
		//saving some cars in the repository
		carRepository.save(new Car("Ford", "Mustang", "Red",
						"ADF-1121", 2021, 59000));
		carRepository.save(new Car("Nissan", "Leaf", "White",
				"SSJ-3002", 2019, 29000));

		carRepository.save(new Car("Toyota", "Prius", "Silver",
				"KKO-0212", 2020, 39000));

        // searching car in the repository
		for (Car car : carRepository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
	}
}
