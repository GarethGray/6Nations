
package uk.ac.qub.SixNationsProject;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

import java.sql.Statement;
import java.util.ArrayList;

public class DbConnect {

	public static void createDB() throws SQLException {


		try (Connection conn = DbConnect.getRemoteConnection();){

			// Create a table and write two rows

			Statement checkIfExists = conn.createStatement();

			Statement setupStatement = conn.createStatement();

			// drop statements

			String dropIfExistsLeague = "DROP TABLE IF EXISTS League;";

			String dropIfExistsFixtureResult = "DROP TABLE IF EXISTS FixtureResult;";

			String dropIfExistsFixture = "DROP TABLE IF EXISTS Fixture;";

			String dropIfExistsTeam = "DROP TABLE IF EXISTS Team;";

			// Create Statements

			String createTeam = "CREATE TABLE Team (TeamName char(50), PRIMARY KEY(TeamName));";

			String createFixture = "Create table Fixture(FixtureID char(8), TeamNameHome char(50), TeamNameAway char(50), Year numeric(4,0),"
					+

					"FixtureNo numeric(1,0), RoundNo numeric(1,0),Primary key(Fixtureid)," +

					" foreign key (TeamNameHome) references Team(teamName),foreign key (TeamNameAway) references Team(teamName));";

			String createFixtureResult = "CREATE TABLE FixtureResult (Year numeric(4,0), FixtureID char(8), TeamName char(50), Tries numeric(3,0), Score numeric(3,0),"

					+ " PRIMARY KEY(FixtureID, TeamName), FOREIGN KEY (TeamName) REFERENCES Team(TeamName)ON DELETE NO ACTION,"

					+ " FOREIGN KEY (FixtureID) REFERENCES Fixture(FixtureID) ON DELETE NO ACTION);";

			// Should Fixture Result also record win/loses or can calculate

			// comparing both teams of fixture?

			String createLeague = "CREATE TABLE League (Year numeric(4,0), TeamName char(50), GamesPlayed numeric(1,0), Won numeric(2,0), Drawn numeric(2,0), Lost numeric(2,0), PointsScored numeric (4,0), "

					+ " PointsConceded numeric (4,0), Tries numeric(3,0), BonusPoints numeric(4,0), TotalPoints numeric(4,0),"

					+ " PRIMARY KEY(Year, TeamName),"

					+ " FOREIGN KEY (TeamName) REFERENCES Team(TeamName)ON DELETE NO ACTION);";

			// execute drop statements

			checkIfExists.addBatch(dropIfExistsLeague);

			checkIfExists.addBatch(dropIfExistsFixtureResult);

			checkIfExists.addBatch(dropIfExistsFixture);

			checkIfExists.addBatch(dropIfExistsTeam);

			checkIfExists.executeBatch();

			// create our league table. Execute setup statements

			setupStatement.addBatch(createTeam);

			setupStatement.addBatch(createFixture);

			setupStatement.addBatch(createFixtureResult);

			setupStatement.addBatch(createLeague);

			setupStatement.executeBatch();

			setupStatement.close();
			
			// adds all teams to the database
			
			addTeams();

		} catch (SQLException ex) {

			// Handle any errors

			System.out.println("SQLException: " + ex.getMessage());

			System.out.println("SQLState: " + ex.getSQLState());

			System.out.println("VendorError: " + ex.getErrorCode());

		}

	}

	public static Connection getRemoteConnection() throws SQLException {

		String dbName = "RugbyGenerator";

		String userName = "Codehorse";

		String password = "RugbyPassword";

		String hostname = "codehorserugby.c8gths3wraz9.eu-west-1.rds.amazonaws.com";

		String port = "3306";

		String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/";

		Connection con = DriverManager.getConnection(jdbcUrl + dbName, userName, password);

		return con;

	}
	
	public static void addTeams(){
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

				// this populates the database with the teams
				try (Connection conn = DbConnect.getRemoteConnection();){
					Statement insertTeam = conn.createStatement();
					for (int i = 0; i < teams.size(); i++) {
						insertTeam.addBatch("INSERT INTO Team Values('" + teams.get(i).getName() + "');");
					}
					insertTeam.executeBatch();
					insertTeam.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
	}

}