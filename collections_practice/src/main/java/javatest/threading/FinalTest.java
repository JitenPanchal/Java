package javatest.threading;

import java.util.ArrayList;
import java.util.List;

public class FinalTest {

	final int x;
	final List<String> list;
	
	public FinalTest() {
		x  = 6;
		list = new ArrayList<>();
		list.add("ffff");
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		FinalTest f  = new FinalTest();
		
		System.out.println(f.x);
		System.out.println(f.list);
	}

}
