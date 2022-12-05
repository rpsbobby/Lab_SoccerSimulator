/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aadp_lab_soccersimulator;

import java.util.Scanner;

/**
 *
 * @author rober
 */
public class ValidateInt {
    
    public static int validateInt(Scanner sc, int numMatches) {
        try {
            numMatches = Integer.parseInt(sc.nextLine()); 
            if (numMatches < 1) {
                System.out.println("Please enter a positive integer");
            } 

        } catch (Exception e) {
            System.out.println("That is not a number. please try again!");
        }
        return numMatches;
    }
    
}
