package application;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		File dir = new File("G:\\Learning\\Simplilearn\\Assessments\\locked-me\\src\\file_dir");
		if (!dir.exists()) dir.mkdirs();
		
		String choice = "";
		Scanner sc = new Scanner(System.in);

		while (!choice.equals("5")) {
			System.out.println("===== MENU =====");
			System.out.println("1. List all files");
			System.out.println("2. Add a file");
			System.out.println("3. Delete a file");
			System.out.println("4. Search for a file");
			System.out.println("5. Exit");
			System.out.println();
			System.out.print("* Your choice: ");
			choice = sc.nextLine();
			System.out.println();
			
			switch(choice) {
				case "1": {
					System.out.println("Files residing in the directory:");
					System.out.println("******************************");
					for(var f : dir.list()) {
						System.out.println(f);
					}
					System.out.println();
					break;
				}
				case "2": {
					System.out.print("Enter the filename with extension you want to add: ");
					String filename = sc.nextLine();
					File file = new File(dir + "\\" + filename);
					if(!file.exists()) {
						try {
							file.createNewFile();
							System.out.println("File created successfully...");
						} catch(Exception e) {
							System.out.println("Some error occured...");
						}
					}
					else
						System.out.println("File already present...");
					System.out.println();
					break;
				}
				case "3": {
					System.out.print("Enter the filename with extension you want to delete: ");
					String filename = sc.nextLine();
					File file = new File(dir + "\\" + filename);
					if(file.exists()) {
						try {
							file.delete();
							System.out.println("File deleted successfully...");
						} catch(Exception e) {
							System.out.println("Some error occured...");
						}
					}
					else
						System.out.println("File not present...");
					System.out.println();
					break;
				}
				case "4": {
					System.out.print("Enter the filename with extension you want to search: ");
					String filename = sc.nextLine();
					File file = new File(dir + "\\" + filename);
					if(file.exists()) {
						System.out.println(file.getAbsolutePath());
						System.out.println("*********************");
						try {
							Files
								.readAllLines(Paths.get(file.getAbsolutePath()))
								.stream()
								.forEach(System.out::println);
						} catch (IOException e) {
							System.out.println("An error occured...");
						}
					}
					else
						System.out.println("File not present...");
					System.out.println();
					break;
				}
				case "5": {
					System.out.println("Successfully exited...");
					break;
				}
				default: {
					System.out.println("Invalid choice! Please try again...");
					System.out.println();
				}
			}
		}

		sc.close();

	}

}
