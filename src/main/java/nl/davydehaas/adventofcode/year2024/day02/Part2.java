package nl.davydehaas.adventofcode.year2024.day02;

import static nl.davydehaas.adventofcode.util.Utils.readFile;
import static nl.davydehaas.adventofcode.util.Utils.timeSolution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Part2 {

    private static final List<String> INPUT = readFile(2024, 2, false);

    public static void main(String[] args) {
        timeSolution(Part2::solve);
    }


    static Number solve() {
        int safeReports = 0;

        for (String line : INPUT) {
            List<Integer> report = Arrays.stream(line.split(" "))
                    .map(Integer::parseInt)
                    .toList();
            if (checkReport(report, true)) {
                safeReports++;
            } else {
                System.out.println(line);
            }
        }
        return safeReports;
    }

    private static boolean checkReport(List<Integer> report, boolean tolerateBadLevel) {
        boolean increasing = report.get(0) < report.get(1);
        for (int i = 0; i < report.size(); i++) {
            int currentLevel = report.get(i);
            int nextLevel = report.get(i + 1);

            if (!checkLevel(currentLevel, nextLevel, increasing)) {
                if (tolerateBadLevel) {
                    for (int j = 0; j < report.size(); j++) {
                        List<Integer> DampenedList = new ArrayList<>(report);
                        //noinspection SuspiciousListRemoveInLoop
                        DampenedList.remove(j);
                        if (checkReport(DampenedList, false)) {
                            return true;
                        }
                    }
                }
                return false;
            }

            if (i == report.size() - 2) {
                return true;
            }
        }
        return true;
    }

    private static boolean checkLevel(int currentLevel, int nextLevel, boolean increasing) {
        int difference;
        if (increasing) {
            difference = nextLevel - currentLevel;
        } else {
            difference = currentLevel - nextLevel;
        }
        return difference > 0 && difference < 4;
    }
}
