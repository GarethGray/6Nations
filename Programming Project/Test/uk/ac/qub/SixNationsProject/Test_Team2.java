package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test_Team2 {

	@Before
	public void setUp() throws Exception {
		Team validTeam = new Team(TeamName.WALES);
	}

	@Test
	public void testTeam() {
		Team validTeam = new Team(TeamName.WALES);
		assertTrue(validTeam != null);
		assertEquals(validTeam.getName(), TeamName.WALES);
		
	}

	@Test
	public void testGetSetName() {
		Team validTeam = new Team(null);
		validTeam.setName(TeamName.FRANCE);
		assertEquals(validTeam.getName(), TeamName.FRANCE);
	}

	@Test
	public void testGetSetPoints() {
		Team validTeam = new Team(TeamName.WALES);
		validTeam.setPoints(5);
		assertEquals(validTeam.getPoints(), 5);
	}


	@Test
	public void testAddPoints() {
		Team validTeam = new Team(TeamName.WALES);
		validTeam.setPoints(5);
		validTeam.addPoints(3);
		assertEquals(validTeam.getPoints(), 8);
	}

	@Test
	public void testGetSetBonusPoints() {
		Team validTeam = new Team(TeamName.WALES);
		validTeam.setBonusPoints(2);
		assertEquals(validTeam.getBonusPoints(), 2);
	}

	@Test
	public void testAddBonusPoints() {
		Team validTeam = new Team(TeamName.WALES);
		validTeam.setBonusPoints(5);
		validTeam.addBonusPoints(3);
		assertEquals(validTeam.getBonusPoints(), 8);
	}

	@Test
	public void testGetScoreFor() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddScoreFor() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetScoreAgainst() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddScoreAgainst() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetPlayed() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetWon() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetLost() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetDrawn() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTries() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddTries() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementPlayed() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementDrawn() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementWon() {
		fail("Not yet implemented");
	}

	@Test
	public void testIncrementLost() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetValues() {
		fail("Not yet implemented");
	}

}
