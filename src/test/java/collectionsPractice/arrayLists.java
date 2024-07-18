package collectionsPractice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class arrayLists extends baseClass{
/// can accept duplicate values //ArraList,LinkedList,vector-
	//Implementing List interface //array have fixed size where as arraylist can grow dynamically //you can access and insert any value in any index 
	/*---------------------------------------------------------------------ArrayLists---------------------------------------------------------------------
	 * ARRAYLISTS--------IMPLEMENTS---------->LISTS----------------EXTENDS------------------>COLLECTION(INTERFACE)
	 * 
	 * Declare --->	Arrays can be created with primitive data types and Objects,		ArrayLists can be created with Objects only
	 * SIZE    ---> Arrays has fixed size,cannot be changed,							Array list has flexible/changeable size
	 * Values  ---->Arrays Can accept duplicate values									ArrayList can accept duplicate values
	 * Addition--->	Array new element cannot be added to any index of the list, 		Array list new element can be added to any position/index of the list
	 * Deletion--->	Array any element cannot be deleted from the list, 					Array list any element can be deleted from any position/index of the list
	 * Access----->	Array time complexity of access O(1)								ArrayList Time Complexity is O(n)	
	 * 
	 	Complexity of Java ArrayList
	  
		Operation 								Time Complexity						Space Complexity
	
		Inserting Element in ArrayList			O(1)								O(N)
		Removing Element from ArrayList			O(N)								O(1)
		Traversing Elements in ArrayList		O(N)								O(N)
		Replacing Elements in ArrayList			O(1)								O(1)
	
	ArrayList in Java is a class in the Java Collection framework that implements the List interface. 
	Here are the advantages and disadvantages of using ArrayList in Java.
	
	ADVANTAGES
	**Dynamic size: ArrayList can dynamically grow and shrink in size, making it easy to add or remove elements as needed.
	**Easy to use: ArrayList is simple to use, making it a popular choice for many Java developers.
	**Fast access: ArrayList provides fast access to elements, as it is implemented as an array under the hood.
	**Ordered collection: ArrayList preserves the order of elements, allowing you to access elements in the order they were added.
	**Supports null values: ArrayList can store null values, making it useful in cases where the absence of a value needs to be represented.
	
	Disadvantages of Java ArrayList
	**Slower than arrays: 		ArrayList is slower than arrays for certain operations, such as inserting elements in the middle of the list.
	
	**Increased memory usage: 	ArrayList requires more memory than arrays, as it needs to maintain its dynamic size and handle resizing.
	
	**Not thread-safe: 			ArrayList is not thread-safe, meaning that multiple threads may access and modify the list concurrently, 
								leading to potential race conditions and data corruption.
								
	**Performance degradation: 	ArrayList’s performance may degrade as the number of elements in the list increases, 
							   	especially for operations such as searching for elements or inserting elements in the middle of the list.
	
	Conclusion
	Points to be remembered from this article are mentioned below:
	**ArrayList is the part of Collection framework. It inherits the AbstractList class and implements the List interface.
	**ArrayList is the implementation of a dynamic array.
	**ArrayList can be initialized used using different constructor types like without parameters, passing collection as a parameter, and passing integer as a parameter.
	**Operations can be performed in ArrayList as follows Adding, removing, iterating, and sorting.
	
	 */
	public static Scanner sc;
	public static ArrayList<Integer> mylist;
	public static int arrayLength;


	public static void addElementToList() {
		mylist = new ArrayList<Integer>();
		sc = new Scanner(System.in);
		System.out.println("Enter The length of the array : ");
		arrayLength = sc.nextInt();
		System.out.println("Enter the array elements : ");
		for (int i = 0; i < arrayLength; i++) {
			mylist.add(sc.nextInt());
		}
		System.out.println("The array list :");
		System.out.println(mylist);
	}

	public static void addElementAtLastIndex() {
		try {
			System.out.println("Enter the new array element : ");
			Integer newElement = sc.nextInt();
			System.out.println("The new array list :");
			System.out.println(mylist);
			mylist.add(newElement);
		} catch (Exception e) {
			System.out.println("New Element NOT added to the Array List");
		}
	}

	public static void sortArrayList(String order) {
		ArrayList<Integer> newList = new ArrayList<Integer>();
		System.out.println("Sorting arraylist....in " + order);
		try {
			Collections.sort(mylist);

			if (order.equalsIgnoreCase("reverse"))
				for (int i = mylist.size() - 1; i >= 0; i--)
					newList.add(mylist.get(i));
			else
				newList = mylist;

			System.out.println("Sorted List : ");
			System.out.println(newList);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteElementFromPosition(int n) {
		if (n < mylist.size() && n > 0) {
			System.out.println("Removing element from position " + n);
			mylist.remove(n - 1);
			System.out.println("New list :");
			System.out.println(mylist);
		} else {
			System.out.println("Element to be removed should range between index :1 to " + mylist.size());
		}
	}

	public static void setNewElementAtIndex(int n, int newElement) {
		if (n <= mylist.size() && n > 0) {
			System.out.println("Setting new element " + newElement + " at position " + n);
			mylist.add(n, newElement);
			;
			System.out.println("New list :");
			System.out.println(mylist);
		} else {
			System.out.println("Element to be added should range between index :1 to " + (mylist.size() + 1));
		}
	}

	public static void main(String[] args) {
		int[] array = { 1, 2, 3, 4 };
		// int[] newArr = array+{6,7} cannot do this as array size is fixed,stores
		// primitives int,char
		// Arraylist = size is flexible,stores Objects Integer,String
		addElementToList();
		// addElementAtLastIndex(mylist);
		// sortArrayList("reverse");
		// sortArrayList("ascending");
		// deleteElementFromPosition(3);
		setNewElementAtIndex(5, 10); // index to lie between 1 to list.size()
		printCollections(mylist);
	}

}
