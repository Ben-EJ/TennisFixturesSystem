/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Csv;

import static Controllers.AdminPageController.teams;
import static Controllers.AdminPageController.teamsAlreadyAdded;
import Controllers.ScoreSheetController;
import static Controllers.ScoreSheetController.matches;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author benja
 */
public class CSV {
     public static void csvInputTeamsAndPlayers(String fileLink) throws FileNotFoundException, IOException{
        List<List<String>> teamsPlayers = new ArrayList<>();
        try (BufferedReader csvInput = new BufferedReader(new FileReader(fileLink))) {//get file
            String line;
        while ((line = csvInput.readLine()) != null) {//while line has data
            String[] data = line.split(",");// split data by ,
            teamsPlayers.add(Arrays.asList(data)); // add each bit of data to array
        }
        int teamsAmmount = 0;
        for (int i = 0; i < teamsPlayers.size(); i++){// for each team
            teamsAmmount += 1;
            teams.add(new TeamsPlayers.Teams(teamsPlayers.get(i).get(0), teamsAmmount));
            teamsAlreadyAdded.add(teamsPlayers.get(i).get(0));
            for (int x = 1; x < teamsPlayers.get(i).size();x++){
               teams.get(i).setPlayers(teamsPlayers.get(i).get(x), teamsAmmount);
            }
        }
        for(int i = 0; i < teams.size(); i++){
            System.out.println(teams.get(i).getTeamName());
            for (int x = 0; x < teams.get(i).getPlayers().size(); x++){
                System.out.println(teams.get(i).getPlayers().get(x).getNamePlayer());
            }
            
        }
    }    
}
     
   public static void csvInputScoreSheets(String fileLink) throws FileNotFoundException, IOException{
        List<ArrayList<String>> scoreSheetData = new ArrayList<>();
        
        try (BufferedReader csvInput = new BufferedReader(new FileReader(fileLink))) {
            String line;
        while ((line = csvInput.readLine()) != null) {
            String[] data = line.split(",");
            
            ArrayList<String> dataMain = new ArrayList<String>();
            for (int z = 0; z < data.length; z++){
                dataMain.add(data[z]);
            }
            scoreSheetData.add(dataMain);
        }
        
    }
    ScoreSheetController.matches.add(new Match.Match(scoreSheetData.get(0).get(0),scoreSheetData.get(0).get(1),scoreSheetData.get(1),scoreSheetData.get(2),scoreSheetData.get(3),scoreSheetData.get(4),scoreSheetData.get(5),scoreSheetData.get(6),scoreSheetData.get(7)));
    for (int i = 0; i < ScoreSheetController.matches.size(); i++){
         ScoreSheetController.calculateAll(i);
         ScoreSheetController.matches.get(i).setMatchComplete(true);
     }
   }
}
