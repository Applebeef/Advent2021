package D1;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class D1 {
    private final File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D1\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        int prev, curr = scanner.nextInt();
        int count = 0;
        while (scanner.hasNextInt()) {
            prev = curr;
            curr = scanner.nextInt();
            if (curr > prev) {
                count++;
            }
        }
        return count;
    }

    public long Solve1_2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextInt()) {
            list.add(scanner.nextInt());
        }

        return IntStream.range(0, list.size() - 1).filter(i -> list.get(i) < list.get(i + 1)).count();
    }

    public int Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        int res = 0;

        int left, middle, right;
        int prev = 0, curr;
        left = Integer.parseInt(scanner.nextLine());
        middle = Integer.parseInt(scanner.nextLine());
        right = Integer.parseInt(scanner.nextLine());
        curr = left + middle + right;
        while (scanner.hasNext()) {
            left = middle;
            middle = right;
            right = Integer.parseInt(scanner.nextLine());
            prev = curr;
            curr = left + middle + right;
            if (curr > prev) {
                res++;
            }

        }

        return res;
    }
}
