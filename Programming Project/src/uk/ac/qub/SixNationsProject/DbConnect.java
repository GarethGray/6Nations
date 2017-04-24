package uk.ac.qub.SixNationsProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DbConnect {

	public static void main(String args[]) throws SQLException {
		Connection conn = getRemoteConnection();

		try {

			// Create a table and write two rows
			Statement checkIfExists = conn.createStatement();
			Statement setupStatement = conn.createStatement();

			String dropIfExistsLeague = "DROP TABLE IF EXISTS League;";
			String dropIfExistsTeam = "DROP TABLE IF EXISTS Team;";
			String dropIfExistsFixture = "DROP TABLE IF EXISTS Fixture;";
			String dropIfExistsResult = "DROP TABLE IF EXISTS Result;";
			

			String createTeam = "CREATE TABLE Team (TeamName char(50), PRIMARY KEY(TeamName));";
			
			String createLeague = "CREATE TABLE League (LeagueID numeric(4,0), TeamName char(50), Tries numeric(4,0), PointsFor numeric (4,0), PointsAgainst numeric (4,0),"
					+ " BonusPoints numeric(4,0), PRIMARY KEY(LeagueID), FOREIGN KEY (TeamName) REFERENCES Team(TeamName) ON DELETE SET NULL);";
			
			String createFixture = "CREATE TABLE Fixture (LeagueID numeric(4,0), Team1 char(50), Team2 char(50), RoundID numeric(2,0)," 
					+ " PRIMARY KEY(LeagueID, RoundID), FOREIGN KEY (Team1) REFERENCES Team(TeamName) ON DELETE SET NULL,  FOREIGN KEY (Team2) REFERENCES Team(TeamName) ON DELETE SET NULL );";
			
			String createResult = "CREATE TABLE Result (FixtureId numeric(4,0), Team1Score numeric(4,0), Team1Tries numeric(4,0), Team2Score numeric(4,0), Team2Tries numeric(4,0),"
					+ "PRIMARY KEY(FixtureId));";

			
			//inserts for team names
			String insertIreland = "INSERT INTO Team (TeamName) VALUES ('Ireland');";
			String insertEngland = "INSERT INTO Team (TeamName) VALUES ('England');";
			String insertScotland = "INSERT INTO Team (TeamName) VALUES ('Scotland');";
			String insertWales = "INSERT INTO Team (TeamName) VALUES ('Wales');";
			String insertFrance = "INSERT INTO Team (TeamName) VALUES ('France');";
			String insertItaly = "INSERT INTO Team (TeamName) VALUES ('Italy');";

			// if table already exists then drop it
			checkIfExists.addBatch(dropIfExistsLeague);
			checkIfExists.addBatch(dropIfExistsResult);
			checkIfExists.addBatch(dropIfExistsFixture);		
			checkIfExists.addBatch(dropIfExistsTeam);
			
			checkIfExists.executeBatch();

			// create our league table
			setupStatement.addBatch(createTeam);
			setupStatement.addBatch(createLeague);
			setupStatement.addBatch(createFixture);
			setupStatement.addBatch(createResult);
			
			setupStatement.addBatch(insertIreland);
			setupStatement.addBatch(insertEngland);
			setupStatement.addBatch(insertScotland);
			setupStatement.addBatch(insertWales);
			setupStatement.addBatch(insertFrance);
			setupStatement.addBatch(insertItaly);
			setupStatement.executeBatch();
			setupStatement.close();

		} catch (SQLException ex) {

			// Handle any errors
			System.out.println("SQLException: " + ex.getMessage());
			System.out.println("SQLState: " + ex.getSQLState());
			System.out.println("VendorError: " + ex.getErrorCode());

		} finally {
			System.out.println("Closing the connection.");

			if (conn != null)
				try {
					conn.close();
				} catch (SQLException ignore) {
				}
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

}
