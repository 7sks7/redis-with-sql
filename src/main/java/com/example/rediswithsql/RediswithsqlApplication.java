package com.example.rediswithsql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class RediswithsqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(RediswithsqlApplication.class, args);
	}

}
