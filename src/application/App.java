package application;

import java.io.File;
import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		
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
					System.out.println("1");
					break;
				}
				case "2": {
					System.out.println("2");
					break;
				}
				case "3": {
					System.out.println("3");
					break;
				}
				case "4": {
					System.out.println("4");
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
