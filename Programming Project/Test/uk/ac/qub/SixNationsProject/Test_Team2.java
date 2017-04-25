package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Test_Team2 {

	//set up data
	
	int validPoints, invalidPoints, validBonusPoints, invalidBonusPoints, validScoreFor, invalidScoreFor,
	validScoreAgainst, invalidScoreAgainst, validPlayed, invalidPlayed, validWon, invalidWon, validLost,
	invalidLost, validDrawn, invalidDrawn, validTries, invalidTries;
	
	private ArrayList<Team> teams;
	
	
	Tournament t1 = new Tournament(teams, 2017);
	
	@Before
	public void setUp() throws Exception {
		
		
		
		validPoints = 4;
		invalidPoints = 6;
		validBonusPoints = 1;
		invalidBonusPoints = 5; //greater than total points
		validScoreFor = 17;
		invalidScoreFor = 4;
		validScoreAgainst = 17;
		invalidScoreAgainst = 4;
		validPlayed = 2;
		invalidPlayed = (t1.getTeams().size());
		validWon = 4;
		invalidWon = (t1.getTeams().size());
		validLost = 4;
		invalidLost = 6;
		validDrawn = 2;
		invalidDrawn = 6;
		validTries = 3;
		invalidTries = - 1;
		
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
