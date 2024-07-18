package stringPractice;

public class FindFirstNonRepeatedCharacter {

	
	public static Character getFirstNonRepeatedChar(String s) {
		char ch;
		for(int i=0;i<s.length();i++) {
			ch = s.charAt(i);
			if(s.indexOf(ch)==s.lastIndexOf(ch)) 
				return ch;	
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(getFirstNonRepeatedChar("qweewretqrt"));
	}
}
