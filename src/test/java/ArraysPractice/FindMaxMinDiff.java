package ArraysPractice;

import java.util.Arrays;

public class FindMaxMinDiff {
	
	public static int getMaxMinDiff(int[] arr) {
		Arrays.sort(arr);
		return ( Math.abs( (arr[0] - arr[arr.length - 1]) ) );
	}
	
	public static void main(String[] args) {
		int[] arr = {45,23,67,89,1,98,34,};
		System.out.println(getMaxMinDiff(arr));
	}

}
