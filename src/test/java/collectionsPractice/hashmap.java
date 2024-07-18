package collectionsPractice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*--------------------------------------------------------------HashMaps--------------------------------------------------------------------
 * Java HashMap class implements the Map interface which allows us to store key and value pair, 
 * where keys should be unique. If you try to insert the duplicate key, it will replace the element of the corresponding key. 
 * It is easy to perform operations using the key index like updation, deletion, etc. HashMap class is found in the java.util package.
 * 
 * HashMap in Java is like the legacy Hashtable class, but it is not synchronized. It allows us to store the null elements as well, but there should be only one null key. 
 * Since Java 5, it is denoted as HashMap<K,V>, where K stands for key and V for value. It inherits the AbstractMap class and implements the Map interface.
 * 
 * Points to remember:
 * 
 * Java HashMap contains values based on the key.
 * Java HashMap contains only unique keys.
 * Java HashMap may have one null key and multiple null values.
 * Java HashMap is non synchronized.
 * Java HashMap maintains no order.
 * The initial default capacity of Java HashMap class is 16 with a load factor of 0.75.
 * No Duplicate Key on HashMap : You cannot store duplicate keys in HashMap. 
 * 		However, if you try to store duplicate key with another value, it will replace the value.
 * 
 * Load Factor
 * The Load Factor is a threshold, if the ratio of the current element by initial capacity crosses this threshold then the 
 * capacity increases so that the operational complexity of the HashMap remains O(1).
 * The meaning of operational complexity of O(1) means the retrieval and insertion operations take constant time.
 * The default load factor of a HashMap is 0.75f.
 * 
 * How do we decide when to increase the capacity?
 * Let us take an example, since the initial capacity by default is 16, consider we have 16 buckets right now.
 * We insert the first element, the current load factor will be 1/16 = 0.0625. Check is 0.0625 > 0.75 ? The answer is No, therefore we don’t increase the capacity.
 * Next we insert the second element, the current load factor will be 2/16 = 0.125. Check is 0.125 > 0.75 ? The answer is No, therefore we don’t increase the capacity.
 * Similarly, for 3rd element, load factor = 3/16 = 0.1875 is not greater than 0.75, No change in the capacity.
 * 4th element, load factor = 4/16 = 0.25 is not greater than 0.75, No change in the capacity.
 * 5th element, load factor = 5/16 = 0.3125 is not greater than 0.75, No change in the capacity.
 * 6th element, load factor = 6/16 = 0.375 is not greater than 0.75, No change in the capacity.
 * 7th element, load factor = 7/16 = 0.4375 is not greater than 0.75, No change in the capacity.
 * 8th element, load factor = 8/16 = 0.5 is not greater than 0.75, No change in the capacity.
 * 9th element, load factor = 9/16 = 0.5625 is not greater than 0.75, No change in the capacity.
 * 10th element, load factor = 10/16 = 0.625 is not greater than 0.75, No change in the capacity.
 * 11th element, load factor = 11/16 = 0.6875 is not greater than 0.75, No change in the capacity.
 * 12th element, load factor = 12/16 = 0.75 is equal to 0.75, still No change in the capacity.
 * 13th element, load factor = 13/16 = 0.8125 is greater than 0.75, at the insertion of the 13th element we double the capacity.Now the capacity is 32.
 * 
 */

public class hashmap extends baseClass {
	
	public static HashMap<Integer, String> mymap ;
	
	public hashmap() {
		mymap = new HashMap<Integer,String>();
		mymap.put(3, "Subaru");
		mymap.put(4, "Me");
		mymap.put(1,"Ram");								//puts value to the hashmap
		mymap.put(2,"Rem");
		
	}
	
	
	public static void main(String[] args) {
		new hashmap();
		Map<Integer,String> mytree = new TreeMap<>();
		//printCollections(mymap);
		mymap.get(1);									//Get the value associated to the key passed;
		mymap.isEmpty();								//Returns boolean value for empty :true , else false
		Set<?> keys =  mymap.keySet();					//return the Set<?> of keys 
		System.out.println(keys);
		
		System.out.println(mymap.values());
		mymap.replace(4, "Tanmoy");						//It replaces the specified value for a specified key.
		mymap.remove(3);
		for (Integer ele : mymap.keySet()) 
			mytree.put(ele, mymap.get(ele));
		//printCollections(mytree);
		printCollections(mymap);
		
	}
	
	

}
