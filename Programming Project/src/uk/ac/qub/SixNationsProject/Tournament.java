package uk.ac.qub.SixNationsProject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;

import java.util.Collections;

public class Tournament {

	private ArrayList<Team> teams;

	private int year;

	private ArrayList<Round> rounds;

	/**
	 * 
	 * Constructor with args that only takes year as an argument.
	 * 
	 * Teams are automatically generated based on the current Six Nations teams
	 * 
	 * @param year
	 * 
	 *            The year the tournament takes place
	 * 
	 */

	public Tournament(int year) {

		// creating all teams to play in the tournament

		Team scotland = new Team(TeamName.SCOTLAND);

		Team france = new Team(TeamName.FRANCE);

		Team england = new Team(TeamName.ENGLAND);

		Team ireland = new Team(TeamName.IRELAND);

		Team wales = new Team(TeamName.WALES);

		Team italy = new Team(TeamName.ITALY);

		// adding all teams to an ArrayList that can be passed into

		// the FixtureGenerator

		ArrayList<Team> teams = new ArrayList<>();

		teams.add(scotland);

		teams.add(france);

		teams.add(england);

		teams.add(ireland);

		teams.add(wales);

		teams.add(italy);

		this.setTeams(teams);

		this.setYear(year);

//		// this populates the database with the teams
//		try {
//			Connection conn = DbConnect.getRemoteConnection();
//			Statement insertTeam = conn.createStatement();
//			for (int i = 0; i < teams.size(); i++) {
//				insertTeam.addBatch("INSERT INTO Team Values('" + teams.get(i).getName() + "');");
//			}
//			insertTeam.executeBatch();
//			insertTeam.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		ArrayList<Round> rounds = this.generateRounds(year, teams);

		this.setRounds(rounds);

	}

	/**
	 * 
	 * Constructor with args that allows users to create a Tournament with a
	 * different
	 * 
	 * array list of teams than the teams currently playing in the Six Nations
	 * 
	 * 
	 * 
	 * @param teams
	 * 
	 *            The list of teams playing in the tournament
	 * 
	 * @param year
	 * 
	 *            The year the tournament takes place
	 * 
	 */

	public Tournament(ArrayList<Team> teams, int year) {

		this.setTeams(teams);

		this.setYear(year);

		ArrayList<Round> rounds = this.generateRounds(year, teams);

		this.setRounds(rounds);

	}

	/**
	 * 
	 * This method generates the rounds and fixtures for an entire tournament.
	 * 
	 * It shuffles the teams to allow for randomly generated fixtures. Then it
	 * 
	 * creates a Round of fixtures using createARound method. It adds this Round
	 * 
	 * to an ArrayList of Rounds. It then moves the last Team in teams to the
	 * 
	 * second place in the array and creates another Round. It repeats this
	 * 
	 * until the given appropriate number of rounds (the number of teams minus
	 * 
	 * 1) have been generated and added to roundList. Using this roundList the
	 * 
	 * method then @returns a new Tournament
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 * @param teams
	 * 
	 * @return Tournament
	 * 
	 */

	public ArrayList<Round> generateRounds(int year, ArrayList<Team> teams) {

		ArrayList<Round> roundList = new ArrayList<>();

		int numberOfRounds = teams.size() - 1;

		// randomly shuffle teams

		Collections.shuffle(teams);

		// generate first round of fixtures

		roundList.add(this.createARound(teams, 1));

		// each loop, reorder the list of teams by moving the last team to the

		// front and then generate another round of fixtures

		for (int i = 0; i < numberOfRounds - 1; i++) {

			Team movingTeam = teams.get((teams.size()) - 1);

			teams.remove(movingTeam);

			teams.add(1, movingTeam);

			roundList.add(this.createARound(teams, i + 2));

		}

		roundList.get(1).getFixture1().fixtureSwitcher();

		roundList.get(3).getFixture1().fixtureSwitcher();

		try {
			Connection conn = DbConnect.getRemoteConnection();
		Statement createLeague = conn.createStatement();
		for (int i=0; i<teams.size(); i++){
			createLeague.addBatch("INSERT INTO League Values("+this.getYear()+", '"+teams.get(i).getName()+"', 0, 0, 0, 0, 0, 0, 0, 0, 0);");
		}
		createLeague.executeBatch();
		createLeague.close();
		} catch (SQLException e){
			e.printStackTrace();
		}
		return roundList;

	}

