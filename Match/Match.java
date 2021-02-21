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
 
    private String teamOne = "";
    private String teamTwo = "";
    
    private ArrayList<String> PlayersTeamAway = new ArrayList<String>();
    private ArrayList<String> PlayersTeamHome = new ArrayList<String>();
    
    private ArrayList<String> PlayerOneVsPlayerThree = new ArrayList<String>();
    private ArrayList<String> homeWinPlayerOneVsPlayerThree = new ArrayList<String>();
  
    private ArrayList<String> PlayerTwoVsPlayerThree = new ArrayList<String>();
    private ArrayList<String> homeWinPlayerTwoVsPlayerThree = new ArrayList<String>();
   
    
    private ArrayList<String> PlayerOneVsPlayerFour = new ArrayList<String>();
    private ArrayList<String> homeWinPlayerOneVsPlayerFour = new ArrayList<String>();

    
    private ArrayList<String> PlayerTwoVsPlayerFour = new ArrayList<String>();
    private ArrayList<String> homeWinPlayerTwoVsPlayerFour = new ArrayList<String>();

    
    private ArrayList<String> doubleSets = new ArrayList<String>();
    private ArrayList<String> homeWinDoubleSets  = new ArrayList<String>();
  
    private ArrayList<String> setWins = new ArrayList<String>();
    private String matchScore;
    
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
    
    public ArrayList<String> getHomeWinPlayerOneVsPlayerThree(){
        return homeWinPlayerOneVsPlayerThree;
    }
    public ArrayList<String> getHomeWinPlayerTwoVsPlayerThree(){
        return homeWinPlayerTwoVsPlayerThree;
    }
    public ArrayList<String> getHomeWinPlayerOneVsPlayerFour(){
        return homeWinPlayerOneVsPlayerFour;
    }
    public ArrayList<String> getHomeWinPlayerTwoVsPlayerFour(){
        return homeWinPlayerTwoVsPlayerFour;
    }
    
    public ArrayList<String> getHomeWinDoubleSets(){
        return homeWinDoubleSets;
    }
    
    public void setHomeWinPlayerOneVsPlayerThree(ArrayList<String> trueOrFalse){
        homeWinPlayerOneVsPlayerThree = trueOrFalse;
    }
    public void setHomeWinPlayerTwoVsPlayerThree(ArrayList<String> trueOrFalse){
        homeWinPlayerTwoVsPlayerThree = trueOrFalse;
    }
    public void setHomeWinPlayerOneVsPlayerFour(ArrayList<String> trueOrFalse){
        homeWinPlayerOneVsPlayerFour = trueOrFalse;
    }
    public void setHomeWinPlayerTwoVsPlayerFour(ArrayList<String> trueOrFalse){
        homeWinPlayerTwoVsPlayerFour = trueOrFalse;
    }
    
    public void setHomeWinDoubleSets(ArrayList<String> trueOrFalse){
        homeWinDoubleSets = trueOrFalse;
    }
    
    
    
    public ArrayList<String> getSetWins(){
        return setWins;
    }

    public void setSetWins (String trueOrFalse){
        setWins.add(trueOrFalse);
    }
    public void clearSetWins (){
        setWins.clear();
    }
    
    public String getMatchScore(){
        return matchScore;
    }

    public void setMatchScore (String trueOrFalse){
        matchScore = trueOrFalse;
    }
  
}
