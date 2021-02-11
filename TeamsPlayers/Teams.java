/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TeamsPlayers;

import java.util.ArrayList;

/**
 *
 * @author benja
 */
public class Teams {
    private String teamName;
    private ArrayList<String> players = new ArrayList<String>();
    
    public Teams(String tName){
        teamName = tName;
    }
    public String getTeamName(){
        return teamName;
    }
    public ArrayList<String> getPlayers(){
        return players;
    }
    
    public void setPlayers(String player){
        players.add(player);
    }
}
