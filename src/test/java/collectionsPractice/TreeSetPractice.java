package collectionsPractice;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetPractice {

	void print_Contents_Increasing_Order(LinkedHashSet<Integer> s)
    {
	    Set<Integer> newSet = new TreeSet<Integer>();
	    for (Integer integer : newSet) {
			
		}
	    for(Integer integer : newSet)
	        System.out.print(integer+" ");
    }
	
	public static Set synchronizedSet(Set<?> myset ){
		
		return  Collections.synchronizedSet(myset);
	}

	
}
