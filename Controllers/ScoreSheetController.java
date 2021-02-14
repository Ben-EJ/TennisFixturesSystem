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
    
    @FXML
    void modifyScoreSheet(ActionEvent event) {
       
    }
    
   
    @FXML
    void newScoreSheet(ActionEvent event) {
        if (AdminPageController.fixtures.isEmpty()){
                  Alert noFixturesCreated = new Alert(Alert.AlertType.ERROR);
                  noFixturesCreated.setHeaderText("No fixtures created.");
                  noFixturesCreated.showAndWait();
        }else{
            for (int i = 0; i < AdminPageController.fixtures.size(); i++){
            if(AdminPageController.fixtures.get(i).getTeamsInFixture().get(0).equals(homeTeamSelection.getValue()) && AdminPageController.fixtures.get(i).getTeamsInFixture().get(1).equals(awayTeamSelection.getValue())){
                System.out.println("MATCH IN FIXTURES 1");
                break;
            }
            else if(AdminPageController.fixtures.get(i).getTeamsInFixture().get(1).equals(homeTeamSelection.getValue()) && AdminPageController.fixtures.get(i).getTeamsInFixture().get(0).equals(awayTeamSelection.getValue())){
                System.out.println("MATCH IN FIXTURES 2");
                break;
            }
            else{
                 System.out.println("Does not exist");
            }
        }
        }
       
    }

    @FXML
    void calculateScores(ActionEvent event) {

    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
