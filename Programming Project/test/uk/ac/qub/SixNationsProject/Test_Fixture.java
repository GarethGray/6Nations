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

	
	int validFixtureNumber;
	Team validTeam1;
	Team validTeam2;
	
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		
		validFixtureNumber = 1;
		validTeam1 = new Team(TeamName.IRELAND);
		validTeam2 = new Team(TeamName.ITALY);
		
		
	}

	/**
	 * Test method for Fixture Constructor
	 */
	@Test
	public void testFixtureConstructor() {
		
		Team team1 = validTeam1;
		Team team2 = validTeam2;
		
		Fixture validFixture = new Fixture(validFixtureNumber, team1, team2);
		
		assertTrue(validFixture != null);
		assertEquals(team1, validFixture.getTeam1());
		assertEquals(team2, validFixture.getTeam2());
		assertEquals(validFixtureNumber, validFixture.getFixtureNumber());
		
	}

	/**
	 * Test method for Getter and Setter for team1
	 */
	@Test
	public void testSetGetTeam1() {
		Team team1 = validTeam1;
		Team team2 = validTeam2;
		
		Fixture validFixture = new Fixture(validFixtureNumber, team1, team2);
		validFixture.setTeam1(team2);
		assertEquals(team2, validFixture.getTeam1());
		
	}

	/**
	 * Test method for getter and setter for team2
	 */
	@Test
	public void testGetSetTeam2() {
		
		Team team1 = validTeam1;
		Team team2 = validTeam2;
		
		Fixture validFixture = new Fixture(validFixtureNumber, team1, team2);
		validFixture.setTeam2(team1);
		assertEquals(team1, validFixture.getTeam2());
	}

	
	/**
	 * Test method for fixtureSwitcher 
	 */
	@Test
	public void testFixtureSwitcher() {
		
		Team team1 = validTeam1;
		Team team2 = validTeam2;
		
		Fixture validFixture = new Fixture(validFixtureNumber, team1, team2);
		validFixture.fixtureSwitcher();
		assertEquals(validFixture.getTeam1(), team2);
		assertEquals(validFixture.getTeam2(), team1);
		
	}

	/**
	 * Test method for setter and getter for fixture number
	 */
	@Test
	public void testSetGetFixtureNumber() {
		
		Team team1 = validTeam1;
		Team team2 = validTeam2;
		
		Fixture validFixture = new Fixture(validFixtureNumber, team1, team2);
		validFixture.setFixtureNumber(2);
		assertEquals(2, validFixture.getFixtureNumber());
		
	}

	

}
