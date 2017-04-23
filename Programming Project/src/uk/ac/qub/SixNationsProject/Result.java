package uk.ac.qub.SixNationsProject;

public class Result {

	// Tries, score and points for team 1 from the fixture
	private int team1Tries, team1Score, team1Points, team1BonusPoints = 0;

	// Tries, score and points for team 2 from the fixture
	private int team2Tries, team2Score, team2Points, team2BonusPoints = 0;

	// Result object to hold the scores of a fixture and the points awarded to
	// teams due to a fixture.
	// Will be initialized with a default score of 0.
	public Result() {
	}

	// Sets the scores of the result object, then calculates and sets the points
	// the teams should receive
	// @param team1 Array of team 1's tries and score
	// @param team2 Array of team 2's tries and score
	public void setScores(int[] team1, int[] team2) {
		this.team1Tries = team1[0];
		this.team1Score = team1[1];

		this.team2Tries = team2[0];
		this.team2Score = team2[1];

		calculatePoints();
	}

	public void calculatePoints() {
		team1Points = 0;
		team1BonusPoints = 0;
		team2Points = 0;
		team2BonusPoints = 0;

		// Draw, award both teams 2 points
		if (team1Score == team2Score) {
			team1Points = team1Points + 2;
			team2Points = team2Points + 2;
		}
		// Team 1 wins, award 4 points
		else if (team1Score > team2Score) {
			team1Points = team1Points + 4;
			// if team 2 scored within 7, award 1 bonus point
			if (team1Score - team2Score <= 7) {
				team2Points++;
				team2BonusPoints++;
			}
		}
		// Team 2 wins, award 4 points
		else if (team1Score < team2Score) {
			team2Points = team2Points + 4;
			// if team 1 scored within 7, award 1 bonus point
			if (team2Score - team1Score <= 7) {
				team1Points++;
				team1BonusPoints++;
			}
		}
		// Bonus point awarded for greater than 3 tries
		if (team1Tries >= 4) {
			team1Points++;
			team1BonusPoints++;
		}
		if (team2Tries >= 4) {
			team2Points++;
			team2BonusPoints++;
		}
	}

	/**
	 * Getters for the tries, scores, points and bonus points of each team Note:
	 * There is no need for setters for these values. They should not be set
	 * individually, but rather with the setScores method above, which will also
	 * calculate the points to be awarded. This prevents the scores/points from
	 * becoming out of sync.
	 */

	/**
	 * @return team1Tries The tries scored by team 1
	 */
	public int getTeam1Tries() {
		return team1Tries;
	}

	/**
	 * @return team1Score The score of team 1
	 */
	public int getTeam1Score() {
		return team1Score;
	}

	/**
	 * @return team1Points The points awarded to team 1
	 */
	public int getTeam1Points() {
		return team1Points;
	}

	/**
	 * @return team1BonusPoints The bonus points awarded to team 1
	 */
	public int getTeam1BonusPoints() {
		return team1BonusPoints;
	}

	/**
	 * @return team2Tries The tries scored by team 2
	 */
	public int getTeam2Tries() {
		return team2Tries;
	}

	/**
	 * @return team2Score The score of team 2
	 */
	public int getTeam2Score() {
		return team2Score;
	}

	/**
	 * @return team2Points The points awarded to team 2
	 */
	public int getTeam2Points() {
		return team2Points;
	}

	/**
	 * @return team2BonusPoints The bonus points awarded to team 2
	 */
	public int getTeam2BonusPoints() {
		return team2BonusPoints;
	}
}
