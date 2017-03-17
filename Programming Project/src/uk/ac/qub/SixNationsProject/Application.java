/**
 * 
 */
package uk.ac.qub.SixNationsProject;

import java.util.ArrayList;

/**
 * @author 40189322
 *
 */
public class Application {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Team scotland = new Team("Scotland");
		Team france = new Team("France");
		Team england = new Team("England");
		Team ireland = new Team("Ireland");
		Team wales = new Team("Wales");
		Team italy = new Team("Italy");

		ArrayList<Team> teams = new ArrayList<>();
		teams.add(scotland);
		teams.add(france);
		teams.add(england);
		teams.add(ireland);
		teams.add(wales);
		teams.add(italy);
		
		Round[] rounds = new Round[5];

		Tournament testTournament = new Tournament(teams, 2017, rounds );
		
		FixtureGenerator fg = new FixtureGenerator(testTournament);
		fg.generateFixtures();
		

	}

}
