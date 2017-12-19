package com.yearcon.weixincard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WeixinCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeixinCardApplication.class, args);
	}
}
