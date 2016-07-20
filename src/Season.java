import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;

public class Season {
	private int _week;
	private Team[] _teams;
	private Schedule[] _schedules;
	public Season(Team[] teams, Schedule[] schedules) {
		_teams = teams;
		_schedules = schedules;	
		_week = 0;
	}

	public void simWeek(){
		for(int week = 0; week<Constants.NUMBER_OF_TEAMS; week++){
			ArrayList<Integer> teamBase = Schedule.getTeamBase();
		for(int i = 0; i<(Constants.NUMBER_OF_TEAMS/2); i++){
			System.out.println("\n\n\n\n\n\n\nGAME " + i + ":  " + teamBase.get(i) + " vs " + _schedules[teamBase.get(i)].get(_week));
			Team home = _teams[teamBase.get(i)];
			Team away = _teams[_schedules[teamBase.get(i)].get(_week)];
			
			Game game = new Game(home, away, teamBase.get(i), _schedules[teamBase.get(i)].get(_week));
				teamBase.remove(_schedules[teamBase.get(i)].get(_week));
		}
		}
	}
	
	public Team getTeam(int teamNum){
		return _teams[teamNum];
	}
}

	
	

