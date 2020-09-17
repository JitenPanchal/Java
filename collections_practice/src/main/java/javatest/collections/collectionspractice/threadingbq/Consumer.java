package javatest.collections.collectionspractice.threadingbq;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {
	private BlockingQueue<Integer> questionList = null;

	public Consumer(BlockingQueue<Integer> questionList) {
		super();
		this.questionList = questionList;
	}

	@Override
	public void run() {
		while (true) {

			try {

				Thread.currentThread().sleep(1000);
				System.out.println("Answered Question :" + questionList.take());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
