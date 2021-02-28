/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Csv.CSV;
import Login.Login;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author benja
 */
public class AdminPageController extends Thread implements Initializable {
   @FXML
    private TextField teamNameField;
    @FXML
    private ComboBox<String> dropDownTeamName;
    @FXML
    private TextField playerNameField;
    
    public static List<TeamsPlayers.Teams> teams = new ArrayList<TeamsPlayers.Teams>();// holds teams objects
    public static List<String> teamsAlreadyAdded = new ArrayList<String>(); // holds teams 
    
    public static List<Match.Fixtures> fixtures = new ArrayList<Match.Fixtures>();// holds fixtures class objects
   
    
    //adds team
    @FXML
    void addTeam(ActionEvent event) {
        int arrayTeamSizeBefore = teams.size();
        System.out.println("adding team");
        String teamName = teamNameField.getText();// gets teams name from text box
        teams.add(new TeamsPlayers.Teams(teamName, teams.size() + 1)); // creates new team object stores in arraylist
        teamsAlreadyAdded.add(teamName); 
        int arrayTeamSizeAfter = teams.size();
        //Tests
        if (arrayTeamSizeAfter > arrayTeamSizeBefore){ // find out if team was added by checking to see if the size of the teams object arraylist's size has increased
            //confermation alert
            Alert teamAdded = new Alert(Alert.AlertType.CONFIRMATION);
            teamAdded.setHeaderText("Team created " + teams.get(arrayTeamSizeAfter - 1).getTeamName() + " Team number: " + teams.get(arrayTeamSizeAfter - 1).getTeamNumber());
            teamAdded.showAndWait();
        }else{
            Alert noTeamAdded = new Alert(Alert.AlertType.ERROR);
            noTeamAdded.setHeaderText("Team creation FAILED");
            noTeamAdded.showAndWait();
        }   
    }
    
    // Updates team name dropdown box
    @FXML
    void dropDownTeamNameOnShowing(Event event) {
        System.out.println("updateTeamList");         
        ObservableList<String> teamsComboContent = FXCollections.observableArrayList(teamsAlreadyAdded);
        dropDownTeamName.setItems(teamsComboContent);
    }
    
    // adds play to teams
    @FXML
    void registerPlayer(ActionEvent event) {
        System.out.println("registerPlayer");
        String teamName = dropDownTeamName.getValue();// get player name to add
        for (int i = 0; i < teams.size(); i++){ // for each team
            if(teamName.equals(teams.get(i).getTeamName())){// if the name of the team given by the user equals that of a team in the teams object list then:
                
                System.out.println("Player Added");
                
                int playerAmmount = teams.get(i).getPlayers().size();
                teams.get(i).setPlayers(playerNameField.getText(), playerAmmount + 1);// adds player to team
                
                // confirms that the player was added
                Alert playerAdded = new Alert(Alert.AlertType.CONFIRMATION);
                playerAdded.setHeaderText("Player added: " + playerNameField.getText() + " / " + " Player Number: "+ teams.get(i).getPlayers().get(teams.get(i).getPlayers().size() - 1).getPlayerNumber() + " / " + " to team: " + teams.get(i).getTeamName());
                playerAdded.showAndWait();
                System.out.println(teams.get(i).getPlayers());
              
                
            }
        }
       
    }
    
    //creates fixtures
    @FXML
    void generateFixtures(ActionEvent event) {
        System.out.println("generateFixtures");
        ArrayList<ArrayList<String>> fixtureList = new ArrayList<ArrayList<String>>();// holds fixtures temp
        
        fixtures.clear();// clear fixtures each time new ones are generated
        if (teams.size() > 0 && (teams.size() % 2) <= 0 && teams.size() <= 12){// if there is an even number of teams        
            for (int i = 0; i < teams.size(); i++){// for each team 
                for (int x = 0; x < teams.size(); x++){//for each team
                    if (teams.get(i).getTeamName().equals(teams.get(x).getTeamName())){// if the two team names obtain from the loops are the same do nothing
                        continue;
                    } else
                    {
                         ArrayList<String> teamPair = new ArrayList<String>();
                         // add the two team names to a array list to create a fixture
                         teamPair.add(teams.get(i).getTeamName());
                         teamPair.add(teams.get(x).getTeamName());
                         System.out.println("============================");
                         System.out.println(teams.get(i).getTeamName());
                         System.out.println(teams.get(x).getTeamName());
                         System.out.println("============================");
                         fixtureList.add(teamPair);// add the pair of team names to a fixture list
                    }
                }
            }
            // tell the user that the fixture generation was successful 
            System.out.println("generateFixtures: SUCCESS");
            Alert generatedFixtures = new Alert(Alert.AlertType.CONFIRMATION);
            generatedFixtures.setHeaderText("Fixtures created, you have: " + teams.size() + " teams ");
            generatedFixtures.showAndWait();
            //create a fixture object and add each list in fixtureList to the fixture objects arraylist
            for (int fixtureAmmount = 0; fixtureAmmount < fixtureList.size(); fixtureAmmount++){
                fixtures.add(new Match.Fixtures(fixtureAmmount, fixtureList.get(fixtureAmmount)));
            }
            
        }else
        {
            // notify the user that fixture generation has failed
            System.out.println("generateFixtures: FAIL");
            Alert cantGenerateFixtures = new Alert(Alert.AlertType.ERROR);
            cantGenerateFixtures.setHeaderText("Error uneven teams, need 2,4,6,8,10,12 teams to generate fixtures. YOU HAVE: " + teams.size() + " teams.");
            cantGenerateFixtures.showAndWait();
        }
    }
    // gets team number
    public int getTeamNumber(String teamName){
        int teamNumber = 0;
        for (int i = 0; i < teams.size(); i++){// for each team
            if (teams.get(i).getTeamName().equalsIgnoreCase(teamName)){// if given team name matches that of one in teams object list then 
                return i; // return current number
            }
        }
        return teamNumber;
    }
    
