package D13;

import D4.Pair;
import D5.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Paper {
    Set<Point> pointSet;
    List<Pair<String, Integer>> foldList;

    public Paper(List<Point> pointList, List<Pair<String, Integer>> foldList) {
        this.foldList = foldList;
        this.pointSet = new HashSet<>();
        pointSet.addAll(pointList);
    }

    public int fold(int amount) {
        for (int i = 0; i < amount; i++) {
            Pair<String, Integer> pair = foldList.get(i);
            switch (pair.getV1()) {
                case "x":
                    foldX(pair.getV2());
                    break;
                case "y":
                    foldY(pair.getV2());
                    break;
            }
        }
        return pointSet.size();
    }

    private void foldY(Integer row) {
        Set<Point> points = pointSet.stream().filter(point -> point.getY() > row).collect(Collectors.toSet());
        pointSet.removeAll(points);
        points.forEach(point -> point.setY(row * 2 - point.getY()));
        pointSet.addAll(points);
    }

    private void foldX(Integer line) {
        Set<Point> points = pointSet.stream().filter(point -> point.getX() > line).collect(Collectors.toSet());
        pointSet.removeAll(points);
        points.forEach(point -> point.setX(line * 2 - point.getX()));
        pointSet.addAll(points);
    }

    @Override
    public String toString() {
        int maxX, maxY;
        maxX = pointSet.stream().mapToInt(Point::getX).max().getAsInt();
        maxY = pointSet.stream().mapToInt(Point::getY).max().getAsInt();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= maxY; i++) {
            for (int j = 0; j <= maxX; j++) {
                if (pointSet.contains(new Point(j, i))) {
                    stringBuilder.append("#");
                } else {
                    stringBuilder.append(" ");
                }
            }
            stringBuilder.append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
