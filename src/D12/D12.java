package D12;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class D12 {
    File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D12\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        caveGraph graph = new caveGraph();
        while (scanner.hasNextLine()) {
            graph.addPath(scanner.nextLine().trim().split("-"));
        }
        Set<List<Cave>> paths = graph.getPaths();
        return paths.size();
    }

    public int Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        caveGraph graph = new caveGraph();
        while (scanner.hasNextLine()) {
            graph.addPath(scanner.nextLine().trim().split("-"));
        }
        Set<List<Cave>> paths = graph.getPaths2Visits();
        return paths.size();
    }

    void printPaths(Set<List<Cave>> paths) {
        for (List<Cave> path : paths) {
            StringBuilder stringBuilder = new StringBuilder("");
            for (Cave cave : path) {
                stringBuilder.append(cave).append(",");
            }
            System.out.println(stringBuilder.substring(0, stringBuilder.length() - 1));
        }
    }
}
