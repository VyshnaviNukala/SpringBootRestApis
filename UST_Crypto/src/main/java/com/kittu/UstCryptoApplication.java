package com.kittu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.kittu")
public class UstCryptoApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(UstCryptoApplication.class, args);
		System.out.println("Application running successfully");
	}

}