	/**
	 * 
	 * This method takes an ArrayList of teams and creates 3 fixtures, pairing
	 * 
	 * teams based on their position within the ArrayList @param teams
	 * 
	 * 
	 * 
	 * @return new Round
	 * 
	 */

	public Round createARound(ArrayList<Team> teams, int roundNumber) {

		try {

			Connection conn = DbConnect.getRemoteConnection();

			Statement insertFixture = conn.createStatement();

			String newFixture1 = "INSERT INTO Fixture Values('" + this.getYear() + "" + roundNumber + "" +

					1 + "', '" + teams.get(0).getName() + "', '" + teams.get(5).getName() + "', " + this.getYear()

					+ ", " + 1 + ", " + roundNumber + ");";

			insertFixture.addBatch(newFixture1);

			String newFixture2 = "INSERT INTO Fixture Values('" + this.getYear() + "" + roundNumber + "" +

					2 + "', '" + teams.get(1).getName() + "', '" + teams.get(4).getName() + "', " + this.getYear()

					+ ", " + 2 + ", " + roundNumber + ");";

			insertFixture.addBatch(newFixture2);

			String newFixture3 = "INSERT INTO Fixture Values('" + this.getYear() + "" + roundNumber + "" +

					3 + "', '" + teams.get(2).getName() + "', '" + teams.get(3).getName() + "', " + this.getYear()

					+ ", " + 3 + ", " + roundNumber + ");";

			insertFixture.addBatch(newFixture3);

			insertFixture.executeBatch();

			insertFixture.close();

			conn.close();
			
			return new Round(new Fixture(1, teams.get(0), teams.get(5)), new Fixture(2, teams.get(1), teams.get(4)),

					new Fixture(3, teams.get(2), teams.get(3)), roundNumber);

		} catch (Exception e) {

			e.printStackTrace();

			return new Round(new Fixture(1, teams.get(0), teams.get(5)), new Fixture(2, teams.get(1), teams.get(4)),

					new Fixture(3, teams.get(2), teams.get(3)), roundNumber);

		}

	}

	/**
	 * 
	 * Getter for teams
	 * 
	 * 
	 * 
	 * @return
	 * 
	 */

	public ArrayList<Team> getTeams() {

		return teams;

	}

	/**
	 * 
	 * Setter for teams
	 * 
	 * 
	 * 
	 * @param teams
	 * 
	 */

	public void setTeams(ArrayList<Team> teams) {

		this.teams = teams;

	}

	/**
	 * 
	 * Getter for year
	 * 
	 * 
	 * 
	 * @return
	 * 
	 */

	public int getYear() {

		return year;

	}

	/**
	 * 
	 * Setter for year
	 * 
	 * 
	 * 
	 * @param year
	 * 
	 */

	public void setYear(int year) {

		this.year = year;

	}

	/**
	 * 
	 * Getter for Rounds
	 * 
	 * 
	 * 
	 * @return
	 * 
	 */

	public ArrayList<Round> getRounds() {

		return rounds;

	}

	/**
	 * 
	 * Setter for rounds
	 * 
	 * 
	 * 
	 * @param rounds
	 * 
	 */

	public void setRounds(ArrayList<Round> rounds) {

		this.rounds = rounds;

	}

	/**
	 * 
	 * Prints each round and the results of each fixture of the round
	 * 
	 */

	public void printTournamentResults() {

		ArrayList<Round> rounds = getRounds();

		for (Round round : rounds) {

			round.printRoundResults();

		}

	}

}