package D10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D10 {
    File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D10\\input");

    public int Solve1() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<SyntaxLine> syntaxLines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            syntaxLines.add(new SyntaxLine(scanner.nextLine().trim()));
        }

        return syntaxLines.stream().mapToInt(SyntaxLine::isCorrupt).sum();
    }

    public long Solve2() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        List<SyntaxLine> syntaxLines = new ArrayList<>();

        while (scanner.hasNextLine()) {
            syntaxLines.add(new SyntaxLine(scanner.nextLine().trim()));
        }
        syntaxLines = syntaxLines.stream().filter(syntaxLine -> syntaxLine.isCorrupt() == 0).collect(Collectors.toList());

        List<Long> results = syntaxLines.stream().mapToLong(SyntaxLine::completeLine).sorted().boxed().collect(Collectors.toList());
        return results.get(results.size() / 2);
    }
}
