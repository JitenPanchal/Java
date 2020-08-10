package testOOPs;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListTest {

	public static void main(String[] args) {
		
		LinkedList<Integer> numbers = new LinkedList<Integer>();
		
		numbers.add(10);
		numbers.add(11);
		numbers.add(15);
		numbers.add(15);
		numbers.add(16);
		numbers.add(5);
		numbers.add(1);
		
		
		Collections.sort(numbers);
		
		
//		for(int i : numbers) {
//			System.out.println(i);
//		}
		
		System.out.println(numbers.offerFirst(150));
		
		System.out.println(numbers);
	}

}
