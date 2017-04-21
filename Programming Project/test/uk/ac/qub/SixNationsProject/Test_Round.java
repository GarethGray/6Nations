/**
 * 
 */
package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

/**
 * @author mattmcquillan
 *
 */
public class Test_Round {

	private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
	
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
		assertEquals(validFixtureNumber, round.getNumber());
		
	
	}

	/**
	 * Test method for getter and setter for fixture1
	 */
	@Test
	public void testSetGetFixture1() {
		
		Round round = new Round(fixture1, fixture2, fixture3, validRoundNumber);
		round.setFixture1(fixture2);
		assertEquals(fixture2, round.getFixture1());
		
		
	}

	/**
	 * Test method for getter and setter for fixture2
	 */
	@Test
	public void testSetGetFixture2() {
		
		Round round = new Round(fixture1, fixture2, fixture3, validRoundNumber);
		round.setFixture2(fixture1);
		assertEquals(fixture1, round.getFixture2());
	}

	/**
	 * Test method for getter and setter for fixture3
	 */
	@Test
	public void testGetFixture3() {
		
		Round round = new Round(fixture1, fixture2, fixture3, validRoundNumber);
		round.setFixture3(fixture1);
		assertEquals(fixture1, round.getFixture3());
	
	}

	/**
	 * Test method for getter and setter for number
	 */
	@Test
	public void testGetSetNumber() {
		Round round = new Round(fixture1, fixture2, fixture3, 3);
		round.setNumber(validRoundNumber);
		assertEquals(validRoundNumber, round.getNumber());
	}

	/**
	 * Test method for print fixtures
	 * 
	 * 
	 */
	@Test
	public void testPrintFixtures() {
		
		
		System.setOut(new PrintStream(outContent));
		
		Round round = new Round(fixture1, fixture2, fixture3, validRoundNumber);
		
		
		round.printFixtures();
		
		//Test that the output is not null
		assertTrue(outContent.toString() != null);
		
		//set up expected output
		String expected = ("Round " + round.getNumber()+"\n"+"1. "+fixture1.getTeam1().getName()+" vs "+fixture1.getTeam2().getName()+"\n"+
		"2. "+fixture2.getTeam1().getName()+" vs "+fixture2.getTeam2().getName()+"\n"
		+"3. "+fixture3.getTeam1().getName()+" vs "+fixture3.getTeam2().getName()+"\n"+" \n");
		  
		 //comparison
		assertEquals(expected, outContent.toString());
		
		
		System.setOut(null);

		 
	   
	}

	

}
