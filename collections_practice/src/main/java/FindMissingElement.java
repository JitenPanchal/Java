import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingElement {

	public static void main(String[] args) {

		@SuppressWarnings("serial")
		List<int[]> input = new ArrayList<int[]>() {
			{
				add(new int[] {});
				add(new int[] { 0 });
				add(new int[] { 1 });
				add(new int[] { 2 });
				add(new int[] { 1, 3 });
				add(new int[] { 1, 2 });
				add(new int[] { 8, 9, 11 });
				add(new int[] { 7, 8, 9, 10 });
			}
		};

		for (int i = 0; i < input.size(); i++) {
			System.out.println(Arrays.toString(input.get(i)) + "\t" + solution(input.get(i)));
		}
	}

	public static int solution(int[] A) {

		if (A == null || A.length == 0)
			return 1;
		
		Arrays.sort(A);

		int counter = 1;
		for (int i = 0; i < A.length; i++) {
			if (A[i] == counter) {
				counter++;
				continue;
			} else {
				return counter;
			}
		}

		return counter;
	}

}
