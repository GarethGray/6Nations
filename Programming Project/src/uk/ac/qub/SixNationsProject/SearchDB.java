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
		// sets up scanner and assigns scanner input to variable
		Scanner scanner = new Scanner(System.in);
		int option;
		String searchTerm;

		// sets up menu for user
		System.out.println("\n You can search the files in a number of ways. \n");
		System.out.println("You can search by year or team name.\n");
		System.out.println("If you would like to search by year press 1. If by team name press 2");
		option = scanner.nextInt();

		try (Connection conn = DbConnect.getRemoteConnection();) {

			if (option == 1) {
				System.out.println("What year would you like to see?");
				searchTerm = scanner.nextLine();

				// creates a sql statement and uses user input of year
				Statement getSearch = conn.createStatement();
				ResultSet rs = getSearch.executeQuery(
						"SELECT TeamName, Tries, Score FROM FixtureResult WHERE Year = '" + searchTerm + "';");
				while (rs.next()) {
					// prints out search result
					System.out.println(rs.getString("TeamName") + "Year: " + rs.getString("Year") + " Tries: "
							+ rs.getString("Tries") + ", Score: " + rs.getString("Score"));
				}
			} else {
				System.out.println("What team do you want to search for?");
				searchTerm = scanner.nextLine();
				Statement getSearch = conn.createStatement();
				ResultSet rs = getSearch.executeQuery(
						"SELECT TeamName, Tries, Score FROM FixtureResult WHERE TeamName = '" + searchTerm + "';");
				while (rs.next()) {
					// prints out search result
					System.out.println(rs.getString("TeamName") + "Year: " + rs.getString("Year") + " Tries: "
							+ rs.getString("Tries") + ", Score: " + rs.getString("Score"));

				}

				conn.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}