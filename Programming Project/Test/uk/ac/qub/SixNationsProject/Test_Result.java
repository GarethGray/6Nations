package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class Test_Result {

	Team team1, team2;
	int validScore1, validScore2, validTries1, validTries2;
	
	@SuppressWarnings("static-access")
	@Before
	public void setUp() throws Exception {
		
		validScore1 = 5;
		validScore2 = 7;
		validTries1 = 1;
		validTries2 = 1;
		
		team1 = new Team(TeamName.ENGLAND);
		team2 = new Team(TeamName.FRANCE);
		
		
		Result.calculateBonusPoints("team1", validScore1, validTries1, "team2", validScore2, validTries2);
		
	}

	@Test
	public void testResult() {
		
		
		
		Result resultValid = new Result();
		assertTrue(resultValid != null);
		
	}


	
	
}
