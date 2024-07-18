package ArraysPractice;

import java.util.ArrayList;
import java.util.List;

public class FindRepeatingElements {

	public static List<Integer> getDuplicateElements(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : arr)
			if (!list.contains(i) && countOf(i,arr)>1)
				list.add(i);
		return list;
	}
	
	public static int countOf(int i,int[] arr) {
		int count =0;
		for(int ele : arr)
			if(ele==i)
				count++;
		return count;
	}
	
	public static void main(String[] args) {
		int[] arr = { 1,1,1,2,2,3,4,5,5,6,6,7};
		System.out.println(getDuplicateElements(arr));
	}
}
