
public class BinaryGap {
	public static void main(String[] args) {
//		int[] numbers = { 9, 529, 20, 15, 32, 1041 };
		
		int[] numbers = { 1376796946 }; 

		for (int i = 0; i < numbers.length; i++) {
			System.out.println("" + numbers[i] + " = " + solution(numbers[i]));
		}
	}

	public static int solution(int N) {
//		9 % 2 = 1
//		4 % 2 = 0
//		2 % 2 = 0
//		1 % 2 = 1

		StringBuilder binaryNumber = new StringBuilder();

		while (N > 0) {
			int remainder = N % 2;
			binaryNumber.append(remainder);
			N /= 2;
		}

		System.out.println(binaryNumber.reverse());
		
//		binaryNumber = new StringBuilder();
//		binaryNumber.append("11000101");
//		binaryNumber = binaryNumber.reverse();

		int maxCounter = 0;
		int tempCounter = 0;

		boolean startOne = false;
		boolean endOne = false;
		final int length = binaryNumber.length();
		for (int i = length - 1; i > -1; i--) {

			char ch = binaryNumber.charAt(i);

			if (endOne == false && startOne == false && ch == '1') {
				startOne = true;
			}
			else if (startOne && endOne == false && ch == '1') {
				endOne = true;
			}
			else if (startOne && ch == '0') {
				tempCounter++;
			}

			if (startOne && endOne) {
				if (tempCounter > maxCounter) {
					maxCounter = tempCounter;	
				}
				
				tempCounter = 0;
				startOne = true;
				endOne = false;
			}

			if (!((length - i) > maxCounter)) {
				break;
			}
		}

		return maxCounter;
	}
}
