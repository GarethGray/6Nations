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
//		Tournament test;
//		Scanner scanner = new Scanner(System.in);
//		try (Connection conn = DbConnect.getRemoteConnection();){
//			DbConnect.createDB();
//			System.out.println("Enter Year");
//			int year = scanner.nextInt();
//			test = new Tournament(year);
//			Statement checkWorks = conn.createStatement();
//			ResultSet rs = checkWorks.executeQuery("SELECT * FROM Team;");
//			while (rs.next()) {
//				System.out.println("Team name: " + rs.getString("TeamName"));
//			}
//
//			//System.out.println("----- \n ResultUtils.promptToInsertResults:\n");
//			//ResultUtils.promptToInsertResults(scanner);
//			
//			System.out.println("----- \n ResultUtils.fileToInsertResults:\n");
//			ResultUtils.fileToInsertResults("matchResults201712.txt");
//			
//			System.out.println("----- \n ResultUtils.getResultsForFixtureDB:\n");
//			ResultUtils.getResultForFixtureDB(scanner);
//			
//			conn.close();
//			
//			ResultUtils.returnLeagueTable();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
		
		Application.menu();
	}

}