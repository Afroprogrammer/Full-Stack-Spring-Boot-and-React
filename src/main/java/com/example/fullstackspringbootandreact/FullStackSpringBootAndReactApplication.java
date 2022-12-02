package com.example.fullstackspringbootandreact;

import com.example.fullstackspringbootandreact.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Arrays;

@SpringBootApplication
public class FullStackSpringBootAndReactApplication  implements CommandLineRunner {
	private static final Logger logger = LoggerFactory.getLogger(FullStackSpringBootAndReactApplication.class);
    @Autowired
	private CarRepository carRepository;
	@Autowired
	private OwnerRepository ownerRepository;

	@Autowired
	private UserRepository urepository;

	public static void main(String[] args) {
		SpringApplication.run(FullStackSpringBootAndReactApplication.class, args);
		logger.info("Application has started");
	}

	@Override
	public void run(String... args) throws Exception {

		Owner owner1 = new Owner("John" , "Johnson");
		Owner owner2 = new  Owner("Mary" , "Robinson");
		ownerRepository.saveAll(Arrays.asList(owner1, owner2));
		//saving some cars in the repository
		Car car1 = new Car("Ford", "Mustang", "Red",
				"ADF-1121", 2021, 59000, owner1);
		Car car2 = new Car("Nissan", "Leaf", "White",
				"SSJ-3002", 2019, 29000, owner2);
		Car car3 = new Car("Toyota", "Prius", "Silver",
				"KKO-0212", 2020, 39000, owner2);
		carRepository.saveAll(Arrays.asList(car1, car2, car3));

        // searching car in the repository
		for (Car car : carRepository.findAll()) {
			logger.info(car.getBrand() + " " + car.getModel());
		}
//
//		urepository.save(new PrincipalUser("user",
//				"$2a$10$NVM0n8ElaRgg7zWO1CxUdei7vWoPg91Lz2aYavh9.f9q0e4bRadue","USER"));
//		urepository.save(new PrincipalUser("admin",
//				"$2a$10$8cjz47bjbR4Mn8GMg9IZx.vyjhLXR/SKKMSZ9.mP9vpMu0ssKi8GW", "ADMIN"));

		urepository.save(new PrincipalUser("user", new BCryptPasswordEncoder().encode("password"), "USER"));
		urepository.save(new PrincipalUser("admin", new BCryptPasswordEncoder().encode("password"), "ADMIN"));


	}
}
