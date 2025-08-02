package playground;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

// Write your code below.
//

class EncryptDecryptFile {
	public void writeDecryptionFile(String message) throws IOException {
		String filePath = Solution.filepath + "DecryptionFile.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
		writer.write(message);
		writer.close();

	}

	public String readEncryptionFile() throws IOException {
		String res = "";
		String filePath = Solution.filepath + "EncryptionFile.txt";
		BufferedReader br = new BufferedReader(new FileReader(filePath));
		String line = "";
		while ((line = br.readLine()) != null) {
			res += line;
		}
		br.close();
		return res;
	}

}

public class Solution {

	public static String filepath = "F:\\Projects\\revision\\";

	private static String generateString() {
		char[] chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890".toCharArray();
		StringBuilder generatedString = new StringBuilder(20);
		Random random = new Random();
		for (int i = 0; i < 40; i++) {
			char c = chars[random.nextInt(chars.length)];
			generatedString.append(c);
		}
		System.out.println("generatedString.toString()" + generatedString.toString());
		return generatedString.toString();
	}

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		String message = sc.nextLine();

		try {
			EncryptDecryptFile f = new EncryptDecryptFile();

			String encryptFilename = Solution.filepath + "EncryptionFile.txt";
			System.out.println(encryptFilename);
			String generatedString = generateString();
			BufferedWriter writer = new BufferedWriter(new FileWriter(encryptFilename));
			writer.write(generatedString);
			writer.close();

			if (f.readEncryptionFile().equals(generatedString)) {
				f.writeDecryptionFile(message);

				String decryptFilename = Solution.filepath + "DecryptionFile.txt";
				BufferedReader reader = new BufferedReader(new FileReader(decryptFilename));
				String messageFromFile = reader.readLine();
				reader.close();

				System.out.println(messageFromFile);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}

	}

}