
package javatest.threading;

public class InterruptThread3 {
	
	
	
	public static void main(String[] args) throws InterruptedException {
		
		MyTask runnableTask = new MyTask();
		
		Thread thread1 = new Thread(runnableTask);
		
		thread1.start();
		
		Thread.currentThread().sleep(1000);
		
		runnableTask.keepRunning = false;
		
//		thread1.join();
		
		
		
		
		System.out.println("Waited for 10 seconds");
	}
}


class MyTask implements Runnable {
	
	public boolean keepRunning = true;

	@Override
	public void run() {
		System.out.println("keepRunning is " + keepRunning);
		while (keepRunning) {
			System.out.println("Thread is running");
			try {
				Thread.currentThread().sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		System.out.println("keepRunning is " + keepRunning);
	}
	
}