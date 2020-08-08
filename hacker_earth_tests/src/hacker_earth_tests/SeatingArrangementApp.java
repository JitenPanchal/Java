package hacker_earth_tests;


import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class SeatingArrangementApp {

	private static class SeatInformation {
		private int seatNumber;
		private String seatType;

		public SeatInformation(int seatNumber, String seatType) {
			super();
			this.seatNumber = seatNumber;
			this.seatType = seatType;
		}

		public int getSeatNumber() {
			return seatNumber;
		}

		public String getSeatType() {
			return seatType;
		}

	}

	public static void main(String[] args) {

		Map<Integer, Integer> map = new HashMap<>();

		int seatsPerRow = 6;
		int totalRows = 18;

		for (int row = 1; row <= totalRows; row = row + 2) {

			int start = (row * seatsPerRow) - (seatsPerRow - 1);
			int end = ((row + 1) * seatsPerRow);

			int counter = 1;

			while (counter <= seatsPerRow) {
				map.put(start++, end--);
				counter++;
			}

		}

		Scanner scanner = new Scanner(System.in);

		final int seatNumber = scanner.nextInt();

		Integer facingSeatNumber = map.get(seatNumber);

		if (facingSeatNumber != null) {
			System.out.println("facing seat number is " + map.get(seatNumber));
		} else {

			Optional<Integer> item = map.entrySet().stream().filter(it -> it.getValue().equals(seatNumber)).findAny()
					.map(it -> it.getKey());

			if (item.isPresent())
				System.out.println("facing seat number is " + item.get());
		}
	}
}
