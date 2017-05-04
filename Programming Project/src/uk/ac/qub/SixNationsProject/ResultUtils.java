package uk.ac.qub.SixNationsProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 
 * @author Grainne Jennings
 * @author Aine Kane
 * @author Laura McCormick
 * @author Matt McQuillan
 * @author Gareth Gray
 *
 */

public final class ResultUtils {

	public static void setResultForFixture(Tournament tournament, int roundNumber, int fixtureNumber, int[] team1Score,
			int[] team2Score) {
		Result result = getResultForFixture(tournament, roundNumber, fixtureNumber);
		//result.setScores(team1Score, team2Score);
	}

	public static Result getResultForFixture(Tournament tournament, int roundNumber, int fixtureNumber) {
		ArrayList<Round> rounds = tournament.getRounds();
		Round round = rounds.get(roundNumber - 1);

		ArrayList<Fixture> fixtures = round.getFixtures();
		Fixture fixture = fixtures.get(fixtureNumber - 1);

		return fixture.getResult();
	}

	
	
	
	
	/**
	 * This method asks the user to input the year, round and fixture to update scores for.
	 * The method then asks for the tries and score for each round in the fixture.
	 * It then updates the database table FixtureResult with these scores.
	 * Finally, it calls ResultUtils.updateLeague() to update the league table values
	 * @param scanner
	 */
	public static void promptToInsertResults(Scanner scanner) {
		try (Connection conn = DbConnect.getRemoteConnection();){
			int tournamentYear = 0;
			int roundNumber = 0;
			int numberOfRounds = 5;
			int fixtureNumber = 0;
			int teamHTries;
			int teamHScore;
			int teamATries;
			int teamAScore;
			String teamHome = null;
			String teamAway = null;
			String fixtureID;

			// asks user to select tournament
			tournamentYear = promptForTournamentYear(scanner, tournamentYear);

			// asks user to select round to input scores into
			roundNumber = promptForRoundNumber(scanner, roundNumber, numberOfRounds);

			// asks user to select fixture to input scores into
			fixtureNumber = promptForFixtureNumber(scanner, fixtureNumber);
			
			// uses user-inputed values to select HOME team from database, prints "Home team: TEAM"
			Statement getTeams = conn.createStatement();
			teamHome = getHomeTeamName(tournamentYear, roundNumber, fixtureNumber, teamHome, getTeams);

			// uses user-inputed values to select AWAY team from database, prints "Away team: TEAM"
			teamAway = getAwayTeamName(tournamentYear, roundNumber, fixtureNumber, teamAway, getTeams);
			

			// asks user to input scores for each team
			System.out.println("\n\nPlease enter scores:");
			System.out.println(teamHome + " tries:");
			teamHTries = scanner.nextInt();
			System.out.println(teamHome + " score:");
			teamHScore = scanner.nextInt();

			System.out.println(teamAway + " tries:");
			teamATries = scanner.nextInt();
			System.out.println(teamAway + " score:");
			teamAScore = scanner.nextInt();
			
			// checks the values the user has entered
			if(validateScore(teamHTries, teamHScore) && validateScore(teamATries, teamAScore)) {
			
			Team home = new Team(TeamName.valueOf(teamHome));
			Team away = new Team(TeamName.valueOf(teamAway));
			home.setTries(teamHTries);
			home.setScore(teamHScore);
			away.setTries(teamATries);
			away.setScore(teamAScore);
			fixtureID = tournamentYear+""+roundNumber+""+fixtureNumber;
					
			insertResultsToDatabase(tournamentYear, fixtureID, home, away);
			
			// based on the results of the selected fixture, this method then updates the League table
			updateLeague(tournamentYear, teamHome, teamAway, teamHTries, teamHScore, teamATries, teamAScore);
			} else {
				System.out.println("The score you have entered cannot be valid. Please check it and try again.");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * This method reads in the name of a file, then reads from that file
	 * and stores each line as a String in an array. Then, it inputs the values from
	 * the file into the database to insert to FixtureResults
	 * @param fileName
	 */
	public static void fileToInsertResults(String fileName){
		// Initializing variables
		ArrayList<String> list = new ArrayList<String>();
		int tournamentYear=0;
		String fixtureID;
		Team home = new Team();
		Team away = new Team();
		
		//reading in a file and storing each line as a String in a String array
		try {
			File file = new File(fileName);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			String line = br.readLine();
			while (line != null) {
				list.add(line);
				line = br.readLine();
			}
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("Input/output exception");
			e.printStackTrace();
		}
		
		// setting each variable as the correct value in the file
		tournamentYear = Integer.valueOf(list.get(0));
		fixtureID = String.valueOf(tournamentYear)+list.get(1)+list.get(2);
		
		home.setName(TeamName.valueOf(list.get(3)));
		home.setTries(Integer.valueOf(list.get(4)));
		home.setScore(Integer.valueOf(list.get(5)));
		
		away.setName(TeamName.valueOf(list.get(6)));
		away.setTries(Integer.valueOf(list.get(7)));
		away.setScore(Integer.valueOf(list.get(8)));
		
		// inserts values into database
		insertResultsToDatabase(tournamentYear, fixtureID, home, away);
	}
	
	
	
	
	
	/**
	 * A method that takes in the tournament year, fixtureID and home and away teams, and inputs the
	 * results into the FixtureResults table
	 * @param tournamentYear
	 * @param fixtureID
	 * @param home
	 * @param away
	 */
	public static void insertResultsToDatabase(int tournamentYear, String fixtureID, Team home, Team away){
		try (Connection conn = DbConnect.getRemoteConnection();){
			
		
		String newResultTeamHome = "INSERT INTO FixtureResult Values(" + tournamentYear + ", '" +fixtureID+ "', '"
				+ String.valueOf(home.getName()) + "'" + ", " + home.getTries() + ", "
				+ home.getScore() + ");";
		
		// creates statement to insert AWAY team results into FixtureResult
		String newResultTeamAway = "INSERT INTO FixtureResult Values(" + tournamentYear + ", '" +fixtureID+ "', '"
				+ String.valueOf(away.getName()) + "'" + ", " + away.getTries() + ", "
				+ away.getScore() + ");";

		// adds statements to insertResult batch and executes them
		Statement insertResult = conn.createStatement();
		insertResult.addBatch(newResultTeamHome);
		insertResult.addBatch(newResultTeamAway);
		insertResult.executeBatch();
		insertResult.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * Reads in year, round and fixture and returns the AWAY team name as a String
	 * @param tournamentYear
	 * @param roundNumber
	 * @param fixtureNumber
	 * @param teamAway
	 * @param getTeams
	 * @return
	 * @throws SQLException
	 */
	public static String getAwayTeamName(int tournamentYear, int roundNumber, int fixtureNumber, String teamAway,
			Statement getTeams) throws SQLException {
		ResultSet rs = getTeams.executeQuery("SELECT TeamNameAway FROM Fixture WHERE Year = " + tournamentYear
				+ " AND RoundNo = " + roundNumber + " AND FixtureNo = " + fixtureNumber + ";");
		while (rs.next()) {
			teamAway = rs.getString("TeamNameAway");
		}
		System.out.println("\nAway team: " + teamAway);
		return teamAway;
	}

	
	

	
	/**
	 * Reads in year, round and fixture and returns the HOME team name as a String
	 * @param tournamentYear
	 * @param roundNumber
	 * @param fixtureNumber
	 * @param teamHome
	 * @param getTeams
	 * @return
	 * @throws SQLException
	 */
	public static String getHomeTeamName(int tournamentYear, int roundNumber, int fixtureNumber, String teamHome,
			Statement getTeams) throws SQLException {
		ResultSet rs = getTeams.executeQuery("SELECT TeamNameHome FROM Fixture WHERE Year = " + tournamentYear
				+ " AND RoundNo = " + roundNumber + " AND FixtureNo = " + fixtureNumber + ";");
		while (rs.next()) {
			teamHome = rs.getString("TeamNameHome");
		}
		System.out.println("\nHome team: " + teamHome);
		return teamHome;
	}

	
	

	
	/**
	 * Prompts user for a fixture number and returns it as an integer
	 * @param scanner
	 * @param fixtureNumber
	 * @return
	 */
	public static int promptForFixtureNumber(Scanner scanner, int fixtureNumber) {
		while (fixtureNumber < 1 || fixtureNumber > 5) {
			System.out.println("Select fixture:");
			fixtureNumber = scanner.nextInt();
		}
		return fixtureNumber;
	}

	
	

	
	/**
	 * Prompts user for a round number and returns it as an integer
	 * @param scanner
	 * @param roundNumber
	 * @param numberOfRounds
	 * @return
	 */
	public static int promptForRoundNumber(Scanner scanner, int roundNumber, int numberOfRounds) {
		while (roundNumber < 1 || roundNumber > numberOfRounds) {
			System.out.println("Select round:");
			roundNumber = scanner.nextInt();
		}
		return roundNumber;
	}
	
	
	
	
	
	/**
	 * Prompts user for a year and returns it as an integer
	 * @param scanner
	 * @param tournamentYear
	 * @return
	 */
	public static int promptForTournamentYear(Scanner scanner, int tournamentYear) {
		while (tournamentYear < 1) {
			System.out.println("Select tournament year:");
			tournamentYear = scanner.nextInt();
		}
		return tournamentYear;
	}

	
	
	

	

	/**
	 * This method asks users for the year, round and fixture that they wish to view results for
	 * It then retrieves this values from the database and prints them to screen
	 * @param scanner
	 */
	public static void getResultForFixtureDB(Scanner scanner) {

		try (Connection conn = DbConnect.getRemoteConnection();){

			String tournamentYear = "0";
			String roundNumber = "0";
			int numberOfRounds = 5;
			String fixtureNumber = "0";
			int teamHTries;
			int teamHScore;
			int teamATries;
			int teamAScore;
			String teamHome = null;
			String teamAway = null;
			String fixtureID;

			// asks user to select tournament
			while (Integer.valueOf(tournamentYear) < 1) {
				System.out.println("Select tournament year:");
				tournamentYear = Integer.toString(scanner.nextInt());
			}

			// asks user to select round from which to retrieve info
			while (Integer.valueOf(roundNumber) < 1 || (Integer.valueOf(roundNumber) > numberOfRounds)) {
				System.out.println("Select round:");
				roundNumber = Integer.toString(scanner.nextInt());
			}

			// asks user to select fixture from which to retrieve scores
			while (Integer.valueOf(fixtureNumber) < 1 || Integer.valueOf(fixtureNumber) > 5) {
				System.out.println("Select fixture:");
				fixtureNumber = Integer.toString(scanner.nextInt());
			}

			fixtureID = tournamentYear + roundNumber + fixtureNumber;

			// uses user-inputed values to select HOME team from database
			Statement getResult = conn.createStatement();
			ResultSet rs = getResult.executeQuery(
					"SELECT TeamName, Tries, Score FROM FixtureResult WHERE FixtureID = '" + fixtureID + "';");
			while (rs.next()) {
				System.out.println(rs.getString("TeamName") + " Tries: "+rs.getString("Tries") + ", Score: " +rs.getString("Score"));
			}

			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void promptToPrintRoundResults(Tournament tournament, Scanner scanner) {
		int roundNumber = 0;
		

		System.out.println("Print the results of a round");
		// asks user to select round to print the score of
		while (roundNumber < 1 || roundNumber > tournament.getRounds().size()) {
			System.out.println("Select round:");
			roundNumber = scanner.nextInt();
		}

		Round round = tournament.getRounds().get(roundNumber - 1);
		round.printRoundResults();
	}
	
	/**
	 * This method reads the current League table values from the database, then updates them
	 * based on the fixture results.
	 * @param year
	 * @param teamHome
	 * @param teamAway
	 * @param teamHTries
	 * @param teamHScore
	 * @param teamATries
	 * @param teamAScore
	 */
	public static void updateLeague(int year, String teamHome, String teamAway, int teamHTries, int teamHScore, int teamATries, int teamAScore){
		int homeGamesPlayed=0;
		int teamHomeScore=0;
		int teamHomePointsConceded=0;
		int teamHomeTries = 0;
		int teamHomeBonusPoints=0;
		int teamHomeTotalPoints=0;
		int teamHomeWon=0;
		int teamHomeDrawn=0;
		int teamHomeLost=0;
		
		int awayGamesPlayed=0;
		int teamAwayScore=0;
		int teamAwayTries =0;
		int teamAwayBonusPoints=0;
		int teamAwayPointsConceded=0;
		int teamAwayTotalPoints=0;
		int teamAwayWon=0;
		int teamAwayDrawn=0;
		int teamAwayLost=0;
		
		try (Connection conn = DbConnect.getRemoteConnection();){
			Statement updateLeague = conn.createStatement();
			
			// calculateBonusPoints returns an int array containing the values for bonus points and match points for both teams
			// index 0 = teamHomeBonusPoints, 1 = teamHomeMatchPoints
			// 2 = teamAwayBonusPoints, 3 = teamAwayBonusPoints
			int[] bonusPoints = Result.calculateBonusPoints(teamHome, teamHScore, teamHTries, teamAway, teamAScore, teamATries);
			
			// selects HOME team values from League table in database
			Statement getLeagueTable = conn.createStatement();
			ResultSet rs = getLeagueTable.executeQuery(
					"SELECT GamesPlayed, Won, Drawn, Lost, PointsScored, PointsConceded, Tries, BonusPoints, TotalPoints FROM League WHERE Year = " + year +
					" AND TeamName = '"+teamHome+"';");
			// updates HOME values based on new match results
			while (rs.next()) {
				homeGamesPlayed = Integer.valueOf(rs.getString("GamesPlayed"))+1;
				teamHomeWon = Integer.valueOf(rs.getString("Won"));
				teamHomeDrawn = Integer.valueOf(rs.getString("Drawn"));
				teamHomeLost = Integer.valueOf(rs.getString("Lost"));
				teamHomeScore = teamHScore + Integer.valueOf(rs.getString("PointsScored"));
				teamHomePointsConceded = teamAScore + Integer.valueOf(rs.getString("PointsConceded"));
				teamHomeTries = teamHTries + Integer.valueOf(rs.getString("Tries"));
				teamHomeBonusPoints = bonusPoints[0] + Integer.valueOf(rs.getString("BonusPoints"));
				teamHomeTotalPoints = bonusPoints[1] + Integer.valueOf(rs.getString("TotalPoints"))+ teamHomeBonusPoints;
				
			}
			
			// selects AWAY team values from League table in database
			rs = getLeagueTable.executeQuery(
					"SELECT GamesPlayed, Won, Drawn, Lost, PointsScored, PointsConceded, Tries, BonusPoints, TotalPoints FROM League WHERE Year = "+year+
					" AND TeamName = '"+teamAway+"';");
			// updates AWAY values based on new match results
			while (rs.next()) {
				awayGamesPlayed = Integer.valueOf(rs.getString("GamesPlayed"))+1;
				teamAwayWon = Integer.valueOf(rs.getString("Won"));
				teamAwayDrawn = Integer.valueOf(rs.getString("Drawn"));
				teamAwayLost = Integer.valueOf(rs.getString("Lost"));
				teamAwayScore = teamAScore + Integer.valueOf(rs.getString("PointsScored"));
				teamAwayPointsConceded = teamHScore + Integer.valueOf(rs.getString("PointsConceded"));
				teamAwayTries = teamATries + Integer.valueOf(rs.getString("Tries"));
				teamAwayBonusPoints = bonusPoints[2] + Integer.valueOf(rs.getString("BonusPoints"));
				teamAwayTotalPoints = bonusPoints[3] + Integer.valueOf(rs.getString("TotalPoints")) + teamAwayBonusPoints;
			}
			rs.close();
			
			// Adjust Wins, Draws and Losses for each team
			if (teamHomeScore == teamAwayScore) {
				teamHomeDrawn++;
				teamAwayDrawn++;
			} else if (teamHomeScore > teamAwayScore) {
				teamHomeWon++;
				teamAwayLost++;
			} else if (teamHomeScore < teamAwayScore) {
				teamAwayWon++;
				teamHomeLost++;
			}
			
			// the following SQL statements update the new values into the Home and Away rows in the League table
			updateLeague.addBatch("UPDATE League SET GamesPlayed = "+homeGamesPlayed+", Won = "+teamHomeWon+", Drawn = "+teamHomeDrawn+", Lost="+teamHomeLost
					+ ", PointsScored = "+teamHomeScore+ ", PointsConceded = "+teamHomePointsConceded+", Tries = "+teamHomeTries+", BonusPoints = "+teamHomeBonusPoints+
					", TotalPoints = "+teamHomeTotalPoints+" WHERE Year = "+year+" AND TeamName ='"+teamHome+"';");
			updateLeague.addBatch("UPDATE League SET GamesPlayed = "+awayGamesPlayed+", Won = "+teamAwayWon+", Drawn = "+teamAwayDrawn+", Lost = "+teamAwayLost
					+ ", PointsScored = "+teamAwayScore+", PointsConceded = "+teamAwayPointsConceded+", Tries = "+teamAwayTries+", BonusPoints = "+teamAwayBonusPoints+
					", TotalPoints = "+teamAwayTotalPoints+" WHERE Year = "+year+" AND TeamName ='"+teamAway+"';");
			
			updateLeague.executeBatch();
			conn.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	
	/**
	 * Takes the user inputted values and checks to see if this can constitute a valid rugby score
	 * @param tries
	 * @param score
	 * @return boolean validScore
	 */
	public static boolean validateScore(int tries, int score) {
		boolean validScore = true;

		if ((score == 2) || (score == 3) || (score == 4) || ((5*tries)>score)){
			validScore = false;
		}
		
		if (tries!=0){
			if(score%tries == 1){
				validScore = false;
			}
		}
	
			return validScore;
	}
}
