package com.jiten.sprint_demp_anno;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
	public static void main(String[] args) {
		ApplicationContext factory = new AnnotationConfigApplicationContext(AppConfig.class);

		Samsung s10 = factory.getBean(Samsung.class);

		s10.config();
	}
}