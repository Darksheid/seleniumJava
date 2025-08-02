package playground;

import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.LinkedList;
import java.util.ArrayList;
import java.util.HashMap;

public class test {
	
	public static void myTests() {
		
		double integer = new Integer(2);
		//int num = integer;   not possible as we are trying to pour value of integer ,which is double type, to int num//need larger container 
		int num = (int)integer;
		System.out.println(integer);
		
	}
	
	public static void main(String[] args) {
		//myTests();
		Map map = new HashMap<String,String>();
		
		map.put("1", "TRoy");
		map.put("2", "STendulkar");
		map.put("3", "Kisan");
		
//		System.out.println(map.values());
		int n =3;
		int count=10;
		int[][] arr = new int[3][3]; 
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++)
				arr[i][j] = count++;
		}
		int min=100,minCol=0;
		for (int[] row : arr) {
			for(int cell : row) {
				if (cell<min) {
					min=cell;
				}
			}
		}
		
//		if (map.get("str")==null) {
//			throw new NoSuchElementException("Cannot find the element");
//		}
		
		
			
		
		
		
	}

}
