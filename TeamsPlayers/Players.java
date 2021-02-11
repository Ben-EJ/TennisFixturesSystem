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
public class Players {
    private String firstNamePlayer;
    private String lastNamePlayer;
    private String teamName;
    private String teamType;
    
    public void Players(String firstName,String lastName,String tName,String tType){
        firstNamePlayer = firstName;
        lastNamePlayer = lastName;
        teamName = tName;
        teamType = tType;
    }
    public String getFirstNamePlayer(){
        return firstNamePlayer;
    }
    public String getLastNamePlayer(){
        return lastNamePlayer;
    }
    public String getTeamName(){
        return teamName;
    }
    public String getTeamType(){
        return teamType;
    }
}
