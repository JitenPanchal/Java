package testOOPs;

public class DirectionsEnumTest {

	public static void main(String[] args) {
		Directions d = Directions.WEST;
		

		System.out.println("******************");
		System.out.println(d.name());
		System.out.println(d.ordinal());
		System.out.println(d.getIndex());
		System.out.println("******************");
		for (int i = 0; i < Directions.values().length; i++) {
			System.out.println((Directions.values()[i]).name() + (Directions.values()[i]).ordinal());
		}
	}

}