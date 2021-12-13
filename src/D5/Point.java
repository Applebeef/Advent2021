package D5;

import java.util.Objects;

public class Point {
    private long x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Point(long x, long y) {
        this.x = x;
        this.y = y;
    }

    public Point(String x, String y) {
        this.x = Long.parseLong(x);
        this.y = Long.parseLong(y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public long getY() {
        return y;
    }

    public void setY(long y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + x + ", " + y + ")";
    }
}
