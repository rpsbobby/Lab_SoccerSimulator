/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aadp_lab_soccersimulator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author rober
 */
public class NewPlayer {
    
    DBConnection conn;
    
    public  void addPlayer(Scanner sc) {
        boolean validTeam = false;
                    String teamName;
                    System.out.println("Please follow the instructions to enter player data.");
                    do {
                        System.out.println("For which team would you like to enter data?");
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
                    String name;
                    int number =  - 1 ;
                    String birth;
                    String position;
                    int goalsScored = - 1;
                    String background;
                    boolean validPlayer = false;
                    System.out.println("Please enter the player's name: ");
                    name = sc.nextLine();
                    System.out.println("Please enter the player's number: ");
                    do {
                        number = ValidateInt.validateInt(sc, number);
                    } while (number < 0);                                              
                    System.out.println("Please enter the player's date of birth: ");
                    birth = sc.nextLine();         
                    System.out.println("Please enter the player's position: ");
                    position = sc.nextLine(); 
                    System.out.println("Please enter the number of goals the player has scored: ");
                    validPlayer = false;
                    do {
                        goalsScored = ValidateInt.validateInt(sc, goalsScored);
                    } while (goalsScored < 0);     
                    System.out.println("Please enter the player's background: ");
                    background = sc.nextLine();                          
                    System.out.println("Thank you for entering a player"); 
                    
                    this.writeToDb(String.format("INSERT INTO %s (name, number, birth, position, goalsScored, background) "
                                        + "VALUES (\"%s\", %d, \"%s\", \"%s\", %d,  \"%s\") ;",
                                        teamName, name, number, birth, position, goalsScored, background));
              
    }
    
    public void writeToDb(String str) {
        conn = new DBConnection();
                    conn.writeToDB(str);
    }
    
}
