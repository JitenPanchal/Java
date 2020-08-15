package testOOPs;

public class ExceptionTests {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(methodReturningValue());

		System.out.println(methodintReturningValue());

		System.out.println(methodintWReturningValue());

	}

	static String methodReturningValue() {
		String s = null;
		try {
			s = "return value from try block";
			return s;
		} catch (Exception e) {
			s = s + "return value from catch block";
			return s;
		} finally {
			s = s + "return value from finally block";
		}
	}

	static int methodintReturningValue() {
		int s = 0;
		try {
			s = 10;
			return s;
		} catch (Exception e) {
			s = s + 50;
			return s;
		} finally {
			s = s + 100;
		}
	}

	static int methodintWReturningValue() {
		Integer s = 0;
		try {
			s = 10;
			return s;
		} catch (Exception e) {
			s = s + 50;
			return s;
		} finally {
			s = s + 100;
		}
	}
}
