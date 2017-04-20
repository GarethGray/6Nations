package uk.ac.qub.SixNationsProject;

public class Fixture {

	private int fixtureNumber;
	private Team team1, team2;

	/**
	 * Constructor with args
	 * 
	 * @param team1
	 * @param team2
	 */

	public Fixture(int fixtureNumber, Team team1, Team team2) {
		this.setFixtureNumber(fixtureNumber);
		this.setTeam1(team1);
		this.setTeam2(team2);
	}

	/**
	 * Getter for team1
	 * 
	 * @return
	 */
	public Team getTeam1() {
		return team1;
	}

	/**
	 * Setter for team1
	 * 
	 * @return
	 */

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	/**
	 * Getter for team2
	 * 
	 * @return
	 */
	public Team getTeam2() {
		return team2;
	}

	/**
	 * Setter for team2
	 * 
	 * @return
	 */

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	/**
	 * This method switches the order of the teams in fixture
	 */
	public void fixtureSwitcher() {
		Team temp = team1;
		this.team1 = team2;
		this.team2 = temp;
	}

	public int getFixtureNumber() {
		return fixtureNumber;
	}

	public void setFixtureNumber(int fixtureNumber) {
		this.fixtureNumber = fixtureNumber;
	}

	public void printFixture() {
		System.out.println(this.team1.getName() + " vs " + this.team2.getName());
	}

	/**
	 * This method overrides the equals method to allow for more accurate
	 * comparison of fixtures so that eg. England vs Scotland is considered the
	 * same as Scotland vs England.
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Fixture)) {
			return false;
		}
		Fixture fixture = (Fixture) obj;
		return ((this.team1.getName().equals(fixture.team1.getName()))
				&& (this.team2.getName().equals(fixture.team2.getName())))
				|| ((this.team1.getName().equals(fixture.team2.getName()))
						&& (this.team2.getName().equals(fixture.team1.getName())));
	}

	/**
	 * This method overrides the hashCode method to allow for more accurate
	 * comparison of fixtures so that eg. England vs Scotland is considered the
	 * same as Scotland vs England.
	 */

	@Override
	public int hashCode() {
		return (int) this.team1.getName().hashCode() * this.team2.getName().hashCode();
	}

}
