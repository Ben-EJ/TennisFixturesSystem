/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

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
public class MainController implements Initializable {
    // =======================================LOGIN PAGE ===============================================
    
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
    void logIn(ActionEvent event) {
        boolean isLogedIn = false;
        System.out.println("Login");
        String userNameObtained = userName.getText();
        String userPasswordObtained = password.getText();
        isLogedIn = Login.loginAsAssosiationSec(userNameObtained,userPasswordObtained);
        
        if (isLogedIn == true){
            try{
                FXMLLoader fxmlAdminPageView = new FXMLLoader(getClass().getResource("FXMLAdminPage.fxml"));
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
        String userNameObtained = userNameScoreSheet.getText();
        String userPasswordObtained = passwordScoreSheet.getText();
        isLogedIn = Login.loginAsAssosiationSec(userNameObtained,userPasswordObtained);
        
        if (isLogedIn == true){
            try{
                FXMLLoader fxmlScoreSheetPageView = new FXMLLoader(getClass().getResource("FXMLScoreSheetPage.fxml"));
                Parent fxmlScoreSheetPageViewLoad = (Parent) fxmlScoreSheetPageView.load();
                ScoreSheetPageTab.setContent(fxmlScoreSheetPageViewLoad);
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
    
    // =======================================LOGIN PAGE END===============================================
    
    // =======================================ADMIN PAGE ===============================================
    @FXML
    private TextField teamNameField;
    @FXML
    private ComboBox<String> dropDownTeamName;
    @FXML
    private TextField playerNameField;
    
    public List<TeamsPlayers.Teams> teams = new ArrayList<TeamsPlayers.Teams>();
    public List<String> teamsAlreadyAdded = new ArrayList<String>();
    
    @FXML
    void addTeam(ActionEvent event) {
        System.out.println("adding team");
        String teamName = teamNameField.getText();
        teams.add(new TeamsPlayers.Teams(teamName));
        teamsAlreadyAdded.add(teamName);
        int arrayTeamSize = teams.size();
        //Tests
        if (arrayTeamSize >= 1){
            Alert teamAdded = new Alert(Alert.AlertType.CONFIRMATION);
            teamAdded.setHeaderText("Team created " + teams.get(arrayTeamSize - 1).getTeamName());
            teamAdded.showAndWait();
        }else{
            Alert noTeamAdded = new Alert(Alert.AlertType.ERROR);
            noTeamAdded.setHeaderText("Team creation FAILED");
            noTeamAdded.showAndWait();
        }   
    }
    
    @FXML
    void updateTeamList(ActionEvent event) {
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
                System.out.println("Player Added");
                teams.get(i).setPlayers(playerNameField.getText());
                Alert playerAdded = new Alert(Alert.AlertType.CONFIRMATION);
                playerAdded.setHeaderText("Player added: " + playerNameField.getText() + " to team: " + teams.get(i).getTeamName());
                playerAdded.showAndWait();
            }
        }
       
    }

    @FXML
    void generateFixtures(ActionEvent event) {
        System.out.println("generateFixtures");
    }

    @FXML
    void generateTeamStats(ActionEvent event) {
        System.out.println("generateTeamStats");
    }
    // =======================================ADMIN PAGE END===============================================
    
    
    // =======================================VIEWER PAGE ===============================================
    @FXML
    void viewFixtureChart(ActionEvent event) {
        System.out.println("viewFixtureChart");
    }

    @FXML
    void showAllTeamStats(ActionEvent event) {
        System.out.println("showAllTeamStats");
    }

    @FXML
    void showAllTeamRankings(ActionEvent event) {
        System.out.println("showAllTeamRankings");
    }

    @FXML
    void viewMatchScores(ActionEvent event) {
        System.out.println("viewMatchScores");
    }
    // =======================================VIEWER PAGE END===============================================
    
    
    // =======================================SCORESHEET PAGE ===============================================
    @FXML
    private TextField field1;
    @FXML
    private TextField field2;
    @FXML
    private TextField field3;
    @FXML
    private TextField field4;
    @FXML
    private TextField field5;
    @FXML
    private TextField field6;
    @FXML
    private TextField field7DB;
    @FXML
    private TextField field8DB;
    @FXML
    private TextField field9DB;
    @FXML
    private TextField field10;
    @FXML
    private TextField field11;
    @FXML
    private TextField field12;
    @FXML
    private TextField field13;
    @FXML
    private TextField field14;
    @FXML
    private TextField field15;
    
    @FXML
    void newScoreSheet(ActionEvent event) {
        System.out.println("newScoreSheet");
        
    }

    @FXML
    void modifyScoreSheet(ActionEvent event) {
        System.out.println("modifyScoreSheet");
    }

    @FXML
    void calculateScores(ActionEvent event) {
        System.out.println("calculateScores");
    }
    // =======================================SCORESHEET PAGE END===============================================
    
    
    
    
    
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
