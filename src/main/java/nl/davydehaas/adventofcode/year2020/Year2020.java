package nl.davydehaas.adventofcode.year2020;

import nl.davydehaas.adventofcode.utils.Utils;

import java.util.List;

public abstract class Year2020 {
    
    protected static List<String> readFile(String pathName) {
        return Utils.readFile("/year2020/" + pathName);
    }
}
