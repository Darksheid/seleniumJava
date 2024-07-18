package collectionsPractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class LinkedLists {
	
	/*-------------------------------Notes for Reference-------------------------------
	 *. 
	 * 
	 * Java LinkedList class uses a doubly linked list to store the elements. It provides a linked-list data structure. 
	 * It inherits the AbstractList class and implements List and Deque interfaces.
	 * The important points about Java LinkedList are:
		 * Java LinkedList class can contain duplicate elements.
		 * Java LinkedList class maintains insertion order.
		 * Java LinkedList class is non synchronized.
		 * In Java LinkedList class, manipulation is fast because no shifting needs to occur.
		 * Java LinkedList class can be used as a list, stack or queue.
	*
	* ArrayList and LinkedList both implement the List interface and maintain insertion order. Both are non-synchronized classes.
	* However, there are many differences between the ArrayList and LinkedList classes that are given below.

									ArrayList													LinkedList
	1) ArrayList internally uses a dynamic array to store the elements.					LinkedList internally uses a doubly linked list to store the elements.
																						If any element is removed from the array, all the other elements are shifted in memory.
																						
	2) Manipulation with ArrayList is slow because it internally uses an array. 		Manipulation with LinkedList is faster than ArrayList because it uses a doubly linked list,
																						 so no bit shifting is required in memory.
																						
	3) An ArrayList class can act as a list only because it implements List only.		LinkedList class can act as a list and queue both because it implements List 
																						and Deque interfaces.
																						
	4) ArrayList is better for storing and accessing data.								LinkedList is better for manipulating data.
	
	5) The memory location for the elements of an ArrayList is contiguous.				The location for the elements of a linked list is not contagious.
	
	6) Generally, when an ArrayList is initialized, 									There is no case of default capacity in a LinkedList. 
		a default capacity of 10 is assigned to the ArrayList.							In LinkedList, an empty list is created when a LinkedList is initialized.
			
	7) To be precise, an ArrayList is a resizable array.								LinkedList implements the doubly linked list of the list interface.

	*
	*The following are some important points to remember regarding an ArrayList and LinkedList.
	*
	*When the rate of addition or removal rate is more than the read scenarios, then go for the LinkedList. 
	*On the other hand, when the frequency of the read scenarios is more than the addition or removal rate, then ArrayList takes precedence over LinkedList.
	*
	*Since the elements of an ArrayList are stored more compact as compared to a LinkedList; therefore, the ArrayList is more cache-friendly as compared to the LinkedList.
	*Thus, chances for the cache miss are less in an ArrayList as compared to a LinkedList. 
	*Generally, it is considered that a LinkedList is poor in cache-locality.
	* 
	*Memory overhead in the LinkedList is more as compared to the ArrayList. It is because, in a LinkedList, we have two extra links (next and previous)
	*as it is required to store the address of the previous and the next nodes, and these links consume extra space. Such links are not present in an ArrayList.
	*
	*
	*---------------------------------------------------------------End of Reference--------------------------------------------------------------------------------
	*/

	public static LinkedList<Integer> newlist;
	public static ArrayList<Integer> arr1,arr2;

	public LinkedLists() {
		newlist = new LinkedList<Integer>();
		arr1 = new ArrayList<Integer>();
		arr2 = new ArrayList<Integer>();
		newlist.add(10);
		newlist.add(20);
		newlist.add(30);
		newlist.add(40);
		newlist.add(50);
		arr1.add(70);
		arr1.add(80);
		arr2.add(300);
		arr2.add(400);
	}

	public static LinkedList<Integer> addItemToLinkedList(LinkedList<Integer> mylist, int index, int new_element) {
		try {
			if (index >= 0 && index <= mylist.size()) {
				System.out.println("Adding " + new_element + " at index :" + index);
				mylist.add(index, new_element);
				System.out.println("Addition sucessfull!!!");
			} else
				System.out.println("Index out of bounds,index values must lie between 0 and " + mylist.size());
		} catch (Exception e) {
			System.out.println("Error while adding new elements to list");
		}
		return mylist;

	}

	public static void printList(LinkedList<Integer> list) {
		Iterator<Integer> i = list.iterator();
		System.out.println("Elements of the List :");
		while (i.hasNext())
			System.out.println(i.next());
	}

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		new LinkedLists();
		//printList(newlist);
		//newlist = addItemToLinkedList(newlist, 7, 30);
		//printList(newlist);
		newlist.add(100); 							//adds at last index
		//newlist.add(index, element); 				//adds at last index
		newlist.addAll(arr1); 						// adds all the elements specified at last of the index
		newlist.addAll(5, arr2); 					// This method Inserts all of the elements in the specified collection into this list, starting at the specified position.
		newlist.addFirst(44);
		newlist.addLast(99);

//		newlist.get(7);							//gets the element value of the specified index
//		newlist.getFirst();						//gets the element value of the First index
//		newlist.getLast();						//gets the element value of the last index
//		newlist.isEmpty();
//		newlist.indexOf(o);						//gets the index of a given element in list
//		newlist.lastIndexOf(o);					//gets the last index of a given elements(multiple) in list
//
//		newlist.remove();						//removes the first element/removes the head of the list
//		newlist.removeAll(c);					//Removes all of this collection's elements that are also contained in thespecified collection
//		newlist.removeFirst();					//Removes and returns the first element from this list.
//		newlist.removeLast();					//Removes and returns the last element from this list.
//		newlist.removeFirstOccurrence(o);		//Removes the first occurrence of the specified element in list (when traversing the list from head to tail). 
//												//If the listdoes not contain the element, it is unchanged.
//
//		newlist.iterator();						//Returns an iterator over the elements in this list (in propersequence).
//												//This implementation merely returns a list iterator over the list.
//
//		Collections.sort(newlist);              //sorts the list ascending
		
//		newlist.toArray();						//Returns an array containing all of the elements in this listin proper sequence (from first to last element). 
//		newlist.toString();						//Returns a string representation of this collection. 
	}

}
