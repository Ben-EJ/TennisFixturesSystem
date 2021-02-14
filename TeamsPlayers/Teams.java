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
}
