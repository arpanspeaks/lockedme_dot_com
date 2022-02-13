package util;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileOperations {

	public static void listFiles(File base_dir) {
		
		List<String> filenames = new ArrayList<>();
		List<File> directories = new ArrayList<>();

		for (File f : base_dir.listFiles()) {
			if (f.isDirectory()) directories.add(f);
			else if (f.isFile()) filenames.add(f.getName());
		}

		for (File f : directories) {
			for (String filename : f.list()) {
				filenames.add(filename);
			}
		}

		if (filenames.size() == 0) System.out.println("Empty directory!");
		else {
			System.out.println("File names sorted in alphabetical order:");
			System.out.println("******************************");
			filenames.stream().sorted().forEach(System.out::println);
		}
		
	}

	public static void addFile(File base_dir, Scanner sc) {
		
		System.out.print("Enter the username ");
		String username = Helper.getValidUserInput(sc);
		File dir = new File(base_dir + "\\" + username);
		if (!dir.exists()) {
			dir.mkdir();
			System.out.println(String.format("Directory for the user \"%s\" is created!", username));
		}
		System.out.print("Enter the filename you want to add ");
		String filename = Helper.getValidUserInput(sc);
		File file = new File(dir.getAbsolutePath() + "\\" + filename);
		if (!file.exists()) {
			try {
				file.createNewFile();
				System.out.println("File added successfully...");
			} catch (Exception e) {
				System.out.println("Some error occured...");
			}
		} else System.out.println("File already present...");
		
	}

	public static void deleteFile(File base_dir, Scanner sc) {
		
		System.out.print("Enter the username ");
		String username = Helper.getValidUserInput(sc);
		File dir = new File(base_dir + "\\" + username);
		if (dir.exists()) {
			System.out.print("Enter the filename you want to delete ");
			String filename = Helper.getValidUserInput(sc);
			File file = new File(dir.getAbsolutePath() + "\\" + filename);
			if (file.exists()) {
				try {
					file.delete();
					System.out.println("File deleted successfully...");
				} catch (Exception e) {
					System.out.println("Some error occured...");
				}
			} else System.out.println("File not present...");
		} else System.out.println(String.format("Directory for the user \"%s\" does not exist!", username));
		
	}

	public static void searchFile(File base_dir, Scanner sc) {
		
		System.out.print("Enter the username ");
		String username = Helper.getValidUserInput(sc);
		File dir = new File(base_dir + "\\" + username);
		if (dir.exists()) {
			System.out.print("Enter the filename you want to search ");
			String filename = Helper.getValidUserInput(sc);
			File file = new File(dir.getAbsolutePath() + "\\" + filename);
			if (file.exists()) System.out.println("File is present in the directory...");
			else System.out.println("File not present...");
		} else System.out.println(String.format("Directory for the user \"%s\" does not exist!", username));
		
	}

}
