package D17;

import Util.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Probe {
    int xVelocity, yVelocity;
    List<Integer> xRange, yRange;
    Point currentPosition;
    long trajectoryCount;

    public Probe(List<Integer> xRange, List<Integer> yRange) {
        this.xRange = xRange;
        this.yRange = yRange;
        trajectoryCount = 0;
    }

    public long calculateTrajectory(int bruteForceRange) {
        long maxY = Integer.MIN_VALUE;
        for (int x = -bruteForceRange; x < bruteForceRange; x++) {
            for (int y = -bruteForceRange; y < bruteForceRange; y++) {
                long currY = testTrajectory(x, y);
                if (currY > maxY) {
                    maxY = currY;
                }
            }
        }
        return maxY;
    }

    private long testTrajectory(int x, int y) {
        xVelocity = x;
        yVelocity = y;
        currentPosition = new Point(0, 0);
        long maxY = Integer.MIN_VALUE;
        while (!passedRange(currentPosition) && !inRange(currentPosition)) {
            currentPosition = nextStep(currentPosition);
            if (currentPosition.getY() > maxY) {
                maxY = currentPosition.getY();
            }
        }
        if (inRange(currentPosition)) {
            trajectoryCount++;
            return maxY;
        } else {
            return Integer.MIN_VALUE;
        }
    }

    private Point nextStep(Point currentPosition) {
        Point nextPosition = new Point(currentPosition.getX() + xVelocity, currentPosition.getY() + yVelocity);
        if (xVelocity > 0) {
            xVelocity--;
        } else if (xVelocity < 0) {
            xVelocity++;
        }
        yVelocity--;
        return nextPosition;
    }

    private boolean passedRange(Point point) {
        boolean res = (xVelocity == 0 && point.getX() < xRange.get(0));
        boolean res2 = (yVelocity < 0 && point.getY() < yRange.get(0));
        return res || res2;
    }

    private boolean inRange(Point point) {
        return point.getX() >= xRange.get(0) && point.getX() <= xRange.get(1)
                && point.getY() >= yRange.get(0) && point.getY() <= yRange.get(1);
    }
}
