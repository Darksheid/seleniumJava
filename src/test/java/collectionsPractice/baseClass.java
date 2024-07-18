package collectionsPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class baseClass {
	
	public static final void printCollections(List<?>list) {
		System.out.println("The Elements of the ArrayList : ");
		for(Object o : list)
			System.out.print(" "+o+" ");
		System.out.print("\n");
	}
	
	public static final void printCollections(Set<?> myset) {
		System.out.println("The elements of the set :");
		for(Object o : myset)
			System.out.print(" "+o+" ");
		System.out.print("\n");
	}
	
	public static final void printCollections(Map<?, ?> mymap) {
		@SuppressWarnings("unchecked")
		Set<?> keys = mymap.keySet();
		for (Object o : keys)
			System.out.println(o+" : key,  Value : "+ mymap.get(o));
	}
	
	
	

}
