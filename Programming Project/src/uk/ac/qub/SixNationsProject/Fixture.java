package uk.ac.qub.SixNationsProject;
/**
 * 
 * 
 * @author Laura McCormick
 * @author Matt McQuillan
 * @author Gareth Gray
 *
 */
public class Fixture {

	private int fixtureNumber;
	private int fixtureID;
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

	/**
	 *  Prints the results of the fixture in a readable format to System.out
	 */
	public void printFixtureResult() {
		System.out.println("\t\t" + team1.getName() + "\t vs\t" + team2.getName());
		System.out.println("TRIES:\t\t" + result.getTeam1Tries() + "\t\t\t" + result.getTeam2Tries());
		System.out.println("SCORE:\t\t" + result.getTeam1Score() + "\t\t\t" + result.getTeam2Score());
		System.out.println("POINTS:\t\t" + result.getTeam1Points() + "\t\t\t" + result.getTeam2Points());
		System.out.println("BONUS:\t\t" + result.getTeam1BonusPoints() + "\t\t\t" + result.getTeam2BonusPoints());
		System.out.println("");
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
	 * Returns fixtureNumber
	 * @return
	 */
	public int getFixtureNumber() {
		return fixtureNumber;
	}

	/**
	 * Sets fixtureNumber
	 * @param fixtureNumber
	 */
	public void setFixtureNumber(int fixtureNumber) {
		this.fixtureNumber = fixtureNumber;
	}

	public void setResult(Result result) {
		this.result = result;
	}

	/**
	 * Returns fixtureNumber
	 * @return
	 */
	public Result getResult() {
		return result;
	}

	/**
	 * Returns fixtureNumber
	 * @return
	 */
	public int getFixtureID() {
		return fixtureID;
	}

	/**
	 * Sets fixtureNumber
	 * @param fixtureNumber
	 */
	public void setFixtureID(int fixtureID) {
		this.fixtureID = fixtureID;
	}
}
