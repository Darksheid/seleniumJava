package utilities;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.RowFactory;
import org.apache.spark.sql.SparkSession;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructType;

public class csvFileRead {

	public static String filePath = "F:/Selenium Training and Notes/Selenium/EgleEyePromo.csv";

	public static void fileRead2() throws FileNotFoundException {
		List<String[]> tableData = new ArrayList<String[]>();
		String[] tableHeaders = { "type", "transactionid", "storeid", "productid", "barcode", "itemnumbertype",
				"promotionid", "state", "promotionprice", "rewardvalue", "promotiontype", "statedate", "enddate",
				"listgroup", "listdescription", "threshold", "changetype", "qualtype", "sellinguom", "sellinguep",
				"offername", "offermsg", "theme1", "theme2", "theme3", "promocreatedate", "promocreateid",
				"promoapprovaldate", "promoapprovalid", "wasprice", "waswasprice", "intermediateprice",
				"nearlywasprice", "rpmpromodtlid", "rpmpromocompid", "rpmpromocompdispid", "source", "selindicator" };
		tableData.add(tableHeaders);
		File file = new File(filePath);
		Scanner scanner = new Scanner(file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine().toString().trim();
			String[] eachRow = line.split("\\|");
			tableData.add(eachRow);
			 System.out.println(line);
		}
		scanner.close();
	}

	public static void main(String[] args) throws Exception {
		// readFile();
		// readBooksFromCSV();
		//fileRead2();
		// List<String[]> data = fileRead2();
		// for (String[] row : data) {
		// for (String cell : row)
		// System.out.print(cell + "#");
		// System.out.println();
//		Scanner sc = new Scanner(System.in);
//		String line = sc.nextLine().toString().trim();
//		System.out.println(line);
		
	}
		
}

