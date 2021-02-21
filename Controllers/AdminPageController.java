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
    
    public static List<TeamsPlayers.Teams> teams = new ArrayList<TeamsPlayers.Teams>();
    public static List<String> teamsAlreadyAdded = new ArrayList<String>();
    
    public static List<Match.Fixtures> fixtures = new ArrayList<Match.Fixtures>();
    public ArrayList<ArrayList<String>> fixtureList = new ArrayList<ArrayList<String>>();
    
    @FXML
    void addTeam(ActionEvent event) {
        System.out.println("adding team");
        String teamName = teamNameField.getText();
        teams.add(new TeamsPlayers.Teams(teamName, teams.size() + 1));
        teamsAlreadyAdded.add(teamName);
        int arrayTeamSize = teams.size();
        //Tests
        if (arrayTeamSize >= 1){
            Alert teamAdded = new Alert(Alert.AlertType.CONFIRMATION);
            teamAdded.setHeaderText("Team created " + teams.get(arrayTeamSize - 1).getTeamName() + " Team number: " + teams.get(arrayTeamSize - 1).getTeamNumber());
            teamAdded.showAndWait();
        }else{
            Alert noTeamAdded = new Alert(Alert.AlertType.ERROR);
            noTeamAdded.setHeaderText("Team creation FAILED");
            noTeamAdded.showAndWait();
        }   
    }
    
    @FXML
    void dropDownTeamNameOnShowing(Event event) {
        System.out.println("updateTeamList");         
        ObservableList<String> teamsComboContent = FXCollections.observableArrayList(teamsAlreadyAdded);
        dropDownTeamName.setItems(teamsComboContent);
    }
    
    @FXML
    void registerPlayer(ActionEvent event) {
        System.out.println("registerPlayer");
        String teamName = dropDownTeamName.getValue();
        for (int i = 0; i < teams.size(); i++){
            if(teamName.equals(teams.get(i).getTeamName())){
                if(teams.get(i).getPlayers().size() != 2){
                    System.out.println("Player Added");
                    int playerAmmount = teams.get(i).getPlayers().size();
                    teams.get(i).setPlayers(playerNameField.getText(), playerAmmount + 1);
                    Alert playerAdded = new Alert(Alert.AlertType.CONFIRMATION);
 
                    playerAdded.setHeaderText("Player added: " + playerNameField.getText() + " / " + " Player Number: "+ teams.get(i).getPlayers().get(teams.get(i).getPlayers().size() - 1).getPlayerNumber() + " / " + " to team: " + teams.get(i).getTeamName());
                    playerAdded.showAndWait();
                    System.out.println(teams.get(i).getPlayers());
                }else
                {
                     Alert noTeamAdded = new Alert(Alert.AlertType.ERROR);
                     noTeamAdded.setHeaderText("Player creation: FAILED, TEAM HAS 2 PLAYERS");
                     noTeamAdded.showAndWait();
                }
                
            }
        }
       
    }

    @FXML
    void generateFixtures(ActionEvent event) {
        System.out.println("generateFixtures");
        if (teams.size() > 0 && (teams.size() % 2) <= 0 && teams.size() <= 12){           
            for (int i = 0; i < teams.size(); i++){
                for (int x = 0; x < teams.size(); x++){
                    if (teams.get(i).getTeamName().equals(teams.get(x).getTeamName())){
                        
                    } else
                    {
                         ArrayList<String> teamPair = new ArrayList<String>();
                         teamPair.add(teams.get(i).getTeamName());
                         teamPair.add(teams.get(x).getTeamName());
                         System.out.println("============================");
                         System.out.println(teams.get(i).getTeamName());
                         System.out.println(teams.get(x).getTeamName());
                         System.out.println("============================");
                         fixtureList.add(teamPair);
                    }
                }
            }
            System.out.println("generateFixtures: SUCCESS");
            Alert generatedFixtures = new Alert(Alert.AlertType.CONFIRMATION);
            generatedFixtures.setHeaderText("Fixtures created, you have: " + teams.size() + " teams ");
            generatedFixtures.showAndWait();
            
            for (int fixtureAmmount = 0; fixtureAmmount < fixtureList.size(); fixtureAmmount++){
                fixtures.add(new Match.Fixtures(fixtureAmmount, fixtureList.get(fixtureAmmount)));
            }
            
        }else
        {
            System.out.println("generateFixtures: FAIL");
            Alert cantGenerateFixtures = new Alert(Alert.AlertType.ERROR);
            cantGenerateFixtures.setHeaderText("Error uneven teams, need 2,4,6,8,10,12 teams to generate fixtures. YOU HAVE: " + teams.size() + " teams.");
            cantGenerateFixtures.showAndWait();
        }
    }
    public int getTeamNumber(String teamName){
        int teamNumber = 0;
        for (int i = 0; i < teams.size(); i++){
            if (teams.get(i).getTeamName().equalsIgnoreCase(teamName)){
                return i;
            }
        }
        return teamNumber;
    }
    @FXML
    void generateTeamStats(ActionEvent event) throws IOException {
        System.out.println("generateTeamStats");
        for (int teamNum = 0 ; teamNum < teams.size();teamNum++){
            int score = 0;
            for (int i = 0; i < ScoreSheetController.matches.size(); i++){
                if (teams.get(teamNum).getTeamName().equalsIgnoreCase(ScoreSheetController.matches.get(i).getTeamAway()) || teams.get(teamNum).getTeamName().equalsIgnoreCase(ScoreSheetController.matches.get(i).getTeamHome())){
                 
                    for (int x = 0; x < ScoreSheetController.matches.get(i).getSetWins().size(); x++){
                    if(ScoreSheetController.matches.get(i).getSetWins().get(x).equalsIgnoreCase("Win")){
                        score += 1;
                    }
                    }
                     if(ScoreSheetController.matches.get(i).getTeamAway().equalsIgnoreCase(teams.get(teamNum).getTeamName())){
                         teams.get(teamNum).addSetsWon(score);
                         }
                      else if(ScoreSheetController.matches.get(i).getTeamHome().equalsIgnoreCase(teams.get(teamNum).getTeamName())){
                    teams.get(teamNum).addSetsWon(5 - score);
                    }
                }
                
                
            }
            int ammountOfMatches = 0;
            for (int z = 0; z < ScoreSheetController.matches.size(); z++){
                if (teams.get(teamNum).getTeamName().equalsIgnoreCase(ScoreSheetController.matches.get(z).getTeamAway()) || teams.get(teamNum).getTeamName().equalsIgnoreCase(ScoreSheetController.matches.get(z).getTeamHome())){
                    ammountOfMatches += 1;
                }
            }
            teams.get(teamNum).setMatchesPlayed(ammountOfMatches);
        }
      for (int i = 0; i < teams.size(); i++){
          System.out.println("Team Name: " + teams.get(i).getTeamName() + " / " + " Matches Played: " + teams.get(i).getMatchesPlayed() + " / " + "Sets Won" + teams.get(i).getSetsWon());
      }
    }
   
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
