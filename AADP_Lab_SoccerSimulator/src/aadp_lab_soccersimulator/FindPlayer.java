/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aadp_lab_soccersimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author rober
 */
public class FindPlayer {
    
    
    public static void findPlayer(Scanner sc) {
         boolean validTeam = false;
                    String teamName;
                    System.out.println("Please follow the instructions to get player data.");
                    do {
                        System.out.println("For which team would you like to get player data?");
                        teamName = sc.nextLine();
                        for (String team : Constants.teams) {
                            if (teamName.toLowerCase().equals(team.toLowerCase())) {
                                validTeam = true;
                                break;
                            }
                        }
                        if (teamName.toLowerCase().equals("exit")) break;
                        if (!validTeam) System.out.println("That is not one of the teams. Please try again!");
                    } while (!validTeam);
                    try {
                        DBConnection db = new DBConnection();
                        ResultSet rs = db.getFromDB(teamName);
                        String name;
                        int number;
                        String birth;
                        String position;
                        int goalsScored;
                        String background;
                        while (rs.next()) {
                            name = rs.getString("name");
                            number = rs.getInt("number");
                            birth = rs.getString("birth");
                            position = rs.getString("position");
                            goalsScored = rs.getInt("goalsScored");
                            background = rs.getString("background");              
                            System.out.println(String.format("Name: %s -- Number: %d -- DoB: %s -- Position: %s -- Number of goals scored: %d", name, number, birth, position, goalsScored));
                            System.out.println("Background:");
                            System.out.println(background);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }                     
    }
    
}
