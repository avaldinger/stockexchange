package com.avalding.stockapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "com.avalding")
public class StockappApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockappApplication.class, args);
		
		
	}

}
