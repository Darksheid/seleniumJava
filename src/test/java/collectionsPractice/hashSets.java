package collectionsPractice;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;


/*--------------------------------------Notes for HashSets-------------------------------
 * Hashsets contains elements in any order irrespective of the addition sequence
 * Hashsets dont contain duplicate, if duplicate entry is entered then the duplicate element is ignored
 * it contains only the distinct elements ,as defined by set
 */

public class hashSets extends baseClass{
	public static HashSet<Integer> myset;
	public static HashSet<Integer> newset;
	public static ArrayList<Integer> aList;
	public static LinkedList<Integer> lList;
	
	public hashSets() {
		myset = new HashSet<Integer>();
		newset = new HashSet<Integer>();
		aList = new ArrayList<Integer>();
		lList = new LinkedList<Integer>();
		
		aList.add(200);
		aList.add(300);
		
		lList.add(1000);
		lList.add(2000);
		
		myset.add(10);
		myset.add(20);
		myset.add(30);
		myset.add(40);
		newset.add(50);
		newset.add(60);
		newset.add(70);
		newset.add(80);
	}
	
	public static void main(String[] args) {
		new hashSets();
		printCollections(myset);
		//myset.add(e);											Add the elements to the hashsets
		myset.addAll(aList);									//adds collection, arraylist,linkedlist,hashsets to the hashsets
		myset.addAll(lList);
		myset.addAll(newset);
		printCollections(myset);
		System.out.println(myset.contains(100));  				//Checks if an object is present in the set
		System.out.println(myset.containsAll(aList));			//Checks an linkedlist/hashset/arraylist present in the Hashset; 
		myset.equals(myset);									//checks if an hashset has same obejcts of that of a an another Hashset
		System.out.println(myset.isEmpty());					//checks the hash set is empty or not
		//myset.iterator();										//returns a Interator<?> 
		myset.remove(10);										//Removes a specific object
		myset.removeAll(aList);									//Removes collection, arraylist,linkedlist,hashsets from the hashsets
		printCollections(myset);
		System.out.println(myset.size());						//Returns the size of the set
		
	}

}
