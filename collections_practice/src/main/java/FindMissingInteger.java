
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingInteger {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("serial")
		List<int[]> input = new ArrayList<int[]>() {
			{
				add(new int[] { 1, 3, 6, 4, 1, 2 });
//				add(new int[] { 4,5,6,2 });
//				add(new int[] { 1,2,3 });
//				add(new int[] {});
//				add(new int[] { 3,4,5,6 });
//				add(new int[] { 200 });
//				add(new int[] { 0 });
//				add(new int[] { 1 });
//				add(new int[] { 1, 2, 3 });
//				add(new int[] { -1 });
//				add(new int[] { -1, -3 });
//				add(new int[] { -1, -3, -100 });
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

		int counter = A[0];

		for (int i = 1; i < A.length; i++) {

			if (A[i] == counter)
				continue;

			if (!(A[i] == ++counter))
				break;
//				return counter < 0 ? 1 : counter;
		}
		
		if (counter < 0)
			return 1;
		else if (A[0] > 1 ) {
			return A[0]-1;
		}
		else {
			return counter + 1;
		}

//		return counter < 0 ? 1 : counter + 1;
	}
}
