package uk.ac.qub.SixNationsProject;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Sandbox {

	public static void main(String[] args) {
		
		/**
		 * This section of code is creating a tournament and testing that it returns the correct teams in the tournament
		 */
		Tournament test;
		Scanner scanner = new Scanner(System.in);
		try {
			DbConnect.createDB();
			Connection conn = DbConnect.getRemoteConnection();
			test = new Tournament(2017);
			Statement checkWorks = conn.createStatement();
			ResultSet rs = checkWorks.executeQuery("SELECT * FROM Team;");
			while (rs.next()) {
				System.out.println("Team name: " + rs.getString("TeamName"));
			}

			System.out.println("----- \n ResultUtils.promptToInsertResults:\n");
			ResultUtils.promptToInsertResults(scanner);
			
			System.out.println("----- \n ResultUtils.getResultsForFixtureDB:\n");
			ResultUtils.getResultForFixtureDB(scanner);
			
			conn.close();
			
			returnLeagueTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void returnLeagueTable(){
		Connection conn;
		try {
			conn = DbConnect.getRemoteConnection();
			Statement getLeagueTable = conn.createStatement();
			ResultSet rs = getLeagueTable.executeQuery("SELECT * FROM League");
			System.out.println("YEAR\t TEAM NAME\t GAMES PLAYED\t POINTS SCORED\t POINTS CONCEDED\t TRIES\t BONUS\t TOTAL POINTS");
			while(rs.next()){
				System.out.println(rs.getString("Year")+"\t"+rs.getString("TeamName")+"\t"+
			rs.getString("GamesPlayed")+"\t"+rs.getString("PointsScored")+"\t"+rs.getString("PointsConceded")+"\t"+
			rs.getString("Tries")+"\t"+rs.getString("BonusPoints")+"\t"+rs.getString("TotalPoints")+"\t");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}