package uk.ac.qub.SixNationsProject;

/**
 * @KathyAyers
 * 
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.InputMismatchException;
import java.util.Scanner;

public class SearchDB {
	/**
	 * This method asks for input from the user and then uses the input to
	 * search the database and return the relevant records.
	 * 
	 */

	public static void searchDatabase() {

		// sets up scanner and variables
		Scanner scanner = new Scanner(System.in);
		int option = 0;

		// menu continues unless exit is selected
		while (option != 5) {
			
			/**
			 *  declare vars
			 */
			String searchTerm;

			// sets up menu for user
			System.out.println("\nYou can search the files in a number of ways. \n");
			System.out.println("If you would like to search by year enter 1 \nIf by team name enter 2");
			System.out.println("If you would like to find the maximum score achieved in a year, enter 3");
			System.out.println("If you would like to find the most tries scored in a year, enter 4");
			System.out.println("If you would like to return to the main method, enter 5");

			// Takes user input
			option = scanner.nextInt();

			try (Connection conn = DbConnect.getRemoteConnection();) {

				switch (option) {

				// user wishes to search by year
				case 1:
					System.out.println("What year would you like to see?(Give year as XXXX)");
					searchTerm = String.valueOf(scanner.nextInt());

					// creates a sql statement and uses user input of year
					Statement getSearch = conn.createStatement();

					ResultSet rs = getSearch.executeQuery(
							"SELECT TeamName, Tries, Score FROM FixtureResult WHERE Year = " + searchTerm + ";");
					// validation
					boolean hasRows = false;
					while (rs.next()) {
						hasRows = true;
						System.out.println(rs.getString("TeamName") + " Tries: " + rs.getString("Tries") + ", Score: "
								+ rs.getString("Score"));
					}
					if (!hasRows) {
						System.out.println("Your search has returned no records.");
					}
					break;

				case 2:
					// user searches by team name

					System.out.println(
							"What team do you want to search for?(Enter England, Scotland, Wales, Ireland, Italy or France");
					searchTerm = scanner.next();
					searchTerm.toUpperCase();

					// creates a sql state and uses user input of team name
					Statement getSearch2 = conn.createStatement();
					ResultSet rs2 = getSearch2
							.executeQuery("SELECT TeamName, Year, Tries, Score FROM FixtureResult WHERE TeamName = '"
									+ searchTerm + "';");
					// validation
					hasRows = false;
					while (rs2.next()) {
						hasRows = true;
						// prints out search result
						System.out.println(rs2.getString("TeamName") + " Year: " + rs2.getString("Year") + " Tries: "
								+ rs2.getString("Tries") + ", Score: " + rs2.getString("Score"));
					}
					if (!hasRows) {
						System.out.println("Your search has returned no records.");

					}

					break;

				case 3:
					// user searches for the highest score

					System.out
							.println("What year would you like to see the highest score achieved?(enter year as XXXX)");
					searchTerm = String.valueOf(scanner.nextInt());

					// creates a sql query and uses user input of year
					Statement getSearch3 = conn.createStatement();
					ResultSet rs3 = getSearch3.executeQuery(
							"SELECT TeamName, MAX(PointsScored) From League WHERE Year =" + searchTerm + ";");
					// validation
					hasRows = false;
					while (rs3.next()) {
						hasRows = true;
						// prints out search result
						System.out
								.println(rs3.getString("TeamName") + " Score:  " + rs3.getString("MAX(PointsScored)"));
					}
					if (!hasRows) {
						System.out.println("Your search has returned no records.");

					}

					break;

				case 4:
					// user searches for most tries
					System.out.println("What year would you like to see the most tries achieved?(Enter year as XXXX");
					searchTerm = String.valueOf(scanner.nextInt());

					// creates a sql query and uses user input of year
					Statement getSearch4 = conn.createStatement();
					ResultSet rs4 = getSearch4
							.executeQuery("SELECT TeamName, MAX(Tries) From League WHERE Year =" + searchTerm + ";");
					// validation
					hasRows = false;
					while (rs4.next()) {
						hasRows = true;
						// prints out search result
						System.out.println(rs4.getString("TeamName") + " Tries:  " + rs4.getString("MAX(Tries)"));
					}
					if (!hasRows) {
						System.out.println("Your search has returned no records.");

					}
					break;

				case 5:
					// user exists
					System.out.println("Thank you for using the Six Nations search function. ");

					break;

				default:
					// validation for bad user input
					System.out.println("You have entered an invalid value. Please enter try again.");
					break;
				}

				// connection closed
				conn.close();

			} catch (SQLException e) {
				e.printStackTrace();
			} catch (InputMismatchException e2) {
				e2.printStackTrace();
				System.out.println("You have inputted the wrong data and search will not work.");

			}

		}
		// scanner closed
		scanner.close();

	}

}