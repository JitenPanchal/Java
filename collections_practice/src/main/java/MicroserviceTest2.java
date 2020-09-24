import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MicroserviceTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("serial")
		List<int[]> input = new ArrayList<int[]>() {
			{
				add(new int[] { 3, 4, 5, 7, 3 });
//				add(new int[] { 3, 1 });
//				add(new int[] { 1, 1 });
//				add(new int[] { 110, 5, 9 });
//				add(new int[] { -1000, 11, 10 });
			}
		};

		for (int i = 0; i < input.size(); i++) {
			System.out.println(Arrays.toString(input.get(i)) + "\t" + solution(input.get(i)));
		}
	}

	public static int solution(int[] A) {

		int result = -1;

		if (A[0] <= A[1] && A[1] <= A[2])
			return result;

		if (A[0] > A[1] && A[1] >= A[2])
			return result;

		int prevHeight = A[0];

		boolean isFirstTreeShorter = A[0] <= A[1];

		for (int i = 1; i < A.length - 1; i++) {
			if (!(prevHeight < A[i] && A[i + 1] > A[i])) {
				return -1;
			}
			prevHeight = A[i];
		}

		return result;
	}

}
