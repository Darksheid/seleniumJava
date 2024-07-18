package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelFunctions {

	public String get_cell_value_from_driver_excel(String row_name, String col_name) {
		String res;
		try {
			int i,j;
			FileInputStream fis=new FileInputStream("./src/test/java/testdata/DriverExcel.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook(fis); 
			XSSFSheet sheet = wb.getSheet("Testdata");
			int row_num=sheet.getPhysicalNumberOfRows();
			int col_num = sheet.getRow(0).getPhysicalNumberOfCells();
			
			for(i=1;i<row_num;i++) {
				if(sheet.getRow(i).getCell(0).toString().trim().equals(row_name)) {
					//System.out.println("row_name>>"+row_name+" found at : "+i+" row");
					break;
				}
			}
			
			for(j=1;j<col_num;j++) {
				if(sheet.getRow(0).getCell(j).toString().trim().equals(col_name)) {
					//System.out.println("col_name>>"+col_name+" found at : "+j+" column");
					break;
				}
			}
			
			res=sheet.getRow(i).getCell(j).toString().trim();
			
			return res;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}  
		
	}
	
	public static void main(String[] args) {
		excelFunctions excelFunctions = new excelFunctions();
		String value = excelFunctions.get_cell_value_from_driver_excel("TC01", "url");
		System.out.println("Value : "+value);
	}


	
}
