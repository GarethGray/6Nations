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
		ResultUtils.promptToInsertResults(tournament, scanner);

		// Print the scores of a single round
		ResultUtils.promptToPrintRoundResults(tournament, scanner);

		// Print the results of a whole tournament
		tournament.printTournamentResults();

		// Close the scanner
		scanner.close();
	}

}
