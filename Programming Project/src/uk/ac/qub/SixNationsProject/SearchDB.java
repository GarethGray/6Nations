package uk.ac.qub.SixNationsProject;

/**
 * @KathyAyers
 * 
 */
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
			// declare var
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
					System.out.println("What year would you like to see?");
					searchTerm = String.valueOf(scanner.nextInt());

					// creates a sql statement and uses user input of year
					Statement getSearch = conn.createStatement();

					ResultSet rs = getSearch.executeQuery(
							"SELECT TeamName, Tries, Score FROM FixtureResult WHERE Year = " + searchTerm + ";");
					while (rs.next()) {
						System.out.println(rs.getString("TeamName") + " Tries: " + rs.getString("Tries") + ", Score: "
								+ rs.getString("Score"));
					}
					break;

				case 2:
					// user searches by team name

					System.out.println("What team do you want to search for?");
					searchTerm = scanner.next();
					searchTerm.toUpperCase();

					// creates a sql state and uses user input of team name
					Statement getSearch2 = conn.createStatement();
					ResultSet rs2 = getSearch2
							.executeQuery("SELECT TeamName, Year, Tries, Score FROM FixtureResult WHERE TeamName = '"
									+ searchTerm + "';");
					while (rs2.next()) {
						// prints out search result
						System.out.println(rs2.getString("TeamName") + " Year: " + rs2.getString("Year") + " Tries: "
								+ rs2.getString("Tries") + ", Score: " + rs2.getString("Score"));
					}

					break;

				case 3:
					// user searches for the highest score

					System.out.println("What year would you like to see the highest score achieved?");
					searchTerm = String.valueOf(scanner.nextInt());

					// creates a sql query and uses user input of year
					Statement getSearch3 = conn.createStatement();
					ResultSet rs3 = getSearch3.executeQuery(
							"SELECT TeamName, MAX(PointsScored) From League WHERE Year =" + searchTerm + ";");
					while (rs3.next()) {
						// prints out search result
						System.out
								.println(rs3.getString("TeamName") + " Score:  " + rs3.getString("MAX(PointsScored)"));
					}
					break;

				case 4:
					// user searches for most tries
					System.out.println("What year would you like to see the most tries achieved?");
					searchTerm = String.valueOf(scanner.nextInt());

					// creates a sql query and uses user input of year
					Statement getSearch4 = conn.createStatement();
					ResultSet rs4 = getSearch4
							.executeQuery("SELECT TeamName, MAX(Tries) From League WHERE Year =" + searchTerm + ";");
					while (rs4.next()) {
						// prints out search result
						System.out.println(rs4.getString("TeamName") + " Tries:  " + rs4.getString("MAX(Tries)"));
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
			}

		}
		// scanner closed
		scanner.close();
	}
}