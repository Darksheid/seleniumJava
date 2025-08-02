import java.math.BigDecimal;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Persons {
	int id;
	String gender;

	public Persons(int id, String gender) {
		this.id = id;
		this.gender = gender;
	}

}

public class ArrayPractice {

	public static boolean isAnagaram(String s1, String s2) {
		System.out.println(s1 + " " + s2);
		s1 = s1.toLowerCase();
		s2 = s2.toLowerCase();
		if (s1.length() != s2.length())
			return false;
		for (int i = 0; i < s1.length(); i++) {
			char ch = s1.charAt(i);
			int countOfCharS1 = 0;
			int countOfCharS2 = 0;
			for (int j = 0; j < s1.length(); j++) {
				if (s1.charAt(j) == ch)
					countOfCharS1 += 1;
				if (s2.charAt(j) == ch)
					countOfCharS2 += 1;
			}
			if (countOfCharS1 != countOfCharS2)
				return false;
		}
		return true;
	}

	public static void main(String[] args) {
		// IntStream.range(1, 10).map(e -> e * e).forEach(e -> System.out.println(e));
		IntStream.range(1, 10).map(e -> e * e).boxed().collect(Collectors.toList());
		BigDecimal bd = new BigDecimal(10);

	}

}
