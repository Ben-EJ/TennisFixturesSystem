/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamsPlayers;

/**
 *
 * @author benja
 */
public class TeamStats {
    private String teamName;
    private int matchesPlayed;
    private int matchesWon;
    private int setsWon;
    
    public TeamStats(String teamName,int matchesPlayed,int matchesWon,int setsWon){
        this.teamName = teamName;
        this.matchesPlayed = matchesPlayed;
        this.matchesWon = matchesWon;
        this.setsWon = setsWon;
    }
    
    public String getTeamName(){
        return teamName;
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
    
    public void setTeamName(String teamName){
        this.teamName = teamName;
    }
    public void setMatchesPlayed(int matchesPlayed){
        this.matchesPlayed = matchesPlayed;
    }
    public void setMatchesWon(int matchesWon){
        this.matchesWon = matchesWon;
    }
    public void setSetsWon(int setsWon){
        this.setsWon = setsWon;
    }
}
