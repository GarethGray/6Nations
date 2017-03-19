/**
 * 
 */
package uk.ac.qub.SixNationsProject;

import java.util.ArrayList;
import java.util.Collections;

/**
 * @author 40189322
 *
 */

// TODO make this a singleton to prevent more than one FixtureGenerator being
// created and wreaking havoc with the fixture list.

public class FixtureGenerator {
	
	/**
	 * This method generates the fixtures for an entire tournament. It shuffles the teams to allow for randomly generated fixtures.
	 * Then it creates a Round of fixtures using createARound method. It adds this Round to an ArrayList of Rounds.
	 * It then moves the last Team in teams to the second place in the array and creates another Round. It repeats this until the given 
	 * @param numberofRounds have been generated and added to roundList. Using this roundList the method then @returns a new Tournament
	 * @param numberOfRounds
	 * @param year
	 * @param teams
	 * @return
	 */

	public Tournament generateFixtures(int numberOfRounds, int year, ArrayList<Team> teams) {
		
		
		ArrayList<Round> roundList = new ArrayList<>();

		// randomly shuffle teams
		Collections.shuffle(teams);

		// generate first round of fixtures
		roundList.add(this.createARound(teams));

		// each loop, reorder the list of teams by moving the last team to the front and then generate another round of fixtures
		for (int i = 0; i < numberOfRounds - 1; i++) {
			
			Team movingTeam = teams.get((teams.size()) - 1);
			teams.remove(movingTeam);
			teams.add(1, movingTeam);

			roundList.add(this.createARound(teams));
		}

		return new Tournament(teams, year, roundList);
	}
	

	/**
	 * This method takes an ArrayList of teams and creates 3 fixtures, pairing teams based on their position within the ArrayList
	 * @param teams
	 * @return
	 */
	public Round createARound(ArrayList<Team> teams) {
		
		return new Round(new Fixture(teams.get(0), teams.get(5)),
				new Fixture(teams.get(1), teams.get(4)), new Fixture(teams
						.get(2), teams.get(3)));
		
	}

}
