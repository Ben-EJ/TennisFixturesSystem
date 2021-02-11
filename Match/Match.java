/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Match;

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
    private HashMap<String, int[]> singleSetData = new HashMap<String, int[]>(); 
    private HashMap<String, int[]> doubleSetData = new HashMap<String, int[]>(); 
    private int singleSetsPlayed = 0;
    private int doubleSetsPlayed = 0;
    
    public void Match(int Number,String team1,String team2){
        matchNumber = Number;
        teamOne = team1;
        teamTwo = team2;       
    }
    
    public void setHashMapSingle(){
        
    }
}
