package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
		File base_dir = new File("G:\\Learning\\Simplilearn\\Assessments\\locked-me\\src\\locker_dir");
		if (!base_dir.exists()) base_dir.mkdir();
		
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
					System.out.println("File names sorted in alphabetical order:");
					System.out.println("******************************");
					List<String> filenames = new ArrayList<>();
					List<File> directories = new ArrayList<>();
					
					for(File f : base_dir.listFiles()) {
						if(f.isDirectory()) directories.add(f);
						else if(f.isFile()) filenames.add(f.getName());
					}
					
					for(File f : directories) {
						for(String filename : f.list()) {
							filenames.add(filename);
						}
					}
					
					if(filenames.size() == 0) System.out.println("Empty directory!");
					else filenames.stream().sorted().forEach(System.out::println);
					
					System.out.println();
					break;
				}
				case "2": {
					System.out.print("Enter the username: ");
					String username = sc.nextLine();
					File dir = new File(base_dir + "\\" + username);
					if(!dir.exists()) {
						dir.mkdir();
						System.out.println(String.format("Directory for the user \"%s\" is created!", username));
					}
					System.out.print("Enter the filename with extension you want to add: ");
					String filename = sc.nextLine();
					File file = new File(dir.getAbsolutePath() + "\\" + filename);
					if(!file.exists()) {
						try {
							file.createNewFile();
							System.out.println("File added successfully...");
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
					System.out.print("Enter the username: ");
					String username = sc.nextLine();
					File dir = new File(base_dir + "\\" + username);
					if(dir.exists()) {
						System.out.print("Enter the filename with extension you want to delete: ");
						String filename = sc.nextLine();
						File file = new File(dir.getAbsolutePath() + "\\" + filename);
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
					} else {
						System.out.println(String.format("Directory for the user \"%s\" does not exist!", username));
					}
					
					System.out.println();
					break;
				}
				case "4": {
					System.out.print("Enter the username: ");
					String username = sc.nextLine();
					File dir = new File(base_dir + "\\" + username);
					if(dir.exists()) {
						System.out.print("Enter the filename with extension you want to search: ");
						String filename = sc.nextLine();
						File file = new File(dir.getAbsolutePath() + "\\" + filename);
						if(file.exists()) 
							System.out.println("File is present in the directory...");
						else
							System.out.println("File not present...");
					} else {
						System.out.println(String.format("Directory for the user \"%s\" does not exist!", username));
					}

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
