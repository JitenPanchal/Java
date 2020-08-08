package com.jiten.sprint_demp_anno;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component()
public class Samsung {

	@Autowired
	@Qualifier("intel")
	MobileProcessor mobileProcessor;

	public MobileProcessor getMobileProcessor() {
		return mobileProcessor;
	}

	public void setMobileProcessor(MobileProcessor mobileProcessor) {
		this.mobileProcessor = mobileProcessor;
	}

	public void config() {
		System.out.println("inside Samsing config");
		mobileProcessor.process();
	}
}
