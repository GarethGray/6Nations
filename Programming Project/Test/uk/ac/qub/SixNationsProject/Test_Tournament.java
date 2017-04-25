package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
/**
 * @author 40189322 Gareth Gray
 *
 */

public class Test_Tournament {

	private ArrayList<Fixture> fixtures;
	private Tournament tournament;
	private int year;
	private ArrayList<Team> teams;
	private ArrayList<Round> rounds;

	@Before
	public void setUp() throws Exception {
		
		year = 2017;
		fixtures = new ArrayList<Fixture>();
		teams = new ArrayList<>();
<<<<<<< HEAD
		fg = new Tournament(teams, year);
=======
>>>>>>> branch 'New-Unit-Testing' of https://github.com/GarethGray/6Nations.git

		Team ireland = new Team(TeamName.IRELAND);
		Team france = new Team(TeamName.FRANCE);
		Team england = new Team(TeamName.ENGLAND);
		Team italy = new Team(TeamName.ITALY);
		Team wales = new Team(TeamName.WALES);
		Team scotland = new Team(TeamName.SCOTLAND);

		teams.add(scotland);
		teams.add(wales);
		teams.add(italy);
		teams.add(france);
		teams.add(england);
		teams.add(ireland);
		
		tournament = new Tournament(teams,year);


		rounds = tournament.generateRounds(year, teams);
		for (Round round : rounds) {
			fixtures.addAll(round.getFixtures());
		}

	}

	@Test
	/**
	 * Testing for duplicate fixtures 
	 * Generates an ArrayList of Fixture and then
	 * creates a Set based from that ArrayList. The Set will automatically
	 * remove duplicates. Comparing the ArrayList size with the Set size will
	 * therefore tell us if there were duplicates in the generated fixtures.
	 * 
	 * NB equals and hashCode methods for Fixtures have been overridden.
	 * 
	 */
	public void testGenerateFixturesForDuplicates() {

		Set<Fixture> set = new HashSet<Fixture>(fixtures);

		assertEquals(set.size(), fixtures.size());

	}

	/**
	 * Calculates the number of unique fixtures that should be generated based
	 * on the number of teams and compares that with the number of fixtures
	 * generated by the fixtureGenerator method.
	 */
	@Test
	public void testGenerateFixturesForNumberOfFixtures() {
		int numberOfFixtures = 0;
		for (int i = (teams.size() - 1); i >= 1; i--) {
			numberOfFixtures = numberOfFixtures + i;
		}

		assertEquals(numberOfFixtures, fixtures.size());
	}

	/**
	 * Checks to see if a Round of 3 fixtures is created by createARound method
	 */
	@Test
	public void testCreateARound() {
		Round round = tournament.createARound(teams, 1);
		
		assertEquals(3, round.getFixtures().size());
	}

}
