/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Match;

import java.util.ArrayList;

/**
 *
 * @author benja
 */
public class Fixtures {
    private int fixtureNumber;
    ArrayList<String> teamList = new ArrayList<String>();
    private String[] playersInFixtureSingles;
    
    public Fixtures(int fixtureNum, ArrayList<String> teamsFixture){
         fixtureNumber = fixtureNum;
         teamList = teamsFixture;
        
    }
    
    public int getFixtureNumber(){
        return fixtureNumber;
    }
    public ArrayList<String> getTeamsInFixture(){
        return teamList;
    }
    public String[] getPlayersInFixtureSingles(){
        return playersInFixtureSingles;
    }
}
