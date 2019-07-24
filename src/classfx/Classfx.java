/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author RafiD
 */
public class Classfx extends Application {
    public static int semesterId=1;
    public static int maxCredit=0;
    public static int minCredit=0;
    public static boolean preTime= false;
    @Override
    public void start(Stage stage) throws Exception {
        CreatingConnection conn = new CreatingConnection(); // comment it out , if your working for UI 
        Statement st= CreatingConnection.con.createStatement();
                        ResultSet rs= st.executeQuery("select * from preadvising");
                        boolean adi=true;
                        Loop1:
                        while(rs.next())
                        {
                            semesterId= Integer.parseInt(rs.getString("semester_id"));
                            maxCredit= Integer.parseInt((rs.getString("maxCredit")));
                            minCredit=Integer.parseInt((rs.getString("minCredit")));
                            int panelNo=Integer.parseInt((rs.getString("panel")));
                            if(panelNo==0)preTime=false;
                            if(panelNo==1)preTime=true;
                        }
                        st.close();
                        rs.close();
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene scene = new Scene(root);
        Image i = new Image("img/mechaaboo.png");
        stage.getIcons().add(i);
        stage.setTitle("University Student Information System");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public static void setSemesterId(int id) throws SQLException
    {
     PreparedStatement pst =CreatingConnection.con.prepareStatement("update preAdvising set semester_id=? where semester_id=?");
    pst.setInt(1, id);
    pst.setInt(2, semesterId);
    int updateNews=pst.executeUpdate();
    if (updateNews == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Semester Id Changefailed!");
                alert.setContentText("Recheck If you have written same semester id again or not has been set!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Changed Semester id Successfully!");
                alert.setHeaderText(null);
                alert.setContentText("Have a good sir!");
                alert.showAndWait();
                semesterId=id;
    }
    }
    
    public static void setMaxCredit(int id) throws SQLException
    {
     PreparedStatement pst =CreatingConnection.con.prepareStatement("update preAdvising set maxCredit=? where semester_id=?");
    pst.setInt(1, id);
    pst.setInt(2, semesterId);
    int updateNews=pst.executeUpdate();
    if (updateNews == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Max credit Change failed!");
                alert.setContentText(""
                        + "It has not been set!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Changed Max Credit Successfully!");
                alert.setHeaderText(null);
                alert.setContentText("Have a good sir!");
                alert.showAndWait();
                maxCredit=id;
    }
    }
    public static void setMinCredit(int id) throws SQLException
    {
     PreparedStatement pst =CreatingConnection.con.prepareStatement("update preAdvising set minCredit=? where semester_id=?");
    pst.setInt(1, id);
    pst.setInt(2, semesterId);
    int updateNews=pst.executeUpdate();
    if (updateNews == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Min Credit Change failed!");
                alert.setContentText("It has not been set!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Changed Min Credit Successfully!");
                alert.setHeaderText(null);
                alert.setContentText("Have a good sir!");
                alert.showAndWait();
                minCredit=id;
    }
    }
    public static void setPanel(int id) throws SQLException
    {
     PreparedStatement pst =CreatingConnection.con.prepareStatement("update preAdvising set panel=? where semester_id=?");
    pst.setInt(1, id);
    pst.setInt(2, semesterId);
    int updateNews=pst.executeUpdate();
    if (updateNews == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Panel Change failed!");
                alert.setContentText("It has not been set!");
                alert.showAndWait();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Changed Panel Successfully!");
                alert.setHeaderText(null);
                alert.setContentText("Have a good sir!");
                alert.showAndWait();
                if(id==1)preTime=true;
                else preTime=false;
    }
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
