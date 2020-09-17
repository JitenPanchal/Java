package javatest.threading;

public class InterruptThread2 {
	
	public static boolean keepRunning = true;
	
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			while (keepRunning) {
				System.out.println("Thread is running");
			}
		});
		
		
		t1.start();
		
		Thread.sleep(4000);
		
		keepRunning = false;
		
		System.out.println("Waited for 10 seconds");
	}
}
