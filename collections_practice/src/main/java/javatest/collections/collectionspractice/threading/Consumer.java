package javatest.collections.collectionspractice.threading;

import java.util.List;

public class Consumer implements Runnable {
	private List<Integer> questionList = null;

	public Consumer(List<Integer> questionList) {
		super();
		this.questionList = questionList;
	}

	public void answerQuestion() throws InterruptedException {
		synchronized (questionList) {
			while (questionList.isEmpty()) {
				System.out.println("No Question to answer.. waiting for producer to get questions " + Thread.currentThread());
				questionList.wait();
			}
		}

		synchronized (questionList) {
			if (!questionList.isEmpty()) {
				System.out.println("Answered Question : " + questionList.remove(0) + "|" + Thread.currentThread());
				Thread.sleep(100);
				questionList.notify();
			}
		}
	}

	@Override
	public void run() {
		try {
			while (true) {
				answerQuestion();
			}
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
