package D8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class D8 {

    private final File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D8\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String str;

        int res = 0;
        while (scanner.hasNextLine()) {
            str = scanner.nextLine();
            res += Arrays.stream(str.split("\\|")[1].split(" ")).mapToInt(String::length).filter(this::isEasyDigit).count();
        }

        return res;
    }

    private boolean isEasyDigit(int segments) {
        return segments == 2 || segments == 4 || segments == 3 || segments == 7;
    }

    public int Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String[] str;
        List<InputLine> inputLines = new ArrayList<>();
        while (scanner.hasNextLine()) {
            str = scanner.nextLine().split("\\|");
            inputLines.add(new InputLine(str));
        }
        int res = 0;
        for (InputLine inputLine : inputLines) {
            res += inputLine.decodeOutput();
        }
        return res;
    }
}
