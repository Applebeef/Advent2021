package D11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D11 {

    File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D11\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine().trim());
        }
        OctopusMap octopusMap = new OctopusMap(input);
        octopusMap.runSimulation(100);

        return octopusMap.getFlashes();
    }

    public int Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> input = new ArrayList<>();
        while (scanner.hasNextLine()) {
            input.add(scanner.nextLine().trim());
        }
        OctopusMap octopusMap = new OctopusMap(input);
        return octopusMap.runSimulation2();
    }
}
