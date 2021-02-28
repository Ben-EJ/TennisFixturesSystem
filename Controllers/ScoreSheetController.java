/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import Login.Login;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
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
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author benja
 */
public class ScoreSheetController implements Initializable {
    @FXML
    private TextField field9DB;

    @FXML
    private TextField field8DB;

    @FXML
    private TextField field7DB;

    @FXML
    private TextField field11;

    @FXML
    private TextField field12;

    @FXML
    private TextField field1;

    @FXML
    private TextField field10;

    @FXML
    private TextField field15;

    @FXML
    private TextField field13;

    @FXML
    private TextField field14;

    @FXML
    private TextField field6;

    @FXML
    private TextField field3;

    @FXML
    private TextField field2;

    @FXML
    private TextField field5;

    @FXML
    private TextField field4;
    
    @FXML
    private ComboBox<String> homeTeamSelection;

    @FXML
    private ComboBox<String> awayTeamSelection;
    
    @FXML
    private ComboBox<String> awayPlayerOne;
    @FXML
    private ComboBox<String> awayPlayerTwo;
    
    @FXML
    private ComboBox<String> homePlayerOne;
    @FXML
    private ComboBox<String> homePlayerTwo;
    
    @FXML
    private TextArea finalScore;
    public static List<Match.Match> ScoreSheet = new ArrayList<Match.Match>();
    //updates combo boxes for teams
    public void teamsLoad(){
        ObservableList<String> TeamSelectionText = FXCollections.observableArrayList(AdminPageController.teamsAlreadyAdded);
        homeTeamSelection.setItems(TeamSelectionText);
        awayTeamSelection.setItems(TeamSelectionText);
    }
    
    // updates combo boxes for players when teams selected
    public void teamPlayersLoad(int homeAwayTeamSelect){
        List<String> playersHome = new ArrayList<String>();
        List<String> playersAway = new ArrayList<String>();
        System.out.println("Start Load Players");
        // if selected team type is home team then
        if (homeAwayTeamSelect == 0){
             for (int i = 0; i < AdminPageController.teams.size(); i++){// for each team
                // if obtained team is equal to home team name in combo box
                if (AdminPageController.teams.get(i).getTeamName().equals(homeTeamSelection.getValue())){
                    // for each player in team
                    for(int z = 0; z < AdminPageController.teams.get(i).getPlayers().size(); z++){
                        playersHome.add(AdminPageController.teams.get(i).getPlayers().get(z).getNamePlayer()); // add player name to temp list 
                    }
                    ObservableList<String> playerSelectionTextHome = FXCollections.observableArrayList(playersHome);
                    homePlayerOne.setItems(playerSelectionTextHome);
                    homePlayerTwo.setItems(playerSelectionTextHome);
                }
        }
        }else{
              for (int i = 0; i < AdminPageController.teams.size(); i++){// for each team
                 // if obtained team is equal to away team name in combo box
               if (AdminPageController.teams.get(i).getTeamName().equals(awayTeamSelection.getValue())){
                   // for each player in team
                   for(int x = 0; x < AdminPageController.teams.get(i).getPlayers().size(); x++){
                        playersAway.add(AdminPageController.teams.get(i).getPlayers().get(x).getNamePlayer());// add player name to temp list
                   }
                   ObservableList<String> playerSelectionTextAway = FXCollections.observableArrayList(playersAway);
                   awayPlayerOne.setItems(playerSelectionTextAway);
                   awayPlayerTwo.setItems(playerSelectionTextAway);
          
            }
        }
        }
        System.out.println("End Load Players");
    }
    
     @FXML
    void comboBoxAwayTeam(Event event) {
        teamsLoad();
    }

    @FXML
    void comboBoxHomeTeam(Event event) {
        teamsLoad();
    }
    
    @FXML
    void comboBoxAwayTeamPlayersOne(Event event) {
       teamPlayersLoad(1);
    }
    
    @FXML
    void comboBoxAwayTeamPlayersTwo(Event event) {
       teamPlayersLoad(1);
    }
    
    @FXML
    void comboBoxHomeTeamPlayersOne(Event event) {
         teamPlayersLoad(0);
    }
    
     @FXML
    void comboBoxHomeTeamPlayersTwo(Event event) {
         teamPlayersLoad(0);
    }
    
