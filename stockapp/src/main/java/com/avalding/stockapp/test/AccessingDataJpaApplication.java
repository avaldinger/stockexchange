package com.avalding.stockapp.test;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.avalding.stockapp.tables.Account;

@SpringBootApplication
@ComponentScan({"com.avalding.stockapp"})
//@Configuration
//@EnableJpaRepositories(basePackages = "com.avalding.stockapp.tables")
public class AccessingDataJpaApplication {

	private static final Logger log = LoggerFactory.getLogger(AccessingDataJpaApplication.class);

	/**
	static void main(String[] args) {
		SpringApplication.run(AccessingDataJpaApplication.class);
		
	}

	**/
	@Bean
	public CommandLineRunner doTest(CustomerRepository repository) {
		return (args) -> {
			// fetch all customers
			log.info("Customers found with findAll():");
			log.info("-------------------------------");
			for (Account customer : repository.findAll()) {
				log.info(customer.toString());
			}
			log.info("Customers found with findById():");
			log.info("-------------------------------");
			Optional<Account> customer1 = repository.findById(1);
			log.info(customer1.toString());
			log.info("");

		};

	}

}
