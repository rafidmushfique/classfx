/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RafiD
 */
public class StudentController implements Initializable {

    Connection con=CreatingConnection.con;
    public int maxCredit=Classfx.maxCredit;
    
    public int minCredit=Classfx.minCredit;
    public boolean pretime=Classfx.preTime;
    public int credit=ResultController.counter;
     public int semester=Classfx.semesterId;
    ResultSet rs;
    Statement st;
    PreparedStatement pst;
    static public int count;
    static public int total;
    
    static public int id=LoginController.user_id;
    @FXML
    private Button course;
    @FXML
    private Button bk;
    @FXML
    private TextField nametext;
    @FXML
    private TextField gendertext;
    @FXML
    private Label idtext;
    @FXML
    private Label deptext;
    @FXML
    private Label paymenttext;
    @FXML
    
    /**
     * Initializes the controller class.
     */
    
    
      public void addcourseButton(ActionEvent event) throws IOException
  {
      System.out.println(maxCredit);
      System.out.println(credit);
      System.out.println(minCredit);
      System.out.println(pretime);
      if(pretime && minCredit<=credit && credit<=maxCredit)
      {
            
                
                Parent root = FXMLLoader.load(getClass().getResource("Course.fxml"));
                Scene nextScene = new Scene(root);
                Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
                window.setScene(nextScene);
                window.show();
            
          
      }
      else
      {
      Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Information Dialog");
     alert.setHeaderText(null);
     alert.setContentText("Wait For You Designated TimeSlot!");
     Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
     stage.getIcons().add(new Image("img/mechaaboo.png")); 
     alert.showAndWait();
      }
 
  }
         public void viewresultButton(ActionEvent event) 
  {
       Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("Result.fxml"));
       
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
       } catch (IOException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
  }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            // TODO
            show();
            paymentInfo();
        } catch (SQLException ex) {
            //Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        System.out.println(ex.fillInStackTrace());
        }
    }    
    @FXML
     public void backbutton(ActionEvent event) throws IOException
  {
       Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
       Scene nextScene = new Scene(root);
             Stage window= (Stage) ((Node) event.getSource()).getScene().getWindow() ;
             window.setScene(nextScene);
             window.show();
      
  }
     public void show() throws SQLException
     {
         
         
        // String sql="select user.ID, user.Name, user.gender, student.dname,SUM(amount) As amount from ((user inner join student on user.ID = student.ID)inner join fees on student.ID = fees.std_id) where user.id=?;";
    //  st=(Statement)con.createStatement();
    String sql="SELECT user.ID,user.Name,user.gender,student.dname FROM user INNER JOIN student ON user.ID=student.Id WHERE user.ID=?";
       String sql2="SELECT COUNT(sub_id) AS abc FROM stu_takes WHERE semester_id=? and stu_id=?";
       
       PreparedStatement st1=con.prepareStatement(sql2);
      
       st1.setInt(2,id);
       st1.setInt(1,semester);
       System.out.println(st1);
       System.out.println(id);
       System.out.println(semester);
       ResultSet rsd=st1.executeQuery();
     
      System.out.println("this is count");
       while (rsd.next())
       {System.out.println("this is count");
           count=rsd.getInt("abc");
           System.out.println(count);
           
       }
       rsd.close();
       st1.close();
       System.out.println(count);
    pst=con.prepareStatement(sql);
    pst.setInt(1,id);
      rs=pst.executeQuery();
      
      while(rs.next())
      {
      nametext.setText(rs.getString("name"));
      String studentid=rs.getString("id");
      idtext.setText(studentid);
      String gender;
      if(rs.getString("gender").equals("1")){gender="Male";}
      else{gender="female";}
      gendertext.setText(gender);
      deptext.setText(rs.getString("dname"));
      
       //paymenttext.setText(totala);
      
      
      }
      
      
     }
     public void paymentInfo()
     {
         int credit=3;
         String studentid=""+id;
         String sql="select SUM(amount) as amount from fees where std_id=?";
        try {
            PreparedStatement st=con.prepareStatement(sql);
           st.setInt(1,id);
        ResultSet rs=st.executeQuery();
         while(rs.next())
         {
         
         int amount=rs.getInt("amount");
       
       if(studentid.startsWith("16"))
      {
      total=(5000*credit*count);
      }
      else if(studentid.startsWith("17"))
      {
      total=(5500*credit*count);
      }
      else if(studentid.startsWith("18"))
      {
      total=(6000*credit*count);
      }
      else if(studentid.startsWith("19"))
      {
      total=(6500*credit*count);
      }
     //  System.out.print(total);
       //String totala=""+total;
       if(amount<total)
       {
           int due=total-amount;
           String a="Due :"+due +" BDT";
       paymenttext.setText(a);
       }
       else{paymenttext.setText("Paid");}
         }
         
     } catch (SQLException ex) {
            Logger.getLogger(StudentController.class.getName()).log(Level.SEVERE, null, ex);
        }
     }
     
     public void updateButton(ActionEvent event)
     {
      try{
        String a=nametext.getText();
        String b=gendertext.getText();
        System.out.println(a);
        System.out.println(b);
        String UpdateQuery="update user set name= ?,gender=? where id="+id;
                 PreparedStatement   ps=con.prepareStatement(UpdateQuery);
                    ps.setString(1, a);
                    String qwe =gendertext.getText();
                    int ew;
                    if(qwe.equalsIgnoreCase("female"))ew=2;
                    else ew=1;
                    ps.setInt(2, ew);
                    ps.executeUpdate();
                    ps.close();
                     Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Information Dialog");
     alert.setHeaderText(null);
     alert.setContentText("Information Successfully Updated!");
     Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
     stage.getIcons().add(new Image("img/mechaaboo.png")); 
     alert.showAndWait();
        }
        catch(Exception ex)
        {
              Alert alert = new Alert(Alert.AlertType.INFORMATION);
     alert.setTitle("Information Dialog");
     alert.setHeaderText(null);
     alert.setContentText("Something Went wrong Information Was Not Updated!");
     Stage stage = (Stage) alert.getDialogPane().getScene().getWindow();
     stage.getIcons().add(new Image("img/mechaaboo.png")); 
     alert.showAndWait();
        }
     }
    
}
