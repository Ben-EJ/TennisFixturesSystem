/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamsPlayers;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author benja
 */
public class Teams {
    private String teamName;
    private int teamNumber;
    
    private int matchesPlayed;
    private int matchesWon;
    private int setsWon;
    
    private List<Players> players = new ArrayList<Players>();
     
    
    public Teams(String tName,int teamNum){
        teamName = tName;
        teamNumber = teamNum;
    }
    
    public String getTeamName(){
        return teamName;
    }
     public int getTeamNumber(){
        return teamNumber;
    }
    public List<TeamsPlayers.Players> getPlayers(){
        return players;
    }
    
    public void setPlayers(String name, int playerNumber){
        players.add(new Players(name, playerNumber));
    }
    
    public int getMatchesPlayed(){
        return matchesPlayed;
    }
    public int getMatchesWon(){
        return matchesWon;
    }
    public int getSetsWon(){
        return setsWon;
    }
    
    public void setMatchesPlayed(int numToAdd){
        matchesPlayed = numToAdd;
    }
    
    public void addMatchesPlayed(int numToAdd){
        matchesPlayed += numToAdd;
    }
    public void addMatchesWon(int numToAdd){
        matchesWon += numToAdd;
    }
    public void setSetsWon(int numToAdd){
        setsWon = numToAdd;
    }
    
     public void subMatchesPlayed(int numToSub){
        matchesPlayed -= numToSub;
    }
    public void subMatchesWon(int numToSub){
        matchesWon -= numToSub;
    }
    public void subSetsWon(int numToSub){
        setsWon -= numToSub;
    }
}
