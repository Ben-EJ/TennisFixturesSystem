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
    
    private ArrayList<String> PlayersTeamAway = new ArrayList<String>();
    private ArrayList<String> PlayersTeamHome = new ArrayList<String>();
    
    private ArrayList<String> PlayerOneVsPlayerThree = new ArrayList<String>();
    private ArrayList<String> awayWinPlayerOneVsPlayerThree = new ArrayList<String>();
    private boolean setWinAwayPlayerOneVsPlayerThree = false;
    
    
    private ArrayList<String> PlayerTwoVsPlayerThree = new ArrayList<String>();
    private ArrayList<String> awayWinPlayerTwoVsPlayerThree = new ArrayList<String>();
    private boolean setWinAwayPlayerTwoVsPlayerThree = false;
    
    private ArrayList<String> PlayerOneVsPlayerFour = new ArrayList<String>();
    private ArrayList<String> awayWinPlayerOneVsPlayerFour = new ArrayList<String>();
    private boolean setWinAwayPlayerOneVsPlayerFour = false;
    
    private ArrayList<String> PlayerTwoVsPlayerFour = new ArrayList<String>();
    private ArrayList<String> awayWinPlayerTwoVsPlayerFour = new ArrayList<String>();
    private boolean setWinAwayPlayerTwoVsPlayerFour = false;
    
    private ArrayList<String> doubleSets = new ArrayList<String>();
    private ArrayList<String> awayWinDoubleSets  = new ArrayList<String>();
    private boolean setWinAwayDoubleSets = false;
    
    
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
    
    
    public void setPlayerOneVsPlayerThree(String valueToChangeTo, int valueToChange){
       PlayerOneVsPlayerThree.set(valueToChange, valueToChangeTo);
    }
    
    public void setPlayerTwoVsPlayerThree(String valueToChangeTo, int valueToChange){
         PlayerTwoVsPlayerThree.set(valueToChange, valueToChangeTo);
    }
    
    public void setPlayerOneVsPlayerFour(String valueToChangeTo, int valueToChange){
        PlayerOneVsPlayerFour.set(valueToChange, valueToChangeTo); 
    }
    
    public void setPlayerTwoVsPlayerFour(String valueToChangeTo, int valueToChange){
        PlayerTwoVsPlayerFour.set(valueToChange, valueToChangeTo); 
    }
    
    public void setDoubleSets(String valueToChangeTo, int valueToChange){
        doubleSets.set(valueToChange, valueToChangeTo); 
    }
    
    public ArrayList<String> getAwayWinPlayerOneVsPlayerThree(){
        return awayWinPlayerOneVsPlayerThree;
    }
    public ArrayList<String> getAwayWinPlayerTwoVsPlayerThree(){
        return awayWinPlayerTwoVsPlayerThree;
    }
    public ArrayList<String> getAwayWinPlayerOneVsPlayerFour(){
        return awayWinPlayerOneVsPlayerFour;
    }
    public ArrayList<String> getAwayWinPlayerTwoVsPlayerFour(){
        return awayWinPlayerTwoVsPlayerFour;
    }
    
    public ArrayList<String> getAwayWinDoubleSets(){
        return awayWinDoubleSets;
    }
    
    public void setAwayWinPlayerOneVsPlayerThree(ArrayList<String> trueOrFalse){
        awayWinPlayerOneVsPlayerThree = trueOrFalse;
    }
    public void setAwayWinPlayerTwoVsPlayerThree(ArrayList<String> trueOrFalse){
        awayWinPlayerTwoVsPlayerThree = trueOrFalse;
    }
    public void setAwayWinPlayerOneVsPlayerFour(ArrayList<String> trueOrFalse){
        awayWinPlayerOneVsPlayerFour = trueOrFalse;
    }
    public void setAwayWinPlayerTwoVsPlayerFour(ArrayList<String> trueOrFalse){
        awayWinPlayerTwoVsPlayerFour = trueOrFalse;
    }
    
    public void setAwayWinDoubleSets(ArrayList<String> trueOrFalse){
        awayWinDoubleSets = trueOrFalse;
    }
    
    
    
    public boolean setSetWinAwayPlayerOneVsPlayerThree(){
        return setWinAwayPlayerOneVsPlayerThree;
    }
    public boolean setAwayWinPlayerTwoVsPlayerThree(){
       return setWinAwayPlayerTwoVsPlayerThree;
    }
    public boolean setAwayWinPlayerOneVsPlayerFour(){
       return setWinAwayPlayerOneVsPlayerFour;
    }
    public boolean setAwayWinPlayerTwoVsPlayerFour(){
       return setWinAwayPlayerTwoVsPlayerFour;
    }
    
    public boolean setAwayWinDoubleSets(){
        return setWinAwayDoubleSets;
    }
    
    
    public void setSetWinAwayPlayerOneVsPlayerThree(boolean trueOrFalse){
        setWinAwayPlayerOneVsPlayerThree = trueOrFalse;
    }
    public void setAwayWinPlayerTwoVsPlayerThree(boolean trueOrFalse){
        setWinAwayPlayerTwoVsPlayerThree = trueOrFalse;
    }
    public void setAwayWinPlayerOneVsPlayerFour(boolean trueOrFalse){
       setWinAwayPlayerOneVsPlayerFour = trueOrFalse;
    }
    public void setAwayWinPlayerTwoVsPlayerFour(boolean trueOrFalse){
       setWinAwayPlayerTwoVsPlayerFour = trueOrFalse;
    }
    
    public void setAwayWinDoubleSets(boolean trueOrFalse){
        setWinAwayDoubleSets = trueOrFalse;
    }
}
