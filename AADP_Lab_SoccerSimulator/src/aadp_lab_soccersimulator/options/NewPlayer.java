/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aadp_lab_soccersimulator.options;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author rober
 */
public class NewPlayer {
    
    
    private boolean validTeam = false;
    private String teamName;
                    System.out.println("Please follow the instructions to enter player data.");
                    do {
                        System.out.println("For which team would you like to enter data?");
                        teamName = sc.nextLine();
                        for (String team : teams) {
                            if (teamName.toLowerCase().equals(team.toLowerCase())) {
                                validTeam = true;
                                break;
                            }
                        }
                        if (teamName.toLowerCase().equals("exit")) break;
                        if (!validTeam) System.out.println("That is not one of the teams. Please try again!");
                    } while (!validTeam);
                    String name;
                    int number = 0;
                    String birth;
                    String position;
                    int goalsScored = 0;
                    String background;
                    boolean validPlayer = false;
                    System.out.println("Please enter the player's name: ");
                    name = sc.nextLine();
                    System.out.println("Please enter the player's number: ");
                    do {
                        try {
                            number = Integer.parseInt(sc.nextLine()); 
                            if (number < 1) {
                                System.out.println("Please enter a positive integer");
                            } else validPlayer = true;

                        } catch (Exception e) {
                            System.out.println("That is not a number. please try again!");
                        }
                    } while (!validPlayer);                                              
                    System.out.println("Please enter the player's date of birth: ");
                    birth = sc.nextLine();         
                    System.out.println("Please enter the player's position: ");
                    position = sc.nextLine(); 
                    System.out.println("Please enter the number of goals the player has scored: ");
                    validPlayer = false;
                    do {
                        try {
                            goalsScored = Integer.parseInt(sc.nextLine()); 
                            if (goalsScored < 1) {
                                System.out.println("Please enter a positive integer");
                            } else validPlayer = true;

                        } catch (Exception e) {
                            System.out.println("That is not a number. please try again!");
                        }
                    } while (!validPlayer);     
                    System.out.println("Please enter the player's background: ");
                    background = sc.nextLine();                          
                    System.out.println("Thank you for entering a player"); 
                    try {
                        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                        Statement stmt = conn.createStatement();
                        stmt.execute(
                                String.format("INSERT INTO %s (name, number, birth, position, goalsScored, background) "
                                        + "VALUES (\"%s\", %d, \"%s\", \"%s\", %d,  \"%s\") ;",
                                        teamName, name, number, birth, position, goalsScored, background)
                        );
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }      
    
}
