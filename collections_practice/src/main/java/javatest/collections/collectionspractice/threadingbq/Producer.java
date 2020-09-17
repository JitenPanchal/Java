package javatest.collections.collectionspractice.threadingbq;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

	private BlockingQueue<Integer> questionList = null;
	private final int LIMIT = 5;
	private int questionNo;

	public Producer(BlockingQueue<Integer> questionList) {
		super();
		this.questionList = questionList;
	}

	public void readQuestion(int questionNo) throws InterruptedException {
		synchronized (questionList) {
			while (questionList.size() == LIMIT) {
				System.out.println("Question have piled up.. wait for answers");
				questionList.wait();
			}
		}

		synchronized (questionList) {
			questionNo++;
			System.out.println("New Question : " + questionNo);
			questionList.add(questionNo);
			Thread.sleep(100);
			questionList.notify();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				synchronized (this) {
					int nextQuestion = questionNo++;
					System.out.println("Got new Question: " + nextQuestion);
					questionList.put(nextQuestion);
				}
			} catch (InterruptedException e) {
			}
		}
	}

}
