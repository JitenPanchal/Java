import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumDifference {

	public static void main(String[] args) {

		@SuppressWarnings("serial")
		List<int[]> input = new ArrayList<int[]>() {
			{
				add(new int[] { 3, 1, 2, 4, 3 });
				add(new int[] { 3, 1 });
				add(new int[] { 1, 1 });
				add(new int[] { 110, 5, 9 });
				add(new int[] { -1000, 11, 10 });
			}
		};

		for (int i = 0; i < input.size(); i++) {
			System.out.println(Arrays.toString(input.get(i)) + "\t" + solution(input.get(i)));
		}
	}

	public static int solution(int[] A) {
		
		Arrays.sort(A);

		int minDifference = A[1] - A[0];

		for (int i = 0; i < A.length - 1; i++) {

			if (A[i + 1] == A[i]) {
				continue;
			}

			int tempDiff = A[i + 1] - A[i];

			if (minDifference > tempDiff)
				minDifference = tempDiff;
		}

		return minDifference;
	}

}
