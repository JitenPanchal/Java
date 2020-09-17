import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class RotateArrayList {

	public static void main(String[] args) {

		Map<Integer, int[]> map = new HashMap<Integer, int[]>() {
			{
				put(3, new int[] { 3, 8, 9, 7, 6 });
				put(1, new int[] { 0, 0, 0 });
				put(4, new int[] { 1, 2, 3, 4 });
				put(5, new int[] { 1000 });
				put(2, new int[] { 1000,2000 });
				put(42, new int[] { 1, 1, 2, 3, 5 });
			};
		};

		for (Map.Entry<Integer, int[]> entry : map.entrySet()) {
			System.out.println(Arrays.toString(entry.getValue()) + "\t" + "K=" + entry.getKey() + "\t"
					+ Arrays.toString(solution(entry.getValue(), entry.getKey())));
		}

	}

	public static int[] solution(int[] A, int K) {
		
		if (A == null || A.length ==0)
			return A;

		int[] result = new int[A.length];

		if (K > A.length) {
			K = K % A.length;
		}

		for (int i = 0; i < A.length; i++) {

			int index = K + i;

			if (index < A.length) {
				result[index] = A[i];
			} else {
				index = K - (A.length - i);
				result[index] = A[i];
			}
		}

		return result;
	}
}