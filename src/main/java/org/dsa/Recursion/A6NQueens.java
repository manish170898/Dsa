package org.dsa.Recursion;

import java.util.ArrayList;
import java.util.List;

public class A6NQueens {
//        https://leetcode.com/problems/n-queens/description/
    public static void main(String[] args){
        System.out.println(nQueens(4));
    }
    public static List<List<String>> nQueens(int n) {
        List<List<String>> result = new ArrayList<>();

        char [][] board = new char[n][n];
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board.length; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] leftRow = new boolean[n];
        boolean[] upperDiagnol = new boolean[2*n -1];
        boolean[] lowerDiagnol = new boolean[2*n -1];
        recursiveNQueens(0, board, leftRow, upperDiagnol, lowerDiagnol, result, n);
        return result;
    }

    public static void recursiveNQueens(int col, char[][] board, boolean[] leftRow, boolean[] upperDiagnol, boolean[] lowerDiagnol, List<List<String>> result, int n){
        if(col == n){
            result.add(construct(board));
            return;
        }

        for(int row =0; row<n; row++){
            if(!leftRow[row] && !lowerDiagnol[row + col] && !upperDiagnol[(n-1) + (row-col)]){
                board[row][col] = 'Q';
                leftRow[row] = true;
                lowerDiagnol[row + col] = true;
                upperDiagnol[n-1+row-col] = true;
                recursiveNQueens(col + 1, board, leftRow, upperDiagnol, lowerDiagnol, result, n);
                board[row][col] = '.';
                leftRow[row] = false;
                lowerDiagnol[row + col] = false;
                upperDiagnol[n-1+row-col] = false;
            }
        }
    }

    static List<String> construct(char[][] board) {

        List<String> internal = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            String row = new String(board[i]);
            internal.add(row);
        }
        return internal;
    }
}
