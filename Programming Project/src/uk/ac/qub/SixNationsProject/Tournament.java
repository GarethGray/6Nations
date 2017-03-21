package uk.ac.qub.SixNationsProject;

import java.util.ArrayList;

public class Tournament {

	private ArrayList<Team> teams;
	private int year;
	private ArrayList<Round> rounds;

	/**
	 * Constructor with args
	 * 
	 * @param rounds
	 */
	public Tournament(ArrayList<Team> teams, int year, ArrayList<Round> rounds) {
		this.setTeams(teams);
		this.setYear(year);
		this.setRounds(rounds);
	}
	
	/**
	 * Getter for teams
	 * 
	 * @return
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}

	/**
	 * Setter for teams
	 * 
	 * @param teams
	 */

	public void setTeams(ArrayList<Team> teams) {
		this.teams = teams;
	}

	/**
	 * Getter for year
	 * 
	 * @return
	 */
	public int getYear() {
		return year;
	}

	/**
	 * Setter for year
	 * 
	 * @param year
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * Getter for Rounds
	 * 
	 * @return
	 */
	public ArrayList<Round> getRounds() {
		return rounds;
	}

	/**
	 * Setter for rounds
	 * 
	 * @param rounds
	 */
	public void setRounds(ArrayList<Round> rounds) {
		this.rounds = rounds;
	}

}
