package nl.davydehaas.adventofcode.year2021.day03;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part2 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day03.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static int calculate() {
        List<String> binaryNumbers = INPUT;
        List<String> oxygenGeneratorRatings = binaryNumbers;
        List<String> co2ScrubberRatings = binaryNumbers;
        int bits = binaryNumbers.get(0).length();
        
        for (int i = 0; i < bits; i++) {
            if (oxygenGeneratorRatings.size() > 1) {
                int balance = 0;
                
                for (String oxygenGeneratorRating : oxygenGeneratorRatings) {
                    if (oxygenGeneratorRating.charAt(i) == '1') balance++;
                    else balance--;
                }
                
                List<String> filteredList = new ArrayList<>();
                
                if (balance < 0) {
                    for (String oxygenGeneratorRating : oxygenGeneratorRatings) {
                        if (oxygenGeneratorRating.charAt(i) == '0')
                            filteredList.add(oxygenGeneratorRating);
                    }
                } else {
                    for (String oxygenGeneratorRating : oxygenGeneratorRatings) {
                        if (oxygenGeneratorRating.charAt(i) == '1')
                            filteredList.add(oxygenGeneratorRating);
                    }
                }
                
                oxygenGeneratorRatings = filteredList;
            }
            
            if (co2ScrubberRatings.size() > 1) {
                int balance = 0;
                
                for (String co2ScrubberRating : co2ScrubberRatings) {
                    if (co2ScrubberRating.charAt(i) == '1') balance++;
                    else balance--;
                }
                
                List<String> filteredList = new ArrayList<>();
                
                if (balance < 0) {
                    for (String co2ScrubberRating : co2ScrubberRatings) {
                        if (co2ScrubberRating.charAt(i) == '1')
                            filteredList.add(co2ScrubberRating);
                    }
                } else {
                    for (String co2ScrubberRating : co2ScrubberRatings) {
                        if (co2ScrubberRating.charAt(i) == '0')
                            filteredList.add(co2ScrubberRating);
                    }
                }
                
                co2ScrubberRatings = filteredList;
            }
        }
        
        int oxygenGeneratorRating = Integer.parseInt(oxygenGeneratorRatings.get(0), 2);
        int co2ScrubberRating = Integer.parseInt(co2ScrubberRatings.get(0), 2);
        return oxygenGeneratorRating * co2ScrubberRating;
    }
}
