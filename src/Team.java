import java.util.Random;

public class Team {
	private double _playCallConstant;
	//Depth chart storing player index of player for each position
	private int[] _depthChart = new int[Constants.NUM_POSITIONS];
	private String _teamName;
	private int _teamNum;
	private boolean _needPlayers;
	//Could potentially use this if a player retires
	private int _playerCount = 0;
	private Player[] _players = new Player[Constants.MAX_PLAYERS_ON_TEAM];
	
	public Team(int teamNum, String teamName){
		_teamName = teamName;
		_teamNum = teamNum;
		_needPlayers = true;
		Random random = new Random();
		//Plays are chosen based on less than 1.5 run, more than 1.5 pass. This makes it a multiplier of either .5 to 1.5.  
		_playCallConstant = random.nextDouble() + .5;
	}
	
	public Player[] getPlayers(){
		return _players;
	}
	
	public boolean getNeedPlayers(){
		return _needPlayers;
	}
	
	public void setTeamName(String teamName){
		_teamName = teamName;
	}
	
	public String getTeamName(){
		return _teamName;
	}
	
//	public void setQuarterback(Player player){
//		_players[_depthChart[Constants.QUARTERBACK]] = player;
//	}
//	public void setLineman(Player player){
//		_players[_depthChart[Constants.LINEMAN]] = player;
//	}
//	
//	public void setWideout(Player player){
//		_players[_depthChart[Constants.WIDEOUT]] = player;
//	}
	
	
	public Player getPlayer(int index){
		return _players[index];
	}
	//Changed this so that the player is found using the teams depth chart
	public Player getQuarterback(){
		return _players[_depthChart[Constants.QUARTERBACK]];
	}
	public Player getWideout(){
		return _players[_depthChart[Constants.WIDEOUT]];
	}
	public Player getLineman(){
		return _players[_depthChart[Constants.LINEMAN]];
	}
	public double getPlayCallConstant(){
		return _playCallConstant;
	}
	public void setPlayCallConstant(double playCallConstant){
		_playCallConstant = playCallConstant;
	}
	//Goes through every player, and picks a player that is not on a team and with the highest cumulative attribute ratings
	//Repetative method and should be refactored
	//Returns an int of Player chosen in array
	public int choosePlayer(Player[] players){		
		int bestPlayer = 0;
		int bestAttribute = 0;
		for(int i = 0; i<Constants.NUMBER_OF_PLAYERS; i++){
			if(players[i].getOnTeam()==false){
			int[] attributes = players[i].getAttributes();
			int attributeScore = 0;
				for(int x = 0; x<Constants.NUM_ATTRIBUTES; x++){
				attributeScore+=attributes[x];
				}
				if(attributeScore>bestAttribute){
					bestAttribute = attributeScore;
					bestPlayer = i;
				}
			}
		}
		return bestPlayer;
	}
	//Goes through every player, and picks a Quarterback that is not on a team and with the highest Speed, Intel and Passing
	//Returns the index of the best quarterback
	public int chooseQuarterback(Player[] players){
		int bestQuarterback = 0;
		int bestAttribute = 0;
		for(int i = 0; i<Constants.NUMBER_OF_PLAYERS; i++){
			if(players[i].getOnTeam()==false){
			int[] attributes = players[i].getAttributes();
			int attributeScore = 0;
				attributeScore+=attributes[Constants.PASSING];
				attributeScore+=attributes[Constants.INTEL];
				attributeScore+=attributes[Constants.SPEED];
				if(attributeScore>bestAttribute){
					bestAttribute = attributeScore;
					bestQuarterback = i;
				}
				}
			}
		
		return bestQuarterback;
	}
	
	
	public int chooseWideout(Player[] players){
		int bestWideout = 0;
		int bestAttribute = 0;
		for(int i = 0; i<Constants.NUMBER_OF_PLAYERS; i++){
			if(players[i].getOnTeam()==false){
			int[] attributes = players[i].getAttributes();
			int attributeScore = 0;
				attributeScore+=attributes[Constants.SPEED];
				attributeScore+=attributes[Constants.CATCHING];
				attributeScore+=attributes[Constants.STRENGTH];
				if(attributeScore>bestAttribute){
					bestAttribute = attributeScore;
					bestWideout = i;
				}
				}
			}		
		return bestWideout;
	}
	
