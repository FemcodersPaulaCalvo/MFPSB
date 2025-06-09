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

	@Bean
	public CommandLineRunner testConnection(DataSource dataSource) {
		return args -> {
			try {
				System.out.println("🔌 Probando conexión a la base de datos...");
				System.out.println("URL: " + dataSource.getConnection().getMetaData().getURL());
				System.out.println("Usuario: " + dataSource.getConnection().getMetaData().getUserName());
				System.out.println("✅ Conexión exitosa");
			} catch (Exception e) {
				System.err.println("❌ Error al conectar con la base de datos:");
				e.printStackTrace();
			}
		};
	}

}
