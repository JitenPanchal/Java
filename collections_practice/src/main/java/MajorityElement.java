
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		@SuppressWarnings("serial")
		List<int[]> input = new ArrayList<int[]>() {
			{
				add(new int[] { 3, 3, 4, 2, 4, 4, 2, 4, 4 });
				add(new int[] { 3, 3, 4, 2, 4, 4, 2, 4 });
//				add(new int[] { -9, -8, -7, -6, -5, -4, -3, -2, -1 });
//				add(new int[] { -9, -8, -7, -6, -5, -4, -3, -2, -1, 0 });
//				add(new int[] { -9, -8, -7, -6, -5, -4, -3, -2, -1, 0, 1 });
//				add(new int[] { Integer.MAX_VALUE, Integer.MIN_VALUE });
//				add(new int[] { 1000, 5000 });
//				add(new int[] { 90, 91, 92, 93 });
//				add(new int[] { 4, 5, 6, 2 });
//				add(new int[] { 1, 3, 6, 4, 1, 2 });
//				add(new int[] { 1, 2, 3 });
//				add(new int[] {});
//				add(new int[] { 3, 4, 5, 6 });
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
			System.out.println(Arrays.toString(input.get(i)));
			solution(input.get(i));
		}
	}

	public static void solution(int[] A) {
		Arrays.sort(A);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		for (int i = 0; i < A.length; i++) {

			Integer counts = map.get(A[i]);
			if (counts == null) {
				counts = new Integer(1);
			} else {
				counts = counts + 1;
			}
			map.put(A[i], counts);

			if (counts > A.length / 2.0) {
				System.out.println(A[i]);
				return;
			}
		}

		System.out.println("No majority element");
	}
}
