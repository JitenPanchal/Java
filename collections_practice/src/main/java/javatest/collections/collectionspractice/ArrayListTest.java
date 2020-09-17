package javatest.collections.collectionspractice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;

public class ArrayListTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		ArrayList<String> list = new ArrayList<String>();
		 
        list.add("JAVA");
 
        list.add("J2EE");
 
        list.add("JSP");
 
        list.add("SERVLETS");
 
        list.add("STRUTS");
 
//        System.out.println(list);  
        
        String[] arr = new String[list.size()];
        list.toArray(arr);
        
        System.out.println(Arrays.toString(arr));
        
//        Collections.unmodifiableCollection(list);
//        
        Collections.synchronizedList(list);
        
        Iterator<String> iterator = list.iterator();
        
        while (iterator.hasNext())
        {
            String value = iterator.next();
            
            if (value.equalsIgnoreCase("java") || value.equalsIgnoreCase("STRUTS"))
            	iterator.remove();
        }
        
		System.out.println(list);

	}

}
