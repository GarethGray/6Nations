package uk.ac.qub.SixNationsProject;

import java.util.ArrayList;
import java.util.Collections;

public class Tournament {

	private ArrayList<Team> teams;
	private int year;
	private ArrayList<Round> rounds;
	
	
	/**
	 * This method generates the fixtures for an entire tournament. It shuffles the teams to allow for randomly generated fixtures.
	 * Then it creates a Round of fixtures using createARound method. It adds this Round to an ArrayList of Rounds.
	 * It then moves the last Team in teams to the second place in the array and creates another Round. It repeats this until the given 
	 * appropriate number of rounds (the number of teams minus 1) have been generated and added to roundList. Using this roundList the 
	 * method then @returns a new Tournament
	 * @param year
	 * @param teams
	 * @return Tournament
	 */
	
	public Tournament generateFixtures(int year, ArrayList<Team> teams) {
		
		
		ArrayList<Round> roundList = new ArrayList<>();
		int numberOfRounds = teams.size()-1;
		
		// randomly shuffle teams
		Collections.shuffle(teams);

		// generate first round of fixtures
		roundList.add(this.createARound(teams,1));

		// each loop, reorder the list of teams by moving the last team to the front and then generate another round of fixtures
		for (int i = 0; i < numberOfRounds - 1; i++) {
			
			Team movingTeam = teams.get((teams.size()) - 1);
			teams.remove(movingTeam);
			teams.add(1, movingTeam);

			roundList.add(this.createARound(teams,i+2));
		}

		roundList.get(1).getFixture1().fixtureSwitcher();
		roundList.get(3).getFixture1().fixtureSwitcher();
		
		return new Tournament(teams, year, roundList);
	}
	
	/**
	 * This method takes an ArrayList of teams and creates 3 fixtures, 
	 * pairing teams based on their position within the ArrayList @param teams
	 * @return new Round
	 */
	public Round createARound(ArrayList<Team> teams, int roundNumber) {
		
		return new Round(new Fixture(1, teams.get(0), teams.get(5)),
				new Fixture(2, teams.get(1), teams.get(4)), new Fixture(3, teams
						.get(2), teams.get(3)), roundNumber);
		
	}
	
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
