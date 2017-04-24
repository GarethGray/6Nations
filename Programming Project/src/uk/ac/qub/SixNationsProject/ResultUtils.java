package uk.ac.qub.SixNationsProject;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Grainne Jennings
 *
 */

public final class ResultUtils {

	public static void setResultForFixture(Tournament tournament, int roundNumber, int fixtureNumber, int[] team1Score,
			int[] team2Score) {
		Result result = getResultForFixture(tournament, roundNumber, fixtureNumber);
		result.setScores(team1Score, team2Score);
	}

	public static Result getResultForFixture(Tournament tournament, int roundNumber, int fixtureNumber) {
		ArrayList<Round> rounds = tournament.getRounds();
		Round round = rounds.get(roundNumber - 1);

		ArrayList<Fixture> fixtures = round.getFixtures();
		Fixture fixture = fixtures.get(fixtureNumber - 1);

		return fixture.getResult();
	}

// TODO connect to database and do some JDBC - Laura
	public static void promptToInsertResults(Tournament tournament, Scanner scanner) {
		int roundNumber = 0;
		int fixtureNumber = 0;
		Fixture chosenFixture;
		int team1Tries;
		int team1Score;
		int team2Tries;
		int team2Score;
		
		// asks user to select round to input scores into
		while (roundNumber < 1 || roundNumber > tournament.getRounds().size()) {
			System.out.println("Select round:");
			roundNumber = scanner.nextInt();
		}
		roundNumber--;

		// prints fixtures of chosen round
		Round chosenRound = tournament.getRounds().get(roundNumber);
		chosenRound.printFixtures();

		int numberOfFixtures = chosenRound.getFixtures().size();
		// asks user to select fixture to input scores into
		while (fixtureNumber < 1 || fixtureNumber > numberOfFixtures) {
			System.out.println("Select fixture:");
			fixtureNumber = scanner.nextInt();
		}
		fixtureNumber--;
		chosenFixture = chosenRound.getFixtures().get(fixtureNumber);

		// asks user to input scores for each team
		System.out.println("Please enter scores:");
		System.out.println(chosenFixture.getTeam1().getName() + " tries:");
		team1Tries = scanner.nextInt();
		System.out.println(chosenFixture.getTeam1().getName() + " score:");
		team1Score = scanner.nextInt();

		System.out.println(chosenFixture.getTeam2().getName() + " tries:");
		team2Tries = scanner.nextInt();
		System.out.println(chosenFixture.getTeam2().getName() + " score:");
		team2Score = scanner.nextInt();

		int[] team1ScoreArray = { team1Tries, team1Score };
		int[] team2ScoreArray = { team2Tries, team2Score };

		Result result = chosenFixture.getResult();
		result.setScores(team1ScoreArray, team2ScoreArray);

		// Update the teams with their points and scores
		chosenFixture.updateTeamsValues();
		chosenFixture.printFixtureResult();
	}

	public static void promptToPrintRoundResults(Tournament tournament, Scanner scanner) {
		int roundNumber = 0;

		System.out.println("Print the results of a round");
		// asks user to select round to print the score of
		while (roundNumber < 1 || roundNumber > tournament.getRounds().size()) {
			System.out.println("Select round:");
			roundNumber = scanner.nextInt();
		}

		Round round = tournament.getRounds().get(roundNumber - 1);
		round.printRoundResults();
	}
}
