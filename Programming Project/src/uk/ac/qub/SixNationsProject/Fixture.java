package uk.ac.qub.SixNationsProject;

import java.util.Scanner;

public class Fixture {

	private int fixtureNumber;
	private Team team1, team2;
	private Result result;

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
		this.setResult(new Result());
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

	public void setResult(Result result)
	{
		this.result = result;
	}
	
	public Result getResult()
	{
		return result;
	}
}
