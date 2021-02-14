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
public class MainController extends Thread implements Initializable {
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
        String userNameObtained = userNameScoreSheet.getText();
        String userPasswordObtained = passwordScoreSheet.getText();
        isLogedIn = Login.loginAsAssosiationSec(userNameObtained,userPasswordObtained);
        
        if (isLogedIn == true){
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

  
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
