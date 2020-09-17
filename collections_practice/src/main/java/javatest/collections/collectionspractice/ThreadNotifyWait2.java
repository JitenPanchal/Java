package javatest.collections.collectionspractice;

public class ThreadNotifyWait2 {
	public static void main(String[] args) {
		// final Shared2 s = new Shared2();

		Thread t1 = new Thread() {
			public void run() {
				Shared2.methodOne(); // t1 calling methodOne() of 's' object
			}
		};

		Thread t2 = new Thread() {
			@Override
			public void run() {
				Shared2.methodTwo(); // t2 calling methodTwo() of 's' object
			}
		};

		t1.start();

		t2.start();
	}
}

class Shared2 {

	private static final Object lock = new Object();

	static void methodOne() {

		synchronized (lock) {

			Thread t = Thread.currentThread();

			System.out.println(t.getName() + " is relasing the lock and going to wait");

			try {
				lock.wait(); // releases the lock of this object and waits
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			System.out.println(t.getName() + " got the object lock back and can continue with it's execution");
		}
	}

	static void methodTwo() {
		synchronized (lock) {
			Thread t = Thread.currentThread();

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			lock.notify(); // wakes up one thread randomly which is waiting for lock of this object

			System.out.println("A thread which is waiting for lock of this object is notified by " + t.getName());
		}
	}
}