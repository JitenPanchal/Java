package javatest.collections.collectionspractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class FizzBuzzMultiThreaded2 {
	public static void main(String[] args) {

		int length = 20; // Integer.parseInt(args[0]);

		AtomicInteger atomicInteger = new AtomicInteger(0);

		Runnable task = () -> {

			int n;

			
			while ((n = atomicInteger.incrementAndGet()) <= length) {
				if (n % 3 == 0) {
					System.out.println("fizz" + "-" + n + " " + Thread.currentThread().getName());
				} else if (n % 5 == 0) {
					System.out.println("buzz" + "-" + n + " " + Thread.currentThread().getName());
				} else if (n % 3 == 0 && n % 5 == 0) {
					System.out.println("fizzbuzz" + "-" + n + " " + Thread.currentThread().getName());
				} else {
					System.out.println(n + " " + Thread.currentThread().getName());
				}
				
//				try {
//					Thread.currentThread().sleep(500);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
			}

		};

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		for (int i = 0; i < 4; i++) {
			executorService.submit(task);
		}

		executorService.shutdown();
	}
}
