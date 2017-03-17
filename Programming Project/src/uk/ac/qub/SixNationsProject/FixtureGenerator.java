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

	private Tournament tournament;

	/**
	 * Constructor with args
	 * 
	 * @param teams
	 */
	public FixtureGenerator(Tournament tournament) {
		this.setTournament(tournament);
	}

	/**
	 * Getter for Tournament
	 * 
	 * @return
	 */
	public Tournament getTournament() {
		return tournament;
	}

	/**
	 * Setter for Tournament
	 * 
	 * @return
	 */
	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public void generateFixtures() {
		ArrayList<Team> teams1 = (ArrayList<Team>) this.tournament.getTeams().clone();
		ArrayList<Team> teams2 = (ArrayList<Team>) this.tournament.getTeams().clone();

		Collections.shuffle(teams1);
		Collections.shuffle(teams2);

		for (Team t : teams1) {
			System.out.print(t.getName() + " ");
		}
		System.out.println(" ");
		for (Team t : teams2) {
			System.out.print(t.getName() +" ");
		}

	}

}
