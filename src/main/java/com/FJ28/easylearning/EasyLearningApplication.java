package com.FJ28.easylearning;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.FJ28.easylearning.mapper")
// to find the packages of the mapper

public class EasyLearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(EasyLearningApplication.class, args);
	}

}
