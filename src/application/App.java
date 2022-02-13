package application;

import java.io.File;
import java.util.Scanner;

import shared.Constants;
import util.FileOperations;
import util.Helper;

public class App {

	public static void main(String[] args) {
		
		File base_dir = new File(Constants.BASE_DIR_ADDRESS);
		if (!base_dir.exists()) base_dir.mkdir();
		
		String choice = "";
		Scanner sc = new Scanner(System.in);

		while (!choice.equals("5")) {
			Helper.displayMenu();
			choice = Helper.getValidUserInput(sc);
			System.out.println();
			
			switch(choice) {
				case "1": {
					FileOperations.listFiles(base_dir);
					System.out.println();
					break;
				}
				case "2": {
					FileOperations.addFile(base_dir, sc);
					System.out.println();
					break;
				}
				case "3": {
					FileOperations.deleteFile(base_dir, sc);
					System.out.println();
					break;
				}
				case "4": {
					FileOperations.searchFile(base_dir, sc);
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
