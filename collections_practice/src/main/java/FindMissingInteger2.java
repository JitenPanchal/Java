import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindMissingInteger2 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("serial")
		List<int[]> input = new ArrayList<int[]>() {
			{
				add(new int[] {0,1,2,3,4,5,6});
				add(new int[] {-9,-8,-7,-6,-5,-4,-3,-2,-1});
				add(new int[] {-9,-8,-7,-6,-5,-4,-3,-2,-1,0});
				add(new int[] {-9,-8,-7,-6,-5,-4,-3,-2,-1,0,1});
				add(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE });
				add(new int[] {1000,5000});
				add(new int[] { 90, 91, 92, 93 });
				add(new int[] { 4,5,6,2 });
				add(new int[] { 1, 3, 6, 4, 1, 2 });
				add(new int[] { 1,2,3 });
				add(new int[] {});
				add(new int[] { 3,4,5,6 });
				add(new int[] { 200 });
				add(new int[] { 0 });
				add(new int[] { 1 });
				add(new int[] { 1, 2, 3 });
				add(new int[] { -1 });
				add(new int[] { -1, -3 });
				add(new int[] { -1, -3, -100 });
			}
		};

		for (int i = 0; i < input.size(); i++) {
			System.out.println(Arrays.toString(input.get(i)) + "\t" + solution(input.get(i)));
		}
	}

	public static int solution(int[] A) {

		if (A == null || A.length == 0)
			return 1;

		if (A.length == 1) {
			return A[0] == 1 ? A[0] + 1 : 1;
		}

		Arrays.sort(A);

		int counter = A[0];

		for (int i = 1; i < A.length; i++) {

			if (A[i] == counter)
				continue;

			if (!(A[i] == ++counter)) {
				if (A[0] > 1)
					return 1;
				else
					return counter < 0 ? 1 : counter;
			}

		}

		if (counter < 0 || A[0] > 1) {
			return 1;
		} else {
			return counter + 1;
		}

//		if (counter < 0)
//			return 1;
//		else if (A[0] > 1 ) {
//			return A[0]-1;
//		}  
//		else {
//			return counter+1;
//		}
	}
}
