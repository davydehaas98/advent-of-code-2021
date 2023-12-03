package nl.davydehaas.adventofcode.year2020.day02;

import nl.davydehaas.adventofcode.year2020.Year2020;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part2 extends Year2020 {
    
    private static final List<String> INPUT = readFile("/day02.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static Integer calculate() {
        List<String[]> policies = getPolicies();
        int validPasswordCounter = 0;
        
        for (String[] policy : policies) {
            int firstPosition = Integer.parseInt(policy[0]) - 1;
            int secondPosition = Integer.parseInt(policy[1]) - 1;
            char letter = policy[2].charAt(0);
            String password = policy[3];
            // Check positions of letter
            if (password.charAt(firstPosition) == letter && password.charAt(secondPosition) != letter) {
                validPasswordCounter++;
            } else if (password.charAt(firstPosition) != letter && password.charAt(secondPosition) == letter) {
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
