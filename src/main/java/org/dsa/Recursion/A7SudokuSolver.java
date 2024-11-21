package org.dsa.Recursion;

import java.util.Arrays;

public class A7SudokuSolver {
//    https://leetcode.com/problems/sudoku-solver/description/
    public static void main(String[] args){
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};

        System.out.println(Arrays.deepToString(sudokuSolver(board)));
    }
    public static char[][] sudokuSolver(char[][] board) {
        solve(board);
        return board;
    }

    public static boolean solve(char[][] board){
        for(int i=0; i< board.length; i++){
            for(int j=0; j<  board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isValid(board, i, j, c)){
                            board[i][j] = c;
                            if(solve(board)){
                                return true;
                            }
                            else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isValid(char[][] board, int i, int j, char c) {
        for (int k=0; k<9; k++){
            if(board[k][j] == c){
                return false;
            }
            if(board[i][k] == c){
                return false;
            }
            if(board[3*(i/3) + k/3][3*(j/3) + k%3] == c){
                return false;
            }
        }
        return true;
    }
}
