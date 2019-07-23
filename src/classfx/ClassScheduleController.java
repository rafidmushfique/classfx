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
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author RafiD
 */
public class ClassScheduleController implements Initializable {

    Connection con = CreatingConnection.con;

    @FXML
    private Button back;
    @FXML
    private Button refresh;
    @FXML
    private Button addSemester;
    @FXML
    private Button UpdateSemester;
    @FXML
    private Button ShowResultsSemester;
    @FXML
    private Button addRoom;
    @FXML
    private Button deleteRoom;

    @FXML
    private TextField textSemesterId;
    @FXML
    private TextField textSemesterYear;
    @FXML
    private TextField textSemesterSession;
    @FXML
    private TextField textRoomNumber;
    @FXML
    private TextField textRoomCapacity;

    @FXML
    private TableColumn<Semester, String> semesterId;
    @FXML
    private TableColumn<Semester, String> semesterYear;
    @FXML
    private TableColumn<Semester, String> semesterSession;

    @FXML
    private TableColumn<Room, String> roomNumber;
    @FXML
    private TableColumn<Room, String> roomCapacity;

    @FXML
    private TableView semesterTable;
    @FXML
    private TableView roomTable;

    private final ObservableList<Semester> semesterData = FXCollections.observableArrayList();
    private final ObservableList<Room> roomData = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        SemesterTableShow();
    }

    @FXML
    private void BackButtonAction(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Admin.fxml"));
        Scene nextScene = new Scene(root);
        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(nextScene);
        window.show();
    }

    @FXML
    private void AddSemesterButtonAction(ActionEvent event) throws IOException, SQLException {
        if (checkInputsOfSemester()) {
            PreparedStatement pst = con.prepareStatement("insert into semester (year,session,id) values(?,?,?)");
            pst.setString(1, (textSemesterYear.getText()));
            pst.setString(2, textSemesterSession.getText());
            pst.setInt(3, Integer.parseInt(textSemesterId.getText()));
            int result = pst.executeUpdate();
            if (result == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Adding Semester failed!");
                alert.setContentText("Recheck If you have written same semester id again!");
                alert.showAndWait();
                RefreshButtonAction();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Added Semester Successfully!");
                alert.setHeaderText(null);
                alert.setContentText("Good day sir, New Semester Table row created !");
                alert.showAndWait();
                RefreshButtonAction();
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Adding Semester failed!");
            alert.setContentText("Recheck If you have left something unanswered!");
            alert.showAndWait();
            RefreshButtonAction();
        }
        SemesterTableShow();
    }

    @FXML
    private void UpdateSemesterButtonAction(ActionEvent event) throws IOException, SQLException {
        if (checkInputsOfSemester()) {
            PreparedStatement pst = con.prepareStatement("update semester set year=? ,session = ? where semester.id=?");
            System.out.println(textSemesterYear.getText() + " " + textSemesterSession.getText() + " " + textSemesterId.getText());
            pst.setString(1, textSemesterYear.getText());
            pst.setString(2, textSemesterSession.getText());
            pst.setInt(3, Integer.parseInt(textSemesterId.getText()));
            int result = pst.executeUpdate();
            if (result == 0) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Updating Semester failed!");
                alert.setContentText("Recheck If you have written same semester id again!");
                alert.showAndWait();
                RefreshButtonAction();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Updated Semester Successfully!");
                alert.setHeaderText(null);
                alert.setContentText("Good day sir, New Semester Table row created !");
                alert.showAndWait();
                RefreshButtonAction();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Updating Semester failed!");
            alert.setContentText("Recheck If you have left something unanswered!");
            alert.showAndWait();
            RefreshButtonAction();
        }
        SemesterTableShow();
    }

    @FXML
    private void ShowResultsSemesterButtonAction(ActionEvent event) throws IOException, SQLException {
        String id = textSemesterId.getText();
        if (id.equals("")) {

        } else {
            RoomTableShow();
        }
    }

    private void RefreshButtonAction() {
        textSemesterId.setText("");
        textSemesterYear.setText("");
        textSemesterSession.setText("");
    }

    @FXML
    private void RefreshButtonAction(ActionEvent event) throws IOException {
        textSemesterId.setText("");
        textSemesterYear.setText("");
        textSemesterSession.setText("");
    }

    private boolean checkInputsOfSemester() {
        String id = textSemesterId.getText();
        String year = textSemesterYear.getText();
        String session = textSemesterSession.getText();
        if (id.equals("") || year.equals("") || session.equals("")) {
            return false;
        }
        return true;
    }

    private void SemesterTableShow() {

        try {
            semesterData.clear();
            semesterTable.refresh();
            SemesterStartup();
            semesterId.setCellValueFactory(new PropertyValueFactory<Semester, String>("id"));
            semesterYear.setCellValueFactory(new PropertyValueFactory<Semester, String>("year"));
            semesterSession.setCellValueFactory(new PropertyValueFactory<Semester, String>("session"));
            semesterTable.setItems(semesterData);
            semesterTable.setRowFactory(tv -> {
                TableRow<Semester> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 1 && (!row.isEmpty())) {
                        Semester rowData = row.getItem();
                        textSemesterId.setText("" + rowData.getId());
                        textSemesterYear.setText("" + rowData.getYear());
                        textSemesterSession.setText("" + rowData.getSession());

                    }
                });
                return row;
            });
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void SemesterStartup() {
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from semester");
            String[] Values = new String[3];
            while (rs.next()) {
                Values[1 - 1] = rs.getString("id");
                Values[2 - 1] = rs.getString("year");
                Values[3 - 1] = (rs.getString("session"));
                semesterData.add(new Semester((Values[0]), (Values[01]), (Values[02])));
            }
            st.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void RoomTableShow() {

        try {
            roomData.clear();
            roomTable.refresh();
            RoomStartup();
            roomNumber.setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
            roomCapacity.setCellValueFactory(new PropertyValueFactory<>("roomCapacity"));
            roomTable.setItems(roomData);
            roomTable.setRowFactory(tv -> {
                TableRow<Room> row = new TableRow<>();
                row.setOnMouseClicked(event -> {
                    if (event.getClickCount() == 1 && (!row.isEmpty())) {
                        Room rowData = row.getItem();
                        textRoomNumber.setText("" + rowData.getRoomNumber());
                        textRoomCapacity.setText("" + rowData.getRoomCapacity());
                    }
                });
                return row;
            });
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }

    private void RoomStartup() {
        try {
            String id = textSemesterId.getText();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select numb,seatingCapacity from room where semester_id=" + id);
            String[] Values = new String[2];
            while (rs.next()) {
                Values[1 - 1] = rs.getString("numb");
                Values[2 - 1] = rs.getString("seatingCapacity");
                
                roomData.add(new Room((Values[0]), (Values[01])));
            }
            st.close();
            rs.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void AddRoomButtonAction() throws SQLException {
        System.out.println(RoomInputsCheck());
        if (RoomInputsCheck()) {
            String id = textSemesterId.getText();
            if (!id.equals("")) {
                PreparedStatement pre = con.prepareStatement("insert into room (numb,seatingCapacity,semester_id) values(?,?,?)");
                pre.setString(1, textRoomNumber.getText());
                pre.setInt(2, Integer.parseInt(textRoomCapacity.getText()));
                pre.setInt(3, Integer.parseInt(textSemesterId.getText()));
                int result = pre.executeUpdate();
                if (result == 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Adding room failed!");
                    alert.setContentText("Recheck If you have written same room id again!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Room Added Successfully!");
                    alert.setHeaderText(null);
                    alert.setContentText("Good day sir, New room table row created !");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Updating Semester failed!");
                alert.setContentText("Recheck If you have left semester id box left unanswered!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Adding Room failed!");
            alert.setContentText("Recheck If you have left something unanswered!");
            alert.showAndWait();
        }
        RoomTableShow();
        cleanRoomInfos();
    }
    
    
     @FXML
    private void DeleteRoomButtonAction(){
        try{
        if (RoomInputsCheck()) {
            String id = textRoomNumber.getText();
            if (!id.equals("")) {
                PreparedStatement pre = con.prepareStatement("delete from  room where numb=?");
                pre.setString(1, id);
                int result = pre.executeUpdate();
                if (result == 0) {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Dialog");
                    alert.setHeaderText("Deleting room failed!");
                    alert.setContentText("Recheck If the infos again!");
                    alert.showAndWait();
                } else {
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Room Deleted Successfully!");
                    alert.setHeaderText(null);
                    alert.setContentText("Good day sir, New room table row deleted !");
                    alert.showAndWait();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Dialog");
                alert.setHeaderText("Deleting Rooms info failed!");
                alert.setContentText("Recheck If you have left room number box left unanswered!");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error Dialog");
            alert.setHeaderText("Deleting Room failed!");
            alert.setContentText("Recheck If you have left something unanswered!");
            alert.showAndWait();
        }
        }
        catch(Exception ex)
        {
            System.out.println(ex);
            Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error Dialog");
            alert.setHeaderText("Adding Room failed!");
            alert.setContentText("This room has been used for child constraints ! Remove those first to update this.");
            alert.showAndWait();
        }
        RoomTableShow();
        cleanRoomInfos();
    }
    private void cleanRoomInfos()
    {
    textRoomNumber.setText("");
    textRoomCapacity.setText("");
    }
    private boolean RoomInputsCheck() {
        String roomNumber = textRoomNumber.getText();
        String roomCapacity = textRoomCapacity.getText();
        if (roomNumber.equals("") || roomCapacity.equals("")) {
            return false;
        }
        return true;
    }
}
