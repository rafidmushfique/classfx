/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package classfx;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author immah
 */
public class CreatingConnection {
    public static Connection con;
    public CreatingConnection() throws SQLException
    {
         con = DriverManager.getConnection("jdbc:mysql://localhost:3306/classch?zeroDateTimeBehavior=convertToNull", "root", "");
         // this for mhr75 connections with DB
    }

    Object createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
