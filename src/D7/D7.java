package D7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class D7 {
    private final File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D7\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();

        List<Integer> list = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Optional<Integer> max = list.stream().max(Integer::compare);
        Optional<Integer> min = list.stream().min(Integer::compare);

        int distanceSum, minDistanceSum = Integer.MAX_VALUE;
        if (min.isPresent()) {
            for (int i = min.get(); i < max.get(); i++) {
                distanceSum = 0;
                for (Integer integer : list) {
                    distanceSum += Math.abs(integer - i);
                }
                minDistanceSum = Math.min(minDistanceSum, distanceSum);
            }
        }
        return minDistanceSum;
    }

    public int Solve1_2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();

        List<Integer> list = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().sorted().collect(Collectors.toList());

        int median = list.get(list.size() / 2);
        int res = 0;
        for (Integer integer : list) {
            res += Math.abs(integer - median);
        }
        return res;
    }

    public int Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();

        List<Integer> list = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        Optional<Integer> max = list.stream().max(Integer::compare);
        Optional<Integer> min = list.stream().min(Integer::compare);

        int distanceSum, minDistanceSum = Integer.MAX_VALUE;
        if (min.isPresent()) {
            for (int i = min.get(); i <= max.get(); i++) {
                distanceSum = 0;
                for (Integer integer : list) {
                    int distance = Math.abs(integer - i);
                    for (int j = 1; j <= distance; j++) {
                        distanceSum += j;
                    }
                }
                minDistanceSum = Math.min(minDistanceSum, distanceSum);
            }
        }
        return minDistanceSum;
    }

    public long Solve2_2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String str = scanner.nextLine();

        List<Integer> list = Arrays.stream(str.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int average = list.stream().mapToInt(integer -> integer).sum() / list.size();
        long distanceSum = 0;
        for (Integer integer : list) {
            int distance = Math.abs(integer - average);
            for (int j = 1; j <= distance; j++) {
                distanceSum += j;
            }
        }

        return distanceSum;
    }
}
