package javatest.collections.collectionspractice;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ArrayListWithoutTTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		java.util.List l = new ArrayList();
		l.add(1);
		int x = (int) l.get(0);
		System.out.println(x);

//		List<? extends Number> nlist = new ArrayList<Integer>();
//		
//		nlist.add((Number)Integer.valueOf(5));

//		System.out.println(nlist);

		ArrayList<b> t3 = new ArrayList<b>();
		t3.add(new ia());
		t3.iterator();
		m1(t3);
		
	}

	static void m1(List<? extends b> t3) {

	}

}

interface b {
}

class ia implements b {

}

class ib implements b {

}