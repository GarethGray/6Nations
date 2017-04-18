/**
 * 
 */
package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mattmcquillan
 *
 */
public class Test_Round {

	
	int validFixtureNumber, validRoundNumber;
	Team team1, team2, team3, team4, team5, team6;
	Fixture fixture1, fixture2, fixture3;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		validFixtureNumber = 1;
		validRoundNumber = 1;
		
		
		team1 = new Team(TeamName.ENGLAND);
		team2 = new Team(TeamName.FRANCE);
		team3 = new Team(TeamName.IRELAND);
		team4 = new Team(TeamName.ITALY);
		team5 = new Team(TeamName.SCOTLAND);
		team6 = new Team(TeamName.WALES);
		
		fixture1 = new Fixture(validFixtureNumber, team1, team2);
		fixture2 = new Fixture(validFixtureNumber, team3, team4);
		fixture3 = new Fixture(validFixtureNumber, team5, team6);
		
		
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Round#Round(uk.ac.qub.SixNationsProject.Fixture, uk.ac.qub.SixNationsProject.Fixture, uk.ac.qub.SixNationsProject.Fixture, int)}.
	 */
	@Test
	public void testRoundConstructor() {
		
		Round round = new Round(fixture1, fixture2, fixture3, validRoundNumber);
		assertTrue(round != null);
		
		assertEquals(fixture1, round.getFixture1());
		assertEquals(fixture2, round.getFixture2());
		assertEquals(fixture3, round.getFixture3());
		
	
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Round#getFixture1()}.
	 */
	@Test
	public void testGetFixture1() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Round#getFixture2()}.
	 */
	@Test
	public void testGetFixture2() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Round#getFixture3()}.
	 */
	@Test
	public void testGetFixture3() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Round#getNumber()}.
	 */
	@Test
	public void testGetNumber() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Round#printFixtures()}.
	 */
	@Test
	public void testPrintFixtures() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Round#setFixtures(uk.ac.qub.SixNationsProject.Fixture, uk.ac.qub.SixNationsProject.Fixture, uk.ac.qub.SixNationsProject.Fixture)}.
	 */
	@Test
	public void testSetFixtures() {
		fail("Not yet implemented");
	}

}
