/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Csv.CSV;
import Login.Login;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.ResourceBundle;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *observable list - listener when change is made updates everywhere
 * @author benja
 */
public class MainController extends Thread implements Initializable {
    
    // =======================================LOGIN PAGE ===============================================
    public static ArrayList<TeamsPlayers.TeamStats> teamStats = new ArrayList<TeamsPlayers.TeamStats>();
    @FXML
    private TextArea textAreaDataDisplay;
    @FXML
    private PasswordField password;

    @FXML
    private PasswordField passwordScoreSheet;

    @FXML
    private  TextField userNameScoreSheet;

    @FXML
    private TextField userName;
    @FXML
    private Tab adminPageTab;
    @FXML
    private Tab ScoreSheetPageTab;
    
    
    @FXML
    private Button fixtureChartButton;
    @FXML
    private Button teamRankingsButton;
    @FXML
    private Button matchScoresButton;
    @FXML
    private Button teamStatsButton;
    
    
    @FXML
    private Label EnterTeamNamesFX;
    @FXML
    private ComboBox<String> comboBoxHomeTeam;
    @FXML
    private ComboBox<String> comboBoxAwayTeam;
    @FXML
    private Button submitButtonFXID;
    
    
    @FXML
    void logIn(ActionEvent event) {
        boolean isLogedIn = false;
        System.out.println("Login");
        String userNameObtained = userName.getText();// get username 
        String userPasswordObtained = password.getText();// get password
        isLogedIn = Login.loginAsAssosiationSec(userNameObtained,userPasswordObtained);// check if username an password are correct
        
        if (isLogedIn == true){// if login successfull display admin page and notify the user that the credentials were correct
            try{
                FXMLLoader fxmlAdminPageView = new FXMLLoader(getClass().getResource("/FXML/FXMLAdminPage.fxml"));
                Parent fxmlAdminPageViewLoad = (Parent) fxmlAdminPageView.load();
                adminPageTab.setContent(fxmlAdminPageViewLoad);
                }catch (Exception e){
                    System.out.println("Error: Cant load new window");
                }
        }else{
            System.out.println("Incorrect password or username");
            Alert incorrectUOrP = new Alert(Alert.AlertType.ERROR);
            incorrectUOrP.setHeaderText("Incorrect username or password");
            incorrectUOrP.showAndWait();
        }
    }
    
    @FXML
    void logInScoreSheet(ActionEvent event) {
        boolean isLogedIn = false;
        System.out.println("Login");
        String userNameObtained = userNameScoreSheet.getText();// get username 
        String userPasswordObtained = passwordScoreSheet.getText();// get password
        isLogedIn = Login.loginAsAssosiationSec(userNameObtained,userPasswordObtained);// check if username an password are correct
        
        if (isLogedIn == true){// if login successfull display score page and notify the user that the credentials were correct
            try{
                FXMLLoader fxmlScoreSheetPageView = new FXMLLoader(getClass().getResource("/FXML/FXMLScoreSheetPage.fxml"));
                Parent fxmlScoreSheetPageViewLoad = (Parent) fxmlScoreSheetPageView.load();
                ScoreSheetPageTab.setContent(fxmlScoreSheetPageViewLoad);
                }catch (Exception e){
                    System.out.println("Error: Cant load new window ScoreSheet");
                }
        }else{
            System.out.println("Incorrect password or username");
            Alert incorrectUOrP = new Alert(Alert.AlertType.ERROR);
            incorrectUOrP.setHeaderText("Incorrect username or password");
            incorrectUOrP.showAndWait();
        }
    }
    
    // =======================================LOGIN PAGE END===============================================
    
    // =======================================VIEWER PAGE ===============================================
    @FXML
    void viewFixtureChart(ActionEvent event) {
       System.out.println("viewFixtureChart");
    }

    @FXML
    void showAllTeamStats(ActionEvent event) {
        textAreaDataDisplay.clear();
        textAreaDataDisplay.setWrapText(true);
        for (int i = 0; i < teamStats.size();i++){// loop through team stats and display them in text area    
            textAreaDataDisplay.appendText("Team Name: " + teamStats.get(i).getTeamName() + " Matches Played: " + teamStats.get(i).getMatchesPlayed() + " " + " Matches won: " + teamStats.get(i).getMatchesWon() + " Sets won: " + teamStats.get(i).getSetsWon() + "\n");
        }
        
    }
   
