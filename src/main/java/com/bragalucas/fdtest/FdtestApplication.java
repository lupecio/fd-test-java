package com.bragalucas.fdtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class FdtestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FdtestApplication.class, args);
	}

}
