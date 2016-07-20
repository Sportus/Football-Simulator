
public class Constants {
	
	//Positions
	public static int LINEMAN = 0;
	public static int QUARTERBACK =1;
	public static int WIDEOUT = 2;
	public static int POSITION_UNASSIGNED = 99;
	
	public static int NUM_POSITIONS = 3;
	
	//Depth Chart
	
	public static int SAME_QUARTERBACK_LINEMAN = 0;
	public static int SAME_QUARTERBACK_WIDEOUT = 1;
	public static int SAME_LINEMAN_WIDEOUT =2;
	public static int SAME_QUARTERBACK_LINEMAN_WIDEOUT = 3;
	public static int NO_DUPLICATES = 99;
	
	//Game
	
	public static int NUM_OF_DOWNS = 4;
	public static int TOUCHDOWN_YARD = 25;
	public static int NUM_OF_DRIVES = 5;
	
	//Player Names
	public static String[] FIRST_NAMES = {"Jay", "Aaron", "Peyton", "Tom", "Russel",
									"Tony", "Drew", "Colin", "Ryan", "Kyle", 
									"Philip", "Eli", "Ben", "Scott","Leeroy" ,"David", 
									"Jeff", "Malcom", "Andrew", "Micheal", 
									"Mike", "Roger", "John", "Abe", "Ben", "Collen",
									"Drew", "Elliot", "Fredrick", "George", "Henry",
									"Igbert", "Chris", "Kevin", "Lex",
									"Nat", "Ricky", "Samson", "Steve", "Tyler",
									"Patrick", "Victor", "Ammer",
									"Tim" ,"Alex", "Alejandro", "Enrique", "Shane"
									,"Donald", "Ethan", "Fred", "Emmett", "Jimmy"
									,"Dakota", "Greg", "Jake", "Anthony"
									,"Ernie", "Samson", "Ozzy", "Wendel", "Calvin"
									,"Richard", "Zachary", "Alexander", "Kacey",
									"Ryan", "Julio", "Mickey", "Leonardo", "Tyrone"
									,"Alan", "Bernie", "Canyon", "Doug", "Jeremy"
									, "Chauncey", "Merrill", "Jerald",
									"Lamont", "Jerold", "Frankie", "Harris", "Felix", "Harland", 
									"Leo", "Jamal", "Rolland", "Keith", "Tory", "Hal", "Scot", "Theodore",
									"Zachary", "Vaughn", "Alexander", "Emil", "Darrin", "Richie", "Gabriel",
									"Britt", "Morgan", "Nick", "Stephan", "Wes", "Hugh", "Paris", "Dewey", "Thanh",
									"Randell", "Leonel", "Elijah", "Dillion", "Wayne", "Elliot",
									"Wilburn", "Alden", "Forest", "Brent", "Jon", "Clark", "Carmen", "Elbert"};
	
	public static String[] LAST_NAMES = {"Menke", "Hartz" , "Saint", "Mayoral", "Wynter" , "Mcquiston" , "Thomasson" , "Treat" , "Mohl" , "Caughman" 
											, "Scarbrough" , "Renner" , "Cowman" , "Tennyson" , "Cage" , "Chamlee" , "Sacco" , "Cude", "Bermeo" 
											, "Scoville" , "Lamy" , "Percy" , "Calvin" , "Lafountain" , "Junkin" , "Corpuz" , "Tuttle" , "Bun" , "Mathena" 
											, "Squires" , "Emmett" , "Tony" , "Scott" , "Donald" , "Felix" , "Brent" , "Clark" , "Wendel", "Monroe","Vince","Jackson"
											, "Henry" , "Lamont", "Laurence"};
	
	public static String[] TEAM_NAMES = {"Bills", "Bengals", "Browns", "Broncos", "Texans",  "Colts",  "Jaguars",  "Chiefs",  "Dolphins",  "Patriots",  "Jets",
		"Raiders",  "Steelers",  "Chargers",  "Titans",  "Cardinals", "Falcons",  "Panthers",  "Bears",  "Cowboys",  "Packers",  "Lions",  "Vikings", "Saints",  
		"Giants", "Eagles",  "49ers",  "Seahawks",  "Rams",  "Buccaneers",  "Redskins", "Ravens"};
	
	//Stats locations
	
	public static int PASSING_YARDS = 0;
	public static int PASSES_COMPLETE = 1;
	public static int PASSES_INCOMPLETE = 2;
	public static int RUSHING_YARDS = 3;
	public static int WIDEOUT_YARDS = 4;
	public static int RUSHING_ATTEMPTS = 5;
	public static int NUMBER_OF_STATS = 6;
	
	
	//Attributes
	public static int NUM_ATTRIBUTES = 5;
	public static int MAX_ATTRIBUTE = 20;
	
	//Position in Array
	public static int PASSING =0;
	public static int INTEL = 1;
	public static int SPEED = 2;
	public static int STRENGTH = 3;
	public static int CATCHING = 4;
	
	//Player is unassigned with Team Number 99
	public static int TEAM_UNASSIGNED = 99;
	
	//Number of players in game world
	public static int NUMBER_OF_PLAYERS = 100;
	
	//Odd Number will break the game
	public static int NUMBER_OF_TEAMS = 16;
	
	public static int MAX_PLAYERS_ON_TEAM = 3;
	
	public void setNumberOfPlayers(int numberOfPlayers) {
		NUMBER_OF_PLAYERS = numberOfPlayers;
	}
	public void setNumberOfTeams(int numberOfTeams){
		NUMBER_OF_PLAYERS = numberOfTeams;
	}
}
