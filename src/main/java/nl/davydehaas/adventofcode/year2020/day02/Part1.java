package nl.davydehaas.adventofcode.year2020.day02;

import nl.davydehaas.adventofcode.year2020.Year2020;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part1 extends Year2020 {
    
    private static final List<String> INPUT = readFile("/day02.txt");
    
    public static void main(String[] args) {
        timeSolution(Part1::calculate);
    }
    
    static Integer calculate() {
        List<String[]> policies = getPolicies();
        int validPasswordCounter = 0;
        
        for (String[] policy : policies) {
            String password = policy[3];
            char letter = policy[2].charAt(0);
            int letterOccurrenceCounter = 0;
            // Count occurrences of letter
            for (int i = 0; i < password.length(); i++) {
                if (password.charAt(i) == letter) {
                    letterOccurrenceCounter++;
                }
            }
            // Check valid password
            int min = Integer.parseInt(policy[0]);
            int max = Integer.parseInt(policy[1]);
            if (min <= letterOccurrenceCounter && letterOccurrenceCounter <= max) {
                validPasswordCounter++;
            }
        }
        
        return validPasswordCounter;
    }
    
    private static List<String[]> getPolicies() {
        List<String[]> policies = new ArrayList<>();
        
        for (String line : INPUT) {
            String[] lineArray = line.split(": ");
            String password = lineArray[1];
            
            lineArray = lineArray[0].split(" ");
            String letter = lineArray[1];
            
            lineArray = lineArray[0].split("-");
            String min = lineArray[0];
            String max = lineArray[1];
            
            policies.add(new String[]{min, max, letter, password});
        }
        
        return policies;
    }
}
