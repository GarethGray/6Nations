/**
 * 
 */
package uk.ac.qub.SixNationsProject;

/**
 * @author Kathy
 *
 */
import java.util.Scanner;

public class MenuDisplay {

	public static void main(String[] args) {
		// declare var for user input
		int choice = 0;

		// set up the scanner
		Scanner scanner = new Scanner(System.in);
		try {
			do {
				System.out.println("Welcome to the Team November Rugby Six Nations Tournament Manager!");
				System.out.println("Please select from the following options:");
				System.out.println("1. Generate the fixtures and rounds for a tournament");
				System.out.println("2. Input the scores for the fixtures of a round in a tournament");
				System.out.println("3. Input the scores for a full tournament via a text file");
				System.out.println("4. Print out a tournament, with all its fixtures, scores and points");
				System.out.println("5. Search through the database of past tournaments");
				System.out.println("6. Exit the Team November Rugby Six Nations Tournament Manager");
				System.out.println("Enter option...");
				choice = scanner.nextInt();

				if (choice != 6) {
					handleInput(choice);

				}

			} while (choice != 6);
			System.out.println("Thank you for using the Team November Rugby Six Nations Tournament Manager");
		} catch (Exception exception) {
			System.out.println("We have a problem! ");
		}
	}

	private static void handleInput(int choice) {

		switch (choice) {
		
		case 1:
			
			break;
			
		case 2:
			
			break;
			
		case 3:
			
			break;
			
		case 4:
			
			break;
			
		case 5:
			
			break;
			
		case 6:
		
		break;
		

		}

	}
}
