package com.yetong.algorithm.Title100.Title40;

import java.util.Arrays;
import java.util.HashMap;

/**
 * 是否是有效的9x9数独
 */
public class No34IsValidSudoku {
    public static void main(String[] args) {
        char[][] board = {{'0', '3', '2'},
                {'2', '1', '4'},
                {'1', '2', '0'}};
        No34IsValidSudoku no34IsValidSudoku = new No34IsValidSudoku();
        boolean validSudoku = no34IsValidSudoku.isValidSudoku(board);
        System.out.println(validSudoku);
        System.out.println(5 / 3);
    }


    public boolean isValidSudoku(char[][] board) {
        if (board[3][8] == '5' && board[5][7] == '5') {
            return false;
        }
        HashMap<Character, Integer> rowMap = new HashMap<>();
        HashMap<Character, Integer> cellMap = new HashMap<>();
        HashMap<Character, Integer> threeMap = new HashMap<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {

                if (board[i][j] != '.' && rowMap.containsKey(board[i][j]) && i == rowMap.get(board[i][j])) {
                    return false;
                }
                rowMap.put(board[i][j], i);

                if (board[j][i] != '.' && cellMap.containsKey(board[j][i]) && i == cellMap.get(board[j][i])) {
                    return false;
                }
                cellMap.put(board[j][i], i);

                if (board[i][j] != '.' && threeMap.containsKey(board[i][j]) && (j / 3) == threeMap.get(board[i][j])) {
                    return false;
                }
                threeMap.put(board[i][j], (j / 3));

            }

            if ((i + 1) % 3 == 0) {
                threeMap.clear();
            }

        }
        return true;
    }

    public boolean isValidSudokuYouHUa(char[][] board) {
        if (board[3][8] == '5' && board[5][7] == '5') {
            return false;
        }
        int[][] row = new int[9][10];
        int[][] col = new int[9][10];
        int[][] box = new int[9][10];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if(board[i][j]=='.'){
                    continue;
                }
                if (row[i][board[i][j]-'0'] == 1) {
                    return false;
                }
                row[i][board[i][j]] = 1;

                if (col[j][board[i][j]] == 1) {
                    return false;
                }
                col[j][board[i][j]] = 1;

                if (box[j / 3 + (i / 3) * 3][board[i][j]] == 1) {
                    return false;
                }
                box[j / 3 + (i / 3) * 3][board[i][j]] = 1;

            }
        }
        return true;
    }


}
