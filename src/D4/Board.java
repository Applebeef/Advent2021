package D4;

import java.util.Arrays;

public class Board {
    //83 11 47 61 45
    //30 74 73 14 66
    //53 52 10 57 15
    //64 50 54 28 87
    //26 85 63 25 86

    int[][] board;
    boolean[][] found;

    public static final int SIZEOFBOARD = 5;

    public Board(int[][] board) {
        this.board = board;
        found = new boolean[SIZEOFBOARD][SIZEOFBOARD];
        for (boolean[] arr : found) {
            Arrays.fill(arr, false);
        }
    }

    public void Mark(int num) {
        for (int i = 0; i < SIZEOFBOARD; i++) {
            for (int j = 0; j < SIZEOFBOARD; j++) {
                if (board[i][j] == num) {
                    found[i][j] = true;
                }
            }
        }
    }

    public boolean checkWin() {
        return checkTopBottom() || checkLeftRight();
    }

    private boolean checkLeftRight() {
        boolean res = true;
        for (int i = 0; i < SIZEOFBOARD; i++) {
            for (int j = 0; j < SIZEOFBOARD; j++) {
                res &= found[i][j];
            }
            if (res) {
                return true;
            }
            res = true;
        }
        return false;
    }

    private boolean checkTopBottom() {
        boolean res = true;
        for (int i = 0; i < SIZEOFBOARD; i++) {
            for (int j = 0; j < SIZEOFBOARD; j++) {
                res &= found[j][i];
            }
            if (res) {
                return true;
            }
            res = true;
        }
        return false;
    }

    public int Unmarked() {
        int sum = 0;
        for (int i = 0; i < SIZEOFBOARD; i++) {
            for (int j = 0; j < SIZEOFBOARD; j++) {
                if (!found[i][j]) {
                    sum += board[i][j];
                }
            }
        }
        return sum;
    }
}
