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
		try (Connection conn = DbConnect.getRemoteConnection();){
			DbConnect.createDB();
			System.out.println("Enter Year");
			int year = scanner.nextInt();
			test = new Tournament(year);
			Statement checkWorks = conn.createStatement();
			ResultSet rs = checkWorks.executeQuery("SELECT * FROM Team;");
			while (rs.next()) {
				System.out.println("Team name: " + rs.getString("TeamName"));
			}

			//System.out.println("----- \n ResultUtils.promptToInsertResults:\n");
			//ResultUtils.promptToInsertResults(scanner);
			
			System.out.println("----- \n ResultUtils.fileToInsertResults:\n");
			ResultUtils.fileToInsertResults("matchResults201712");
			
			System.out.println("----- \n ResultUtils.getResultsForFixtureDB:\n");
			ResultUtils.getResultForFixtureDB(scanner);
			
			conn.close();
			
			returnLeagueTable();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	public static void returnLeagueTable(){
		try (Connection conn = DbConnect.getRemoteConnection();){
			Statement getLeagueTable = conn.createStatement();
			ResultSet rs = getLeagueTable.executeQuery("SELECT * FROM League ORDER BY TotalPoints DESC");
			System.out.println("YEAR\t TEAM NAME\tWON \tDRAWN \tLOST \tGAMES PLAYED\t POINTS SCORED\t POINTS CONCEDED\tTRIES\t BONUS\t TOTAL POINTS");
			System.out.println("-----------------------------------------------------------------------------------------------------------------------------------");
			while(rs.next()){
				System.out.format("%1s%13s%9s%9s%8s%13s%15s%18s%18s%10s%10s\n",rs.getString("Year"),rs.getString("TeamName"),
					rs.getString("Won"),rs.getString("Drawn"),rs.getString("Lost"),
			rs.getString("GamesPlayed"),rs.getString("PointsScored"),rs.getString("PointsConceded"),
			rs.getString("Tries"),rs.getString("BonusPoints"),rs.getString("TotalPoints"));
			


			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
}