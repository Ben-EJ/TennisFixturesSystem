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
 
    private String teamOne = ""; // stores home team name
    private String teamTwo = "";// stores away team name
    private boolean matchComplete = false;// true if matches complete
    private ArrayList<String> PlayersTeamAway = new ArrayList<String>(); // stores away players in match
    private ArrayList<String> PlayersTeamHome = new ArrayList<String>();// stores home players in match
    
    private ArrayList<String> PlayerOneVsPlayerThree = new ArrayList<String>();// stores scores for this set of games
    private ArrayList<String> homeWinPlayerOneVsPlayerThree = new ArrayList<String>(); // stores win/loss for home team
  
    private ArrayList<String> PlayerTwoVsPlayerThree = new ArrayList<String>();// stores scores for this set of games
    private ArrayList<String> homeWinPlayerTwoVsPlayerThree = new ArrayList<String>();// stores win/loss for home team
   
    
    private ArrayList<String> PlayerOneVsPlayerFour = new ArrayList<String>();// stores scores for this set of games
    private ArrayList<String> homeWinPlayerOneVsPlayerFour = new ArrayList<String>();// stores win/loss for home team

    
    private ArrayList<String> PlayerTwoVsPlayerFour = new ArrayList<String>();// stores scores for this set of games
    private ArrayList<String> homeWinPlayerTwoVsPlayerFour = new ArrayList<String>();// stores win/loss for home team

    
    private ArrayList<String> doubleSets = new ArrayList<String>();// stores scores for this set of games
    private ArrayList<String> homeWinDoubleSets  = new ArrayList<String>();// stores win/loss for home team
  
    
    private ArrayList<String> setWins = new ArrayList<String>();// contains set wins/losses for home team
    private String matchScore;// contains final match scores
    
    public Match(String team1, String team2,ArrayList<String> PlayersHome, ArrayList<String> PlayersAway, ArrayList<String> PlayerOnePlayerThree,ArrayList<String> PlayerTwoPlayerThree, ArrayList<String> PlayerOnePlayerFour,ArrayList<String> PlayerTwoPlayerFour, ArrayList<String> doubleS){
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
    public boolean getMatchComplete(){
        return matchComplete;
    }
    public void setMatchComplete(boolean status){
        matchComplete = status;
    }
    public String getTeamHome(){
        return teamOne;
    }
    
    public String getTeamAway(){
        return teamTwo;
    }
  
    
    public ArrayList<String> getPlayersTeamAway(){
        return PlayersTeamAway;
    }
    
    public ArrayList<String> getPlayersTeamHome(){
        return PlayersTeamHome;
    }
    
    public void setPlayersTeamAwayPlayerOne(String playerName){
        PlayersTeamAway.set(0, playerName);
    }
    public void setPlayersTeamAwayPlayerTwo(String playerName){
        PlayersTeamAway.set(1, playerName);
    }
    
    public void setPlayersTeamHomePlayerOne(String playerName){
        PlayersTeamHome.set(0, playerName);
    }
    
    public void setPlayersTeamHomePlayerTwo(String playerName){
        PlayersTeamHome.set(1, playerName);
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
