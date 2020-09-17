package javatest.collections.collectionspractice.threading;

import java.util.List;

public class Producer implements Runnable {

	private List<Integer> questionList = null;
	private final int LIMIT = 5;
	private int questionNo;

	public Producer(List<Integer> questionList) {
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
			Thread.sleep(200);
			questionList.notifyAll();
		}
	}

	@Override
	public void run() {
		while (true) {
			try {
				readQuestion(questionNo++);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
