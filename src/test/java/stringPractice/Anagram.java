package stringPractice;

import java.util.Arrays;


public class Anagram {
	
	public static boolean isAnagram(String s1, String s2) {
		boolean res=false;
		char[] l1 = s1.toCharArray();
		char[] l2 = s2.toCharArray();
		Arrays.sort(l1);
		Arrays.sort(l2);
		res =Arrays.equals(l1, l2)	;
		return res;
	}
	
	public static void main(String[] args) {
		System.out.println("Is anagaram :: " +isAnagram("text", "extt"));
	}

}
