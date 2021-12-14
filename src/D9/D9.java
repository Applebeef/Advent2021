package D9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class D9 {
    File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D9\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> stringList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            stringList.add(scanner.nextLine().trim());
        }
        InputMap inputMap = new InputMap(stringList);
        return inputMap.getSetOfMinimumPoints().stream().mapToInt(inputMap::getPointFromArr).map(i -> i + 1).sum();
    }

    public int Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<String> stringList = new ArrayList<>();
        while (scanner.hasNextLine()) {
            stringList.add(scanner.nextLine().trim());
        }
        InputMap inputMap = new InputMap(stringList);
        List<Integer> list = inputMap.findBasins(inputMap.getSetOfMinimumPoints()).stream().mapToInt(Set::size).boxed().sorted(Collections.reverseOrder()).limit(3).collect(Collectors.toList());
        return list.get(0) * list.get(1) * list.get(2);
    }
}
