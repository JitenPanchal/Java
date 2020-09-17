package javatest.collections.collectionspractice;

class AB {
	int i = 50;

	@Override
	protected void finalize() throws Throwable {
		System.out.println("From Finalize Method");
	}
}

public class FinalizeTest {
	public static void main(String[] args) throws InterruptedException {
		// Creating two instances of class A

		AB a1 = new AB();

		AB a2 = new AB();

		// Assigning a2 to a1

		a1 = a2;

		// Now both a1 and a2 will be pointing to same object

		// An object earlier referred by a1 will become abandoned

		System.out.println("done");
		
		System.gc();
		
//		Runtime.getRuntime().runFinalization();
//		
//		Thread.currentThread().join();
	}
}