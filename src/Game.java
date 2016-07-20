public class Game {
	private int _teamNumHome;
	private int _teamNumAway;
	private Team _home;
	private Team _away;
	private int[] _score;
	private double[] _yards;
	
	
	public Game(Team home, Team away, int teamNumHome, int teamNumAway){
		_home = home;
		_away = away;
		_teamNumHome = teamNumHome;
		_teamNumAway = teamNumAway;
		_score = new int[Constants.NUMBER_OF_TEAMS];
		_yards = new double[Constants.NUMBER_OF_TEAMS];
			for(int i = 0; i <Constants.NUMBER_OF_TEAMS; i++){
				_score[i] = 0;
				_yards[i] = 0;
			}
			simGame();
	}
	
	public void simGame(){
		for(int i = 0; i< (Constants.NUM_OF_DRIVES); i++){
				this.simDriveSim(_teamNumHome, _home, i, true);
				this.simDriveSim(_teamNumAway, _away, i, false);	
		}
	}
	
	public void simDriveSim(int teamNum, Team team, int drive, boolean isHome) {
        boolean inDrive = true;
        double yard = 0;
        
        //TODO Write in Game method
        while (inDrive == true) {
            for(int down = 0; down <Constants.NUM_OF_DOWNS; down++){
            	
                SimDown simDown = new SimDown(team, down, drive);
                System.out.println("They are at the " + yard + " yard line\n");
                //TODO Different choosing mechanics
                double rand = (Math.random() * 1 + 1);
                if (rand > 1.5) {
                    double simDownRun = simDown.simRun();
                    yard = simDownRun + yard;
                   
                    if(isHome){
                    	 _home.getWideout().addRushingYards(simDownRun);
                    	 _home.getWideout().addRushingAttemps(1);
                    }
                    else{
                    	_away.getWideout().addRushingYards(simDownRun);
                    	_away.getWideout().addRushingAttemps(1);
                    }
                    
                   
                }
                //Passing Yards can be negative, which would be a sack.  For team 1 this is different
                else if (rand < 1.5) {
                    double simPass = simDown.simPass();
                    yard = simPass + yard;
                    if (simPass == 0.0) {
                    	if(isHome){
                    		_home.getQuarterback().addPassesIncomplete(1);
                    	}
                    	else{
                    		_away.getQuarterback().addPassesIncomplete(1);
                    	}
                    }
                    //Sack -- counts as rushing yard loss...not sure if this is best way
                    else if (simPass < 0.0) {
                    	if(isHome){
                    		_home.getQuarterback().addRushingYards(simPass);
                    	}
                    	else{
                    		_away.getQuarterback().addRushingYards(simPass);
                    	}
                    } 
                    
                    else {
                    	if(isHome){
                    		_home.getQuarterback().addPassingYards(simPass);
                    		_home.getQuarterback().addPassesComplete(1);
                    	}
                    	else{
                    		_away.getQuarterback().addPassingYards(simPass);
                    		_away.getQuarterback().addPassesComplete(1);
                    	}
                    }

                } else {

                }
                //Should be outside if else
                if (simDown.didSimTouchdown(yard)) {
                    _score[teamNum] += 1;
                    System.out.println("TD");
                    down = Constants.NUM_OF_DOWNS; // Gets out of loop, workaround
                }
            }
            _yards[teamNum] += yard;
            inDrive = false;
        }
    }
	
    public int didWin(int _teamNumHome, int _teamNumAway) {
        if (_score[_teamNumHome] > _score[_teamNumAway]) {
            return 1;
        } else if (_score[_teamNumHome] < _score[_teamNumAway]) {
            return 0;
        } else {
            return 2;
        }
    }
}
