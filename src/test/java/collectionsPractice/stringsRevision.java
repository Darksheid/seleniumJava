package collectionsPractice;

public class stringsRevision {

	/*
	 * Strings are objects that represent sequence of character
	 * 
	 */

	public static void main(String[] args) {
		String s1 = "Your name";
		String s2 = "Your name";
		System.out.println(s1 == s2);

		// in the avobe example the s1 points to "your name" value is memory,
		// when we declare String s2 ="your name"; the s2 will be pointing to same memory
		// thus s1==s2 will return as true

		String s3 = new String("text");
		String s4 = new String("text");
		System.out.println(s3 == s4);

		// in the avobe example the String s3 = new String("text"); a new object of string class will be created in memory,
		// when we declare String s4 = new String("text"); again a new object of string class will be created in memory, different location than that of what s3 is pointing
		// thus s1==s2 will return as false

		s3.length();								//retruns length of the string
		s3.charAt(0);								//retruns characater at the specific position
		s3.compareTo(s2);							//The result is a negative integer if this String object lexicographically precedes the argument string. 
													//The result is a positive integer if this String object lexicographically follows the argument string.
													//The result is zero if the strings are equal; compareTo returns 0 exactly when the equals(Object) method would return true. 
		s3.compareToIgnoreCase(s2);
		s3.contains("e");						
		s3.indexOf("t");							//returns the first index of the character
		s3.lastIndexOf("t");						//retruns last index of the character
		s3.replace("t", " ");						//replaces a char with another character
		s3.trim();									//trim whitespaces and extra spaces
		s3.toLowerCase();
		s3.toUpperCase();
		s3.split("e");					

	}

}
