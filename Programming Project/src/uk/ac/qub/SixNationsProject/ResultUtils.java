package uk.ac.qub.SixNationsProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	public static void promptToInsertResults(Scanner scanner) {
		try {
			Connection conn = DbConnect.getRemoteConnection();
			int tournamentYear = 0;
			int roundNumber = 0;
			int numberOfRounds = 3;
			int fixtureNumber = 0;
			int teamHTries;
			int teamHScore;
			int teamATries;
			int teamAScore;
			String teamHome = null;
			String teamAway = null;

			// asks user to select tournament
			while (tournamentYear < 1) {
				System.out.println("Select tournament year:");
				tournamentYear = scanner.nextInt();
			}

			// asks user to select round to input scores into
			while (roundNumber < 1 || roundNumber > numberOfRounds) {
				System.out.println("Select round:");
				roundNumber = scanner.nextInt();
			}

			// asks user to select fixture to input scores into
			while (fixtureNumber < 1 || fixtureNumber > 5) {
				System.out.println("Select fixture:");
				fixtureNumber = scanner.nextInt();
			}

			// uses user-inputted values to select HOME team from database
			Statement getTeams = conn.createStatement();
			ResultSet rs = getTeams.executeQuery("SELECT TeamNameHome FROM Fixture WHERE Year = " + tournamentYear
					+ " AND RoundNo = " + roundNumber + " AND FixtureNo = " + fixtureNumber + ";");
			while (rs.next()) {
				teamHome = rs.getString("TeamNameHome");
			}
			System.out.println("\nHome team: " + teamHome);

			// uses user-inputted values to select AWAY team from database
			rs = getTeams.executeQuery("SELECT TeamNameAway FROM Fixture WHERE Year = " + tournamentYear
					+ " AND RoundNo = " + roundNumber + " AND FixtureNo = " + fixtureNumber + ";");
			while (rs.next()) {
				teamAway = rs.getString("TeamNameAway");
			}
			System.out.println("\nHome team: " + teamAway);

			// asks user to input scores for each team
			System.out.println("Please enter scores:");
			System.out.println(teamHome + " tries:");
			teamHTries = scanner.nextInt();
			System.out.println(teamHome + " score:");
			teamHScore = scanner.nextInt();

			System.out.println(teamAway + " tries:");
			teamATries = scanner.nextInt();
			System.out.println(teamAway + " score:");
			teamAScore = scanner.nextInt();

			// int[] team1ScoreArray = { teamHTries, teamHScore };
			// int[] team2ScoreArray = { teamATries, teamAScore };

			// Result result = chosenFixture.getResult();
			// result.setScores(team1ScoreArray, team2ScoreArray);

			// Update the teams with their points and scores
			// chosenFixture.updateTeamsValues();
			// chosenFixture.printFixtureResult();

			// the code inside the try block inserts results for each team in
			// the fixture specified

			Statement insertResult = conn.createStatement();

			String newResultTeamHome = "INSERT INTO FixtureResult Values(" + tournamentYear + ", '" + tournamentYear
					+ "" + roundNumber + "" + fixtureNumber + "', '" + teamHome + "'" + ", " + teamHTries + ", "
					+ teamHScore + ");";
			String newResultTeamAway = "INSERT INTO FixtureResult Values(" + tournamentYear + ", '" + tournamentYear
					+ "" + roundNumber + "" + fixtureNumber + "', '" + teamAway + "'" + ", " + teamATries + ", "
					+ teamAScore + ");";

			insertResult.addBatch(newResultTeamHome);
			insertResult.addBatch(newResultTeamAway);
			insertResult.executeBatch();
			insertResult.close();

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void getResultForFixtureDB(Scanner scanner) {

		try {
			Connection conn = DbConnect.getRemoteConnection();

			String tournamentYear = "0";
			String roundNumber = "0";
			int numberOfRounds = 3;
			String fixtureNumber = "0";
			int teamHTries;
			int teamHScore;
			int teamATries;
			int teamAScore;
			String teamHome = null;
			String teamAway = null;
			String fixtureID;

			// asks user to select tournament
			while (Integer.valueOf(tournamentYear) < 1) {
				System.out.println("Select tournament year:");
				tournamentYear = Integer.toString(scanner.nextInt());
			}

			// asks user to select round from which to retrieve info
			while (Integer.valueOf(roundNumber) < 1 || (Integer.valueOf(roundNumber) > numberOfRounds)) {
				System.out.println("Select round:");
				roundNumber = Integer.toString(scanner.nextInt());
			}

			// asks user to select fixture from which to retrieve scores
			while (Integer.valueOf(fixtureNumber) < 1 || Integer.valueOf(fixtureNumber) > 5) {
				System.out.println("Select fixture:");
				fixtureNumber = Integer.toString(scanner.nextInt());
			}

			fixtureID = tournamentYear + roundNumber + fixtureNumber;

			// uses user-inputted values to select HOME team from database
			Statement getResult = conn.createStatement();
			ResultSet rs = getResult.executeQuery(
					"SELECT TeamName, Tries, Score FROM FixtureResult WHERE FixtureID = '" + fixtureID + "';");
			while (rs.next()) {
				System.out.println(rs.getString("TeamName") + " Tries: "+rs.getString("Tries") + ", Score: " +rs.getString("Score"));
			}

			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
