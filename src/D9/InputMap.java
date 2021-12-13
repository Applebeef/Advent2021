package D9;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import D5.Point;

public class InputMap {
    Integer[][] arr;

    public InputMap(List<String> stringList) {
        arr = new Integer[stringList.size()][];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stringList.get(i).chars().mapToObj(integer -> integer - '0').toArray(Integer[]::new);
        }
    }

    public Set<Point> getSetOfMinimumPoints() {
        Set<Point> pointSet = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                pointSet.add(searchFromPoint(i, j));
            }
        }
        pointSet.remove(null);
        return pointSet;
    }

    private Point searchFromPoint(int row, int col) {
        Point curr;
        Stack<Point> pointStack = new Stack<>();
        Set<Point> pointSet = new HashSet<>();
        pointStack.push(new Point(col, row));
        int min = 9;
        Point minPoint = null;
        while (!pointStack.isEmpty()) {
            curr = pointStack.pop();
            pointSet.add(curr);
            if (getPointFromArr(curr) < min) {
                min = getPointFromArr(curr);
                minPoint = curr;
            }
            for (Sides side : Sides.values()) {
                Point newPoint = side.of(curr);
                if (!pointSet.contains(newPoint) && getPointFromArr(newPoint) < getPointFromArr(curr)) {
                    pointStack.push(newPoint);
                }
            }
        }
        return minPoint;
    }

    public int getPointFromArr(Point point) {
        if (point.getY() >= arr.length || point.getY() < 0 || point.getX() >= arr[(int) point.getY()].length || point.getX() < 0) {
            return 9;
        }
        return arr[(int) point.getY()][(int) point.getX()];
    }

    public Set<Set<Point>> findBasins(Set<Point> setOfMinimumPoints) {
        Set<Set<Point>> basins = new HashSet<>();
        for (Point point : setOfMinimumPoints) {
            basins.add(findBasin(point));
        }
        return basins;
    }

    private Set<Point> findBasin(Point point) {
        Stack<Point> pointStack = new Stack<>();
        Set<Point> pointSet = new HashSet<>();
        pointStack.push(point);
        Point curr;
        while (!pointStack.isEmpty()) {
            curr = pointStack.pop();
            pointSet.add(curr);
            for (Sides sides : Sides.values()) {
                Point newPoint = sides.of(curr);
                if (!pointSet.contains(newPoint) && getPointFromArr(newPoint) < 9) {
                    pointStack.push(newPoint);
                }
            }
        }
        return pointSet;
    }
}
