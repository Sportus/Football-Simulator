
public class World {
	 Player[] _players;
	 Team[] _teams;
	//Creates players and teams based on Constsnt specifications for number
	public World(){
		long startTime = System.nanoTime();     
		_players = new Player[Constants.NUMBER_OF_PLAYERS];
		_teams = new Team[Constants.NUMBER_OF_TEAMS];
		
		for(int i = 0; i<Constants.NUMBER_OF_PLAYERS; i++){
			_players[i] = new Player();
		}
		
		for(int i = 0; i<Constants.NUMBER_OF_TEAMS; i++){
		_teams[i] = new Team(i, Constants.TEAM_NAMES[i]);
		}
		long estimatedTime = System.nanoTime() - startTime;
		double seconds = (double)estimatedTime / 1000000000.0;
		System.out.println("World Gen Completed in " + seconds +  " seconds");
	}
	
	public void displayText(){
		for(int i = 0; i<Constants.NUMBER_OF_PLAYERS;i++){
			if(_players[i].getOnTeam() == true){
				int attributeScore = 0;
			int[] attributes;
			attributes = _players[i].getAttributes();
			for(int x = 0; x<Constants.NUM_ATTRIBUTES; x++){
				attributeScore+=attributes[x];
				}
			System.out.println("The " + _teams[_players[i].getTeamNum()].getTeamName()
					+ " player " + _players[i].getName() + " has a total attribute skill of " + attributeScore);
			}
		}
	}
	
	public void simPlayerSelection(){
		for(int i = 0; i<Constants.NUMBER_OF_TEAMS; i++){
			int chosen = _teams[i].choosePlayer(_players);
			_players[chosen].setIsOnTeam(true);
			_players[chosen].setTeamNum(i);
			String name = _players[chosen].getName();
			System.out.println("Team " + _teams[i].getTeamName() + " chose " + name + " with a number of " + chosen);
		}
	}	
	public Team[] getTeams(){
		return _teams;
	}
	public Player[] getPlayers(){
		return _players;
	}
}
