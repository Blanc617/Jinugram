package com.jinu.jinugram;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.jinu.jinugram.user.repository")  
public class JinugramApplication {

	public static void main(String[] args) {
		SpringApplication.run(JinugramApplication.class, args);
	}

}
