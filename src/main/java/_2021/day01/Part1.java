package _2021.day01;

import utils.FileReader;

import java.util.List;
import java.util.stream.Collectors;

public class Part1 {
    public static void main(String[] args) {
        List<Integer> measurements = getMeasurements();
        
        int largerMeasurements = countLargerMeasurements(measurements);
        
        System.out.println("Amount of measurements that are larger than the previous measurement:");
        System.out.println(largerMeasurements);
    }
    
    private static int countLargerMeasurements(List<Integer> measurements) {
        int largerMeasurementCounter = 0;
        int previousMeasurement = measurements.get(0);
        
        for (int measurement : measurements) {
            if (measurement > previousMeasurement)
                largerMeasurementCounter++;
            previousMeasurement = measurement;
        }
        
        return largerMeasurementCounter;
    }
    
    private static List<Integer> getMeasurements() {
        return FileReader.readFile("/_2021/day01-input.txt")
                .stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
