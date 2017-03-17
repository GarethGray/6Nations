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
		
		FixtureGenerator fg = new FixtureGenerator();
		Tournament testTournament = fg.generateFixtures(5, 2017, teams);
		ArrayList<Round> tournamentRounds = testTournament.getRounds();
		int roundNo = 1;
		for(Round r : tournamentRounds){
			System.out.println("Round "+roundNo);
			r.printFixtures();
			System.out.println();
			roundNo++;
		}
	}

}
