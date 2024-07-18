package stringPractice;

public class ReverseEachWordInAString {

	public static String ReverseEachWord (String s) {
		String res="";
		String[] arr = s.split(" ");
		for(int i=0;i<arr.length;i++) {
			res=res+reverse(arr[i])+" ";
		}
	
		return res.trim();
	}
	
	public static String reverse(String s) {
		String newString="";
		for(int i =s.length()-1;i>=0;i--) 
			newString=newString+s.charAt(i);
		return newString;
	}

	public static void main(String[] args) {
		System.out.println(ReverseEachWord("my name is Tanmoy"));
	}

}
