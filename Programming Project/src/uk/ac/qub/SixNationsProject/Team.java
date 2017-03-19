/**
 * 
 */
package uk.ac.qub.SixNationsProject;

/**
 * @author 40189322
 *
 */
public class Team {

	private TeamName name;

	/**
	 * constructor with args
	 * 
	 * @param name
	 */

	public Team(TeamName name) {
		this.setName(name);

	}

	/**
	 * Getter for name
	 * 
	 * @return
	 */
	public TeamName getName() {
		return name;
	}

	/**
	 * Setter for name
	 * 
	 * @return
	 */

	public void setName(TeamName name) {
		this.name = name;
	}
}
