package testOOPs;

public class App {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BaseClass obj = new DerivedA();
		
		int y = 11;
		int x = -10 + -(++y);
		
		System.out.println(x);
		
		System.out.println(obj.x);
		obj.method();
	}

}
