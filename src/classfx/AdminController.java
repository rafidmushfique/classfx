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
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RafiD
 */
public class AdminController implements Initializable {

    @FXML
    private Button studentinfo;
    @FXML
    private Button facultyinfo;
    @FXML
    private Button accountentinfo;
    @FXML
    private Button approvelist;
    @FXML
    private Button classschedule;
    @FXML
    private Button preAdvising;
    
      public void studentinfo(ActionEvent event) throws IOException
  {
       Parent root = FXMLLoader.load(getClass().getResource("StuInfo.fxml"));
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
      
  }
    public void preAdvisingInfo(ActionEvent event) throws IOException
  {
       Parent root = FXMLLoader.load(getClass().getResource("preAdvising.fxml"));
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
      
  }  
      
          public void facultyinfo(ActionEvent event) throws IOException
  {
       Parent root = FXMLLoader.load(getClass().getResource("FacultyInfo.fxml"));
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
      
  }
              public void accountentinfo(ActionEvent event) throws IOException
  {
       Parent root = FXMLLoader.load(getClass().getResource("AccInfo.fxml"));
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
      
  }
                  public void approvelist(ActionEvent event) throws IOException
  {
       Parent root = FXMLLoader.load(getClass().getResource("Aprrove.fxml"));
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
      
  }
                      public void classschedule(ActionEvent event) throws IOException
  {
       Parent root = FXMLLoader.load(getClass().getResource("ClassSchedule.fxml"));
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
      
  }
                          public void Backbutton(ActionEvent event) throws IOException
  {
       Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
      
  }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
    }    
    
}