    public static ArrayList<Match.Match> matches = new ArrayList<Match.Match>();
    public boolean editMode = false;
    public int editNumber = 0;      
    private void testModifyScoreSheet(int i){
        System.out.println(" ");
        System.out.println("Matches " + matches.get(i).getTeamHome() + " Combo: " + awayTeamSelection.getValue());
        System.out.println("Matches " + matches.get(i).getTeamAway() + " Combo: " + homeTeamSelection.getValue());
        System.out.println("Matches " + matches.get(i).getPlayersTeamHome().get(0) + " Combo: " + homePlayerOne.getValue());
        System.out.println("Matches " + matches.get(i).getPlayersTeamHome().get(1) + " Combo: " + homePlayerTwo.getValue());
        System.out.println("Matches " + matches.get(i).getPlayersTeamAway().get(0) + " Combo: " + awayPlayerOne.getValue());
        System.out.println("Matches " + matches.get(i).getPlayersTeamAway().get(1) + " Combo: " + awayPlayerTwo.getValue());
        
        System.out.println(" ");
        if (matches.get(i).getTeamHome().equalsIgnoreCase(homeTeamSelection.getValue())){
            System.out.println("TEST ONE PASS");
        }
        if (matches.get(i).getTeamAway().equalsIgnoreCase(awayTeamSelection.getValue())){
            System.out.println("TEST TWO PASS");
        }
        if (matches.get(i).getPlayersTeamAway().get(0).equalsIgnoreCase(awayPlayerOne.getValue())){
            System.out.println("TEST THREE PASS");
        }
        if ( matches.get(i).getPlayersTeamAway().get(1).equalsIgnoreCase(awayPlayerTwo.getValue())){
            System.out.println("TEST FOUR PASS");
        }
        if (matches.get(i).getPlayersTeamHome().get(0).equalsIgnoreCase(homePlayerOne.getValue())){
            System.out.println("TEST FIVE PASS");
        }
        if (matches.get(i).getPlayersTeamHome().get(1).equalsIgnoreCase(homePlayerTwo.getValue())){
            System.out.println("TEST SIX PASS");
        }
    }
    @FXML
    void modifyScoreSheet(ActionEvent event) {
        boolean found = false;
        for (int i = 0; i < matches.size(); i++){    // for each match 
            testModifyScoreSheet(i);
            // if all details of match are the same as the match details in combo boxes then
            if(matches.get(i).getTeamHome().equalsIgnoreCase(homeTeamSelection.getValue()) 
            && matches.get(i).getTeamAway().equalsIgnoreCase(awayTeamSelection.getValue())  
            && matches.get(i).getPlayersTeamAway().get(0).equalsIgnoreCase(awayPlayerOne.getValue()) 
            && matches.get(i).getPlayersTeamAway().get(1).equalsIgnoreCase(awayPlayerTwo.getValue()) 
            && matches.get(i).getPlayersTeamHome().get(0).equalsIgnoreCase(homePlayerOne.getValue())
            && matches.get(i).getPlayersTeamHome().get(1).equalsIgnoreCase(homePlayerTwo.getValue()))     
            {
                editMode = true;// switch on edit mode
                found = true;// set found 
                
                editNumber = i; // get current number of match to edit
                // put found data in combo boxes                
                System.out.println("Found Scoresheet");
                field1.setText(matches.get(i).getPlayerOneVsPlayerThree().get(0));
                field2.setText(matches.get(i).getPlayerOneVsPlayerThree().get(1));
                field3.setText(matches.get(i).getPlayerOneVsPlayerThree().get(2));
                
                field4.setText(matches.get(i).getPlayerOneVsPlayerFour().get(0));
                field5.setText(matches.get(i).getPlayerOneVsPlayerFour().get(1));
                field6.setText(matches.get(i).getPlayerOneVsPlayerFour().get(2));
                
                field10.setText(matches.get(i).getPlayerTwoVsPlayerThree().get(0));
                field11.setText(matches.get(i).getPlayerTwoVsPlayerThree().get(1));
                field12.setText(matches.get(i).getPlayerTwoVsPlayerThree().get(2));
                
                field13.setText(matches.get(i).getPlayerTwoVsPlayerFour().get(0));
                field14.setText(matches.get(i).getPlayerTwoVsPlayerFour().get(1));
                field15.setText(matches.get(i).getPlayerTwoVsPlayerFour().get(2));
                
                field7DB.setText(matches.get(i).getDoubleSets().get(0));
                field8DB.setText(matches.get(i).getDoubleSets().get(1));
                field9DB.setText(matches.get(i).getDoubleSets().get(2));
                break;
            }
        }
        if(found == false){// if no match with those details are found alert the user
            Alert noMatchFound = new Alert(Alert.AlertType.ERROR);
            noMatchFound.setHeaderText("No Match Found");
            noMatchFound.showAndWait();
        }
    }
    
