package com.santander.efx;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EfxApplication implements CommandLineRunner {

	@Autowired
	private DemoUseCase useCase;

	public static void main(String[] args) {
		SpringApplication.run(EfxApplication.class, args);
	}

	@Override
	public void run(String... args) {
		useCase.run();
	}
}
