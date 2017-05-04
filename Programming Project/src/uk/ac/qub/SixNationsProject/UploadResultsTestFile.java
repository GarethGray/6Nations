package uk.ac.qub.SixNationsProject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * 
 * @author Laura McCormick
 *
 */

public class UploadResultsTestFile {
	
	/**
	 * This method reads in a given file and uses the values within it to update the scores of a fixture
	 * 
	 * @author Laura McCormick
	 * @param tournament
	 * @param fileName
	 */
	public static void uploadResults(Tournament tournament, String fileName) {
		int roundNumber = 0;
		int fixtureNumber = 0;
		Fixture chosenFixture;
		int team1Tries;
		int team1Score;
		int team2Tries;
		int team2Score;
		
		// The info variable iterates after each piece of information is used
		int info = 1;
		
		// An ArrayList is created containing the values from the file
		ArrayList<String> list = readFile(fileName);
		
		// Gleans round number from second line of file
		while (roundNumber < 1 || roundNumber > tournament.getRounds().size()) {
			roundNumber = Integer.valueOf(list.get(info));
		}
		info++;
		roundNumber--;

		// Selects round and determines number of fixtures in that round
		Round chosenRound = tournament.getRounds().get(roundNumber);
		int numberOfFixtures = chosenRound.getFixtures().size();
		
		// Gleans fixture number from third line of file
		while (fixtureNumber < 1 || fixtureNumber > numberOfFixtures) {
			fixtureNumber = Integer.valueOf(list.get(info));
		}
		info++;
		fixtureNumber--;
		chosenFixture = chosenRound.getFixtures().get(fixtureNumber);

		// gleans scores from fourth, fifth, sixth and seventh line of file
		team1Tries = Integer.valueOf(list.get(info));
		info++;
		team1Score = Integer.valueOf(list.get(info));
		info++;

		team2Tries = Integer.valueOf(list.get(info));
		info++;
		team2Score = Integer.valueOf(list.get(info));
		info++;

		int[] team1ScoreArray = { team1Tries, team1Score };
		int[] team2ScoreArray = { team2Tries, team2Score };

		Result result = chosenFixture.getResult();
		//result.setScores(team1ScoreArray, team2ScoreArray);

		// Update the teams with their points and scores
		chosenFixture.updateTeamsValues();
		System.out.println("Updated Fixture:");
		chosenFixture.printFixtureResult();
	}
	
	
	/**
	 * This method reads in the file specified and creates an ArrayList, where each 
	 * line is a new String in the list
	 * 
	 * @author Laura McCormick
	 * @param fileName
	 * @return ArrayList<String>
	 */
	public static ArrayList<String> readFile(String fileName) {
		ArrayList<String> list = new ArrayList<String>();
		
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

		return list;
	}
}