    //this function blanks all textboxes and combo boxes on score sheet
    @FXML
    void newScoreSheet(ActionEvent event) {
                field1.setText("");
                field2.setText("");
                field3.setText("");
                
                field10.setText("");
                field11.setText("");
                field12.setText("");
                
                field4.setText("");
                field5.setText("");
                field6.setText("");
                
                field13.setText("");
                field14.setText("");
                field15.setText("");
                
                field7DB.setText("");
                field8DB.setText("");
                field9DB.setText("");
                
                finalScore.setText("");
                
                homeTeamSelection.setValue("");
                awayTeamSelection.setValue("");
                
                awayPlayerOne.setValue("");
                awayPlayerTwo.setValue("");
                
                homePlayerOne.setValue("");
                homePlayerTwo.setValue("");
                
                homeTeamSelection.setPromptText("Home team");
                awayTeamSelection.setPromptText("Away team");
                
                awayPlayerOne.setPromptText("Away Player");
                awayPlayerTwo.setPromptText("Away Player");
                
                homePlayerOne.setPromptText("Home Player");
                homePlayerTwo.setPromptText("Home Player");
    }
    
    // calculates if a game was won by home team
    public String gameWon(String data){
        String winLoss = "loss";
        for(int l = 0; l < 3; l++){
            String[] splitResult = data.split(":");
            System.out.println(splitResult[0] + " " + splitResult[1]);
            if (Integer.parseInt(splitResult[0]) > Integer.parseInt(splitResult[1])){
                return "Win";
            }else{
                return "loss";
            }
        }
        return winLoss;
    }
    // calculates if a set of games was won 
    public String winSet(ArrayList<String> gameScores){
         int teamOne = 0;
         int teamTwo = 0;
         for (int winLoss = 0; winLoss < gameScores.size(); winLoss++){
            System.out.println("Score " + gameScores.get(winLoss));
            if(gameScores.get(winLoss).equals("Win")){
                teamOne += 1;
                
            }else
            {
                
                teamTwo += 1;
            }
        }
        if(teamOne > teamTwo){
           
            return "Win";
        }else if(teamOne < teamTwo)
        {
            
            return "loss";
        }else{
            
            return "draw";
        }
    } 
    //calculates match score
    public String finalMatchScores(ArrayList<String> setWins){
        int teamOne = 0;
        int teamTwo = 0;
        
        for (int i = 0; i < setWins.size(); i++){
            if(setWins.get(i).equalsIgnoreCase("Win")){
              
                teamOne += 1;
            }
            else if (setWins.get(i).equalsIgnoreCase("loss")) {
                
                teamTwo +=1;
            }
        }
        return teamOne + ":" + teamTwo;
    }
    
