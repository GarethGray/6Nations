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

			// drop statements

			String dropIfExistsLeague = "DROP TABLE IF EXISTS League;";

			String dropIfExistsFixtureResult = "DROP TABLE IF EXISTS FixtureResult;";

			String dropIfExistsFixture = "DROP TABLE IF EXISTS Fixture;";

			String dropIfExistsTeam = "DROP TABLE IF EXISTS Team;";

			// Create Statements

			String createTeam = "CREATE TABLE Team (TeamName char(50), PRIMARY KEY(TeamName));";

			String createFixture = "CREATE TABLE Fixture (TeamName char(50), Year numeric(4,0), FixtureID int not null auto_increment, RoundNo numeric(1,0),  "

					+ " PRIMARY KEY(FixtureID, TeamName), FOREIGN KEY (TeamName) REFERENCES Team(TeamName) ON DELETE NO ACTION) ENGINE=InnoDB DEFAULT CHARSET=latin1;";

			String createFixtureResult = "CREATE TABLE FixtureResult (Year numeric(4,0), FixtureID int not null auto_increment, TeamName char(50), Tries numeric(3,0), Score numeric(3,0),"

					+ " PRIMARY KEY(FixtureID, TeamName), FOREIGN KEY (TeamName) REFERENCES Team(TeamName)ON DELETE NO ACTION,"

					+ " FOREIGN KEY (FixtureID) REFERENCES Fixture(FixtureID) ON DELETE NO ACTION);";

			// Should Fixture Result also record win/loses or can calculate
			// comparing both teams of fixture?

			String createLeague = "CREATE TABLE League (Year numeric(4,0), FixtureID int not null auto_increment, TeamName char(50), GamesPlayed numeric(1,0), PointsScored numeric (4,0), "

					+ " PointsConceded numeric (4,0), Tries numeric(3,0), BonusPoints numeric(4,0), TotalPoints numeric(4,0),"

					+ " PRIMARY KEY(Year, FixtureID, TeamName),"

					+ " FOREIGN KEY (TeamName) REFERENCES Team(TeamName)ON DELETE NO ACTION, "

					+ " FOREIGN KEY (FixtureID) REFERENCES Fixture(FixtureID) ON DELETE NO ACTION);";

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