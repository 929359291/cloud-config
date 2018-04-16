package com.demo.demologin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.demo.demologin.mapper")
@SpringBootApplication
public class DemoLoginApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoLoginApplication.class, args);
	}
}