    public void calculateAll(int matchToEdit){
        ArrayList<String> tempWinPlayerOnePlayerThree = new ArrayList<String>();
        ArrayList<String> tempWinPlayerTwoPlayerThree = new ArrayList<String>();
        ArrayList<String> tempWinPlayerOnePlayerFour = new ArrayList<String>();
        ArrayList<String> tempWinPlayerTwoPlayerFour = new ArrayList<String>();
        ArrayList<String> tempWinDoubleSet = new ArrayList<String>();
        matches.get(editNumber).clearSetWins();
        
        for (int u = 0; u <= 2; u++){// for each game score PlayerOne VS PlayerThree
            String temp = matches.get(matchToEdit).getPlayerOneVsPlayerThree().get(u);
            tempWinPlayerOnePlayerThree.add(gameWon(temp)); 
        }
        for (int y = 0; y <= 2; y++){// for each game score PlayerTwoP VS PlayerThree
            String temp = matches.get(matchToEdit).getPlayerTwoVsPlayerThree().get(y);// get match score
            tempWinPlayerTwoPlayerThree.add(gameWon(temp)); // calculate game victory 
        }
        for (int h = 0; h <= 2; h++){// for each game score PlayerOne VS PlayerFour
            String temp = matches.get(matchToEdit).getPlayerOneVsPlayerFour().get(h);
            tempWinPlayerOnePlayerFour.add(gameWon(temp)); 
        }
        for (int c = 0; c <= 2; c++){// for each game score PlayerTwo VS PlayerFour
            String temp = matches.get(matchToEdit).getPlayerTwoVsPlayerFour().get(c);
            tempWinPlayerTwoPlayerFour.add(gameWon(temp)); 
        }
        for (int f = 0; f <= 2; f++){// for each game score in DoubleSet
            String temp = matches.get(matchToEdit).getDoubleSets().get(f);
            tempWinDoubleSet.add(gameWon(temp)); 
        }
        
        // ==========================Sets game outcome in match object==========================
        matches.get(matchToEdit).setHomeWinPlayerOneVsPlayerThree(tempWinPlayerOnePlayerThree);
        matches.get(matchToEdit).setHomeWinPlayerTwoVsPlayerThree(tempWinPlayerTwoPlayerThree);
        matches.get(matchToEdit).setHomeWinPlayerOneVsPlayerFour(tempWinPlayerOnePlayerFour);
        matches.get(matchToEdit).setHomeWinPlayerTwoVsPlayerFour(tempWinPlayerTwoPlayerFour);
        matches.get(matchToEdit).setHomeWinDoubleSets(tempWinDoubleSet);
        
        //==========================Sets set outcome in match object==========================
        matches.get(matchToEdit).setSetWins(winSet(matches.get(matchToEdit).getHomeWinPlayerOneVsPlayerThree()));
        matches.get(matchToEdit).setSetWins(winSet(matches.get(matchToEdit).getHomeWinPlayerTwoVsPlayerThree()));
        matches.get(matchToEdit).setSetWins(winSet(matches.get(matchToEdit).getHomeWinPlayerOneVsPlayerFour()));
        matches.get(matchToEdit).setSetWins(winSet(matches.get(matchToEdit).getHomeWinPlayerTwoVsPlayerFour()));
        matches.get(matchToEdit).setSetWins(winSet(matches.get(matchToEdit).getHomeWinDoubleSets()));
        // ==========================Sets match outcome in match object==========================
        matches.get(matchToEdit).setMatchScore(finalMatchScores(matches.get(matchToEdit).getSetWins()));
        
        // sets text area to final matches scores
        finalScore.setText(matches.get(matchToEdit).getMatchScore());
    }
    
