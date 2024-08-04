package org.dsa.Graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class G9SurroundedRegions {
    public static void main(String[] args) {
        char[][] ans = new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}};
        System.out.println(Arrays.deepToString(surroundedRegions(ans)));
    }

    public static char[][] surroundedRegions(char[][] board){
        int row = board.length;
        int col = board[0].length;

        char[][] ans = new char[row][col];
        int[][] vis = new int[row][col];
        for(int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(i == 0 || j ==0 || i == row-1 || j == col-1){
                    if(board[i][j] == 'O') {
                        vis[i][j] = 1;
                        dfsR(i, j, vis, board);
                    }
                }

            }
        }

        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(vis[i][j] == 1){
                    ans[i][j] = 'O';
                    continue;
                }
                ans[i][j]= 'X';
            }
        }
        return ans;
    }

    private static void dfsR(int i, int j, int[][] vis, char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] delRow = new int[]{-1,0,+1,0};
        int[] delCol = new int[]{0,+1,0,-1};
        for(int k=0 ; k<4; k++){
            int nrow = i + delRow[k];
            int ncol = j + delCol[k];
            if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && board[nrow][ncol] == 'O' && vis[nrow][ncol]!=1){
                vis[nrow][ncol] = 1;
                dfsR(nrow,ncol,vis,board);
            }
        }
    }

}
