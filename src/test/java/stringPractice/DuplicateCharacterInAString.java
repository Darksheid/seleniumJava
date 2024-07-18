package stringPractice;

import java.util.HashSet;


public class DuplicateCharacterInAString {
	
	
	public static HashSet<Character> duplicateChar(String s) {
		HashSet<Character> dupChar = new HashSet<>();
		for(int i=0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(s.indexOf(ch)!=s.lastIndexOf(ch))
				dupChar.add(s.charAt(i));
		}
		System.out.println(dupChar);
		return dupChar;	
	}
	
	public static void main(String[] args) {
		duplicateChar("praveen");
	}

}
