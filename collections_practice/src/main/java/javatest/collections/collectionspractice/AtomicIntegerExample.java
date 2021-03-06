package javatest.collections.collectionspractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicIntegerExample {
	public static void main(String[] args) throws InterruptedException {
		Test t = new Test();
		t.runMethod();
	}
}

class Test {
	public void runMethod() throws InterruptedException {
		ExecutorService executorService = Executors.newFixedThreadPool(50);

		AtomicInteger atomicCounter = new AtomicInteger(0);

		Runnable task = () -> {
			System.out.println(Thread.currentThread().getName());
			atomicCounter.incrementAndGet();
		};

		for (int i = 0; i < 1000; i++) {
			executorService.submit(task);
		}

		executorService.shutdown();
		executorService.awaitTermination(60, TimeUnit.SECONDS);

		System.out.println("Final Count is : " + atomicCounter.get());
	}
}