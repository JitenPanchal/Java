package com.jiten.spring_demo;

import org.springframework.stereotype.Component;

@Component
public class Bike implements Vehicle {
	
	public void drive() {
		System.out.println("Driving bike :) :) :)");
	}
	
}
