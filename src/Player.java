import java.util.Random;


public class Player {
	
		private int[] _attributes = new int[Constants.NUM_ATTRIBUTES];
		private int _teamNum;
		private boolean _isOnTeam;
		private String _name;
		private int _positionNumber;
		private double[] _stats;
		
		public Player(){	
			_attributes = generateAttributes();
			_isOnTeam = false;
			_positionNumber = Constants.POSITION_UNASSIGNED;
			_teamNum = Constants.TEAM_UNASSIGNED;
			_name = generateName();
			_stats = new double[Constants.NUMBER_OF_STATS];
			
			for(int i = 0; i<Constants.NUMBER_OF_STATS; i++){
				_stats[i] = 0.0;
			}
		}
		public int getQuarterbackPass(){
			int quarterbackPass = (_attributes[Constants.PASSING]*3 +_attributes[Constants.INTEL]*2);
			return quarterbackPass;
		}
		public int getQuarterbackRun(){
			int quarterbackRun = (_attributes[Constants.PASSING] + _attributes[Constants.SPEED]*2 + _attributes[Constants.STRENGTH]*2);
			return quarterbackRun;
			
		}
		public int getWideoutCatching(){
			int wideoutCatching = _attributes[Constants.CATCHING]*5;
			return wideoutCatching;
			
		}
		public int getWideoutRun(){
			int wideoutRun = _attributes[Constants.SPEED]*4 + _attributes[Constants.STRENGTH];
			return wideoutRun;
			
		}
		public int getBlocking(){
			return _attributes[Constants.STRENGTH]*4 + _attributes[Constants.SPEED];
			
		}
		
		public double getPassingYards(){
			return _stats[Constants.PASSING_YARDS];
		}
		public void addPassingYards(double yards){
		   _stats[Constants.PASSING_YARDS] += yards;
		}
		public double getPassesComplete(){
			return _stats[Constants.PASSES_COMPLETE];
		}
		public void addPassesComplete(double passesComplete){
		   _stats[Constants.PASSES_COMPLETE] += passesComplete ;
		}
		
		public double getPassesIncomplete(){
			return _stats[Constants.PASSES_INCOMPLETE];
		}
		public void addPassesIncomplete(double passesIncomplete){
		   _stats[Constants.PASSES_INCOMPLETE] += passesIncomplete ;
		}
		
		public double getRushingYards(){
			return _stats[Constants.RUSHING_YARDS];
		}
		public void addRushingYards(double yards){
		   _stats[Constants.RUSHING_YARDS] += yards;
		}
		public void addRushingAttemps(double attempts){
			_stats[Constants.RUSHING_ATTEMPTS] += attempts;
		}
		public double getRushingAttemps(){
			return _stats[Constants.RUSHING_ATTEMPTS];
		}
		public double getWideoutYards(){
			return _stats[Constants.WIDEOUT_YARDS];
		}
		public void addWideoutYards(double yards){
		   _stats[Constants.WIDEOUT_YARDS] += yards;
		}
		
		public int[] generateAttributes(){
			int[] attributes = new int[Constants.NUM_ATTRIBUTES];
			Random numberGen = new Random();
			for(int i = 0; i<Constants.NUM_ATTRIBUTES; i++){
				attributes[i] = numberGen.nextInt(Constants.MAX_ATTRIBUTE) + 1;
			}
			return attributes;
		}
		public String generateName(){
				String name = "";
				Random nameGen = new Random();
				name = Constants.FIRST_NAMES[nameGen.nextInt(Constants.FIRST_NAMES.length)];
				name = name + " " + Constants.LAST_NAMES[nameGen.nextInt(Constants.LAST_NAMES.length)];
				return name;
		}
		public int[] getAttributes(){
			return _attributes;
		}
		public String getName(){
			return _name;
		}
		public boolean getOnTeam(){
			return _isOnTeam;
		}
		public int getPositionNumber(){
			return _positionNumber;
		}
		public int getTeamNum(){
			return _teamNum;
		}
		public void setTeamNum(int teamNum){
			_teamNum = teamNum;
		}
		public void setIsOnTeam(boolean isOnTeam){
			_isOnTeam = isOnTeam;
		}
		public void setPositionNumber(int positionNumber){
			_positionNumber = positionNumber;
		}
		public void setName(String name){
			_name = name;
		}
		public void setAttributes(int[] attributes){
			_attributes = attributes;
		}
		
		public void clearAttributes(){
			int[] clearAttributes = new int[Constants.NUM_ATTRIBUTES];
			
			for(int i = 0; i<Constants.NUM_ATTRIBUTES; i++){
				clearAttributes[i] = 0;
			}
			setAttributes(clearAttributes);
		}
}
