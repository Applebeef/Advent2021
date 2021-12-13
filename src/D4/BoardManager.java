package D4;

import java.util.ArrayList;
import java.util.List;

public class BoardManager {
    List<Pair<Board, Boolean>> boardList = new ArrayList<>();

    Integer winningNumber = 0;
    Board winningBoard = null;

    public void addBoard(Board board) {
        boardList.add(new Pair<>(board, false));
    }

    public void addBoard(int[][] board) {
        boardList.add(new Pair<>(new Board(board), false));
    }

    @Override
    public String toString() {
        return boardList.toString();
    }

    public void Mark(int num) {
        for (Pair<Board, Boolean> board : boardList) {
            if (board.getV2().equals(false)) {
                board.getV1().Mark(num);
            }
        }
    }

    public int checkResult() {
        if (winningBoard == null) {
            return 0;
        } else {
            return winningNumber * winningBoard.Unmarked();
        }
    }

    public boolean allWon() {
        for (Pair<Board, Boolean> pair : boardList) {
            if (!pair.getV2()) {
                return false;
            }
        }
        return true;
    }

    public void checkWin(int num) {
        for (Pair<Board, Boolean> pair : boardList) {
            if (!pair.getV2()) {
                if (pair.getV1().checkWin()) {
                    winningBoard = pair.getV1();
                    winningNumber = num;
                    pair.setV2(true);
                }
            }
        }
    }
}
