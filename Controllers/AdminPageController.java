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
//                        boolean foundMatch = false;
//                        for (int z = 0; z < fixtureList.size(); z++){
//                            if (fixtureList.get(z).get(1).equals(teams.get(i).getTeamName()) && fixtureList.get(z).get(0).equals(teams.get(x).getTeamName())){
//                                foundMatch = true;
////                                System.out.println("=============REJECTED PAIR===============");
////                                System.out.println(teams.get(i).getTeamName());
////                                System.out.println(teams.get(x).getTeamName());
////                                System.out.println("============================");
//                            }
//                        }
//                        if(foundMatch == false){
//                           
//                        }
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

    @FXML
    void generateTeamStats(ActionEvent event) {
        System.out.println("generateTeamStats");
        testData();
    }
    
    public void testData(){
        teams.add(new TeamsPlayers.Teams("Filton", 1));
        teams.add(new TeamsPlayers.Teams("UWE", 2));
        teams.add(new TeamsPlayers.Teams("KCC", 3));
        teams.add(new TeamsPlayers.Teams("Page", 4));
        
        teamsAlreadyAdded.add("Filton");
        teamsAlreadyAdded.add("UWE");
        teamsAlreadyAdded.add("KCC");
        teamsAlreadyAdded.add("Page");
        
        teams.get(0).setPlayers("Alex", 1);
        teams.get(0).setPlayers("Brian", 2);
        
        teams.get(1).setPlayers("Jin", 1);
        teams.get(1).setPlayers("Julia", 2);
        teams.get(1).setPlayers("Stewart", 3);
        
        teams.get(2).setPlayers("Chris", 1);
        teams.get(2).setPlayers("Ryan", 2);
        
        teams.get(3).setPlayers("Peter", 1);
        teams.get(3).setPlayers("Phil", 2);
        
        for(int i = 0; i < teams.size(); i++){
            System.out.println(teams.get(i).getTeamName());
            for (int x = 0; x < teams.get(i).getPlayers().size(); x++){
                System.out.println(teams.get(i).getPlayers().get(x).getNamePlayer());
            }
            
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
