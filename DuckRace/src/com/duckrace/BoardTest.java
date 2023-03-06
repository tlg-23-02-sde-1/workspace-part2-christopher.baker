package com.duckrace;
import static com.duckrace.Reward.*;

class BoardTest {
    public static void main(String[] args) {
        Board board = new Board();

//        board.dumpStudentIdMap();
        System.out.println();

        board.processWin(2, PRIZES);
        board.processWin(5, PRIZES);
        board.processWin(5, PRIZES);
        board.processWin(9, DEBIT_CARD);
        board.processWin(2, DEBIT_CARD);
        board.processWin(11, PRIZES);

        board.renderRacerMap();


//        board.processWin(2, Reward.DEBIT_CARD);
    }
}