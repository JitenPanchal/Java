package javatest.threading;

public class InterruptThread {
	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			while (!Thread.currentThread().isInterrupted()) {
				System.out.println("Thread is running");
			}
		});
		
		
		t1.start();
		
		Thread.sleep(10000);
		
		t1.interrupt();
		
		System.out.println("Waited for 10 seconds");
	}
}
