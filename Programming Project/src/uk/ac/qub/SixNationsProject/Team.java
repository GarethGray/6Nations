/**
 * 
 */
package uk.ac.qub.SixNationsProject;

/**
 * @author 40189322
 *
 */
public class Team {

	private String name;

	/**
	 * constructor with args
	 * 
	 * @param name
	 */

	public Team(String name) {
		this.setName(name);

	}

	/**
	 * Getter for name
	 * 
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter for name
	 * 
	 * @return
	 */

	public void setName(String name) {
		this.name = name;
	}
}
