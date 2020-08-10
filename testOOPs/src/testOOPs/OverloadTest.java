package testOOPs;

public class OverloadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer i = 1;
		m1(i);

	}
	
	static void m1(Object o) {
		System.out.println("Object = " + o);
	}
	
	static void m1(Number o) {
		System.out.println("Number = " + o);
	}
	
	static void m1(Integer o) {
		System.out.println("Integer = " + o);
	}
	
	static void m1(int o) {
		System.out.println("int = " + o);
	}

}
