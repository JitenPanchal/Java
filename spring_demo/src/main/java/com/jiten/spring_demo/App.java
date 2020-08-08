package com.jiten.spring_demo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {

		System.out.println(System.getProperty("user.dir"));
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Vehicle obj = (Vehicle) context.getBean(Car.class);
		obj.drive();

		Tyre tyre = (Tyre) context.getBean(Tyre.class);
		System.out.println(tyre);
	}
}