package utilities;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CSVutilities {
	
	public String headerLine;
	
	public ArrayList<HashMap<String,String>> readfromCSVasMap(String delimiter,String filePath,boolean isHeaderPresent) throws Throwable {
		ArrayList<HashMap<String,String>> list = new ArrayList<>();
		File file = new File(filePath);
		int counter=0;
		try {
			Scanner sc = new Scanner(file);
			System.out.println("Reading the File at : "+filePath);
			while(sc.hasNextLine()) {
				HashMap<String,String> map = new HashMap<>();
				String rowData = sc.nextLine().toString().trim();
				if(isHeaderPresent && counter==0) {
					headerLine=rowData;
				}else {
					headerLine = configurations.getValue("header");
					
				}
				String[] th = headerLine.split(delimiter);
				String[] tr = rowData.split(delimiter);
				int index=0;
				for(String key : th) 
					map.put(key, tr[index++]);
	
				list.add(map);
			}
			sc.close();
			return list;
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	public static void main(String[] args) throws Throwable {
		CSVutilities csv = new CSVutilities();
		ArrayList<HashMap<String,String>> myList = csv.readfromCSVasMap("\\|", "F:/Selenium Training and Notes/Selenium/EgleEyePromo.csv", false);
		
		for (HashMap<String , String> map : myList) {
			for(String key : map.keySet()) {
				System.out.print(key + " : "+ map.get(key)+",");
			}
			System.out.println("");
		}
	}

}
