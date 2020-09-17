package javatest.collections.collectionspractice;

import java.util.Arrays;
import java.util.Collections;

public class DefaultInterfaceMethodeTest {
	public static void main(String[] args) {
		
		DefaultInterfaceMethode t = new DefaultInterfaceMethode() {

			@Override
			public String getName() {
				return "Jiten Panchal";
			};
		};
		
		Collections.unmodifiableList(Arrays.asList(""));
		
		
		DefaultInterfaceMethode t2 = new DefaultInterfaceMethode() {};
		
		System.out.println(t.getName());
		System.out.println(t2.getName());
	}
	

}

