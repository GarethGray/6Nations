package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test_Result {

	@Before
	public void setUp() throws Exception {
		
		
		
	}

	@Test
	public void testResult() {
		
		Result resultValid = new Result();
		assertTrue(resultValid != null);
		
	}

	@Test
	public void testSetScores() {
		
		Result resultValid = new Result();
		resultValid.setScores(team1, team2);
		
	}

	@Test
	public void testCalculatePoints() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeam1Tries() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeam1Score() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeam1Points() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeam1BonusPoints() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeam2Tries() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeam2Score() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeam2Points() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetTeam2BonusPoints() {
		fail("Not yet implemented");
	}

}
