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
    
    public static List<Match.Match> ScoreSheet = new ArrayList<Match.Match>();
    
    @FXML
    void updateDropdownTeams(ActionEvent event) {
        System.out.println("updateTeamList");         
        ObservableList<String> TeamSelectionText = FXCollections.observableArrayList(AdminPageController.teamsAlreadyAdded);
        homeTeamSelection.setItems(TeamSelectionText);
        awayTeamSelection.setItems(TeamSelectionText);
    }
    @FXML
    void updateDropdownPlayers(ActionEvent event) {
        List<String> playersHome = new ArrayList<String>();
        List<String> playersAway = new ArrayList<String>();
        for (int i = 0; i < AdminPageController.teams.size(); i++){
            
               if (AdminPageController.teams.get(i).getTeamName().equals(awayTeamSelection.getValue())){
                   for(int x = 0; x < AdminPageController.teams.get(i).getPlayers().size(); x++){
                        playersAway.add(AdminPageController.teams.get(i).getPlayers().get(x).getNamePlayer());
                   }
                   ObservableList<String> playerSelectionTextAway = FXCollections.observableArrayList(playersAway);
                   awayPlayerOne.setItems(playerSelectionTextAway);
                   awayPlayerTwo.setItems(playerSelectionTextAway);
          
            }
        }
        for (int i = 0; i < AdminPageController.teams.size(); i++){
          if (AdminPageController.teams.get(i).getTeamName().equals(homeTeamSelection.getValue())){
                    for(int z = 0; z < AdminPageController.teams.get(i).getPlayers().size(); z++){
                        playersHome.add(AdminPageController.teams.get(i).getPlayers().get(z).getNamePlayer()); 
                    }
                    ObservableList<String> playerSelectionTextHome = FXCollections.observableArrayList(playersHome);
                    homePlayerOne.setItems(playerSelectionTextHome);
                    homePlayerTwo.setItems(playerSelectionTextHome);
                }
        }
    }
    public static ArrayList<Match.Match> matches = new ArrayList<Match.Match>();
    @FXML
    void modifyScoreSheet(ActionEvent event) {
        boolean found = false;
        for (int i = 0; i < matches.size(); i++){
            if(matches.get(i).getTeamAway().equals(awayTeamSelection.getValue()) 
            && matches.get(i).getTeamHome().equals(homeTeamSelection.getValue())  
            && matches.get(i).getPlayersTeamAway().get(0).equals(awayPlayerOne.getValue()) 
            && matches.get(i).getPlayersTeamAway().get(1).equals(awayPlayerTwo.getValue()) 
            && matches.get(i).getPlayersTeamHome().get(0).equals(homePlayerOne.getValue())
            && matches.get(i).getPlayersTeamHome().get(1).equals(homePlayerTwo.getValue()))     
            {
                found = true;
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
        if(found == false){
            Alert noMatchFound = new Alert(Alert.AlertType.ERROR);
            noMatchFound.setHeaderText("No Match Found");
            noMatchFound.showAndWait();
        }
    }
    
   
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
    }

    @FXML
    void calculateScores(ActionEvent event) {
        System.out.println("Calculate And Save");
         if (AdminPageController.fixtures.isEmpty()){
                  Alert noFixturesCreated = new Alert(Alert.AlertType.ERROR);
                  noFixturesCreated.setHeaderText("No fixtures created.");
                  noFixturesCreated.showAndWait();
        }else{
            for (int i = 0; i < AdminPageController.fixtures.size(); i++){
            if(AdminPageController.fixtures.get(i).getTeamsInFixture().get(0).equals(homeTeamSelection.getValue()) && AdminPageController.fixtures.get(i).getTeamsInFixture().get(1).equals(awayTeamSelection.getValue()) || AdminPageController.fixtures.get(i).getTeamsInFixture().get(1).equals(homeTeamSelection.getValue()) && AdminPageController.fixtures.get(i).getTeamsInFixture().get(0).equals(awayTeamSelection.getValue())){
                ArrayList<String> playerTeamAway = new ArrayList<String>();
                ArrayList<String> playerTeamHome = new ArrayList<String>();
                
                ArrayList<String> PlayerOnePlayerThree = new ArrayList<String>();
                ArrayList<String> PlayerTwoPlayerThree = new ArrayList<String>();
                ArrayList<String> PlayerOnePlayerFour = new ArrayList<String>();
                ArrayList<String> PlayerTwoPlayerFour = new ArrayList<String>();
    
                ArrayList<String> doubleS = new ArrayList<String>();
    
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
                
                matches.add(new Match.Match(awayTeamSelection.getValue(),homeTeamSelection.getValue(),playerTeamAway,playerTeamHome,PlayerOnePlayerThree,PlayerTwoPlayerThree,PlayerOnePlayerFour,PlayerTwoPlayerFour,doubleS));
                break;
            }
            else{
                 System.out.println("Does not exist");
            }
        }
        }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
