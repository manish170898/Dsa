package org.dsa.Graph;

public class G10NumberOfEnclaves {
//    https://leetcode.com/problems/number-of-enclaves/
    public static void main(String[] args) {

    }

    public static int noOfEnclaves(int[][] board){
        int row = board.length;
        int col = board[0].length;
        int count=0;
        int[][] vis = new int[row][col];
        for(int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(i == 0 || j ==0 || i == row-1 || j == col-1){
                    if(board[i][j] == 1) {
                        vis[i][j] = 1;
                        dfsE(i, j, vis, board);
                    }
                }

            }
        }
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if(vis[i][j] != 1 && board[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }


    private static void dfsE(int i, int j, int[][] vis, int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[] delRow = new int[]{-1,0,+1,0};
        int[] delCol = new int[]{0,+1,0,-1};
        for(int k=0 ; k<4; k++){
            int nrow = i + delRow[k];
            int ncol = j + delCol[k];
            if(nrow>=0 && nrow <n && ncol>=0 && ncol<m && board[nrow][ncol] == 1 && vis[nrow][ncol]!=1){
                vis[nrow][ncol] = 1;
                dfsE(nrow,ncol,vis,board);
            }
        }
    }
}
