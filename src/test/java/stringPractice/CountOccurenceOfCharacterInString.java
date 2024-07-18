package stringPractice;

import java.util.HashMap;
import java.util.HashSet;

public class CountOccurenceOfCharacterInString {
	
	public static HashMap<Character, Integer> getCount(String s) {
		int i=0;
		int count =0;
		HashMap<Character, Integer> mapOfCount = new HashMap<>();
		HashSet<Character> myset = new HashSet<Character>();
		for(i =0;i<s.length();i++) {
			char ch = s.charAt(i);
			if(!myset.contains(ch))
				myset.add(ch);
		}
		
		System.out.println(myset);
		
		for(Character ch : myset) {
			count=0;
			for(i=0;i<s.length();i++) {
				if(ch.equals(s.charAt(i)))
					count++;
			}
			mapOfCount.put(ch, count);
		}
		
		return mapOfCount;
	
	}
	
	public static void main(String[] args) {
		HashMap<Character, Integer> map = getCount("gdeifgeiug");
		for(Character ch : map.keySet())
			System.out.println(ch +" has count : " + map.get(ch));
	}

}
