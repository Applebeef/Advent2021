package D17;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D17 {
    File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D17\\input");

    public long Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String[] str = scanner.nextLine().trim().split(" ");
        List<Integer> xRange, yRange;
        xRange = Arrays.stream(str[2].trim().substring(2, str[2].trim().length() - 1).split("\\.\\.")).map(Integer::parseInt).collect(Collectors.toList());
        yRange = Arrays.stream(str[3].trim().substring(2).split("\\.\\.")).map(Integer::parseInt).collect(Collectors.toList());
        Probe probe = new Probe(xRange, yRange);
        return probe.calculateTrajectory(1000);
    }

    public long Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String[] str = scanner.nextLine().trim().split(" ");
        List<Integer> xRange, yRange;
        xRange = Arrays.stream(str[2].trim().substring(2, str[2].trim().length() - 1).split("\\.\\.")).map(Integer::parseInt).collect(Collectors.toList());
        yRange = Arrays.stream(str[3].trim().substring(2).split("\\.\\.")).map(Integer::parseInt).collect(Collectors.toList());
        Probe probe = new Probe(xRange, yRange);
        probe.calculateTrajectory(1000);
        return probe.trajectoryCount;
    }
}
