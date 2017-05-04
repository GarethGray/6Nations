/**
 * 
 */
package uk.ac.qub.SixNationsProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 40189322, 40084540
 *
 */
public class Application {

//	/**
//	 * @param args
//	 */
//	public static void main(String[] args) {
//
//		menu();
//	}

	public static void menu() {
		Scanner menuChoice = new Scanner(System.in);
		int choice=0;
		while (choice!=6){
		choice = 0;

		System.out.println("\nWelcome to the Six Nations! Please select an option from the menu:\n");

		System.out.println("1. Create new tournament\n" + "2. Insert match results\n" + "3. View match results\n"
				+ "4. View league table\n" + "5. Search database\n" + "6. Exit\n");

		// user inputs values until a valid value is found
		while (choice < 1 || choice > 6) {
			System.out.println("Please input an integer between 1 and 6.");
			if (menuChoice.hasNextInt()==false){
				menuChoice.next();
			} else {
				choice = menuChoice.nextInt();
			}
		}

		// system returns the number they have chosen
		System.out.println("You have selected choice: " + choice);

		// system uses a switch statement to execute their choice
		switch (choice) {
		
		// if the user selects Create New Tournament, the method
		// Application.Tournament is called
		// and they are prompted to insert the year for a new tournament
		case 1:
			createTournament(menuChoice);
			break;
			
		// if the user selects Insert Match Results, they will be asked how they would prefer to input the results
		case 2:
			selectResultInputMethod(menuChoice);
			break;

		// if the user selects View Match Results, they are asked to select the match to view
		// results for and this is executed by ResultUtils.getResultsForFixtureDB
		case 3:
			ResultUtils.getResultForFixtureDB(menuChoice);
			break;

		// if the user selects View League Table, the league table is retrieved
		// from the database and displayed
		case 4:
			selectReturnLeagueMethod(menuChoice);
			break;

		// if the user selects Search Database, SearchDB.searchDatabase is called
		case 5:
			SearchDB.searchDatabase();
			break;

		// if the user selects Exit, the system displays a confirmation message
		// and ends
		case 6:
			System.out.println("Exiting Six Nations program. Goodbye.");
			break;

		default:
			System.out.println("Unrecognised input, program ending.");
			break;
		}
		}
		menuChoice.close();
	}





	/**
	 * This method asks the user which version of the League table they would like to view
	 * @param menuChoice
	 */
	public static void selectReturnLeagueMethod(Scanner menuChoice) {
		int choice;
		System.out.println("Would you like to view...\n" + "1. the league table for a certain year\n" + "2. all league tables for all recorded years\n");
		choice = menuChoice.nextInt();
		// if the user selects manual input, the method calls
		// ResultUtils.promptToInsertResults()
		if (choice == 1) {
			System.out.println("Which year would you like to view the league for?");
			choice = menuChoice.nextInt();
			ResultUtils.returnLeagueTableForYear(choice);
			// if the user selects all league tables for all recorded years, all results from League are printed from the database
		} else if (choice == 2) {
			ResultUtils.returnLeagueTable();
		} else {
			System.out.println("Invalid option. Returning to main menu...");
		}
	}

	
	
	
	
	/**
	 * This method prompts the user for the method by which they would like to input match results.
	 * If they want to input them manually, it calls ResultUtils.promptToInsertResults.
	 * If they want to update them from a file, it calls ResultUtils.fileToInsertResults.
	 * @param menuChoice
	 */
	public static void selectResultInputMethod(Scanner menuChoice) {
		int choice;
		System.out.println("Would you like to input your scores via...\n" + "1. manual input\n" + "2. file input\n");
		choice = menuChoice.nextInt();
		// if the user selects manual input, the method calls
		// ResultUtils.promptToInsertResults()
		if (choice == 1) {
			ResultUtils.promptToInsertResults(new Scanner(System.in));
			// if the user selects input from a file, they are asked the
			// name of the file
			// this is passed into ResultUtils.fileToInsertResults()
		} else if (choice == 2) {
			System.out.println("What is the name of your file? (Please include file extension, eg .txt)");
			String fileName=menuChoice.next();
			ResultUtils.fileToInsertResults(fileName);
		} else {
			System.out.println("That was not an option. Returning to main menu...");
			// TODO return to main menu?
		}
	}

	
	
	
	
	/**
	 * This method creates a new Tournament based on the year inputed by the user
	 * 
	 * @author Laura McCormick
	 * @return Tournament
	 */
	public static void createTournament(Scanner menuChoice) {
		try (Connection conn = DbConnect.getRemoteConnection()){
			int year = 0;
			boolean bcorrect = false;

			while (bcorrect == false) {
				String ccorrect = "A";

				// method prompts user for the year the tournament is in
				while (year<1 || year>9999){
					System.out.println("Which year is the tournament in?");
					if(menuChoice.hasNextInt()){
						year = menuChoice.nextInt();
					} else {
						System.out.println("Please enter a valid 4-digit integer.");
						menuChoice.next();
					}
				}
			
				while (!ccorrect.equalsIgnoreCase("Y") && !ccorrect.equalsIgnoreCase("N")) {
					System.out.println("This tournament is for the year " + year + ". Is this correct? Y/N");
					ccorrect = menuChoice.next();
				}

				if (ccorrect.equalsIgnoreCase("Y")) {
				bcorrect = true;
				} 
			};

			Statement checkYearExists = conn.createStatement();
			ResultSet checkYear = checkYearExists.executeQuery("Select Year from Fixture where year = " + year + ";");
			if (!checkYear.next()){
				System.out.println("Six Nations " + year + " created. Fixtures have been generated.");
				Tournament newTourn = new Tournament(year);
			} else {
				System.out.println("This tournament already exists in the database. Returning to main menu.");
			}
			
		} catch (SQLException e) {
		e.printStackTrace();
		}
	}
}

