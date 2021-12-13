package D13;

import D4.Pair;
import D5.Point;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class D13 {
    File points = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D13\\points");
    File folds = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D13\\folds");

    public int Solve1() throws FileNotFoundException {
        Scanner pointsScanner = new Scanner(points);
        Scanner foldsScanner = new Scanner(folds);
        List<Point> pointList = new ArrayList<>();
        List<Pair<String, Integer>> foldList = new ArrayList<>();

        while (pointsScanner.hasNextLine()) {
            String[] point = pointsScanner.nextLine().trim().split(",");
            pointList.add(new Point(point[0], point[1]));
        }
        while (foldsScanner.hasNextLine()) {
            String[] fold = foldsScanner.nextLine().trim().split(" ")[2].split("=");
            foldList.add(new Pair<>(fold[0], Integer.parseInt(fold[1])));
        }
        Paper paper = new Paper(pointList, foldList);
        int res = paper.fold(1);
        return res;
    }

    public String Solve2() throws FileNotFoundException {
        Scanner pointsScanner = new Scanner(points);
        Scanner foldsScanner = new Scanner(folds);
        List<Point> pointList = new ArrayList<>();
        List<Pair<String, Integer>> foldList = new ArrayList<>();

        while (pointsScanner.hasNextLine()) {
            String[] point = pointsScanner.nextLine().trim().split(",");
            pointList.add(new Point(point[0], point[1]));
        }
        while (foldsScanner.hasNextLine()) {
            String[] fold = foldsScanner.nextLine().trim().split(" ")[2].split("=");
            foldList.add(new Pair<>(fold[0], Integer.parseInt(fold[1])));
        }
        Paper paper = new Paper(pointList, foldList);
        paper.fold(foldList.size());
        return paper.toString().trim();

    }
}
