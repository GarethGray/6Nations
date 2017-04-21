package uk.ac.qub.SixNationsProject;

import java.util.ArrayList;
import java.util.Scanner;

public final class ResultUtils {

	public static void setResultForFixture(Tournament tournament, int roundNumber, int fixtureNumber, int[] team1Score, int[] team2Score)
	{
		Result result = getResultForFixture(tournament, roundNumber, fixtureNumber);		
		result.setScores(team1Score, team2Score);
	}
	
	public static Result getResultForFixture(Tournament tournament, int roundNumber, int fixtureNumber)
	{
		ArrayList<Round> rounds = tournament.getRounds();
		Round round = rounds.get(roundNumber - 1); 
		
		ArrayList<Fixture> fixtures = round.getFixtures();
		Fixture fixture = fixtures.get(fixtureNumber - 1);
		
		return fixture.getResult();
	}
	
	public static void promptToInsertScores(Tournament tournament) {
		Scanner scanner = new Scanner(System.in);
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

		scanner.close();
		
		int[] team1ScoreArray = {team1Tries, team1Score};
		int[] team2ScoreArray = {team2Tries, team2Score};
		
		Result result = chosenFixture.getResult();
		result.setScores(team1ScoreArray, team2ScoreArray);
		printFixtureScores(chosenRound, chosenFixture);
	}
	
	public static void printFixtureScores(Round round, Fixture fixture) {
		
		Team team1 = fixture.getTeam1();
		Team team2 = fixture.getTeam2();	
		Result result = fixture.getResult();
		
		System.out.println("Round: " + round.getNumber() + ", fixture: " + fixture.getFixtureNumber());
		System.out.println("\t\t" + team1.getName() + "\t vs\t" + team2.getName());
		System.out.println("TRIES:\t\t" + result.getTeam1Tries() + "\t\t\t" + result.getTeam2Tries());
		System.out.println("SCORE:\t\t" + result.getTeam1Score() + "\t\t\t" + result.getTeam2Score());
		System.out.println("POINTS:\t\t" + result.getTeam1Points() + "\t\t\t" + result.getTeam2Points());
		System.out.println("BONUS:\t\t" + result.getTeam1BonusPoints() + "\t\t\t" + result.getTeam2BonusPoints());
	}
}
