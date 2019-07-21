/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 * FXML Controller class
 *
 * @author RafiD
 */
public class LoginController implements Initializable {

    @FXML
    private Button login;
    @FXML
    private Button signup;
    @FXML
    private TextField text1;
    @FXML
    private PasswordField pass1;

    /**
     * Initializes the controller class.
     * @throws java.io.IOException
     */
    @FXML
    public void handle1(ActionEvent event) throws IOException
    {
         String a=text1.getText();
        String b=pass1.getText();
        if(a.equals("admin") && b.equals("admin"))
        
        {
         Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
        
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
        
        // TODO
    }    

    
}
