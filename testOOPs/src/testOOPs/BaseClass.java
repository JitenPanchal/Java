package testOOPs;

import java.io.IOException;

public class BaseClass {

	protected String x = "BaseClass";

	protected void method() {
		System.out.println("Basclass method");
	}

	public BaseClass createInstance() throws CustomBaseException, IOException {
		return new BaseClass();
	}

}
