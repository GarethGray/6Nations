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
public class Test_Fixture {

	
	int validFixtureNumber, invalidFixtureNumber;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		validFixtureNumber = 1;
		invalidFixtureNumber = 9;
		
		
	}

	/**
	 * Test method for Fixture Constructor
	 */
	@Test
	public void testFixtureConstructor() {
		
		Team team1 = new Team(TeamName.IRELAND);
		Team team2 = new Team(TeamName.ITALY);
		
		Fixture validFixture = new Fixture(1, team1, team2);
		
		assertTrue(validFixture != null);
		
	}

	/**
	 * Test method for Getter and Setter for team1
	 */
	@Test
	public void testSetGetTeam1() {
		Team team1 = new Team(TeamName.IRELAND);
		Team team2 = new Team(TeamName.ITALY);
		
		Fixture validFixture = new Fixture(1, team1, team2);
		assertEquals(TeamName.IRELAND, validFixture.getTeam1());
		
		
		
		
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Fixture#setTeam1(uk.ac.qub.SixNationsProject.Team)}.
	 */
	@Test
	public void testSetTeam1() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Fixture#getTeam2()}.
	 */
	@Test
	public void testGetTeam2() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Fixture#setTeam2(uk.ac.qub.SixNationsProject.Team)}.
	 */
	@Test
	public void testSetTeam2() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Fixture#fixtureSwitcher()}.
	 */
	@Test
	public void testFixtureSwitcher() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Fixture#getFixtureNumber()}.
	 */
	@Test
	public void testGetFixtureNumber() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for {@link uk.ac.qub.SixNationsProject.Fixture#setFixtureNumber(int)}.
	 */
	@Test
	public void testSetFixtureNumber() {
		fail("Not yet implemented");
	}

}
