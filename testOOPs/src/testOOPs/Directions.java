package testOOPs;

public enum Directions {

	NORTH(0), SOUTH(3), EAST(1), WEST(2);

	int index;

	Directions(int i) {
		this.index = i;
		System.out.println(i);
	}

	static {
		System.out.println("from sib");
	}
	{
		System.out.println("from ib");
	}

	public int getIndex() {
		return this.index;
	}
}
