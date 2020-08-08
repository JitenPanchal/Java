package hacker_earth_tests;

import java.util.Scanner;

public class ScannerApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		int number = 0;
		String line = null;

		do {
			if (scanner.hasNextInt()) {
				number = scanner.nextInt();
			} else {
				scanner.next();
			}
		} while (!(number > 0 && number < 10));

		do {
			line = scanner.next();
		} while (!(line.length() >= 1 && line.length() <= 15));

		System.out.println(number * 2);
		System.out.println(line);
	}
}