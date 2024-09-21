package com.jinu.jinugram.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan("com.jinu.jinugram.user.repository")
public class MyBatisConfig {
}
