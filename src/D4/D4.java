package D4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class D4 {
    File numbers = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D4\\input");
    File boards = new File("C:\\Users\\oroth\\IdeaProjects\\Advent\\src\\D4\\input2");

    public int Solve1() throws FileNotFoundException {
        Scanner numbersScanner = new Scanner(numbers);
        Scanner boardScanner = new Scanner(boards);

        String nums = numbersScanner.nextLine();
        BoardManager boardManager = new BoardManager();

        //Build boards
        while (boardScanner.hasNextInt()) {
            int[][] arr = new int[Board.SIZEOFBOARD][Board.SIZEOFBOARD];
            for (int i = 0; i < Board.SIZEOFBOARD; i++) {
                for (int j = 0; j < Board.SIZEOFBOARD; j++) {
                    arr[i][j] = boardScanner.nextInt();
                }
            }
            boardManager.addBoard(arr);
        }

        List<Integer> list = Arrays.stream(nums.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int lastRes = 0;
        for (Integer integer : list) {
            boardManager.Mark(integer);
            boardManager.checkWin(integer);
            lastRes = boardManager.checkResult();
            if (lastRes != 0) {
                return lastRes;
            }

            if (boardManager.allWon()) {
                break;
            }
        }
        return lastRes;
    }

    public int Solve2() throws FileNotFoundException {
        Scanner numbersScanner = new Scanner(numbers);
        Scanner boardScanner = new Scanner(boards);

        String nums = numbersScanner.nextLine();
        BoardManager boardManager = new BoardManager();

        //Build boards
        while (boardScanner.hasNextInt()) {
            int[][] arr = new int[Board.SIZEOFBOARD][Board.SIZEOFBOARD];
            for (int i = 0; i < Board.SIZEOFBOARD; i++) {
                for (int j = 0; j < Board.SIZEOFBOARD; j++) {
                    arr[i][j] = boardScanner.nextInt();
                }
            }
            boardManager.addBoard(arr);
        }

        List<Integer> list = Arrays.stream(nums.split(",")).mapToInt(Integer::parseInt).boxed().collect(Collectors.toList());
        int lastRes = 0;
        for (Integer integer : list) {
            boardManager.Mark(integer);
            boardManager.checkWin(integer);
            lastRes = boardManager.checkResult();

            if (boardManager.allWon()) {
                break;
            }
        }
        return lastRes;
    }
}
