package org.dsa.Matrix;

public class M3ScoreAfterFlippingMatrix {
//    https://leetcode.com/submissions/detail/1257176854/
    public static void main(String[] args) {
        int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
        matrixScore(grid);
    }
    public static int matrixScore(int[][] grid) {
        boolean flip = false;
        int n = grid.length;
        int m = grid[0].length;
        int [] countZeros = new int[m];
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(j==0 && grid[i][j] == 0){
                    flip = true;
                    grid[i][j] = 1;
                }
                else if(flip == true){
                    if(grid[i][j] == 1)  grid[i][j] = 0;
                    else if (grid[i][j] == 0) grid[i][j] = 1;
                }
                if(j == m-1 && flip == true) flip = false;
                // Count zeros in each column
                if(grid[i][j] == 0){
                    countZeros[j] += 1;
                }
            }
        }

        int ans = 0;
        flip = false;

        for(int j=0; j<m; j++){
            if(n - countZeros[j] <= n/2){
                for(int i=0; i<n; i++){
                    if(grid[i][j] == 1)  grid[i][j] = 0;
                    else if (grid[i][j] == 0) grid[i][j] = 1;
                }
            }
        }

        for(int i=0; i<n; i++){
            StringBuilder sb = new StringBuilder();
            for(int j=0; j<m; j++){
                sb.append(grid[i][j]);
            }
            ans += Integer.parseInt(sb.toString(),2);
        }
        return ans;
    }
}
