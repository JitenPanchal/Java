package testOOPs;

public class DerivedA extends BaseClass{
	protected int y = 10;
	protected String  x = "DerivedClass";
	
	@Override
	protected void method() {
		System.out.println("Derived method");
	}
}