	public int chooseLineman(Player[] players){
		int bestLineman = 0;
		int bestAttribute = 0;
		for(int i = 0; i<Constants.NUMBER_OF_PLAYERS; i++){
			if(players[i].getOnTeam()==false){
			int[] attributes = players[i].getAttributes();
			int attributeScore = 0;
				attributeScore+=attributes[Constants.INTEL];
				attributeScore+=attributes[Constants.STRENGTH];
				if(attributeScore>bestAttribute){
					bestAttribute = attributeScore;
					bestLineman = i;
				}
				}
			}		
		return bestLineman;
	}
	
	
	public void updateDepthChart(Player[] players){
		//Finds players that have same team num, creates array with those players
		int playerCount = 0;
		for(int i = 0; i<Constants.NUMBER_OF_PLAYERS; i++){
			if(players[i].getTeamNum() == _teamNum){
				_players[playerCount] = players[i];
				playerCount++;
			}
		}
		getHighestQuarterback(_players);
		getHighestLineman(_players);
		getHighestWideout(_players);
			
//			for(int i = 0; i < Constants.MAX_PLAYERS_ON_TEAM; i++){
//				
//				if(_players[i].getPositionNumber() == Constants.QUARTERBACK){
//					setQuarterback(_players[i]);
//				}
//				else if(_players[i].getPositionNumber() == Constants.LINEMAN){
//					setLineman(_players[i]);
//				}
//				else if(_players[i].getPositionNumber() == Constants.WIDEOUT){
//					setWideout(_players[i]);
//				}
//				else {
//					
//				}
//				
//				
//			}
		
		System.out.println("Quarterback " + _players[_depthChart[Constants.QUARTERBACK]].getName());
		System.out.println("Wideout " + _players[_depthChart[Constants.WIDEOUT]].getName());
		System.out.println("Lineman " + _players[_depthChart[Constants.LINEMAN]].getName());

	}
	
	//Could use some refactoring...potentially make a position class????
	
	
	//Should be used first.  Assigns highest quarterback to have a position, quarterback, returning the position in the player array
	public int getHighestQuarterback(Player[] players){
		int quarterbackSkillHighest = 0;
		int playerIndex = 0;
		for(int i = 0; i<Constants.MAX_PLAYERS_ON_TEAM; i++){
			int quarterbackSkill = (players[i].getQuarterbackPass()+ players[i].getQuarterbackRun());
			if(quarterbackSkill>quarterbackSkillHighest){
			quarterbackSkillHighest = quarterbackSkill;
			playerIndex = i;
			}
		}
		_players[playerIndex].setPositionNumber(Constants.QUARTERBACK);
		_depthChart[Constants.QUARTERBACK] = playerIndex;
		return playerIndex;
	}

	
	//Usually used last, finds all available players without position and chooses highest wideout, returning the position in the player array
	public int getHighestWideout(Player[] players){
		int wideoutkSkillHighest = 0;
		int playerIndex = 0;
		for(int i = 0; i<Constants.MAX_PLAYERS_ON_TEAM; i++){
			int wideoutSkill = (players[i].getWideoutCatching()+ players[i].getWideoutRun());
			if(wideoutSkill>wideoutkSkillHighest && players[i].getPositionNumber() == Constants.POSITION_UNASSIGNED){
			wideoutkSkillHighest = wideoutSkill;
			playerIndex = i;
			}
		}
		_players[playerIndex].setPositionNumber(Constants.WIDEOUT);
		_depthChart[Constants.WIDEOUT] = playerIndex;
		return playerIndex;
	}
	
	//Usually second, finds all available players without position and chooses highest wideout, returning the position in the player array
	public int getHighestLineman(Player[] players){
		int linemanSkillHighest = 0;
		int playerIndex = 0;
		for(int i = 0; i<Constants.MAX_PLAYERS_ON_TEAM; i++){
			int linemanSkill = (players[i].getBlocking());
			if(linemanSkill>linemanSkillHighest && players[i].getPositionNumber() == Constants.POSITION_UNASSIGNED){
			linemanSkillHighest = linemanSkill;
			playerIndex = i;
			}
		}
		_players[playerIndex].setPositionNumber(Constants.LINEMAN);
		_depthChart[Constants.LINEMAN] = playerIndex;
		return playerIndex;
	}
}
