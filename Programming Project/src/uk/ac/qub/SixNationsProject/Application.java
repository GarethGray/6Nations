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
		
<<<<<<< HEAD
		System.out.println("From each according to his ability to each according to his need");
		System.out.println("Laura got is workingngkj");
=======
		System.out.println("Aine woz ere k");
>>>>>>> branch 'master' of https://github.com/GarethGray/6Nations

		Team scotland = new Team(TeamName.SCOTLAND);
		Team france = new Team(TeamName.FRANCE);
		Team england = new Team(TeamName.ENGLAND);
		Team ireland = new Team(TeamName.IRELAND);
		Team wales = new Team(TeamName.WALES);
		Team italy = new Team(TeamName.ITALY);

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
		for(Round r : tournamentRounds){
			r.printFixtures();
		}
	}

}
