package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

public class Test_FixtureGenerator {

	private ArrayList<Fixture> fixtures;
	private FixtureGenerator fg;
	private int year;
	private ArrayList<Team> teams;

	
	@Before
	public void setUp() throws Exception {
		fixtures = new ArrayList<>();
		fg = new FixtureGenerator();
		year = 2017;
		
		
		Team ireland = new Team(TeamName.IRELAND);
		Team france = new Team(TeamName.FRANCE);
		Team england = new Team(TeamName.ENGLAND);
		Team italy = new Team(TeamName.ITALY);
		Team wales = new Team(TeamName.WALES);
		Team scotland = new Team(TeamName.SCOTLAND);
		

		
		ArrayList<Team> teams = new ArrayList<>();
		teams.add(scotland);	
		teams.add(wales);
		teams.add(italy);
		teams.add(france);
		teams.add(england);
		teams.add(ireland);
		
	}

	@Test
	public void testGenerateFixtures() {
		for (Round round : fg.generateFixtures(year, teams).getRounds()) {
			fixtures.addAll(round.getFixtures());
		}
		
		Set<Fixture> set = new HashSet<Fixture>(fixtures);	
		
		assertEquals(set.size(), fixtures.size());
		
		
	}

	@Test
	public void testCreateARound() {
		fail("Not yet implemented");
	}

}
