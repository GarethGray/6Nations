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
		
		Result match1result = new Result(tournamentRounds.get(0), tournamentRounds.get(0).getFixture1(),
				tournamentRounds.get(0).getFixture1().getTeam1(), 7, 20,
				tournamentRounds.get(0).getFixture1().getTeam2(), 6, 47);
		
		match1result.printMatchScores();
		System.out.println();
		
		Result match2result = new Result(tournamentRounds.get(0), tournamentRounds.get(0).getFixture2(),
				tournamentRounds.get(0).getFixture2().getTeam1(), 0, 0,
				tournamentRounds.get(0).getFixture2().getTeam2(), 0, 0);
			
		match2result.printMatchScores();
	}

}
