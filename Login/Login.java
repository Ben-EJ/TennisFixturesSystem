/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Login;

/**
 *
 * @author benja
 */
public class Login {
    private static String usernameAssosiationSecritary = "";
    private static String passwordAssosiationSecritary = "";
    
    public Login(){
        
    }
    public static boolean loginAsAssosiationSec(String userName, String password){
        if (userName.equals(usernameAssosiationSecritary) && password.equals(passwordAssosiationSecritary)){
           return true; 
        }
        return false;
    }
}
