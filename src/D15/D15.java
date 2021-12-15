package D15;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D15 {
    File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D15\\input");

    private Integer incrementList(Integer integer) {
        int res = integer + 1;
        if (res > 9) {
            res = 1;
        }
        return res;
    }

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

    public int Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<List<Integer>> input = new ArrayList<>();
        String inputLine;
        while (scanner.hasNextLine()) {
            inputLine = scanner.nextLine().trim();
            input.add(inputLine.chars().map(integer -> integer - '0').boxed().collect(Collectors.toList()));
        }
        for (List<Integer> list : input) {
            List<Integer> tempList = new ArrayList<>(list);
            for (int i = 0; i < 4; i++) {
                List<Integer> incrementedList = tempList.stream().map(this::incrementList).collect(Collectors.toList());
                list.addAll(incrementedList);
                tempList = incrementedList;
            }
        }
        List<List<Integer>> tempInput = new ArrayList<>(input);
        for (int i = 0; i < 4; i++) {
            List<List<Integer>> incrementedInput = new ArrayList<>();
            for (List<Integer> list : tempInput) {
                List<Integer> newList = list.stream().map(this::incrementList).collect(Collectors.toList());
                input.add(newList);
                incrementedInput.add(newList);
            }
            tempInput = incrementedInput;
        }
        Graph graph = new Graph(input);
        graph.dijkstra();

        return graph.getEnd().getDist();
    }
}
