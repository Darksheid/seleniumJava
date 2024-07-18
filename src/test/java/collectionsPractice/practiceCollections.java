package collectionsPractice;

import java.util.HashSet;

/*
 * print unique numbers and the count present in list/array
 * a =[1,1,2,2,2,2,3,3,3,4,4,4,4,4,5,5,6,7]
 *  1-2 ,	2-4, 3-3 , 4-5, 5-2, 6-1,7-1
 */

public class practiceCollections {
	
	
	public static int count(Integer num, int[] arr) {
		int n =0;
		for(int i : arr) 
			if(num==i)
				n++;
		return n;
	}
		
	public static void main(String[] args) {
	int[] a= {1,1,2,2,2,2,3,3,3,4,4,4,4,4,5,5,6,7};
	HashSet<Integer> myset = new HashSet<Integer>();
	for (int i : a)
		myset.add(i);
	for(Integer number : myset) 
		System.out.println("Count of "+number+" in array :"+count(number,a));
		
	}
}
