package D5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class D5 {
    File file = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D5\\input");

    public long Solve() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        String[] str;
        String[] strs2;
        Point p1, p2;
        List<Line> lineList = new ArrayList<>();
        Map<Point, Integer> pointIntegerMap = new HashMap<>();

        while (scanner.hasNextLine()) {
            str = scanner.nextLine().split(" -> ");
            strs2 = str[0].split(",");
            p1 = new Point(Integer.parseInt(strs2[0]), Integer.parseInt(strs2[1]));
            strs2 = str[1].split(",");
            p2 = new Point(Integer.parseInt(strs2[0]), Integer.parseInt(strs2[1]));
            lineList.add(new Line(p1, p2));
        }

        for (Line line : lineList) {
            List<Point> list = line.allCoveredPoints();
            if (list != null) {
                for (Point point : list) {
                    if (pointIntegerMap.containsKey(point)) {
                        int temp = pointIntegerMap.get(point);
                        temp++;
                        pointIntegerMap.put(point, temp);
                    } else {
                        pointIntegerMap.put(point, 1);
                    }
                }
            }
        }

        return pointIntegerMap.values().stream().filter(integer -> integer >= 2).count();
    }
}
