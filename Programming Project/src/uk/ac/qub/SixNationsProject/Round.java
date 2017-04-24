/**
 * 
 */
package uk.ac.qub.SixNationsProject;

import java.util.ArrayList;

/**
 * @author Gareth Gray
 *
 */
public class Round {

	private Fixture fixture1, fixture2, fixture3;
	private ArrayList<Fixture> fixtures = new ArrayList<>();
	private int number;

	/**
	 * Constructor with args
	 * 
	 * @param fixture1
	 * @param fixture2
	 * @param fixture3
	 * @param number
	 */
	public Round(Fixture fixture1, Fixture fixture2, Fixture fixture3, int number) {
		this.setFixture1(fixture1);
		this.setFixture2(fixture2);
		this.setFixture3(fixture3);
		this.setFixtures();
		this.setNumber(number);
	}

	/**
	 * Getter for Fixture1
	 * 
	 * @return
	 */
	public Fixture getFixture1() {
		return fixture1;
	}

	/**
	 * Setter for Fixture1
	 * 
	 * @return
	 */

	public void setFixture1(Fixture fixture1) {
		this.fixture1 = fixture1;
	}

	/**
	 * Getter for Fixture2
	 * 
	 * @return
	 */
	public Fixture getFixture2() {
		return fixture2;
	}

	/**
	 * Setter for Fixture2
	 * 
	 * @return
	 */
	public void setFixture2(Fixture fixture2) {
		this.fixture2 = fixture2;
	}

	/**
	 * Getter for Fixture3
	 * 
	 * @return
	 */
	public Fixture getFixture3() {
		return fixture3;
	}

	/**
	 * Setter for Fixture3
	 * 
	 * @return
	 */
	public void setFixture3(Fixture fixture3) {
		this.fixture3 = fixture3;
	}

	/**
	 * Getter for number
	 * 
	 * @return
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * Setter for number
	 * 
	 * @return
	 */
	public void setNumber(int number) {
		this.number = number;
	}

	/**
	 * Prints out the Round number and the fixtures in a Round 17/04, Laura:
	 * added fixture numbers to use with inputScores method in Result
	 */
	public void printFixtures() {
		System.out.println("Round " + this.number);
		System.out.println("1. " + fixture1.getTeam1().getName() + " vs " + fixture1.getTeam2().getName());
		System.out.println("2. " + fixture2.getTeam1().getName() + " vs " + fixture2.getTeam2().getName());
		System.out.println("3. " + fixture3.getTeam1().getName() + " vs " + fixture3.getTeam2().getName());
		System.out.println(" ");
	}

	public ArrayList<Fixture> getFixtures() {
		return fixtures;
	}

	public void setFixtures() {
		fixtures.add(getFixture1());
		fixtures.add(getFixture2());
		fixtures.add(getFixture3());
	}

	public void printRoundResults() {
		ArrayList<Fixture> fixtures = getFixtures();
		int fixtureNumber;
		System.out.println("Round: " + this.number);
		for (Fixture fixture : fixtures) {
			fixtureNumber = fixture.getFixtureNumber();
			System.out.println("Fixture: " + fixtureNumber);
			fixture.printFixtureResult();
		}
	}

}
