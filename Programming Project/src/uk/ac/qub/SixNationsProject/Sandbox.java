package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Sandbox {

	public static void main(String[] args) {
		
		FixtureGenerator fg = new FixtureGenerator();
		ArrayList<Fixture> fixtures = new ArrayList<>();
		
		// TODO Auto-generated method stub
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
		
		Fixture testFixture = new Fixture(1, england, scotland);
		Fixture testFixture2 = new Fixture(2, england, scotland);
		
		
	}

}
