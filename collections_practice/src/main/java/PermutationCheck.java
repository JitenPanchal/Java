import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationCheck {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("serial")
		List<int[]> input = new ArrayList<int[]>() {
			{
				add(new int[] {});
				add(new int[] { 3 });
				add(new int[] { 1, 100 });
				add(new int[] { -1, -2, -3, -4 });
				add(new int[] { -99, -11, -88 });
				add(new int[] { 4, 1, 3 });
				add(new int[] { 4, 1, 3, 2 });
				add(new int[] { -99, 9, 11, 10, 11 });
				add(new int[] { 9, 11, 10, 11 });

			}
		};

		for (int i = 0; i < input.size(); i++) {
			System.out.println(Arrays.toString(input.get(i)) + "\t" + solution(input.get(i)));
		}
	}

	public static int solution(int[] A) {

		if (A.length < 2)
			return A[0] == 1 ? 1 : 0;

		Arrays.sort(A);

		int counter = 1;
		for (int i = 1; i < A.length; i++) {
			if (!(A[i] == ++counter))
				return 0;
		}

		return 1;
	}
}
