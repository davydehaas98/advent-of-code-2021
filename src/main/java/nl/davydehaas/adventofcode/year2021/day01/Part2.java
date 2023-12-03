package nl.davydehaas.adventofcode.year2021.day01;

import nl.davydehaas.adventofcode.year2021.Year2021;

import java.util.ArrayList;
import java.util.List;

import static nl.davydehaas.adventofcode.utils.Utils.timeSolution;

class Part2 extends Year2021 {
    
    private static final List<String> INPUT = readFile("/day01.txt");
    
    public static void main(String[] args) {
        timeSolution(Part2::calculate);
    }
    
    static int calculate() {
        List<Integer> measurements = INPUT.stream()
                .map(Integer::parseInt)
                .toList();
        List<Integer> slidingWindows = getSlidingWindows(measurements);
        
        return countLargerMeasurements(slidingWindows);
    }
    
    private static List<Integer> getSlidingWindows(List<Integer> measurements) {
        List<Integer> slidingWindows = new ArrayList<>();
        
        for (int i = 0; i < measurements.size(); i++) {
            try {
                int firstMeasurement = measurements.get(i);
                int secondMeasurement = measurements.get(i + 1);
                int thirdMeasurement = measurements.get(i + 2);
                
                int slidingWindow = firstMeasurement + secondMeasurement + thirdMeasurement;
                slidingWindows.add(slidingWindow);
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        
        return slidingWindows;
    }
    
    private static int countLargerMeasurements(List<Integer> measurements) {
        int largerMeasurementCounter = 0;
        int previousMeasurement = measurements.get(0);
        
        for (int measurement : measurements) {
            if (measurement > previousMeasurement) {
                largerMeasurementCounter++;
            }
            previousMeasurement = measurement;
        }
        
        return largerMeasurementCounter;
    }
}
