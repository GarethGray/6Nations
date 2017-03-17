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

	public Tournament generateFixtures(int numberOfRounds, int year, ArrayList<Team> teams) {
		
		
		ArrayList<Round> roundList = new ArrayList<>();

		// randomly shuffle teams
		Collections.shuffle(teams);

		// generate first fixture
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
	

	public Round createARound(ArrayList<Team> teams) {
		
		return new Round(new Fixture(teams.get(0), teams.get(5)),
				new Fixture(teams.get(1), teams.get(4)), new Fixture(teams
						.get(2), teams.get(3)));
		
	}

}
