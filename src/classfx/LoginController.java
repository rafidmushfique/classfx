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
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    private Button forgotPassword;
    @FXML
    private TextField text1;
    @FXML
    private PasswordField pass1;
    @FXML
    private ImageView loginGif;
    @FXML
    private ImageView loginGif2;
    @FXML
    private Button back;
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
       loginGif.setImage(new Image(this.getClass().getResource("login.gif").toExternalForm()));
       loginGif.setVisible(true);
       loginGif2.setImage(new Image(this.getClass().getResource("login2.gif").toExternalForm()));
       loginGif2.setVisible(true);
       
        
        // TODO
    }    

     @FXML
    public void backButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void ForgotPasswordButton(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("ForgotPassword.fxml"));
            Scene nextScene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(nextScene);
            window.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
