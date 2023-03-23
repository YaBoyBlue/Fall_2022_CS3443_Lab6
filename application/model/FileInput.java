package application.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FileInput {

	public static ArrayList<String> getContent(String fileName) {
		Scanner scanner;
		File file = new File(fileName);		
		
		ArrayList<String> arrayList = new ArrayList<String>();
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : Person.java - pickActivity() : File not found...");
			return arrayList;
		}
		
		while (scanner.hasNextLine()) {
			arrayList.add(scanner.nextLine());
		}
		
		scanner.close();
		
		return arrayList;
	}
	
	public static ArrayList<ArrayList<String>> getContent(String fileName, String delimiter) {
		Scanner scanner;
		File file = new File(fileName);		
		
		ArrayList<ArrayList<String>> arrayList = new ArrayList<ArrayList<String>>();
		
		try {
			scanner = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("ERROR : Person.java - pickActivity() : File not found...");
			return arrayList;
		}
		
		while (scanner.hasNextLine()) {
			ArrayList<String> line = new ArrayList<String>();
			
			line.addAll(Arrays.asList(scanner.nextLine().split(delimiter)));
			
			arrayList.add(line);
		}
		
		scanner.close();
		
		return arrayList;
	}
}
