/**
 * 
 */
package uk.ac.qub.SixNationsProject;

/**
 * @author 40189322
 *
 */
public class Round {

	private Fixture fixture1, fixture2, fixture3;
	private int number;
	
	/**
	 * Constructor with args
	 * 
	 * @param fixture1
	 * @param fixture2
	 * @param fixture3
	 */
	public Round(Fixture fixture1, Fixture fixture2, Fixture fixture3, int number) {
		this.setFixture1(fixture1);
		this.setFixture2(fixture2);
		this.setFixture3(fixture3);
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
	 * @return
	 */
	public int getNumber() {
		return number;
	}
	/**
	 * Setter for number
	 * @return
	 */
	public void setNumber(int number) {
		this.number = number;
	}
	
	/**
	 * Prints out the Round number and the fixtures in a Round
	 */
	public void printFixtures(){
		System.out.println("Round " + this.number);
		System.out.println(fixture1.getTeam1().getName()+" vs "+fixture1.getTeam2().getName());
		System.out.println(fixture2.getTeam1().getName()+" vs "+fixture2.getTeam2().getName());
		System.out.println(fixture3.getTeam1().getName()+" vs "+fixture3.getTeam2().getName());
		System.out.println(" ");
	}

}
