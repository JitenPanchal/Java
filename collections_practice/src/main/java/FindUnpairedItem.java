import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindUnpairedItem {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("serial")
		List<int[]> input = new ArrayList<int[]>() {
			{
				add(new int[] { 9, 3, 9, 3, 7, 9 });
//				add(new int[] {});
				add(new int[] { 42 });
//				add(new int[] { 42, 43 });
//				add(new int[] { 9, 3, 9, 3 });
				add(new int[] { 2, 2, 3, 3, 4 });
				
			}
		};

		for (int i = 0; i < input.size(); i++) {
			System.out.println(Arrays.toString(input.get(i)) + "\t" + solution(input.get(i)));
		}
	}

	public static int solution(int[] A) {

		if (A == null || A.length == 0)
			return 0;

		Arrays.sort(A);

		for (int i = 0; i < A.length - 1; i = i + 2) {
			if (A[i] == A[i + 1]) {
				continue;
			} else {
				return A[i];
			}
		}

		
		return A[A.length - 1];
	}
}
