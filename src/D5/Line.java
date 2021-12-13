package D5;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Line {
    private Point p1, p2;

    public Line(Point p1, Point p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public List<Point> allCoveredPoints() {
        List<Point> pointList;

        if (p1.getX() == p2.getX()) {
            pointList = calcVertical();
        } else {
            pointList = calcLine();
        }

        return pointList;
    }

    private List<Point> calcLine() {
        List<Point> pointList = new ArrayList<>();
        Point smaller = getP1().getX() > getP2().getX() ? getP2() : getP1();

        IntStream stream = IntStream.range(0, getXDifference() + 1);
        stream.forEach(i -> pointList.add(new Point(smaller.getX() + i, smaller.getY() + (i * getSlope()))));

        return pointList;
    }

    //Same X
    private List<Point> calcVertical() {
        List<Point> pointList = new ArrayList<>();
        Point bigger, smaller;
        if (getP1().getY() > getP2().getY()) {
            bigger = getP1();
            smaller = getP2();
        } else {
            smaller = getP1();
            bigger = getP2();
        }

        IntStream range = IntStream.range((int) smaller.getY(), (int) bigger.getY() + 1);
        range.forEach(i -> pointList.add(new Point(bigger.getX(), i)));
        return pointList;
    }

    public Point getP1() {
        return p1;
    }

    public void setP1(Point p1) {
        this.p1 = p1;
    }

    public Point getP2() {
        return p2;
    }

    public void setP2(Point p2) {
        this.p2 = p2;
    }

    public int getSlope() {
        return (int) ((p1.getY() - p2.getY()) / ((p1.getX()) - p2.getX()));
    }

    public int getXDifference() {
        return (int) Math.abs(p1.getX() - p2.getX());
    }
}
