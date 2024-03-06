package com.dji.sample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@MapperScan("com.dji.sample.*.dao")//mapper包里面放的是我们对数据库操作的东西，这个注解是告诉Mybatis,mapper包在何处
@SpringBootApplication
@EnableScheduling
@ComponentScan("com.dji")
public class CloudApiSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudApiSampleApplication.class, args);
	}

}
