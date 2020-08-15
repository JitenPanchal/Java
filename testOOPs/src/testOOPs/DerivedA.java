package testOOPs;

import java.io.EOFException;

public class DerivedA extends BaseClass{
	protected int y = 10;
	protected String  x = "DerivedClass";
	
	@Override
	protected void method() {
		System.out.println("Derived method");
	}
	
	@Override
	public DerivedA createInstance() throws CustomDerivedException, EOFException {
		return new DerivedA();
	}
}
