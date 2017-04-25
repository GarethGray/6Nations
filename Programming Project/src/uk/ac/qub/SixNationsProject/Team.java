/**
 * 
 */
package uk.ac.qub.SixNationsProject;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 40189322, 40084540
 *
 */
public class Team {

	private TeamName name;

	// Values for the team that will be used in the League Table
	private int points, bonusPoints, scoreFor, scoreAgainst, played, won, lost, drawn, tries = 0;

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

	/**
	 * Getter for points awarded to the team
	 *
	 * @return points
	 */
	public int getPoints() {
		return points;
	}

	/**
	 * Setter for points awarded to the team
	 */
	public void setPoints(int points) {
		this.points = points;
	}

	/**
	 * Adds to point total
	 *
	 * @param points
	 *            The points to be added
	 */
	public void addPoints(int points) {
		this.points = this.points + points;
	}

	/**
	 * Getter for bonusPoints awarded to the team
	 *
	 * @return bonusPoints
	 */
	public int getBonusPoints() {
		return bonusPoints;
	}

	/**
	 * Setter for bonusPoints awarded to the team
	 */
	public void setBonusPoints(int bonusPoints) {
		this.bonusPoints = bonusPoints;
	}

	/**
	 * Adds to bonus point total
	 *
	 * @param bonusPoints
	 *            The bonusPoints to be added
	 */
	public void addBonusPoints(int bonusPoints) {
		this.bonusPoints = this.bonusPoints + bonusPoints;
	}

	/**
	 * Getter for total score the team has scored in all fixtures
	 *
	 * @return scoreFor
	 */
	public int getScoreFor() {
		return scoreFor;
	}

	/**
	 * Setter for total score the team has scored in all fixtures
	 */
	public void setScoreFor(int scoreFor) {
		this.scoreFor = scoreFor;
	}

	/**
	 * Adds to scoreFor total
	 *
	 * @param score
	 *            The score to be added
	 */
	public void addScoreFor(int score) {
		this.scoreFor = this.scoreFor + score;
	}

	/**
	 * Getter for total score that has been scored against this team in all
	 * fixtures
	 *
	 * @return scoreAgainst
	 */
	public int getScoreAgainst() {
		return scoreAgainst;
	}

	/**
	 * Setter for total score that has been scored against this team in all
	 * fixtures
	 */
	public void setScoreAgainst(int score) {
		this.scoreAgainst = scoreAgainst;
	}

	/**
	 * Adds to scoreAgainst total
	 *
	 * @param score
	 *            The scoreAgainst to be added
	 */
	public void addScoreAgainst(int score) {
		this.scoreAgainst = this.scoreAgainst + score;
	}

	/**
	 * Getter for games played
	 *
	 * @return played
	 */
	public int getPlayed() {
		return played;
	}

	/**
	 * Setter for games played
	 */
	public void setPlayed(int played) {
		this.played = played;
	}

	/**
	 * Getter for games won
	 *
	 * @return won
	 */
	public int getWon() {
		return won;
	}

	/**
	 * Setter for games won
	 */
	public void setWon(int won) {
		this.won = won;
	}

	/**
	 * Getter for games lost
	 *
	 * @return lost
	 */
	public int getLost() {
		return lost;
	}

	/**
	 * Setter for games lost
	 */
	public void setLost(int lost) {
		this.lost = lost;
	}

	/**
	 * Getter for games drawn
	 *
	 * @return drawn
	 */
	public int getDrawn() {
		return drawn;
	}

	/**
	 * Setter for games drawn
	 */
	public void setDrawn(int drawn) {
		this.drawn = drawn;
	}

	/**
	 * Getter for tries
	 *
	 * @return tries
	 */
	public int getTries() {
		return tries;
	}

	/**
	 * Setter for tries
	 */
	public void setTries(int tries) {
		this.tries = tries;
	}

	/**
	 * Adds to tries total
	 *
	 * @param tries
	 *            The tries to be added
	 */
	public void addTries(int tries) {
		this.tries = this.tries + tries;
	}

	/**
	 * Increment the played value by 1
	 */
	public void incrementPlayed() {
		this.played++;
	}

	/**
	 * Increment the drawn value by 1
	 */
	public void incrementDrawn() {
		this.drawn++;
	}

	/**
	 * Increment the won value by 1
	 */
	public void incrementWon() {
		this.won++;
	}

	/**
	 * Increment the lost value by 1
	 */
	public void incrementLost() {
		this.lost++;
	}

	/**
	 * Returns the values of the team in a hashmap, with the value name as key.
	 * 
	 * @return Hashmap of team values
	 */
	public Map<String, Integer> getValues() {
		Map<String, Integer> teamValues = new HashMap<>();

		teamValues.put("points", getPoints());
		teamValues.put("bonusPoints", getBonusPoints());
		teamValues.put("scoreFor", getScoreFor());
		teamValues.put("scoreAgainst", getScoreAgainst());
		teamValues.put("played", getPlayed());
		teamValues.put("won", getWon());
		teamValues.put("drawn", getDrawn());
		teamValues.put("lost", getLost());
		teamValues.put("tries", getTries());

		return teamValues;
	}
}
