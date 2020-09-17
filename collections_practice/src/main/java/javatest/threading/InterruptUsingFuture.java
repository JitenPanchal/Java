
package javatest.threading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class InterruptUsingFuture {
	
	
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {
		
		MyTask2 runnableTask = new MyTask2();
		
		
		ExecutorService executorService = Executors.newFixedThreadPool(1);
		
		
		Future<String> result = executorService.submit(runnableTask);
		
		Thread.currentThread().sleep(1000);
		
		runnableTask.keepRunning = false;
		
		result.cancel(true);
		
//		System.out.println(result.get(1000, TimeUnit.SECONDS));
		
//		thread1.join();
		
		executorService.shutdown();
		
		
		
		
		System.out.println("Waited for 10 seconds");
	}
}


class MyTask2 implements Callable<String> {
	
	public boolean keepRunning = true;

	
	@Override
	public String call() throws Exception {
		System.out.println("keepRunning is " + keepRunning);
		while (keepRunning) {
			System.out.println("Thread is running");
//			try {
//				Thread.currentThread().sleep(200);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
		
		System.out.println("keepRunning is " + keepRunning);
		
		return "Done";
	}

	
	
}