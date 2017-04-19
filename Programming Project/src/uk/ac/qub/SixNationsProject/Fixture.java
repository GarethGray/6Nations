package uk.ac.qub.SixNationsProject;

import java.util.Scanner;

public class Fixture {

	private int fixtureNumber;
	private Team team1, team2;

	/**
	 * Constructor with args
	 * 
	 * @param team1
	 * @param team2
	 */

	public Fixture(int fixtureNumber, Team team1, Team team2) {
		this.setFixtureNumber(fixtureNumber);
		this.setTeam1(team1);
		this.setTeam2(team2);
	}

	/**
	 * Getter for team1
	 * 
	 * @return
	 */
	public Team getTeam1() {
		return team1;
	}

	/**
	 * Setter for team1
	 * 
	 * @return
	 */

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	/**
	 * Getter for team2
	 * 
	 * @return
	 */
	public Team getTeam2() {
		return team2;
	}

	/**
	 * Setter for team2
	 * 
	 * @return
	 */

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	/**
	 * This method switches the order of the teams in fixture
	 */
	public void fixtureSwitcher() {
		Team temp = team1;
		this.team1 = team2;
		this.team2 = temp;
	}

	public int getFixtureNumber() {
		return fixtureNumber;
	}

	public void setFixtureNumber(int fixtureNumber) {
		this.fixtureNumber = fixtureNumber;
	}

	public static Result insertScores(Tournament tournament) {
		Scanner scanner = new Scanner(System.in);
		int roundNumber = 0;
		int fixtureNumber = 0;
		Fixture chosenFixture;
		int team1Tries;
		int team1Points;
		int team2Tries;
		int team2Points;

		// asks user to select round to input scores into
		while (roundNumber < 1 || roundNumber > tournament.getRounds().size()) {
			System.out.println("Select round:");
			roundNumber = scanner.nextInt();
		}
		roundNumber--;

		// prints fixtures of chosen round
		tournament.getRounds().get(roundNumber).printFixtures();

		// asks user to select fixture to input scores into
		while (fixtureNumber < 1 || fixtureNumber > tournament.getRounds().get(roundNumber).getFixtures().size()) {
			System.out.println("Select fixture:");
			fixtureNumber = scanner.nextInt();
		}
		fixtureNumber--;
		chosenFixture = tournament.getRounds().get(roundNumber).getFixtures().get(fixtureNumber);

		// asks user to input scores for each team
		System.out.println("Please enter scores:");
		System.out.println(chosenFixture.getTeam1().getName() + " tries:");
		team1Tries = scanner.nextInt();
		System.out.println(chosenFixture.getTeam1().getName() + " points:");
		team1Points = scanner.nextInt();

		System.out.println(chosenFixture.getTeam2().getName() + " tries:");
		team2Tries = scanner.nextInt();
		System.out.println(chosenFixture.getTeam2().getName() + " points:");
		team2Points = scanner.nextInt();

		scanner.close();
		Result result = new Result(tournament, roundNumber, fixtureNumber, team1Tries, team1Points, team2Tries,
				team2Points);
		result.printMatchScores();

		return result;
	}

}
