

import java.util.ArrayList;
import java.util.List;

public class SeatingArrangementTest {

	private static final String OCCUPIED = "OCCUPIED";
	private static final String VACANT = "VACANT";

	public static void main(String[] args) {

//		int numberOfStudents = 5;
//		int numberOfRows = 2;
//		int maxCapacityOfRow = 2;
//		int[] prefRow = new int[] { 1, 1, 2, 1, 1 };

		String[] nmk = args[0].split("\\s+");

		int numberOfStudents = Integer.parseInt(nmk[0]);
		int numberOfRows = Integer.parseInt(nmk[1]);
		int maxCapacityOfRow = Integer.parseInt(nmk[2]);

		String[] line2 = args[1].split("\\s+");

		int[] prefRow = new int[line2.length];

		for (int i = 0; i < line2.length; i++) {
			prefRow[i] = Integer.parseInt(line2[i]);
		}

		List<SeatInfo> seatInfoList = new ArrayList<SeatInfo>();

		int seatCounter = 1;
		for (int row = 1; row <= numberOfRows; row++) {
			for (int i = 1; i <= maxCapacityOfRow; i++) {
				seatInfoList.add(new SeatInfo(seatCounter++, row));
			}
		}

		int prefSeatCounter = 0;

		for (int i = 0; i < prefRow.length; i++) {

			boolean isPreferedSeatFound = false;

			for (int j = 0; j < seatInfoList.size(); j++) {
				SeatInfo seatInfo = seatInfoList.get(j);

				if (seatInfo.getRowNumber() == prefRow[i]) {
					if (!seatInfo.isOccupied()) {
						seatInfo.setOccupied(true);
						isPreferedSeatFound = true;
						prefSeatCounter++;
						break;
					}
				}
			}

			if (!isPreferedSeatFound) {
				for (SeatInfo seatInfo : seatInfoList) {

					if (!seatInfo.isOccupied() && seatInfo.getRowNumber() >= prefRow[i]) {
						seatInfo.setOccupied(true);
						break;
					}

				}
			}

		}

		System.out.println((prefRow.length - prefSeatCounter));

	}

}

class SeatInfo {

	private int seatNumber;

	private int rowNumber;

	private boolean isOccupied;

	public int getSeatNumber() {
		return seatNumber;
	}

	public int getRowNumber() {
		return rowNumber;
	}

	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}

	public boolean isOccupied() {
		return isOccupied;
	}

	public void setOccupied(boolean isOccupied) {
		this.isOccupied = isOccupied;
	}

	public SeatInfo(int seatNumber, int rowNumber) {
		super();
		this.seatNumber = seatNumber;
		this.rowNumber = rowNumber;
	}

}
