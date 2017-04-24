package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class Test_Team {

	@Before
	public void setUp() throws Exception {
		
		Team validTeam = new Team(TeamName.WALES);
	
		
	}

	/**
	 * Testing constructor args
	 */
	@Test
	public void testTeam() {
	
		Team validTeam = new Team(TeamName.WALES);
		assertTrue(validTeam  != null);
		
	}

	/**
	 * Testing getter and setter
	 */
	@Test
	public void testSetGetName() {
		Team validTeam = new Team(TeamName.WALES);
		assertEquals(validTeam.getName(), TeamName.WALES);
		
	}

	

}
