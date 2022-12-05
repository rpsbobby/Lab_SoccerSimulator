/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aadp_lab_soccersimulator;

import static aadp_lab_soccersimulator.Constants.dbName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rober
 */
public class DBConnection {
   
    private String DB_URL = "jdbc:mysql://localhost/" + dbName;
    
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
        } catch (Exception ex) {
            Logger.getLogger(DBConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
         try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/", Constants.USER, Constants.PASS);
            Statement stmt = conn.createStatement();
            stmt.execute("CREATE SCHEMA IF NOT EXISTS " + Constants.dbName +";");
            stmt.execute("USE " + Constants.dbName + ";");
            for (String team : Constants.teams) {
                stmt.execute(
                        "CREATE TABLE IF NOT EXISTS "+ team + " ("
                                + "name VARCHAR(30) NOT NULL,"
                                + "number INT NOT NULL PRIMARY KEY,"
                                + "birth VARCHAR(30),"
                                + "position VARCHAR(30),"
                                + "goalsScored INT,"
                                + "background TEXT(1000));"
                );                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

       
}
