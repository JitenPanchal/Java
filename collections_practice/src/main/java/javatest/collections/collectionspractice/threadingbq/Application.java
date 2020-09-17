package javatest.collections.collectionspractice.threadingbq;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


import javatest.collections.collectionspractice.threadingbq.*;

public class Application {

	public static void main(String[] args) {
		BlockingQueue<Integer> questionList = new ArrayBlockingQueue<>(5);

		Thread producer = new Thread(new Producer(questionList));
		Thread consumer = new Thread(new Consumer(questionList));
		Thread consumer2 = new Thread(new Consumer(questionList));
		Thread consumer3 = new Thread(new Consumer(questionList));
		
		producer.start();
		consumer.start();
		consumer2.start();
		consumer3.start();

	}

}
