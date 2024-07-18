package playground;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.LinkedList;
import java.util.ArrayList;

public class test {
	
	public static void myTests() {
		
		double integer = new Integer(2);
		//int num = integer;   not possible as we are trying to pour value of integer ,which is double type, to int num//need larger container 
		int num = (int)integer;
		System.out.println(integer);
		
	}
	
	public static void main(String[] args) {
		//myTests();
		int[] arr1 = {1,2,3,4};
		System.out.print("Array...");
		for (Integer i : arr1)
			System.out.print(i);
		List<Integer> arr2 = new ArrayList<Integer>();
		for(int i=12;i<=20;i++)
			arr2.add(i);
		System.out.print("Arraylist...");
		for (Integer i : arr2)
			System.out.print(i+" ");
		
		System.out.println("Linkedlist...");
		List<Integer> arr3 = new LinkedList<Integer>();
		for(int i=12;i<=20;i++)
			arr3.add(i);
		for (Integer i : arr2)
			System.out.print(i);
		
		
		
	}

}
