package D9;

import Util.Point;

public enum Sides {
    UP(-1, 0) {
        @Override
        public Point reverse(Point point) {
            return DOWN.of(point);
        }
    }, DOWN(1, 0) {
        @Override
        public Point reverse(Point point) {
            return UP.of(point);
        }
    }, LEFT(0, -1) {
        @Override
        public Point reverse(Point point) {
            return RIGHT.of(point);
        }
    }, RIGHT(0, 1) {
        @Override
        public Point reverse(Point point) {
            return LEFT.of(point);
        }
    };

    int row, col;

    Sides(int row, int col) {
        this.row = row;
        this.col = col;
    }

    public Point of(Point point) {
        return new Point(point.getX() + col, point.getY() + row);
    }

    abstract public Point reverse(Point point);
}
