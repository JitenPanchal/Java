package com.jiten.sprint_demp_anno;

import java.util.concurrent.Future;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.jiten.sprint_demp_anno")
public class AppConfig {
	
	public AppConfig() {
		System.out.println("AppConfig ctor called");
	}

	@Bean
	public IProductService getProductService() {
		return new ProductService();
	}

//	@Bean
//	public Samsung getSamsung() {
//		return new Samsung();
//	}
//	
//	@Bean
//	public MobileProcessor getMobileProcessor() {
//		return new Snapdragon();
//	}

}