    @FXML
    void calculateScores(ActionEvent event) {
        System.out.println("Calculate And Save");
        if(editMode == false){ // if not in edit mode then
            if (AdminPageController.fixtures.isEmpty()){// if fixtures is empty then alert user
                  Alert noFixturesCreated = new Alert(Alert.AlertType.ERROR);
                  noFixturesCreated.setHeaderText("No fixtures created.");
                  noFixturesCreated.showAndWait();
            }else{
                // for all fixtures found
                for (int i = 0; i < AdminPageController.fixtures.size(); i++){
                    // check to see if data found in fixtures equals that which was found in text boxes, if this is so then
                    if(AdminPageController.fixtures.get(i).getTeamsInFixture().get(0).equals(homeTeamSelection.getValue()) && AdminPageController.fixtures.get(i).getTeamsInFixture().get(1).equals(awayTeamSelection.getValue()) || AdminPageController.fixtures.get(i).getTeamsInFixture().get(1).equals(homeTeamSelection.getValue()) && AdminPageController.fixtures.get(i).getTeamsInFixture().get(0).equals(awayTeamSelection.getValue())){
                        // data is pulled from combo boxes and text boxes and saved in a match object which is stores in a array list of match objects
                        ArrayList<String> playerTeamAway = new ArrayList<String>();
                        ArrayList<String> playerTeamHome = new ArrayList<String>();
                
                        ArrayList<String> PlayerOnePlayerThree = new ArrayList<String>();
                        ArrayList<String> PlayerTwoPlayerThree = new ArrayList<String>();
                        ArrayList<String> PlayerOnePlayerFour = new ArrayList<String>();
                        ArrayList<String> PlayerTwoPlayerFour = new ArrayList<String>();
                        ArrayList<String> doubleS = new ArrayList<String>();
                        
                        ArrayList<String> tempWinPlayerOnePlayerThree = new ArrayList<String>();
                        ArrayList<String> tempWinPlayerTwoPlayerThree = new ArrayList<String>();
                        ArrayList<String> tempWinPlayerOnePlayerFour = new ArrayList<String>();
                        ArrayList<String> tempWinPlayerTwoPlayerFour = new ArrayList<String>();
                        ArrayList<String> tempWinDoubleSet = new ArrayList<String>();
                        
    
                        playerTeamAway.add(awayPlayerOne.getValue());
                        playerTeamAway.add(awayPlayerTwo.getValue()); 
                        playerTeamHome.add(homePlayerOne.getValue());
                        playerTeamHome.add(homePlayerTwo.getValue());
                
                        PlayerOnePlayerThree.add(field1.getText());
                        PlayerOnePlayerThree.add(field2.getText());
                        PlayerOnePlayerThree.add(field3.getText());
                
                        PlayerTwoPlayerThree.add(field10.getText());
                        PlayerTwoPlayerThree.add(field11.getText());
                        PlayerTwoPlayerThree.add(field12.getText());
                
                        PlayerOnePlayerFour.add(field4.getText());
                        PlayerOnePlayerFour.add(field5.getText());
                        PlayerOnePlayerFour.add(field6.getText());
                
                        PlayerTwoPlayerFour.add(field13.getText());
                        PlayerTwoPlayerFour.add(field14.getText());
                        PlayerTwoPlayerFour.add(field15.getText());
                
                        doubleS.add(field7DB.getText());
                        doubleS.add(field8DB.getText());
                        doubleS.add(field9DB.getText());
                
                        matches.add(new Match.Match(homeTeamSelection.getValue(), awayTeamSelection.getValue(),playerTeamHome,playerTeamAway,PlayerOnePlayerThree,PlayerTwoPlayerThree,PlayerOnePlayerFour,PlayerTwoPlayerFour,doubleS));
                        matches.get(matches.size() - 1).setMatchComplete(true);
                        calculateAll(matches.size() - 1);// calculate scores
                        
                        break;
                        
                        }
                    else{
                        System.out.println("Does not exist");
                    }
                }
            }
        }
        else if(editMode == true){// if edit mode is on then
                // edit currently selected match (save any new values entered / edited )
                matches.get(editNumber).setPlayerOneVsPlayerThree(field1.getText(), 0);
                matches.get(editNumber).setPlayerOneVsPlayerThree(field2.getText(), 1);
                matches.get(editNumber).setPlayerOneVsPlayerThree(field3.getText(), 2);
                
                matches.get(editNumber).setPlayerTwoVsPlayerThree(field10.getText(), 0);
                matches.get(editNumber).setPlayerTwoVsPlayerThree(field11.getText(), 1);
                matches.get(editNumber).setPlayerTwoVsPlayerThree(field12.getText(), 2);
                
                matches.get(editNumber).setPlayerOneVsPlayerFour(field4.getText(), 0);
                matches.get(editNumber).setPlayerOneVsPlayerFour(field5.getText(), 1);
                matches.get(editNumber).setPlayerOneVsPlayerFour(field6.getText(), 2);
                
                matches.get(editNumber).setPlayerTwoVsPlayerFour(field13.getText(), 0);
                matches.get(editNumber).setPlayerTwoVsPlayerFour(field14.getText(), 1);
                matches.get(editNumber).setPlayerTwoVsPlayerFour(field15.getText(), 2);
                
                matches.get(editNumber).setDoubleSets(field7DB.getText(), 0);
                matches.get(editNumber).setDoubleSets(field8DB.getText(), 1);
                matches.get(editNumber).setDoubleSets(field9DB.getText(), 2);
                matches.get(editNumber).setMatchComplete(true);
                calculateAll(editNumber); // recalculate scores
                System.out.print("Edit Made");
                editMode = false;// make sure edit mode is off before continuing 
                
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    
    
}