    @FXML
    void showAllTeamRankings(ActionEvent event) {
        System.out.println("showAllTeamRankings");
        ArrayList<TeamsPlayers.TeamStats> sortedTeamStats = new ArrayList<TeamsPlayers.TeamStats>();// Output ArrayList
        ArrayList<Integer> teamStatsSetWins = new ArrayList<Integer>(); // Stores set win values for each team
        
        
        for (int i = 0; i < AdminPageController.teams.size(); i++){
           teamStatsSetWins.add(AdminPageController.teams.get(i).getSetsWon());// append set win values from each team
    }

        Collections.sort(teamStatsSetWins, Collections.reverseOrder());// sorts array
        
        Set<Integer> setToRemoveDuplicates = new LinkedHashSet<>(teamStatsSetWins);//removes duplicate values   
        ArrayList<Integer> teamStatsFinalList = new ArrayList<Integer>(setToRemoveDuplicates);//converts back to ArrayList for proccessing
           
        for (int x = 0; x < teamStatsFinalList.size(); x++){// for each set win value
            for (int z = 0; z < teamStats.size(); z++){//for each team Stat
            if (teamStatsFinalList.get(x) == teamStats.get(z).getSetsWon()){// a teams stat matches a ordered stat in teamStatsFinalList then
                sortedTeamStats.add(teamStats.get(z));// append to new list of sorted team stats
            }
            }
        }
        textAreaDataDisplay.clear();
        textAreaDataDisplay.setWrapText(true);
        for (int i = 0; i < sortedTeamStats.size();i++){    
            textAreaDataDisplay.appendText("Team Name: " + sortedTeamStats.get(i).getTeamName() + " Matches Played: " + sortedTeamStats.get(i).getMatchesPlayed() + " " + " Matches won: " + sortedTeamStats.get(i).getMatchesWon() + " Sets won: " + sortedTeamStats.get(i).getSetsWon() + "\n");
        } 
    }
   
    @FXML
    void viewMatchScores(ActionEvent event) throws IOException {
        // displays match scores if fixtures are created
        if(AdminPageController.fixtures.size() != 0){
            EnterTeamNamesFX.setVisible(true);
            comboBoxHomeTeam.setVisible(true);
            comboBoxAwayTeam.setVisible(true);
            submitButtonFXID.setVisible(true);
        
            fixtureChartButton.setVisible(false);
            teamRankingsButton.setVisible(false);
            matchScoresButton.setVisible(false);
            teamStatsButton.setVisible(false);
            textAreaDataDisplay.setVisible(false); 
         }else{
            Alert noFixtures = new Alert(Alert.AlertType.ERROR);
            noFixtures.setHeaderText("No fixtures generated");
            noFixtures.showAndWait();
        }
    }
    
    // updates home team combo box with team list
    @FXML
    void onShowingHomeTeam(Event event) {
        ObservableList<String> TeamSelectionText = FXCollections.observableArrayList(AdminPageController.teamsAlreadyAdded);
        comboBoxHomeTeam.setItems(TeamSelectionText);
        comboBoxAwayTeam.setItems(TeamSelectionText);
    }
    // updates away team combo box with team list
    @FXML
    void onShowingAwayTeam(Event event) {
        ObservableList<String> TeamSelectionText = FXCollections.observableArrayList(AdminPageController.teamsAlreadyAdded);
        comboBoxHomeTeam.setItems(TeamSelectionText);
        comboBoxAwayTeam.setItems(TeamSelectionText);
    }
    
