/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author RafiD
 */
public class Classfx extends Application {
    public static int semesterid=1;
    @Override
    public void start(Stage stage) throws Exception {
        CreatingConnection conn = new CreatingConnection(); // comment it out , if your working for UI 
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Image i = new Image("img/mechaaboo.png");
        stage.getIcons().add(i);
        stage.setTitle("University Student Information System");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
