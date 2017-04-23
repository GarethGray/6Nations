package uk.ac.qub.SixNationsProject;

public class Fixture {

	private int fixtureNumber;
	private Team team1, team2;
	private Result result;

	/**
	 * Constructor with args
	 *
	 * @param fixtureNumber
	 * @param team1
	 * @param team2
	 */

	public Fixture(int fixtureNumber, Team team1, Team team2) {
		this.setFixtureNumber(fixtureNumber);
		this.setTeam1(team1);
		this.setTeam2(team2);
		this.setResult(new Result());
	}

	/**
	 * This method switches the order of the teams in fixture
	 */
	public void fixtureSwitcher() {
		Team temp = team1;
		this.team1 = team2;
		this.team2 = temp;
	}

	// Prints the results of the fixture in a readable format to System.out
	public void printFixtureResult() {
		System.out.println("\t\t" + team1.getName() + "\t vs\t" + team2.getName());
		System.out.println("TRIES:\t\t" + result.getTeam1Tries() + "\t\t\t" + result.getTeam2Tries());
		System.out.println("SCORE:\t\t" + result.getTeam1Score() + "\t\t\t" + result.getTeam2Score());
		System.out.println("POINTS:\t\t" + result.getTeam1Points() + "\t\t\t" + result.getTeam2Points());
		System.out.println("BONUS:\t\t" + result.getTeam1BonusPoints() + "\t\t\t" + result.getTeam2BonusPoints());
		System.out.println("");
	}

	public void updateTeamsValues() {
		// Set team 1 points and score
		team1.addPoints(result.getTeam1Points());
		team1.addBonusPoints(result.getTeam1BonusPoints());
		team1.addScoreFor(result.getTeam1Score());
		team1.addTries(result.getTeam1Tries());
		team1.addScoreAgainst(result.getTeam2Score());
		team1.incrementPlayed();

		// Set team 2 points and score
		team2.addPoints(result.getTeam2Points());
		team2.addBonusPoints(result.getTeam2BonusPoints());
		team2.addScoreFor(result.getTeam2Score());
		team2.addTries(result.getTeam2Tries());
		team2.addScoreAgainst(result.getTeam1Score());
		team2.incrementPlayed();

		if (result.getTeam1Score() > result.getTeam2Score()) {
			team1.incrementWon();
			team2.incrementLost();
		} else if (result.getTeam2Score() > result.getTeam1Score()) {
			team2.incrementWon();
			team1.incrementLost();
		} else {
			team1.incrementDrawn();
			team2.incrementDrawn();
		}
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

	public int getFixtureNumber() {
		return fixtureNumber;
	}

	public void setFixtureNumber(int fixtureNumber) {
		this.fixtureNumber = fixtureNumber;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	public Result getResult() {
		return result;
	}
}
