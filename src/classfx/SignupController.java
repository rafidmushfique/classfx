/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;

/**
 * FXML Controller class
 *
 * @author RafiD
 */
public class SignupController implements Initializable {

    @FXML
    private Button signup;
    @FXML
    private Button back;
    @FXML
    private ChoiceBox choiceBox;







    /**
     * Initializes the controller class.
     */
    @Override
    
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    choiceBox.getItems().add("What is your pet name?");
    choiceBox.getItems().add("What is your Father name");
    choiceBox.getItems().add("What is your Mother name");
    choiceBox.getItems().add("What is your favourite Song?");
    choiceBox.getItems().add("What is your hobby");
    choiceBox.getItems().add("Any key value ?");
    }    
    
}
