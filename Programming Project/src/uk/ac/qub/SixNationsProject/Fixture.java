package uk.ac.qub.SixNationsProject;

public class Fixture {

	private Team team1, team2;
	private Round round;

	/**
	 * Constructor with args
	 * 
	 * @param team1
	 * @param team2
	 * @param round
	 */

	public Fixture(Team team1, Team team2, Round round) {
		this.setTeam1(team1);
		this.setTeam2(team2);
		this.setRound(round);
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
	 * Getter for Round
	 * 
	 * @return
	 */
	public Round getRound() {
		return round;
	}

	/**
	 * Setter for Round
	 * 
	 * @return
	 */
	public void setRound(Round round) {
		this.round = round;
	}

}
