package javatest.collections.collectionspractice;

import java.util.Scanner;

public class Prime {
	public static void main(String args[]) {
		System.out.println("Enter the number to check: ");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		boolean isPrime = false;
		if (num != 0) {
			isPrime = checkPrime(num);
		} else {
			System.out.println("Enter valid number");
		}
		if (isPrime == false) {
			System.out.println(" NOT PRIME!!");
		} else {
			System.out.println("PRIME!!");
		}
	}

	public static boolean checkPrime(int number) {
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 2; i < sqrt; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}