package ArraysPractice;

import java.util.ArrayList;
import java.util.List;

public class CommonElementsInTwoArrays {

	public static List<Integer> getCommonElements(int[] arr1, int[] arr2) {
		List<Integer> list = new ArrayList<>();
		List<Integer> uniqueElementsArr1 = getUniqueElements(arr1);
		List<Integer> uniqueElementsArr2 = getUniqueElements(arr2);
		if (uniqueElementsArr1.size() <= uniqueElementsArr2.size()) {
			for (Integer i : uniqueElementsArr1)
				if (uniqueElementsArr2.contains(i))
					list.add(i);
		} else {
			for (Integer ele : uniqueElementsArr2)
				if (uniqueElementsArr1.contains(ele))
					list.add(ele);
		}

		return list;
	}

	public static List<Integer> getUniqueElements(int[] arr) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i : arr)
			if (!list.contains(i))
				list.add(i);
		return list;
	}

	public static void main(String[] args) {
		int[] arr1 ={1,2,3,4,5,6};
		int[] arr2 = {5,6,7,8,9};
		System.out.println(getCommonElements(arr1 , arr2));
	}

}
