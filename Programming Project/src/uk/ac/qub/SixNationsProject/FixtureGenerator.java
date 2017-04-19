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
	 * appropriate number of rounds (the number of teams minus 1) have been generated and added to roundList. Using this roundList the 
	 * method then @returns a new Tournament
	 * @param year
	 * @param teams
	 * @return Tournament
	 */

	
	

	/**
	 * This method takes an ArrayList of teams and creates 3 fixtures, 
	 * pairing teams based on their position within the ArrayList @param teams
	 * @return new Round
	 */
	public Round createARound(ArrayList<Team> teams, int roundNumber) {
		
		return new Round(new Fixture(1, teams.get(0), teams.get(5)),
				new Fixture(2, teams.get(1), teams.get(4)), new Fixture(3, teams
						.get(2), teams.get(3)), roundNumber);
		
	}

}
