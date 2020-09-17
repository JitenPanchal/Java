package testOOPs;

public interface InterfaceWithDefaultMethods {

	void method();
	
	default void defaultMethod() {
		System.out.println("inside defaultMethod");
	}
}
