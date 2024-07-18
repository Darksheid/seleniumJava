package stringPractice;

import java.util.HashMap;
import java.util.HashSet;

public class CountOccurenceOfWordInString {
	
	public static HashMap<String, Integer> countWords(String s){
		s= s.toLowerCase();
		int count=0;
		HashMap<String, Integer> mymap = new HashMap<>();
		HashSet<String> set = new HashSet<>();
		String[] arr = s.split(" ");
		for(String word : arr) {
			if(!set.contains(word))
				set.add(word);
		}
		
		for(String distinctWord : set ) {
			count=0;
			for(String allWords : arr)
				if(distinctWord.equals(allWords))
					count++;
			mymap.put(distinctWord, count);
		
		}
		return mymap;
	}
	
	public static void main(String[] args) {
		HashMap<String, Integer> map = countWords("My name is Tanmoy Roy");
		for(String word : map.keySet())
			System.out.println("'"+word + "' occurance count : "+ map.get(word));
	}

}
