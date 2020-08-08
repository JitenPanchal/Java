package com.jiten.sprint_demp_anno;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Intel implements MobileProcessor {

	public void process() {
		System.out.println("Ranked The best");
	}
}
