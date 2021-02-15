/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Match;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author benja
 */
public class Match {
    private int matchNumber = 0;
    private boolean matchStatus = false;
    private String teamOne = "";
    private String teamTwo = "";
    ArrayList<String> PlayersTeamAway = new ArrayList<String>();
    ArrayList<String> PlayersTeamHome = new ArrayList<String>();
    
    ArrayList<String> PlayerOneVsPlayerThree = new ArrayList<String>();
    ArrayList<String> PlayerTwoVsPlayerThree = new ArrayList<String>();
    ArrayList<String> PlayerOneVsPlayerFour = new ArrayList<String>();
    ArrayList<String> PlayerTwoVsPlayerFour = new ArrayList<String>();
    
    ArrayList<String> doubleSets = new ArrayList<String>();
    
    public Match(String team1, String team2,ArrayList<String> PlayersAway, ArrayList<String> PlayersHome, ArrayList<String> PlayerOnePlayerThree,ArrayList<String> PlayerTwoPlayerThree, ArrayList<String> PlayerOnePlayerFour,ArrayList<String> PlayerTwoPlayerFour, ArrayList<String> doubleS){
        teamOne = team1;
        teamTwo = team2;   
        PlayersTeamAway = PlayersAway;
        PlayersTeamHome = PlayersHome;
        PlayerOneVsPlayerThree = PlayerOnePlayerThree;
        PlayerTwoVsPlayerThree = PlayerTwoPlayerThree;
        PlayerOneVsPlayerFour = PlayerOnePlayerFour;
        PlayerTwoVsPlayerFour = PlayerTwoPlayerFour;
        
        doubleSets = doubleS;
    }
    
    public String getTeamAway(){
        return teamOne;
    }
    
    public String getTeamHome(){
        return teamTwo;
    }
    
    public ArrayList<String> getPlayersTeamAway(){
        return PlayersTeamAway;
    }
    
    public ArrayList<String> getPlayersTeamHome(){
        return PlayersTeamHome;
    }
    
    
    public ArrayList<String> getPlayerOneVsPlayerThree(){
        return PlayerOneVsPlayerThree;
    }
    public ArrayList<String> getPlayerTwoVsPlayerThree(){
        return PlayerTwoVsPlayerThree;
    }
    public ArrayList<String> getPlayerOneVsPlayerFour(){
        return PlayerOneVsPlayerFour;
    }
    public ArrayList<String> getPlayerTwoVsPlayerFour(){
        return PlayerTwoVsPlayerFour;
    }
    
    public ArrayList<String> getDoubleSets(){
        return doubleSets;
    }
    
    
    
    
    
    
}
