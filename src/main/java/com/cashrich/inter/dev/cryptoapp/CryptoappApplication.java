package com.cashrich.inter.dev.cryptoapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.cashrich.inter.dev.cryptoapp.security", "com.cashrich.inter.dev.cryptoapp.config"})

public class CryptoappApplication {

	public static void main(String[] args) {
		SpringApplication.run(CryptoappApplication.class, args);
	}

}
