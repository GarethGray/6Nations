package uk.ac.qub.SixNationsProject;

import java.io.ByteArrayOutputStream;

import java.sql.Connection;

import java.sql.ResultSet;

import java.sql.SQLException;

import java.sql.Statement;

import java.util.ArrayList;

import java.util.Scanner;

public class Sandbox {

	public static void main(String[] args) {

		try {

			Connection conn = DbConnect.getRemoteConnection();

			Statement insertTeam = conn.createStatement();

			Statement checkWorks = conn.createStatement();

			Scanner scanner = new Scanner(System.in);

			DbConnect.createDB();

			ArrayList<Fixture> fixtures;

			Tournament tournament;

			int year;

			ArrayList<Team> teams;

			ArrayList<Round> rounds;

			// instantiation of bytearray stream to capture output from print
			// method

			ByteArrayOutputStream outContent = new ByteArrayOutputStream();

			Fixture fixture1, fixture2, fixture3;

			Result result1, result2, result3;

			int[] team3score, team4score, team5score, team6score;

			// TODO Auto-generated method stub

			year = 2017;

			fixtures = new ArrayList<Fixture>();

			teams = new ArrayList<>();

			Team ireland = new Team(TeamName.IRELAND);

			Team france = new Team(TeamName.FRANCE);

			Team england = new Team(TeamName.ENGLAND);

			Team italy = new Team(TeamName.ITALY);

			Team wales = new Team(TeamName.WALES);

			Team scotland = new Team(TeamName.SCOTLAND);

			teams.add(scotland);

			teams.add(wales);

			teams.add(italy);

			teams.add(france);

			teams.add(england);

			teams.add(ireland);

			for (int i = 0; i < teams.size(); i++) {

				String insertTeamNames = "INSERT INTO Team Values('" + teams.get(i).getName() + "');";

				insertTeam.addBatch(insertTeamNames);

			}

			insertTeam.executeBatch();

			insertTeam.close();

			checkWorks = conn.createStatement();

			ResultSet rs = checkWorks.executeQuery("SELECT * FROM Team;");

			while (rs.next()) {

				System.out.println("Team name:" + rs.getString("TeamName"));

			}
			
			rs = checkWorks.executeQuery("SELECT * FROM Fixture;");
			
			while (rs.next()){
				System.out.println("Fixture ");
			}

			tournament = new Tournament(teams, year);

			rounds = tournament.generateRounds(year, teams);

			for (Round round : rounds) {

				fixtures.addAll(round.getFixtures());

			}

			fixture1 = new Fixture(1, ireland, france);

			fixture2 = new Fixture(2, england, italy);

			fixture3 = new Fixture(3, wales, scotland);

			int[] team1score = { 22, 4 };

			int[] team2score = { 0, 0 };

			// team3score

			// team4score

			// team5score

			// team6score;

			result1 = new Result();

			result1.setScores(team1score, team2score);

			result2 = new Result();

			result2.setScores(team1score, team2score);

			result3 = new Result();

			result3.setScores(team1score, team2score);

			fixture1.setResult(result1);

			fixture2.setResult(result2);

			fixture3.setResult(result3);

			Round round = new Round(fixture1, fixture2, fixture3, 1);

			rounds.add(round);

			tournament.printTournamentResults();

			ResultUtils.promptToInsertResults(tournament, scanner);

		} catch (SQLException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		}

	}

}
