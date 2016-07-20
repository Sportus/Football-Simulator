import java.text.DecimalFormat;

public class Driver {
	static Player[] _players;
	static Team[] _teams;
	
	public static void main(String[] args) {

		World world = new World();
		
		long startTime = System.nanoTime();     
		for(int i = 0; i<Constants.MAX_PLAYERS_ON_TEAM; i++){
			world.simPlayerSelection();
		}
		long estimatedTime = System.nanoTime() - startTime;
		double playerSelectionseconds = (double)estimatedTime / 1000000000.0;
		Player[] players = world.getPlayers();
		Team[] teams = world.getTeams();
		
		//TODO Assign positions on teams for their players
		world.displayText();
		
		for(int i = 0; i<Constants.NUMBER_OF_PLAYERS;i++){
			if(players[i].getTeamNum() == 0){
			System.out.println(teams[players[i].getTeamNum()].getTeamName() + " Name " + players[i].getName() + "  Passing " + (players[i].getQuarterbackPass() + players[i].getQuarterbackRun()) + " Blocking " + players[i].getBlocking()
					+" Wideout " + (players[i].getWideoutCatching() + players[i].getWideoutRun()));
			}
			else if(players[i].getTeamNum() == 1){
			System.out.println(teams[players[i].getTeamNum()].getTeamName() + " Name " + players[i].getName() + "  Passing " + (players[i].getQuarterbackPass() + players[i].getQuarterbackRun()) + " Blocking " + players[i].getBlocking()
					+" Wideout " + (players[i].getWideoutCatching() + players[i].getWideoutRun()));
			}
			else if(players[i].getTeamNum() == 2){
			System.out.println(teams[players[i].getTeamNum()].getTeamName() + " Name " + players[i].getName() + "  Passing " + (players[i].getQuarterbackPass() + players[i].getQuarterbackRun()) + " Blocking " + players[i].getBlocking()
					+" Wideout " + (players[i].getWideoutCatching() + players[i].getWideoutRun()));
			}
			else if(players[i].getTeamNum() == 3){
			System.out.println(teams[players[i].getTeamNum()].getTeamName() + " Name " + players[i].getName() + "  Passing " + (players[i].getQuarterbackPass() + players[i].getQuarterbackRun()) + " Blocking " + players[i].getBlocking()
					+" Wideout " + (players[i].getWideoutCatching() + players[i].getWideoutRun()));
			}
		}
		long startTime1 = System.nanoTime();     
		for(int i = 0; i<Constants.NUMBER_OF_TEAMS;i++){
			teams[i].updateDepthChart(players);
		}
		long estimatedTime1 = System.nanoTime() - startTime1;
		double seconds1 = (double)estimatedTime1 / 1000000000.0;
		System.out.println("PlayerPickTime " + playerSelectionseconds +  " seconds");
		System.out.println("UpdatedDepthChart " + seconds1 +  " seconds");
		
		int numberOfTries = 1;
		Schedule[] schedules = null;
		boolean legitScheduleCreated = false;
		while(legitScheduleCreated==false){
			schedules= Schedule.generateRandomSchedule();
				for(int i = 0; i< Constants.NUMBER_OF_TEAMS; i++){
				if(schedules[i].contains(Constants.POSITION_UNASSIGNED)){
					i = Constants.NUMBER_OF_TEAMS;
					legitScheduleCreated = false;
					System.out.println("Trying....." + numberOfTries);
					numberOfTries++;
				}
				else{
					legitScheduleCreated = true;
				}
			}
		}
		for (int i = 0; i < schedules.length; i++) {
			System.out.println("\nTEAM " + i );
			for (int z = 0; z < (Constants.NUMBER_OF_TEAMS - 1); z++) {
				System.out.print("(" + schedules[i].get(z) + ")");
			}
		}
		System.out.println("\n\n\n\n");
//		schedules = Schedule.generateRoundRobinSchedule();
//		for (int i = 0; i < schedules.length; i++) {
//			System.out.println("\nTEAM " + i );
//			for (int z = 0; z < (Constants.NUMBER_OF_TEAMS - 1); z++) {
//				System.out.print("(" + schedules[i].get(z) + ")");
//			}
//		}
		Season season = new Season(teams, schedules);
		season.simWeek();
		
			for(int i = 0; i< Constants.NUMBER_OF_TEAMS; i++){		
				Team team = season.getTeam(i);
				Player qb = team.getQuarterback();
				DecimalFormat decFor = new DecimalFormat("###");
				double completionPercentage = qb.getPassesComplete() / (qb.getPassesComplete() + qb.getPassesIncomplete());
			System.out.println(team.getTeamName() + " quarterback " + qb.getName() + 
					" threw for " + qb.getPassingYards() + " yards. "
					+ (int)qb.getPassesComplete() + "/" +  (int)(qb.getPassesIncomplete() + qb.getPassesComplete())
							+ " the completion percentage was " + decFor.format(completionPercentage*100) + "%.  Average yards per completion " + decFor.format(qb.getPassingYards()/qb.getPassesComplete()));
		}
		System.out.println("\n\n");
		for(int i = 0; i< Constants.NUMBER_OF_TEAMS; i++){
			Team team = season.getTeam(i);
			Player wr = team.getWideout();
			DecimalFormat decFor = new DecimalFormat("#,##0.00;-#");
			System.out.println(team.getTeamName() + " runningback " + wr.getName() + 
					" ran for " + wr.getRushingYards() + " yards. " + wr.getRushingAttemps() + " carries.  Averaged  " + decFor.format((wr.getRushingYards() / wr.getRushingAttemps())) + " yards per carry");
		}
	
	System.out.println("Total time " + (System.nanoTime() - startTime)/1000000000.0);
	
	}
}
