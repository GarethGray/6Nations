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
		String testString=null;
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
			
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}