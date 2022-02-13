package util;

import java.util.Scanner;

public class Helper {
	
	public static void displayMenu() {
		System.out.println("===== MENU =====");
		System.out.println("1. List all files");
		System.out.println("2. Add a file");
		System.out.println("3. Delete a file");
		System.out.println("4. Search for a file");
		System.out.println("5. Exit\n");
		System.out.print("* Your choice ");
	}
	
	public static String getValidUserInput(Scanner sc) {
		String userInput = "";
		do {
			System.out.print("(Input can't be empty): ");
			userInput = sc.nextLine();
		} while(userInput.trim().equals(""));
		return userInput;
	}

}
