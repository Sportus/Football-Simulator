import java.text.DecimalFormat;

public class SimDown {
    private Team _team;
    private PreGamePreset _preGame;
    private int _down;
    private String _logText;
    private DecimalFormat decimalFormat;
    private int _drive;


    public SimDown(Team team, int down, int drive){
        _team = team;
        _preGame = new PreGamePreset(team);
        _down = down;
        decimalFormat = new DecimalFormat("###.##");
        _drive = drive;
    }
    
    public double simRun(){
        double runYard = _preGame.runYard();
        _logText =  "Drive " + _drive + " Down " + _down + ": " +  _team.getWideout().getName()+ " ran for " + decimalFormat.format(runYard) + " yards";
        System.out.println(_logText);
        return runYard;
    }

    public double simPass(){
    	
        boolean didSack = _preGame.didSack();
        boolean didComplete = _preGame.didComplete();
        double passYard = _preGame.passYard();
        double sackYard = _preGame.sackYard();

        if(didSack == false && didComplete == true){
            _logText = "Drive " + _drive + " Down " + _down + ": " + _team.getQuarterback().getName() + " has completed a pass for " + decimalFormat.format(passYard) + " yards";
            System.out.println(_logText);
            return passYard;
        }

        else if(didSack==true){
            _logText =  "Drive " + _drive + " Down " + _down + ": " + _team.getQuarterback().getName() + " has been sacked for " + decimalFormat.format(sackYard) + " yards";
            System.out.println(_logText);
            return sackYard;
        }
        else if(didComplete ==false){
            _logText =  "Drive " + _drive + " Down " + _down + ": " + _team.getQuarterback().getName() + " has failed to complete a pass";
            System.out.println(_logText);
        }
        return 0.0;
    }
    
    
    public boolean didSimTouchdown(double yard){
        if(yard>25){
            return true;
        }
        else{

        }
        return false;

    }
    public String getDisplayLog(){
        return _logText;
    }

}

