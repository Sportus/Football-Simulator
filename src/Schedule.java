import java.util.ArrayList;
import java.util.Random;


public class Schedule extends ArrayList<Integer> {

	int _teamNum;
	
	public Schedule(int teamNum){
		super();
		_teamNum = teamNum;
	//	THIS IS FOR generateSchedule attempt
		for (int i = 0; i < Constants.NUMBER_OF_TEAMS; i++) {
			
			if(i == teamNum){
				
			}
			else{
				this.add(i);
			}
		}	
	}
	//Will not work for more than 20 teams(performance issues), as well as odd numbers
	public static Schedule[] generateRandomSchedule() {
		//Team Base is the team candidates left for each team
		Schedule[] teamBase = new Schedule[(Constants.NUMBER_OF_TEAMS)];
		//Generic schedules
		Schedule[] schedules = new Schedule[(Constants.NUMBER_OF_TEAMS)];

		for (int i = 0; i < Constants.NUMBER_OF_TEAMS; i++) {
			teamBase[i] = new Schedule(i);
		}
		//Assigned this to positions unassigned denoting no team has been chosen
		for (int i = 0; i < Constants.NUMBER_OF_TEAMS; i++) {
			schedules[i] = new Schedule(i);
			for (int x = 0; x < (Constants.NUMBER_OF_TEAMS - 1); x++) {
				schedules[i].set(x, Constants.POSITION_UNASSIGNED);
			}
		}

		int tryCount = 0;
		for (int i = 0; i < Constants.NUMBER_OF_TEAMS; i++) {
			for (int x = 0; x < (Constants.NUMBER_OF_TEAMS - 1); x++) {
				Random random = new Random();
				//Not sure if this is needed, have seen a crash(3/28/2015) in development
				if (teamBase[i].size() == 0) {
					break;
				}

				//Seed is an element chosen from a team's teamBase
				int seed = random.nextInt(teamBase[i].size());

				//Team number is elemement derived from seed
				int teamNum = teamBase[i].get(seed);
				// Take this if statement out if. I added this in thinking I had
				// found a solution...I did not sadly....THIS MAY BE
				// UNTRUE!!!!!!!!!!!!!!!!!!!
				
				//There is already assigned position.  Nothing is needed
				if (schedules[i].get(x) != Constants.POSITION_UNASSIGNED) {

				}

				//If both schedules need a new position
				else if (schedules[i].get(x) == Constants.POSITION_UNASSIGNED
						&& schedules[teamNum].get(x) == Constants.POSITION_UNASSIGNED) {
					
					schedules[i].set(x, teamNum);
					schedules[teamNum].set(x, i);
					teamBase[i].remove(seed);
					teamBase[teamNum].remove(teamBase[teamNum].indexOf(i));
				} 
				//If TryCount is greater than 1000, then it is assumed that it is an endless loop and will be commenced to finish as x will be added
				else {
					if (tryCount > 1000) {
					} else {
						tryCount++;
						x--;
					}
				}

			}
		}
		return schedules;
	}
	//This works for even numbers. Incredibly efficient, though dull...
	public static Schedule[] generateRoundRobinSchedule() {
		Schedule[] schedules = new Schedule[(Constants.NUMBER_OF_TEAMS)];
		for (int i = 0; i < Constants.NUMBER_OF_TEAMS; i++) {
			schedules[i] = new Schedule(i);
		}

		int maxOpponent = (Constants.NUMBER_OF_TEAMS - 1);
		// Each Week
		for (int week = 0; week < (Constants.NUMBER_OF_TEAMS - 1); week++) {
			maxOpponent--;
			// Week
			for (int team = 0; team < Constants.NUMBER_OF_TEAMS; team++) {
				if(team == maxOpponent){
				}
				else{
				schedules[team].set(week, maxOpponent);
				
				}
				if (maxOpponent == 0) {
					maxOpponent = (Constants.NUMBER_OF_TEAMS - 1);
				} else {
					maxOpponent--;
				}
				
			}
		}
		return schedules;
	}
	
	public static ArrayList<Integer> getTeamBase(){
		ArrayList<Integer> teamBase = new ArrayList<Integer>();
		for(int i = 0; i <Constants.NUMBER_OF_TEAMS; i++){
			teamBase.add(i);
		}
		return teamBase;
	}
}
