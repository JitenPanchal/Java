package javatest.collections.collectionspractice.threading;

import java.util.ArrayList;
import java.util.List;

public class Application {

	public static void main(String[] args) {

		List<Integer> questionList = new ArrayList<>();

		Thread producer = new Thread(new Producer(questionList));
		
		Consumer consumerTask = new Consumer(questionList);
		
		Thread consumer = new Thread(consumerTask);
		Thread consumer2 = new Thread(consumerTask);
		Thread consumer3 = new Thread(consumerTask);
		
		producer.start();
		consumer.start();
		consumer2.start();
		consumer3.start();

	}

}
