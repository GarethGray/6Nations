package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test_Team {

	@Before
	public void setUp() throws Exception {
		
		Team validTeam = new Team(TeamName.WALES);
	
		
	}

	@Test
	public void testTeam() {
	
		Team validTeam = new Team(TeamName.WALES);
		assertTrue(validTeam  != null);
		
	}

	@Test
	public void testGetName() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetName() {
		fail("Not yet implemented");
	}

}
