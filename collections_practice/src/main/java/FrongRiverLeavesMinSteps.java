
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FrongRiverLeavesMinSteps {

	public static void main(String[] args) {

		@SuppressWarnings("serial")
		List<InputInfo> input = new ArrayList<InputInfo>() {
			{
				add(new InputInfo(5, new int[] { 11, 1,  4, 2, 3, 5, 4 }));
				add(new InputInfo(5, new int[] { 1,  4, 2, 3, 5, 4 }));
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

		for (int i = 1; i <= X; i++) {

			boolean found = false;
			for (int j = 0; j < A.length; j++) {
				if (A[j] == i) {
					found = true;

					if (j > second) {
						second = j;
					}

					break;
				}
			}

			if (!found)
				return -1;
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

//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;

//public class FrongRiverLeavesMinSteps {
//
//	public static void main(String[] args) {
//
//		@SuppressWarnings("serial")
//		List<InputInfo> input = new ArrayList<InputInfo>() {
//			{
////				add(new InputInfo(5, new int[] { 1, 3, 1, 4, 2, 3, 5, 4 }));
//
//				add(new InputInfo(8, new int[] { 1, 3, 1, 8, 2, 3, 4, 5, 4, 6, 7, 9 }));
//			}
//		};
//
//		for (int i = 0; i < input.size(); i++) {
//			System.out.println(Arrays.toString(input.get(i).A) + "\t" + solution(input.get(i).X, input.get(i).A));
//		}
//	}
//
//	public static int solution(int X, int[] A) {
//
//		if (A == null || A.length == 0)
//			return 1;
//
//		List<IndexInfo> list = new ArrayList<>(A.length);
//
//		for (int i = 0; i < A.length; i++) {
//			list.add(new IndexInfo(i, A[i]));
//		}
//
//		Collections.sort(list, (left, right) -> {
//			return (left.position + left.index) - (right.position + right.index);
//		});
//
//		System.out.println(list);
//
//		int index = Collections.binarySearch(list, new IndexInfo(-1, X));
//
//		if (index < 0)
//			return -1;
//		else
//			return list.get(index).index;
//	}
//
//	static class IndexInfo implements Comparable<IndexInfo> {
//		public int index;
//		public int position;
//
//		public IndexInfo(int index, int position) {
//			super();
//			this.index = index;
//			this.position = position;
//		}
//
//		@Override
//		public String toString() {
//			return "index=" + index + "---" + "position = " + position + "\n";
//		}
//
//		@Override
//		public int compareTo(IndexInfo o) {
//			return this.position - o.position;
//		}
//
//	}
//
//	static class InputInfo {
//		public int X;
//		public int[] A;
//
//		public InputInfo(int x, int[] a) {
//			super();
//			X = x;
//			A = a;
//		}
//
//		@Override
//		public String toString() {
//			return "X = " + X + "\t" + "A = " + Arrays.toString(A);
//		}
//	}
//}