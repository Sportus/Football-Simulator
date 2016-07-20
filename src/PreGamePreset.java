
public class PreGamePreset {
	
	    private Team _team;

	    private double _quarterbackPass;
	    private double _quarterbackRun;
	    private double _wideoutCatching;
	    private double _wideoutRun;
	    private double _blocking;

	    public  PreGamePreset(Team team){
	        _team = team;
	        _quarterbackPass = _team.getQuarterback().getQuarterbackPass();
	        _quarterbackRun =_team.getQuarterback().getQuarterbackRun();
	        _wideoutCatching = _team.getWideout().getWideoutCatching();
	        _wideoutRun =  _team.getWideout().getWideoutRun();
	        _blocking = _team.getLineman().getBlocking();
	    }
	    public boolean didComplete(){
	        boolean didComplete=false;
	        double rand = Math.random()*2 +1;
	        double complete = (_quarterbackPass*3+_wideoutCatching)/4;
	        if(complete*rand>100){
	            didComplete = true;
	        }
	        else{

	        }
	        return didComplete;
	    }
	    public double passYard(){
	    	
	        double passLength = (Math.random()*5 + 1);
	        if((Math.random()*2+1) > 1.5){
	            double passRun = (Math.random()*5 +1)+ (_wideoutRun/10);
	            return passRun + passLength;
	        }
	        else
	        {

	        }
	        return passLength;

	    }
	    public boolean didSack(){
	        //This could use tweaking.  If blocker has 100 then they have 100 percent of blocking
	        boolean didSack;
	        double percentSack = 100;
	        percentSack = percentSack - _blocking * (Math.random()*3 +1);

	        if(percentSack>0){
	            didSack = true;
	        }
	        else{
	            didSack = false;
	        }
	        return didSack;

	    }
	    public double runYard(){
	        double runYard;
	        if(this.didSack()==true){
	            runYard = -1*(Math.random()*5 +1);
	        }
	        else{
	            runYard = ((_blocking*2 + _quarterbackRun*2)/4)/(Math.random()*25 + 1);
	        }
	        return runYard;
	    }
	    public double sackYard(){
	        return (-1*(Math.random()*5 +1));
	    }
	    
	    
	    //TODO add some more presets such as wind/
	}
