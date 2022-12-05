/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aadp_lab_soccersimulator;

/**
 *
 * @author rober
 */
public class SimulateMatch {
    
    public static void simulateMatches(int numMatches) {
        for (int matchNum = 1; matchNum <= numMatches; matchNum++) {
                        int team1Num = (int) (Math.floor(Math.random() * Constants.teams.length));
                        String team1 = Constants.teams[team1Num];
                        int team2Num;
                        do {
                            team2Num = (int) (Math.floor(Math.random() * Constants.teams.length));
                        } while (team1Num == team2Num);
                        String team2 = Constants.teams[team2Num];
                        int team1Score = (int) (Math.floor(Math.random() * 6));
                        int team2Score = (int) (Math.floor(Math.random() * 6));
                        System.out.println("Time for mathch: " + matchNum);
                        if (team1Score > team2Score) {
                            System.out.println(String.format("Congratulation %s! %s scored %d goals and %s scored %d goals.", team1, team1, team1Score, team2, team2Score));
                        } else if (team1Score < team2Score) {
                            System.out.println(String.format("Congratulation %s! %s scored %d goals and %s scored %d goals.", team2, team1, team1Score, team2, team2Score));
                        } else {
                            System.out.println(String.format("It was a draw!! %s scored %d goals and %s scored %d goals.",  team1, team1Score, team2, team2Score));
                        }
                    }
    }
    
    
}
