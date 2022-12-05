/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aadp_lab_soccersimulator;

import static aadp_lab_soccersimulator.Constants.dbName;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


/**
 *
 * @author Sam
 * Please put the names and student numbers of the team here:
 * 
 * Name 1: Robert Szlufik
 * Number 1: 20203583
 * 
 * Name 2:
 * Number 2:
 * 
 * Name 3:
 * Number 3:
 * 
 * Name 4:
 * Number 4
 * 
 */

public class AADP_Lab_SoccerSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
        
        
        int option;
        boolean exit = false;
        Scanner sc = new Scanner(System.in);
        do {
            printBaner();        
            try {
                option = Integer.parseInt(sc.nextLine());
                if (option == 1) {
                    NewPlayer player = new NewPlayer();
                    player.addPlayer(sc);  
                } else if (option == 2) {
                   FindPlayer.findPlayer(sc);
                } else if (option == 3) {
                    System.out.println("How many matches would you like to simulate?");
                    int numMatches = - 1;
                    do {
                        numMatches = ValidateInt.validateInt(sc, numMatches);
                        System.out.println(numMatches);
                    } while (numMatches < 0);
                    SimulateMatch.simulateMatches(numMatches);                   
                } else if (option == 4) {
                    System.out.println("Goodbye, and thank you for using the SoccerSimulator!");
                    exit = true;
                } else {
                    System.out.println("That is an invalid number. Please try again!");
                }
            } catch (Exception e) {
                System.out.println("That is not a number. Please try again!");
            }         
        } while (!exit);   
    }   
    
    private static void printBaner() {
        System.out.println("Welcome! What would you like to do today? Please enter the number corresponding to your choice.");
        System.out.println("1. Enter a new player to a team.");
        System.out.println("2. See the players on a team.");
        System.out.println("3. Simulate a number of matches.");
        System.out.println("4. Exit the programme."); 
    }
}
