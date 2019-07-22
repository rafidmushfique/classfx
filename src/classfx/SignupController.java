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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RafiD
 */
public class SignupController implements Initializable {

<<<<<<< HEAD
=======
    @FXML
    private Button signup;
    @FXML
    private Button back;
>>>>>>> e7d6f3b7516b69424c5628e605387489020d655b








    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    public void backButton(ActionEvent event) 
  {
      try
      {
      Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
      Scene nextScene = new Scene(root);
      Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
      window.setScene(nextScene);
      window.show();
      }
      catch(Exception e)
      {
      e.printStackTrace();
      }
  }
}
