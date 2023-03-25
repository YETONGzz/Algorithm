package com.yetong.algorithm.Title100.Title40;

/**
 * 解数独
 */
public class No36SolveSudoku {
    public static void main(String[] args) {

    }

    public void solveSudoku(char[][] board) {
        char[][] row = new char[9][9];
        char[][] col = new char[9][9];
        char[][] box = new char[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                row[i][board[i][j]] = 1;

                if (board[j][i] != '.') {
                    continue;
                }
                col[j][board[j][i]] = 1;

                box[i / 3 + (j / 3) * 3][board[i][j]]=1;
            }
        }


    }
}
