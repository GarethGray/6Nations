package uk.ac.qub.SixNationsProject;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class Test_Team {

	//set up data
	
		int validPoints, invalidPoints, validBonusPoints, invalidBonusPoints, validScoreFor, invalidScoreFor,
		validScoreAgainst, invalidScoreAgainst, validPlayed, invalidPlayed, validWon, invalidWon, validLost,
		invalidLost, validDrawn, invalidDrawn, validTries, invalidTries;
		
		public ArrayList<Team> teams;
		

	
	
	
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
		invalidPlayed = 6;
		validWon = 4;
		invalidWon = 6;
		validLost = 4;
		invalidLost = 6;
		validDrawn = 2;
		invalidDrawn = 6;
		validTries = 3;
		invalidTries = - 1;
		
	}

	@Test
	public void testTeam() {
		Team team  = new Team(TeamName.ENGLAND);
		assertNotNull(team);
	}

	@Test
	public void testGetSetValidName() {
		Team team  = new Team();
		team.setName(TeamName.ENGLAND);
		assertEquals(team.getName(), TeamName.ENGLAND);
	}

	@Test
	public void testGetSetValidPoints() {
		Team team  = new Team();
		team.setPoints(validPoints);
		assertEquals(team.getPoints(), validPoints);
	}
	
	@Test
	public void testGetSetInvalidPoints() {
		Team team  = new Team();
		team.setPoints(invalidPoints);
		assertEquals(team.getPoints(), invalidPoints);
	}

	@Test
	public void testAddPoints() {
		Team team  = new Team();
		team.setPoints(validPoints);
		team.addPoints(3);
		assertEquals(team.getPoints(), (validPoints + 3));
	}

	@Test
	public void testGetSetValidBonusPoints() {
		Team team  = new Team();
		team.setBonusPoints(validBonusPoints);
		assertEquals(team.getBonusPoints(), validBonusPoints);
	}
	
	@Test
	public void testGetSetInvalidBonusPoints() {
		Team team  = new Team();
		team.setBonusPoints(invalidBonusPoints);
		assertEquals(team.getBonusPoints(), invalidBonusPoints);
	}

	@Test
	public void testAddBonusPoints() {
		Team team  = new Team();
		team.setBonusPoints(validBonusPoints);
		team.addBonusPoints(2);
		assertEquals(team.getBonusPoints(), (validBonusPoints + 2));
	}

	@Test
	public void testGetSetValidScoreFor() {
		Team team  = new Team();
		team.setScoreFor(validScoreFor);
		assertEquals(team.getScoreFor(), validScoreFor);
	}
	
	@Test
	public void testGetSetInvalidScoreFor() {
		Team team  = new Team();
		team.setScoreFor(invalidScoreFor);
		assertEquals(team.getScoreFor(), invalidScoreFor);
	}

	@Test
	public void testAddScoreFor() {
		Team team  = new Team();
		team.setScoreFor(validScoreFor);
		team.addScoreFor(5);
		assertEquals(team.getScoreFor(), (validScoreFor +5));
	}

	@Test
	public void testGetSetValidScoreAgainst() {
		Team team  = new Team();
		team.setScoreAgainst(validScoreAgainst);
		assertEquals(team.getScoreAgainst(), validScoreAgainst);
	}

	@Test
	public void testGetSetInvalidScoreAgainst() {
		Team team  = new Team();
		team.setScoreAgainst(invalidScoreAgainst);
		assertEquals(team.getScoreAgainst(), invalidScoreAgainst);
	}

	
	@Test
	public void testAddScoreAgainst() {
		Team team  = new Team();
		team.setScoreAgainst(validScoreAgainst);
		team.addScoreAgainst(5);
		assertEquals(team.getScoreAgainst(), (validScoreAgainst + 5));
	}

	@Test
	public void testGetSetValidPlayed() {
		Team team  = new Team();
		team.setPlayed(validPlayed);
		assertEquals(team.getPlayed(), validPlayed);
	}
	
	@Test
	public void testGetSetInvalidPlayed() {
		Team team  = new Team();
		team.setPlayed(invalidPlayed);
		assertEquals(team.getPlayed(), invalidPlayed);
	}

	@Test
	public void testGetSetValidWon() {
		Team team  = new Team();
		team.setWon(validWon);
		assertEquals(team.getWon(), validWon);
	}

	@Test
	public void testGetSetInvalidWon() {
		Team team  = new Team();
		team.setWon(invalidWon);
		assertEquals(team.getWon(), invalidWon);
	}
	
	@Test
	public void testGetSetValidLost() {
		Team team  = new Team();
		team.setLost(validLost);
		assertEquals(team.getLost(), validLost);
	}

	@Test
	public void testGetSetInvalidLost() {
		Team team  = new Team();
		team.setLost(invalidLost);
		assertEquals(team.getLost(), invalidLost);
	}
	
	@Test
	public void testGetSetValidDrawn() {
		Team team  = new Team();
		team.setDrawn(validDrawn);
		assertEquals(team.getDrawn(), validDrawn);
	}
	
	@Test
	public void testGetSetinvalidDrawn() {
		Team team  = new Team();
		team.setDrawn(invalidDrawn);
		assertEquals(team.getDrawn(), invalidDrawn);
	}

	@Test
	public void testGetSetValidTries() {
		Team team  = new Team();
		team.setTries(validTries);
		assertEquals(team.getTries(), validTries);
		
	}
	
	@Test
	public void testGetSetInvalidTries() {
		Team team  = new Team();
		team.setTries(invalidTries);
		assertEquals(team.getTries(), invalidTries);
	
	}
		

	@Test
	public void testAddTries() {
		Team team  = new Team();
		team.setTries(validTries);
		team.addTries(1);
		assertEquals(team.getTries(), (validTries + 1));
	}

	@Test
	public void testIncrementPlayed() {
		Team team  = new Team();
		team.setPlayed(validPlayed);
		team.incrementPlayed();
		assertEquals(team.getPlayed(), ++validPlayed);
	}

	@Test
	public void testIncrementDrawn() {
		Team team  = new Team();
		team.setDrawn(validDrawn);
		team.incrementDrawn();
		assertEquals(team.getDrawn(), ++validDrawn);
	}

	@Test
	public void testIncrementWon() {
		Team team  = new Team();
		team.setWon(validWon);
		team.incrementWon();
		assertEquals(team.getWon(), ++validWon);
	}

	@Test
	public void testIncrementLost() {
		Team team  = new Team();
		team.setLost(validLost);
		team.incrementLost();
		assertEquals(team.getLost(), ++validLost);
	}

	@Test
	public void testGetValues() {

		/**
		 * Set up expected object
		 */
		Team expected = new Team();
		
		/**
		 * set data for expected
		 */
		expected.setPoints(validPoints);
		expected.setBonusPoints(validBonusPoints);
		expected.setScoreFor(validScoreFor);
		expected.setScoreAgainst(validScoreAgainst);
		expected.setPlayed(validPlayed);
		expected.setWon(validPlayed);
		expected.setDrawn(validDrawn);
		expected.setLost(validLost);
		expected.setTries(validTries);
		
		/**
		 * simulate method call on expected object
		 */
		Map<String, Integer> teamValues = new HashMap<>();
		
		teamValues.put("points", expected.getPoints());
		teamValues.put("bonusPoints", expected.getBonusPoints());
		teamValues.put("scoreFor", expected.getScoreFor());
		teamValues.put("scoreAgainst", expected.getScoreAgainst());
		teamValues.put("played", expected.getPlayed());
		teamValues.put("won", expected.getWon());
		teamValues.put("drawn", expected.getDrawn());
		teamValues.put("lost", expected.getLost());
		teamValues.put("tries", expected.getTries());
		
		/**
		 * set up actual object
		 */
		Team team = new Team();
		team.setPoints(validPoints);
		team.setBonusPoints(validBonusPoints);
		team.setScoreFor(validScoreFor);
		team.setScoreAgainst(validScoreAgainst);
		team.setPlayed(validPlayed);
		team.setWon(validPlayed);
		team.setDrawn(validDrawn);
		team.setLost(validLost);
		team.setTries(validTries);
	
		/**
		 * compare map from actual method call to simulated call on expected object
		 */
		assertEquals(team.getValues(), teamValues);
		
	}

}
