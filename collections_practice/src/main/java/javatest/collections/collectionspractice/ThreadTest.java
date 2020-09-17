package javatest.collections.collectionspractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {
	// Main Thread
	public static void main(String[] args) throws InterruptedException, ClassNotFoundException {

		UserThread2 userThread = new UserThread2(); // Creating the UserThread
//		userThread.setDaemon(false);
		userThread.start(); // Starting the thread
		
//		userThread.join();
		
		
		ExecutorService executorService = Executors.newSingleThreadExecutor();
	}
}

class UserThread2 extends Thread {
	@Override
	public void run() {
		for (int i = 0; i < 100000; i++) {
			System.out.println("This is an user thread...." + i);
		}
	}
}