    public static void generateTeamStatsFunc(){
        
        MainController.teamStats.clear();
        for (int teamNum = 0 ; teamNum < teams.size();teamNum++){ // for each team
            int score = 0;
            int wins = 0;
            for (int i = 0; i < ScoreSheetController.matches.size(); i++){// for each match
                if (ScoreSheetController.matches.get(i).getMatchComplete() == true){ // if match has been played
                    //if the given away team name or home team name match that of one in the matches obejects list then 
                    if (teams.get(teamNum).getTeamName().equalsIgnoreCase(ScoreSheetController.matches.get(i).getTeamHome()) || teams.get(teamNum).getTeamName().equalsIgnoreCase(ScoreSheetController.matches.get(i).getTeamAway())){
                    
                        // for each match that team played
                    for (int x = 0; x < ScoreSheetController.matches.get(i).getSetWins().size(); x++){
                        // if they won a set increment there score 
                        if(ScoreSheetController.matches.get(i).getSetWins().get(x).equalsIgnoreCase("Win") && ScoreSheetController.matches.get(i).getTeamHome().equalsIgnoreCase(teams.get(teamNum).getTeamName())){
                            score += 1;
                        }
                        else if (ScoreSheetController.matches.get(i).getSetWins().get(x).equalsIgnoreCase("loss") && ScoreSheetController.matches.get(i).getTeamAway().equalsIgnoreCase(teams.get(teamNum).getTeamName())){
                            score += 1;
                        }
                    }
                    
                    String matchScore = ScoreSheetController.matches.get(i).getMatchScore();
                    // if a match's home team name is equal to that of the current team name then
                    if(ScoreSheetController.matches.get(i).getTeamHome().equalsIgnoreCase(teams.get(teamNum).getTeamName())){
                       // see if they one the match if they did increment win socre
                       String[] splitResult = matchScore.split(":");
                       if (Integer.parseInt(splitResult[0]) > Integer.parseInt(splitResult[1])){
                          wins += 1;
                       }
                    }
                    // does the same as the lines above but if the team is an away team
                    else if (ScoreSheetController.matches.get(i).getTeamAway().equalsIgnoreCase(teams.get(teamNum).getTeamName())){
                        String[] splitResult = matchScore.split(":");
                        if (Integer.parseInt(splitResult[0]) < Integer.parseInt(splitResult[1])){
                          wins += 1;
                       }
                    }
                    //if current match equals current team name (if home team)
                    if(ScoreSheetController.matches.get(i).getTeamHome().equalsIgnoreCase(teams.get(teamNum).getTeamName())){
                        teams.get(teamNum).setSetsWon(score);// set ammount of sets won for that team
                    }
                    //if current match equals current team name (if away team)
                    else if(ScoreSheetController.matches.get(i).getTeamAway().equalsIgnoreCase(teams.get(teamNum).getTeamName())){
                        teams.get(teamNum).setSetsWon(score);// set ammount of sets won for that team
                    }
                }         
            }         
            }
            
        int ammountOfMatches = 0;
        // for each match
        for (int z = 0; z < ScoreSheetController.matches.size(); z++){
            // if current team name is equal to either matches home team name or away team then
            if (teams.get(teamNum).getTeamName().equalsIgnoreCase(ScoreSheetController.matches.get(z).getTeamHome()) || teams.get(teamNum).getTeamName().equalsIgnoreCase(ScoreSheetController.matches.get(z).getTeamAway())){
                ammountOfMatches += 1;// increment matches played
            }
        }
        teams.get(teamNum).setMatchesPlayed(ammountOfMatches);// set ammount of matches played
        
        MainController.teamStats.add(new TeamsPlayers.TeamStats(teams.get(teamNum).getTeamName(), teams.get(teamNum).getMatchesPlayed(), wins,  teams.get(teamNum).getSetsWon())); // create new team stat
       
    }
    
}
    
    @FXML
    void generateTeamStats(ActionEvent event) throws IOException {
       generateTeamStatsFunc();
    }
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
