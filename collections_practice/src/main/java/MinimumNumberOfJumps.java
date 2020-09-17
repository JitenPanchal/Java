import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfJumps {

	public static void main(String[] args) {
		@SuppressWarnings("serial")
		List<InputInfo> inputInfoList = new ArrayList<InputInfo>() {
			{
				add(new InputInfo(10, 85, 30));
				add(new InputInfo(10, 20, 1));
				add(new InputInfo(10, 10, 1));
				add(new InputInfo(10, 10, 10));
				add(new InputInfo(10, 11, 10));
				add(new InputInfo(10, 60, 3));
				add(new InputInfo(10, 11, 50));
				
				add(new InputInfo(3, 999111321, 7));
				
			}
		};

		for (InputInfo inputInfo : inputInfoList) {
			System.out.println(inputInfo + "\t" + solution(inputInfo.X, inputInfo.Y, inputInfo.D));
		}

	}

	public static int solution(int X, int Y, int D) {
//		if (X == Y)
//			return 0;
//
//		int counter = 0;
//
//		int progress = X;
//		while (true) {
//			progress = progress + D;
//			counter++;
//			if (progress >= Y)
//				break;
//		}
//
//		return counter;
		
		int result = (Y - X)/D;
		if ((Y-X) % D > 0) {
			return result + 1;
		}
		return result;
		
//		X = 10	Y=85	D=30	3
//		X = 10	Y=20	D=1	10
//		X = 10	Y=10	D=1	0
//		X = 10	Y=10	D=10	0
//		X = 10	Y=11	D=10	1
//		X = 10	Y=60	D=3	17
//		X = 10	Y=11	D=50	1
//		X = 3	Y=999111321	D=7	142730189
		
		
	}
}

class InputInfo {
	public int X;
	public int Y;
	public int D;

	public InputInfo(int x, int y, int d) {
		super();
		X = x;
		Y = y;
		D = d;
	}

	@Override
	public String toString() {
		return "X = " + X + "\t" + "Y=" + Y + "\t" + "D=" + D;
	}

}
