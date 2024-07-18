package stringPractice;

public class removeSpecialCharactersInString {

	public static void main(String[] args){

        String s="@@$$%%%'';;/./ Selenium$$$##KISKSK";
        String replaced=s.replaceAll("[^a-z0-9A-zA-Z]","");
        System.out.println(replaced);
        //Change special character in a string
        String s1="@Praveen";
        String replacement=s1.replace("@","");
        System.out.println(replacement);

    }
}
