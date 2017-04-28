/**
 * 
 */
package uk.ac.qub.SixNationsProject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author 40189322, 40084540
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		menu();

		// creating all teams to play in the tournament
		Team scotland = new Team(TeamName.SCOTLAND);
		Team france = new Team(TeamName.FRANCE);
		Team england = new Team(TeamName.ENGLAND);
		Team ireland = new Team(TeamName.IRELAND);
		Team wales = new Team(TeamName.WALES);
		Team italy = new Team(TeamName.ITALY);

		// adding all teams to an ArrayList that can be passed into
		// the FixtureGenerator
		ArrayList<Team> teams = new ArrayList<>();
		teams.add(scotland);
		teams.add(france);
		teams.add(england);
		teams.add(ireland);
		teams.add(wales);
		teams.add(italy);

		// Create a new tournament object
		Tournament tournament = new Tournament(teams, 2017);

		// Create System.in scanner, once closed another can't be opened (also
		// closes System.in)
		Scanner scanner = new Scanner(System.in);

		// Examples:
		// Enter score by user input
		// ResultUtils.promptToInsertResults(tournament, scanner);

		// Print the scores of a single round
		// ResultUtils.promptToPrintRoundResults(tournament, scanner);

		// Print the results of a whole tournament
		// tournament.printTournamentResults();

		// Close the scanner
		scanner.close();

		// UploadResultsTestFile.uploadResults(tournament, "TeamUpdate");
	}

	@SuppressWarnings("unused")
	public static void menu() {
		Tournament tournament = null;
		Scanner menuChoice = new Scanner(System.in);
		int choice = 0;

		System.out.println("Welcome to the Six Nations! Please select an option from the menu:\n");

		System.out.println("1. Create new tournament\n" + "2. Insert match results\n" + "3. View match results\n"
				+ "4. View league table\n" + "5. Exit");

		// user inputs values until a valid value is found
		while (choice < 1 || choice > 5) {
			choice = menuChoice.nextInt();
		}

		// system returns the number they have chosen
		System.out.println("You have selected choice: " + choice);

		// system uses a switch statement to execute their choice
		switch (choice) {
		// if the user selects Create New Tournament, the method Application.Tournament is called
		// and they are prompted to insert the year for a new tournament
		case 1:
			tournament = createTournament();
			tournament.printTournamentResults();
			break;
			
		// if the user selects Insert Match Results, they will be asked
		// how they would prefer to input the results
		case 2:
			if (tournament != null) {
				System.out.println(
						"Would you like to input your scores via...\n" + "1. manual input\n" + "2. file input\n");
				choice = menuChoice.nextInt();
				// if the user selects manual input, the method calls ResultUtils.promptToInsertResults()
				if (choice == 1) {
					// TODO finish inserts for promptToInsertResults method
					ResultUtils.promptToInsertResults(tournament, new Scanner(System.in));
				// if the user selects input from a file, they are asked the name of the file
				// this is passed into UploadResultsTestFile.uploadResults()
				} else if (choice == 2) {
					System.out.println("What is the name of your file?");
					UploadResultsTestFile.uploadResults(tournament, menuChoice.nextLine());
				} else {
					System.out.println("That was not an option. Prepare to die.");
				}
			} else {
				System.out.println("No tournament selected. You must create a tournament before proceeding.");
			}
			break;
			
		// if the user selects View Match Results, they are asked to select the match to view
		// results for and this is executed by //TODO which method?
		case 3:
			// TODO return match results from database
			break;
			
		// if the user selects View League Table, the league table is retrieved from the database and displayed
		case 4:
			// TODO league table logic!
			// TODO return league table from database
			break;
		
		// if the user selects Exit, the system displays a confirmation message and ends
		case 5:
			System.out.println("Exiting Six Nations program. Goodbye.");
			break;
		
		default:
			System.out.println("Unrecognised input, program ending.");
			break;
		}

		menuChoice.close();
	}

	/**
	 * This method creates a new Tournament based on the year inputed by the user
	 * @author Laura McCormick
	 * @return Tournament
	 */
	public static Tournament createTournament() {
		Scanner ct = new Scanner(System.in);
		int year = 0;
		boolean bcorrect = false;

		while (bcorrect == false) {
			String ccorrect = "A";

			// method prompts user for the year the tournament is in
			System.out.println("Which year is the tournament in?");
			year = ct.nextInt();

			while (!ccorrect.equalsIgnoreCase("Y") && !ccorrect.equalsIgnoreCase("N")) {
				System.out.println("This tournament is for the year " + year + ". Is this correct? Y/N");
				ccorrect = ct.next();
			}

			if (ccorrect.equalsIgnoreCase("Y")) {
				bcorrect = true;
			}
		}
		;

		System.out.println("Six Nations " + year + " created. Fixtures have been generated.");
		ct.close();
		return new Tournament(year);
	}

}
