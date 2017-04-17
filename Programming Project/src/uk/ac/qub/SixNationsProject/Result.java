package uk.ac.qub.SixNationsProject;

import java.util.Scanner;

public class Result {
	private Tournament tournament;
	private Round round;
	private Fixture fixture;
	
	private Team team1;
	private int team1Tries;
	private int team1Points;
	
	private Team team2;
	private int team2Tries;
	private int team2Points;
	
	public Result(){
	}
	
	public Result(Tournament tournament, int roundNumber, int fixtureNumber, int team1Tries, int team1Points, int team2Tries,
			int team2Points){
		this.setTournament(tournament);
		this.round = tournament.getRounds().get((roundNumber));
		this.fixture=round.getFixtures().get((fixtureNumber));
		this.team1=this.fixture.getTeam1();
		this.team1Tries=team1Tries;
		this.team1Points=team1Points;
		this.team2=this.fixture.getTeam2();
		this.team2Tries=team2Tries;
		this.team2Points=team2Points;
	}
	
	public static Result insertScores(Tournament tournament){
		Scanner scanner = new Scanner(System.in);
		int roundNumber=0;
		int fixtureNumber=0;
		Fixture chosenFixture;
		int team1Tries;
		int team1Points;
		int team2Tries;
		int team2Points;

		//asks user to select round to input scores into
		while (roundNumber <1 || roundNumber > tournament.getRounds().size()){
			System.out.println("Select round:");
			roundNumber = scanner.nextInt();
		}
		roundNumber--;
		
		//prints fixtures of chosen round
		tournament.getRounds().get(roundNumber).printFixtures();
		
		//asks user to select fixture to input scores into
		while (fixtureNumber <1 || fixtureNumber > tournament.getRounds().get(roundNumber).getFixtures().size()){
			System.out.println("Select fixture:");
			fixtureNumber = scanner.nextInt();
		}
		fixtureNumber--;
		chosenFixture=tournament.getRounds().get(roundNumber).getFixtures().get(fixtureNumber);
		
		//asks user to input scores for each team
		System.out.println("Please enter scores:");
		System.out.println(chosenFixture.getTeam1().getName() + " tries:");
		team1Tries = scanner.nextInt();
		System.out.println(chosenFixture.getTeam1().getName() + " points:");
		team1Points = scanner.nextInt();
		
		System.out.println(chosenFixture.getTeam2().getName() + " tries:");
		team2Tries = scanner.nextInt();
		System.out.println(chosenFixture.getTeam2().getName() + " points:");
		team2Points = scanner.nextInt();
		
		scanner.close();
		Result result = new Result(tournament, roundNumber, fixtureNumber, team1Tries, team1Points, team2Tries, team2Points);
		result.printMatchScores();
		
		return result;
	}

	public void printMatchScores(){
		System.out.println("Round: "+round.getNumber()+", fixture: "+fixture.getFixtureNumber());
		System.out.println("\t"+team1.getName()+"\t vs\t"+team2.getName());
		System.out.println("TRIES\t"+team1Tries+"\t\t\t"+team2Tries);
		System.out.println("POINTS\t"+team1Points+"\t\t\t"+team2Points);
	}
	
	/**
	 * @return the round
	 */
	public Round getRound() {
		return round;
	}

	/**
	 * @return the fixture
	 */
	public Fixture getFixture() {
		return fixture;
	}

	/**
	 * @return the team1
	 */
	public Team getTeam1() {
		return team1;
	}

	/**
	 * @return the team1Tries
	 */
	public int getTeam1Tries() {
		return team1Tries;
	}

	/**
	 * @return the team1Points
	 */
	public int getTeam1Points() {
		return team1Points;
	}

	/**
	 * @return the team2
	 */
	public Team getTeam2() {
		return team2;
	}

	/**
	 * @return the team2Tries
	 */
	public int getTeam2Tries() {
		return team2Tries;
	}

	/**
	 * @return the team2Points
	 */
	public int getTeam2Points() {
		return team2Points;
	}

	/**
	 * @param round the round to set
	 */
	public void setRound(Round round) {
		this.round = round;
	}

	/**
	 * @param fixture the fixture to set
	 */
	public void setFixture(Fixture fixture) {
		this.fixture = fixture;
	}

	/**
	 * @param team1 the team1 to set
	 */
	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	/**
	 * @param team1Tries the team1Tries to set
	 */
	public void setTeam1Tries(int team1Tries) {
		this.team1Tries = team1Tries;
	}

	/**
	 * @param team1Points the team1Points to set
	 */
	public void setTeam1Points(int team1Points) {
		this.team1Points = team1Points;
	}

	/**
	 * @param team2 the team2 to set
	 */
	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	/**
	 * @param team2Tries the team2Tries to set
	 */
	public void setTeam2Tries(int team2Tries) {
		this.team2Tries = team2Tries;
	}

	/**
	 * @param team2Points the team2Points to set
	 */
	public void setTeam2Points(int team2Points) {
		this.team2Points = team2Points;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}
}
