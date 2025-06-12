package com.MyFirstProjectSpringBoot.MFPSB;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import javax.sql.DataSource;

@SpringBootApplication
public class MfpsbApplication {

	public static void main(String[] args) {
		SpringApplication.run(MfpsbApplication.class, args);
	}

}
