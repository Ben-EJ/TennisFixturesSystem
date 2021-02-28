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
public class Players{
    private String namePlayer;
    private int playerNumber;

    Players(String name, int playerNum) {
        namePlayer = name;
        playerNumber = playerNum;
    }
    
    public String getNamePlayer(){
        return namePlayer;
    }
    public int getPlayerNumber(){
        return playerNumber;
    }
}
