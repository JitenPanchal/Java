package javatest.collections.collectionspractice;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Set;

public class HashMapTest {

	public static void main(String[] args) {
		
		 //Thread as an anonymous inner class
		Thread t = new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("Keep some task here.....");
            }
        };
        t.start();
 
        //Thread as an anonymous inner class
        new Thread(new Runnable() {
 
            public void run()
            {
                System.out.println("Keep some task here.....");
 
            }
        }).start();
        
		// TODO Auto-generated method stub
		// Creating the HashMap

		HashMap<String, String> map = new HashMap<String, String>();

		// Adding key-value pairs to HashMap

		map.put("ONE", "AAA");

		map.put("TWO", "BBB");

		map.put("THREE", "CCC");

		map.put("FOUR", "DDD");

		map.put("FIVE", "EEE");

		// Printing Key-value pairs

		System.out.println("HashMap Before Remove :");

		Set<Entry<String, String>> keyValueSet = map.entrySet();

		for (Entry<String, String> entry : keyValueSet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}

		System.out.println("------------------");

		// Removes the mapping for the key 'ONE' only if it is currently mapped to 'CCC'

		map.remove("ONE", "CCC");

		// Removes the mapping for the key 'FIVE' only if it is currently mapped to
		// 'EEE'

		map.remove("FIVE", "EEE");

		System.out.println("HashMap After Remove :");

		for (Entry<String, String> entry : keyValueSet) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}

}
