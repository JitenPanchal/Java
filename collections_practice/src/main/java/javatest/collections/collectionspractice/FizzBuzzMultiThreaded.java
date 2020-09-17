package javatest.collections.collectionspractice;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class FizzBuzzMultiThreaded {
	public static void main(String[] args) {
		Runnable printFizz = () -> {
			System.out.println("fizz");
		};

		Runnable printBuzz = () -> {
			System.out.println("buzz");
		};

		Runnable printFizzBuzz = () -> {
			System.out.println("fizzbuzz");
		};

		IntConsumer intConsumer = n -> System.out.println(n);

		ExecutorService executorService = Executors.newFixedThreadPool(4);

		FizzBuzz fizzBuzz = new FizzBuzz(15);

		for (int i = 0; i < 4; i++) {
			
		
			
			
			executorService.submit(() -> {
				try {
					fizzBuzz.fizz(printFizz);
					fizzBuzz.buzz(printBuzz);
					fizzBuzz.fizzbuzz(printFizzBuzz);
					fizzBuzz.number(intConsumer);
					fizzBuzz.increment();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					System.exit(1);
				}

			});
		}

		executorService.shutdown();

	}
}

class FizzBuzz {

	private int n;
	private int currentNumber = 1;

	public FizzBuzz(int n) {
		this.n = n;
	}

	public synchronized void fizz(Runnable printFizz) throws InterruptedException {
		if (currentNumber % 3 == 0) {
			printFizz.run();
		}
	}

	public synchronized void buzz(Runnable printBuzz) throws InterruptedException {
		if (currentNumber % 5 == 0) {
			printBuzz.run();
		}
	}

	public synchronized void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
		if (currentNumber % 3 == 0 && currentNumber % 5 == 0) {
			printFizzBuzz.run();
		}
	}

	// printNumber.accept(x) outputs "x", where x is an integer.
	public synchronized void number(IntConsumer printNumber) throws InterruptedException {
		if (!(currentNumber % 3 == 0 && currentNumber % 5 == 0)) {
			printNumber.accept(currentNumber);
		}
	}

	public synchronized void increment() {
		currentNumber = currentNumber + 1;
	}
}