package D15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D15 {
    File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D15\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<List<Integer>> input = new ArrayList<>();
        String inputLine;
        while (scanner.hasNextLine()) {
            inputLine = scanner.nextLine().trim();
            input.add(inputLine.chars().map(integer -> integer - '0').boxed().collect(Collectors.toList()));
        }
        Graph graph = new Graph(input);
        graph.dijkstra();
        return graph.getEnd().getDist();
    }
}
