package testOOPs;

public class A extends BaseClass{
	protected int y = 10;
	protected String  x = "DerivedClass";
	
	@Override
	protected void method() {
		System.out.println("Derived method");
	}
}
