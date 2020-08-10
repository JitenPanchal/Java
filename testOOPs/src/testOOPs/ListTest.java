package testOOPs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ListTest {

	public static void main(String[] args) {

		List<Integer> numbers = new ArrayList<>();

		numbers.add(10);
		numbers.add(11);
		numbers.add(15);
		numbers.add(15);
		numbers.add(16);
		numbers.add(5);
		numbers.add(1);

		Collections.sort(numbers);

		System.out.println(numbers);

		int index = Arrays.binarySearch(numbers.toArray(), 15);

		System.out.println(index);

		if (++index < numbers.size()) {
			if (numbers.get(index).equals(15)) {
				System.out.println("15 is duplicate");
			} else {
				System.out.println("15 is not duplicate");
			}
		} else {
			System.out.println("15 is not duplicate");
		}

	}
}
