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
		
		//creating all teams to play in the tournament
		Team scotland = new Team(TeamName.SCOTLAND);
		Team france = new Team(TeamName.FRANCE);
		Team england = new Team(TeamName.ENGLAND);
		Team ireland = new Team(TeamName.IRELAND);
		Team wales = new Team(TeamName.WALES);
		Team italy = new Team(TeamName.ITALY);

		//adding all teams to an ArrayList that can be passed into
		//the FixtureGenerator
		ArrayList<Team> teams = new ArrayList<>();
		teams.add(scotland);
		teams.add(france);
		teams.add(england);
		teams.add(ireland);
		teams.add(wales);
		teams.add(italy);
		
		//create new FixtureGenerator
		FixtureGenerator fg = new FixtureGenerator();
		
		//create Tournament by passing in fixtures generated
		//with year and ArrayList of teams
		Tournament testTournament = fg.generateFixtures(2017, teams);
		ArrayList<Round> tournamentRounds = testTournament.getRounds();
		for(Round r : tournamentRounds){
			r.printFixtures();
		}
		
		//creating new Results for a given Fixture
		Result testResults = new Result(testTournament, 1, 1, 3, 40, 5, 20);
		testResults.printMatchScores();
		
		Result testResults2 = new Result(testTournament, 1, 2, 3, 40, 5, 20);
		testResults2.printMatchScores();
	}

}