    // submits selected team names for getting match scores for viewer
    @FXML
    void submitButtton(ActionEvent event) {
        textAreaDataDisplay.clear();
        
        String teamHomeFixture = comboBoxHomeTeam.getValue();
        String teamAwayFixture = comboBoxAwayTeam.getValue();
        
        EnterTeamNamesFX.setVisible(false);
        comboBoxHomeTeam.setVisible(false);
        comboBoxAwayTeam.setVisible(false);
        submitButtonFXID.setVisible(false);
        
        fixtureChartButton.setVisible(true);
        teamRankingsButton.setVisible(true);
        matchScoresButton.setVisible(true);
        teamStatsButton.setVisible(true);
        textAreaDataDisplay.setVisible(true);
        
        boolean matchFound = false;
        for (int i = 0; i < AdminPageController.fixtures.size();i++){// for each fixture
            // if home team name in fixture equals obtained team name from combo box and away team name in fixture equals obtained team name from combo box then
            if (AdminPageController.fixtures.get(i).getTeamsInFixture().get(0).equalsIgnoreCase(teamHomeFixture) && AdminPageController.fixtures.get(i).getTeamsInFixture().get(1).equalsIgnoreCase(teamAwayFixture)){
                
                for (int x = 0; x < ScoreSheetController.matches.size();x++){// for each match 
                    // if home team name in match equals the home team name from combo box and also away team name in match equals the home team name from combo box then
                    if (ScoreSheetController.matches.get(x).getTeamHome().equalsIgnoreCase(teamHomeFixture) && ScoreSheetController.matches.get(x).getTeamAway().equalsIgnoreCase(teamAwayFixture)){
                        // if match is complete then print match data to text area
                        if(ScoreSheetController.matches.get(x).getMatchComplete() == true){
                            matchFound = true;
                            Alert foundMatch = new Alert(Alert.AlertType.CONFIRMATION);
                            foundMatch.setHeaderText("Found Match");
                            foundMatch.showAndWait();
                            
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getTeamHome() + " vs " + ScoreSheetController.matches.get(x).getTeamAway() + "\n");
                            textAreaDataDisplay.appendText(" " + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getPlayersTeamHome().get(0) + " vs " + ScoreSheetController.matches.get(x).getPlayersTeamAway().get(0) + " " + "(Single Set)" + ":" + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getPlayerOneVsPlayerThree().get(0)+ "," + " " + ScoreSheetController.matches.get(x).getPlayerOneVsPlayerThree().get(1)+ "," + " " + ScoreSheetController.matches.get(x).getPlayerOneVsPlayerThree().get(2) + "\n");
                            textAreaDataDisplay.appendText(" " + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getPlayersTeamHome().get(0) + " vs " + ScoreSheetController.matches.get(x).getPlayersTeamAway().get(1) + " " + "(Single Set)" + ":" + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getPlayerTwoVsPlayerThree().get(0)+ "," + " " + ScoreSheetController.matches.get(x).getPlayerTwoVsPlayerThree().get(1)+ "," + " " + ScoreSheetController.matches.get(x).getPlayerTwoVsPlayerThree().get(2) + "\n");
                            textAreaDataDisplay.appendText(" " + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getPlayersTeamHome().get(1) + " vs " + ScoreSheetController.matches.get(x).getPlayersTeamAway().get(0) + " " + "(Single Set)" + ":" + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getPlayerOneVsPlayerFour().get(0)+ "," + " " + ScoreSheetController.matches.get(x).getPlayerOneVsPlayerFour().get(1)+ "," + " " + ScoreSheetController.matches.get(x).getPlayerOneVsPlayerFour().get(2) + "\n");
                            textAreaDataDisplay.appendText(" " + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getPlayersTeamHome().get(1) + " vs " + ScoreSheetController.matches.get(x).getPlayersTeamAway().get(1) + " " + "(Single Set)" + ":" + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getPlayerTwoVsPlayerFour().get(0)+ "," + " " + ScoreSheetController.matches.get(x).getPlayerTwoVsPlayerFour().get(1)+ "," + " " + ScoreSheetController.matches.get(x).getPlayerTwoVsPlayerFour().get(2) + "\n");
                            textAreaDataDisplay.appendText(" " + "\n");
                            textAreaDataDisplay.appendText("Home vs Away (Double Set): " + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getDoubleSets().get(0)+ "," + " " + ScoreSheetController.matches.get(x).getDoubleSets().get(1)+ "," + " " + ScoreSheetController.matches.get(x).getDoubleSets().get(2) + "\n");
                            textAreaDataDisplay.appendText(" " + "\n");
                            textAreaDataDisplay.appendText("Final Scores: " + "\n");
                            textAreaDataDisplay.appendText(ScoreSheetController.matches.get(x).getMatchScore() + "\n");
                            
                        }
                    }          
                }
            }
        }
        if(matchFound == false){
             Alert foundMatch = new Alert(Alert.AlertType.ERROR);
             foundMatch.setHeaderText("No Match Found: match not finished/not played");
             foundMatch.showAndWait();
        }
    }
    
    // =======================================VIEWER PAGE END===============================================
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        EnterTeamNamesFX.setVisible(false);
        comboBoxHomeTeam.setVisible(false);
        comboBoxAwayTeam.setVisible(false);
        submitButtonFXID.setVisible(false);
        
        try {
           // Imports test data from csv files and stores them in system
           CSV.csvInputTeamsAndPlayers("src/Csv/DataTeamsAndPlayers.csv");
           CSV.csvInputScoreSheets("src/Csv/DataScoreSheetsOne.csv");
           CSV.csvInputScoreSheets("src/Csv/DataScoreSheetsTwo.csv");
       } catch (IOException ex) {
           System.out.println("Error adding CSV file data");
       }
        
        // generates team stats every 30 seconds 
        Timer recalcTeamStatsTimer = new Timer();
        recalcTeamStatsTimer.scheduleAtFixedRate(new TimerTask() {
        @Override
        public void run() {
            AdminPageController.generateTeamStatsFunc();
        }
       }, 0, 30000);
        
    }    
    
}
