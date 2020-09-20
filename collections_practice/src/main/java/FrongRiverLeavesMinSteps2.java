
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FrongRiverLeavesMinSteps2 {

	public static void main(String[] args) {

		@SuppressWarnings("serial")
		List<InputInfo> input = new ArrayList<InputInfo>() {
			{
				add(new InputInfo(5, new int[] { 11, 1, 4, 2, 3, 5, 4 }));
				add(new InputInfo(5, new int[] { 1, 4, 2, 3, 5, 4 }));
				add(new InputInfo(5, new int[] { 1, 1, 4, 2, 3, 5, 4 }));
				add(new InputInfo(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
				add(new InputInfo(15, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
				add(new InputInfo(8, new int[] { 1, 3, 1, 8, 2, 3, 4, 5, 4, 6, 7, 9 }));
			}
		};

		for (int i = 0; i < input.size(); i++) {
			System.out.println(Arrays.toString(input.get(i).A) + "\t" + solution(input.get(i).X, input.get(i).A));
		}
	}

	public static int solution(int X, int[] A) {

		int second = -1;

		Map<Integer, Integer> map = new HashMap<>();

		for (int j = 0; j < A.length; j++) {
			if (!map.containsKey(A[j]))
				map.put(A[j], j);
		}

		for (int i = 1; i <= X; i++) {

			Integer j = map.get(i);
			if (j != null) {

				if (j > second) {
					second = j;
				}
			} else {
				return -1;
			}
		}

		return second;

	}

	static class InputInfo {
		public int X;
		public int[] A;

		public InputInfo(int x, int[] a) {
			super();
			X = x;
			A = a;
		}

		@Override
		public String toString() {
			return "X = " + X + "\t" + "A = " + Arrays.toString(A);
		}
	}
}