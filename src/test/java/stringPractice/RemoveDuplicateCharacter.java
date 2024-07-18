package stringPractice;

import java.util.HashSet;

public class RemoveDuplicateCharacter {

	public static void removeDuplicateChars(String s) {
		String newString = new String("");
		for(int i= 0;i<s.length();i++) {
			String ch =s.charAt(i)+"";
			if(!newString.contains(ch)) 
				newString=newString+ch;
		}
		
		System.out.println(newString);
	}
	
	public static void main(String[] args) {
		removeDuplicateChars("bjkwbjbfjbfdjbkldbvhckjsabnckasnxsjoabxkjab");
	}
	
}
